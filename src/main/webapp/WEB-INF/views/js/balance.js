"use strict"

/**
 * おつり、残額処理
 */

// おつり
let change = ZERO;

// 自動販売機の中に存在している残額
let balance = ZERO;

// 初期設定
function init(){
    const changeButton = document.getElementById("getChangeBtn");
    changeButton.addEventListener("click", getChange);

    const coinChanger = document.getElementById("coin-changer");
    coinChanger.addEventListener("click", returnBalance);
}

/**
 * 残額足し算処理。残額に投入金額を足す。
 */
function addBalance(coinValue){
    balance = balance + coinValue;
}
/**
 * 残額引き算処理。残額に投入金額を引く。
 */
function decBalance(productPrice){
    balance = balance - productPrice;
}
// 残額をおつりで返却
function returnBalance(){
    // おつり返却ポップアップコメント
    const comment = document.getElementById("comment");

    if(balance <= ZERO || balance === undefined){
        alert(ERRB0003);
        // おつり返却ポップアップコメントを修正
        comment.innerText = CANT_GET_CHANGE_COMMENT;
        return false;
    }
    else{
        change = balance;
        balance = ZERO;
        displayBalance(balance);

        comment.innerText = `${change}${RETURN_CHANGE_COMMENT}`;
        changeButtonToggle();
    }
}
// おつり回収
function getChange(){
    const comment = document.getElementById("comment");

    comment.innerText = GET_CHANGE_COMMENT;
    changeButtonToggle();
    change = ZERO;
}

init();