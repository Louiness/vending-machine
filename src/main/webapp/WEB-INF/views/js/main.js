"use strict"

window.onload = () => {
	const soldOutFlagDiv = document.getElementsByClassName("sold-out-flag");
	for(let div of soldOutFlagDiv){
		// 売り切れの場合、
		if(div.getAttribute("value")){
			div.parentElement.style.backgroundColor = COLOR_RED;
		}
	}
};