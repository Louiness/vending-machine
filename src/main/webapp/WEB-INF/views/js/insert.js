"use strict"

// 初期設定
function init() {
	//투입 금액
	let coins = document.getElementsByClassName("coin");
	for(let coin of coins){
		coin.addEventListener("click", insertMoney);
	}

	const bill = document.getElementsByClassName("bill-acceptor")[0];
	bill.addEventListener("click", insertMoney);
}

function insertMoney(money) {
	if(balance === undefined){
		balance = ZERO;
	}
	else{

	}
	// 투입한 금액
	let moneyValue = Number(money.target.getAttribute("id").replace("yen", ""));

	addBalance(moneyValue);

	displayBalance(balance);
}

function displayBalance(balance){
	let balanceElement = document.getElementById("balance");
	balanceElement.innerText = balance;
}

init();