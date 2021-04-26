
// 자판기 내에 존재하는 잔액
let balance = ZERO;

function init() {
	//투입 금액
	let coins = document.getElementsByClassName("coin");
	const bill = document.getElementsByClassName("bill-acceptor")[0];
	const coinInsert = document.getElementById("coin-insert");
	const closeButton = document.getElementById("close-casher-popup");

	for(let coin of coins){
		coin.addEventListener("click", insertMoney);
	}
	bill.addEventListener("click", insertMoney);
	coinInsert.addEventListener("click", casherPopupToggle);
	closeButton.addEventListener("click", casherPopupToggle);
}

function insertMoney(money) {
	if(balance === undefined){
		balance = ZERO;
	}
	else{

	}
	// 투입한 금액
	let moneyValue = Number(money.target.getAttribute("id").replace("yen", ""));

	balance = addBalance(moneyValue);

	displayBalance(balance);
}

function casherPopupToggle() {
	let popup = document.getElementById('casher-popup');
	popup.classList.toggle('active');
}

function displayBalance(balance){
	let balanceElement = document.getElementById("balance");
	balanceElement.innerText = balance;
}

init();