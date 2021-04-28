"use strict"

// 文字列＿売り切れ
const STRING_SOLDOUT = "soldout";

// REST URL
const GET_URL = "/purchase?productNumber=";

// 通信失敗
const FAIL = "fail";

// 文字列＿エラーID
const ERROR_ERRS0001 = "ERRS0001";

// 文字列＿エラーID
const ERROR_ERRS0002 = "ERRS0002";

// 初期設定
function init() {
  const prices = document.getElementsByClassName("price");

  for(let price of prices){
    price.addEventListener("click", purchase);
  }
}

// 製品購入
function purchase(item){

  // 製品番号
  const productNumber = item.target.getAttribute("id");
  // 製品値段
  const priceValue = Number(item.target.innerText);
  // 売り切れフラグ領域
  const soldOutFlagDiv = document.getElementsByClassName(productNumber)[1];

  // 売り切れではない場合、
  if(!soldOutFlagDiv.getAttribute("value")){
    // 残額．フィールド．残額　＜　ローカル変数．製品値段の場合、
    if(balance < priceValue){
      alert(ERRB0002);
    }
    // 上記以外の場合、
    else{
      ajaxConnect(productNumber);
      decBalance(priceValue);
    }
  } else { // 上記以外の場合、
    alert(ERRB0001);
  }
}

// AJAX通信
function ajaxConnect(productNumber){
  const xhr = new XMLHttpRequest;
  const productStateDiv = document.getElementsByClassName(productNumber)[0];

  xhr.onreadystatechange = function() {
    // 通信完了
    if (xhr.readyState === xhr.DONE) {

      if (xhr.status === 200 || xhr.status === 201) {
        const response = JSON.parse(this.responseText);

        if(response.state == FAIL){
          alert(getErrorId(response.error));
          return false;
        }
        else{
          if(response.soldOutFlag === STRING_SOLDOUT){
            let soldOutFlagDiv = document.getElementsByClassName(productNumber)[1];

            soldOutFlagDiv.setAttribute("value", response.soldOutFlag);
            productStateDiv.style.backgroundColor = COLOR_RED;
          }
        }
      }
      // 通信エラー
      else{
        alert(ERRA0001);
      }
    }
  };

  xhr.open("GET", GET_URL + productNumber);
  // サーバー送信
  xhr.send();
}

// エラーIDに合うエラーメッセージを返却
function getErrorId(errorId){
  switch(errorId){
    case ERROR_ERRS0001:
      return ERRS0001;
    case ERROR_ERRS0002:
      return ERRS0002;
  }
}

init();