"use strict"

function init() {
    let prices = document.getElementsByClassName("price");

    for(let price of prices){
        price.addEventListener("click", (item) => {
            let xhr = new XMLHttpRequest;
            let productNumber = item.target.innerText;
            xhr.onreadystatechange = function() { // 요청에 대한 콜백
                if (xhr.readyState === xhr.DONE) { // 요청이 완료되면
                  if (xhr.status === 200 || xhr.status === 201) {
                    let response = JSON.parse(this.responseText);

                    //データが正常
                    if(response.state === SUCCESS){
                        if(response.soldOutFlag){
                            let productState = item.parentElement.parentElement.children[0];

                            productState.style.backgroundColor = "red";
                        }
                    }
                    //データ通信エラー
                    else if(response.state === ERROR){
                        alert('演算途中にエラーが発生しました。');
                        return false;
                    }
                  } else {
                    console.error(xhr.responseText);
                  }
                }
              };

            xhr.open("GET", "/purchase?productNumber=" + productNumber);
            xhr.send(); // 요청 전송 
        });
    }
}

init();