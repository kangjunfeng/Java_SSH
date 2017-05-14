/**
 * Created by kk on 2017/5/13.
 */

/**
 * loginBtn click
 */
// window.onload=function () {
//     var user =document.getElementById("user");
//     user.onkeyup = function () {
//         if(user.value =""){
//             document.getElementById("userTip").innerHTML("请输入用户名");
//         }
//     }
// };

function check() {
    var user =document.getElementById("user");
    if(user.value.length<=0){
        var userTip = document.getElementById("userTip");
        userTip.innerHTML="请输入用户名";
        userTip.style.display= "block";
    }

    var pass =document.getElementById("pass");
    if(pass.value.length<=0){
        var passTip = document.getElementById("passTip");
        passTip.innerHTML="请输入密码";
        passTip.style.display="block";
    }

    if(user.value.length<=0 || pass.value.length<=0){
        return false;
    }

    return true;
}


/**
 * ajax
 */
function createHttpRequest() {
    var xmlHttp =null;
    try{
        xmlHttp =new XMLHttpRequest();
    }catch(e){
        try{
            xmlHttp =new ActiveXObject("Microsoft.XMLHTTP");
        }catch(e1){
            alert("your browser not support ajax!");
        }
    }
    return xmlHttp;
}

function  sendRequest(type,url,mapping) {
    var httpRequest =createHttpRequest();
    httpRequest.open(type,mapping);
    httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    httpRequest.send(url);
}
