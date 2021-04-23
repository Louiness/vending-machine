"use strict"

function init() {
    const prices = document.getElementsByClassName("price");

    for(let price of prices){
        price.addEventListener("click", (item) => {
          const productNumber = item.target.getAttribute("id");
          const productStateDiv = document.getElementsByClassName(productNumber)[0];
          let soldOutFlagDiv = document.getElementsByClassName(productNumber)[1];

          // 매진이 아닐 시
          if(!soldOutFlagDiv.getAttribute("value")){
            const xhr = new XMLHttpRequest;
            xhr.onreadystatechange = function() { // 요청에 대한 콜백
              if (xhr.readyState === xhr.DONE) { // 요청이 완료되면
                if (xhr.status === 200 || xhr.status === 201) {
                  const response = JSON.parse(this.responseText);

                  //データが正常
                  if(response.soldOutFlag === 'soldout'){

                    productStateDiv.style.backgroundColor = "red";
                    soldOutFlagDiv.setAttribute("value", response.soldOutFlag);
                  }
                }
              }
            };

            xhr.open("GET", "/purchase?productNumber=" + productNumber);
            xhr.send(); // 요청 전송
          } else { // 매진일 시
            alert("매진입니다.");
          }

        });
    }
}

init();