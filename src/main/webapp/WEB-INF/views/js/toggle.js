"use strict"

/**
 * トグルイベント
 */
function init(){
	// コイン投入口
	const coinInsert = document.getElementById("coin-insert");
	coinInsert.addEventListener("click", casherPopupToggle);

	// コイン投入ポップアップクローズボタン
	const closeButtonInCasherPopup = document.getElementById("close-casher-popup");
	closeButtonInCasherPopup.addEventListener("click", casherPopupToggle);

	// おつり返却口
	const coinReturn = document.getElementById("coin-return");
	coinReturn.addEventListener("click", changePopupToggle);

	// おつり返却ポップアップクローズボタン
	const closeButtonInChangePopup = document.getElementById("close-change-popup");
	closeButtonInChangePopup.addEventListener("click", changePopupToggle);
}
// おつり返却についてのポップアップにトグルを設定
function changePopupToggle(){
	const popup = document.getElementById('change-popup');
	popup.classList.toggle('active');
}
// おつり返却ボタンにトグルを設定
function changeButtonToggle(){
	const changeButton = document.getElementById("getChangeBtn");
	changeButton.classList.toggle('active');
}
// コイン投入についてのポップアップにトグルを設定
function casherPopupToggle() {
	let popup = document.getElementById('casher-popup');
	popup.classList.toggle('active');
}

init();