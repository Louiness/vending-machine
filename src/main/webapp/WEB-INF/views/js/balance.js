"use strict"

let change = ZERO;

function init(){
    const changeButton = document.getElementById("getChangeBtn");
    changeButton.addEventListener("click", getChange);

    const coinChanger = document.getElementById("coin-changer");
    coinChanger.addEventListener("click", returnBalance);

    let coinReturn = document.getElementById("coin-return");
    let closeButton = document.getElementById("close-change-popup");
    coinReturn.addEventListener("click", changePopupToggle);
    closeButton.addEventListener("click", changePopupToggle);
}

function addBalance(coinValue){
    return balance + coinValue;
}
function decBalance(productPrice){
    return balance - productPrice;
}
function changePopupToggle(){
    let popup = document.getElementById('change-popup');
    popup.classList.toggle('active');
}
function changeButtonToggle(){
    const changeButton = document.getElementById("getChangeBtn");
    changeButton.classList.toggle('active');
}
function returnBalance(){
    if(balance <= ZERO || balance === undefined){
        alert(NOTHING_CHANGE_COMMENT);
        comment.innerText = CANT_GET_CHANGE_COMMENT;
    }
    else{
        change = balance;
        balance = ZERO;
        displayBalance(balance);

        let comment = document.getElementById("comment");
        comment.innerText = `${change}${RETURN_CHANGE_COMMENT}`;
        changeButtonToggle();
    }
}
function getChange(){
    let comment = document.getElementById("comment");

    if(change <= ZERO){
        comment.innerText = `${CANT_GET_CHANGE_COMMENT}`;
    }
    else{
        comment.innerText = `${GET_CHANGE_COMMENT}`;
        changeButtonToggle();
        change = 0;
    }
}

init();