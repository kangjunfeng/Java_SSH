package com.kk.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.kk.bean.StudentBean;
import com.kk.dao.impl.StudentDaoImpl;
import com.kk.entity.Student;
import com.kk.tool.WebTool;
import com.kk.util.WebUtil;

/**
 * Servlet implementation class StudentServlet1
 */

public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDaoImpl daoImpl =new StudentDaoImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String parm =request.getParameter("select");
		System.out.println("partmeter--->"+parm);
		if ("all".equals(parm)) {
			getStudentList(request, response);
		}else if("add".equals(parm)){
			try {
				addStudent(request, response);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("delete".equals(parm)){
			deleteSudent(request, response);
		}else if("update".equals(parm)){
			updateStudent(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
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
          
            boolean flag =daoImpl.add(student);
			if (flag) {
				getStudentList(request, response);
			}else {
				//添加失败
				request.setAttribute("errors", "添加失败");
				request.getRequestDispatcher(request.getContextPath()+"/add");
			}
		}else {
			//验证失败, 返回验证错误信息
			request.setAttribute("users", bean);
			request.getRequestDispatcher("/add").forward(request,response);
		}
	}
	
	/**
	 * 删除学生
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void deleteSudent(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		String id =request.getParameter("id");
		System.out.println("--delete id--" + id);
		if (!daoImpl.delete(id)) {
			request.getSession().setAttribute("errors", "删除失败");
		}
		getStudentList(request, response);
	}
	
	
	private void updateStudent(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
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
          
            boolean flag =daoImpl.update(student);
			if (flag) {
				getStudentList(request, response);
			}else {
				//添加失败
				request.setAttribute("errors", "更新失败");
				request.getRequestDispatcher(request.getContextPath()+"/update.jsp");
			}
		}else {
			//验证失败, 返回验证错误信息
			request.setAttribute("users", bean);
			request.getRequestDispatcher("/update.jsp").forward(request,response);
		}
	}
	
	/**
	 * 查找单个学生
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */	
//	private void findStudentByID(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
//	String id = request.getParameter("id");
//	System.out.println("--find id--" + id);
//	Student student =daoImpl.findStudentById(Integer.parseInt(id));
//	if (student !=null) {
//		request.getSession().setAttribute("stu", student);
//		response.sendRedirect(request.getContextPath()+"/single.jsp");
//	}else {
//		request.getSession().setAttribute("errors", "查找失败");
//	}
//
//}
	
	/**
	 * 获取所有学生列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getStudentList(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		List<Student> list =daoImpl.findAll();
		request.getSession().setAttribute("list", list);
		System.out.println("--list--"+list);
		response.sendRedirect(request.getContextPath()+"/list");
	}
	
	
}
