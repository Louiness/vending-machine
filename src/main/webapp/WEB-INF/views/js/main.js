"use strict"

window.onload = () => {
	const soldOutFlagDiv = document.getElementsByClassName("sold-out-flag");
	for(let div of soldOutFlagDiv){
		// 매진이 아닐 시
		if(div.getAttribute("value")){
			div.parentElement.style.backgroundColor = COLOR_RED;
		}
	}
};