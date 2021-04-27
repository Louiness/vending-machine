<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="kr">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/style.css">
  <title>VendingMachine</title>
</head>
<body>
  <div class="container">
    <div class="vending-machine">
      <div class="display-board">
        <div class="items">
          <c:forEach var="item" items="${list}" varStatus="stat">
            <div class="item${stat.index+1}">
              <img src="${item.itemImage}" alt="" srcset="">
              <div class="purchase-button">
                <div class="${item.itemNumber} product-state">
                  <input type="hidden" class="${item.itemNumber} sold-out-flag" value="${item.soldOutFlag}" />
                </div>
                <div class="product-info">
                  <span id="${item.itemNumber}" class="price">${item.price}</span>
                </div>
              </div>
            </div>
          </c:forEach>
        </div>
        <div class="pick-up-area">
          <div class="pick-up-box">
            <span>pick up box</span>
          </div>
        </div>
      </div>
      <div class="casher">
        <div class="balance-layout">
          <span id="balance">0</span>
        </div>
        <div class="bill-acceptor-layout">
          <span class="bill-acceptor" id="1000yen">지폐 투입구</span>
        </div>
        <div class="coin-changer-layout">
          <span id="coin-changer">거스름돈</span>
        </div>
        <div class="coin-insert-layout">
          <span id="coin-insert">동전 투입구</span>
        </div>
        <div class="coin-return-layout">
          <span id="coin-return">거스름돈 반환구</span>
        </div>
      </div>
    </div>
    <div id="casher-popup">
      <img class="coin 10yen" id="10yen" src="image/10yen.jpg" alt="" srcset="">
      <img class="coin 50yen" id="50yen" src="image/50yen.jpg" alt="" srcset="">
      <img class="coin 100yen" id="100yen" src="image/100yen.jpg" alt="" srcset="">
      <img class="coin 500yen" id="500yen" src="image/500yen.jpg" alt="" srcset="">
      <a id="close-casher-popup" class="close">
        <img src="image/close.png">
      </a>
    </div>
  </div>
  <div id="change-popup">
    <div class="content">
      <span id="comment">현재 반환된 거스름돈이 없습니다.</span>
      <a id="getChangeBtn" class="active">거스름돈 챙기기</a>
      <a id="close-change-popup" class="close">
        <img src="image/close.png">
      </a>
    </div>
  </div>
  <script src="js/constant.js"></script>
  <script src="js/comment.js"></script>
  <script src="js/main.js"></script>
  <script src="js/purchase.js"></script>
  <script src="js/insert.js"></script>
  <script src="js/balance.js"></script>
</body>
</html>