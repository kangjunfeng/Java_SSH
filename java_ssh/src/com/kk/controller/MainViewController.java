package com.kk.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.List;

import javax.print.attribute.standard.MediaSize.NA;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;import org.w3c.dom.ls.LSException;

import com.kk.bean.StudentBean;
import com.kk.dao.impl.StudentDaoImpl;
import com.kk.entity.Student;
import com.kk.tool.WebTool;
import com.kk.util.WebUtil;

@Controller
public class MainViewController {

	@RequestMapping("/login")
	public ModelAndView loginView(HttpServletRequest request,HttpServletResponse response)throws Exception {
		return  new ModelAndView("login");
	}
	
	@RequestMapping("/index")
	public ModelAndView indexView(HttpServletRequest request,HttpServletResponse response)throws Exception{
		return  new ModelAndView("index");
    }
	
	@RequestMapping("/add")
	public ModelAndView addView(HttpServletRequest request,HttpServletResponse response)throws Exception{
		System.out.println("123");
		addStudent(request, response);
		return  new ModelAndView("addStudent");
    }
	
	@RequestMapping("/list")
	public ModelAndView listView(HttpServletRequest request,HttpServletResponse response)throws Exception{
		getStudentList(request, response);
		return  new ModelAndView("list");
    }
	
	@RequestMapping("/delete")
	public ModelAndView deleteView(HttpServletRequest request,HttpServletResponse response)throws Exception{
		deleteSudent(request, response);
		return  new ModelAndView("index");
    }
	
	/**
	 * 删除学生信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void deleteSudent(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		String id =request.getParameter("id");
		System.out.println("--delete id--" + id);
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		StudentDaoImpl  daoImpl =(StudentDaoImpl)context.getBean("studentService"); 
		StudentDaoImpl  daoImpl =new StudentDaoImpl();
		if (!daoImpl.delete(id)) {
			request.getSession().setAttribute("errors", "删除失败");
		}
		getStudentList(request, response);
	}
	
	
	/**
	 * 添加学生
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws NoSuchAlgorithmException 
	 */
	private void addStudent(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException, NoSuchAlgorithmException{
		StudentBean bean =WebUtil.convertFromBean(StudentBean.class, request);
		System.out.println("---bean---"+bean.toString());
		System.out.println("---validate---"+bean.validate());
		
		if (bean.validate()) {
			Student student =new Student();
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			try {
				BeanUtils.copyProperties(student, bean);
			} catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
			
            student.setId(WebTool.createUUID());
            
//            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//    		StudentDaoImpl  daoImpl =(StudentDaoImpl)context.getBean("studentService"); 
    		StudentDaoImpl  daoImpl =new StudentDaoImpl();
            boolean flag =daoImpl.add(student);
			if (flag) {
				getStudentList(request, response);
			}else {
				//添加失败
				request.setAttribute("errors", "添加失败");
//				request.getRequestDispatcher(request.getContextPath()+"/add");
			}
		}else {
			//验证失败, 返回验证错误信息
			request.setAttribute("users", bean);
//			request.getRequestDispatcher("/add").forward(request,response);
		}
	}
	
	/**
	 * 获取所有学生列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getStudentList(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		StudentDaoImpl  daoImpl =(StudentDaoImpl)context.getBean("studentService"); 
		StudentDaoImpl  daoImpl =new StudentDaoImpl();
		List<Student> list =daoImpl.findAll();
		request.getSession().setAttribute("list", list);
		System.out.println("--list---"+list);
//		response.sendRedirect(request.getContextPath()+"/list");
	}
}
