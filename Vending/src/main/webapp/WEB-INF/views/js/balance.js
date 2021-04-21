"use strict"

// 자판기 내에 존재하는 잔액
let balance = document.getElementsByClassName("balance").innerText;

function init() {
    //투입 금액
    let coins = document.getElementsByClassName("coin");

    for(let coin of coins){
        coin.children[0].addEventListener("click", () => {
            let balanceElement = document.getElementById("balance");
            if(balance === undefined){
                balance = ZERO;
            }
            else{
                
            }
            // 투입한 금액
            let coinValue = Number(coin.children[0].getElementById("value").slice(-3));
            
            balance = addBalance(coinValue);
            balanceElement.innerText = balance;
        });
    }
}


function addBalance(coinValue){
    return balance + coinValue;
}
function decBalance(productPrice){
    return balnce - productPrice;
}

init();