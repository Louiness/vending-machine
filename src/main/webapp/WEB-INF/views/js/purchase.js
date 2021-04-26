"use strict"

const STRING_SOLDOUT = "soldout";
const GET_URL = "/purchase?productNumber=";
const SUCCESS = "success";
const ERROR = "error";

function init() {
  const prices = document.getElementsByClassName("price");

  for(let price of prices){
    price.addEventListener("click", (item) => {
      const productNumber = item.target.getAttribute("id");
      const priceValue = Number(price.target.innerText);
      const productStateDiv = document.getElementsByClassName(productNumber)[0];
      let soldOutFlagDiv = document.getElementsByClassName(productNumber)[1];

      // 매진이 아닐 시
      if(!soldOutFlagDiv.getAttribute("value")){
        const xhr = new XMLHttpRequest;
        xhr.onreadystatechange = function() { // 요청에 대한 콜백
          if (xhr.readyState === xhr.DONE) { // 요청이 완료되면
            if (xhr.status === 200 || xhr.status === 201) {
              const response = JSON.parse(this.responseText);
              decBalance(priceValue);
              //データが正常
              if(response.soldOutFlag === STRING_SOLDOUT){

                soldOutFlagDiv.setAttribute("value", response.soldOutFlag);
                productStateDiv.style.backgroundColor = COLOR_RED;
              }
            }
          }
        };

        xhr.open("GET", GET_URL + productNumber);
        xhr.send(); // 요청 전송
      } else { // 매진일 시
        alert(SOLD_OUT_MESSAGE);
      }

    });
  }
}

init();