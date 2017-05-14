window.onload = function () {
     // var leftClass =document.getElementsByClassName("contentLeft");
     // leftClass.style.height =window.screen.height-200;

	 var leftNav =document.getElementById("leftNav");
	 leftNav.style.height =window.screen.height-200+"px";

	 var iframe = document.getElementById("iframe");
	 iframe.style.height =window.screen.height-260+"px";
	 
};

function  showOrHiddenNav(controlID) {
	var secNav = document.getElementById(controlID);
	if(secNav.style.display =="none"){
	secNav.style.display ="block";
	}else {
	secNav.style.display ="none";
	}
}
