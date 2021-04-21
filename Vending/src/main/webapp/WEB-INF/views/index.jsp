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
        <c:forEach var="Test" items="${list}">
          <div class="item1">
            <!-- 제품이미지 설정 -->
            <img src="${Test.itemImage}" alt="" srcset="">
            <div class="purchase-button">
              <div class="product-state">
                <!-- 매진플래그 설정 -->
                <input type="hidden" class="sold-out-flag" value="${Test.soldOutPlag}"/>
              </div>
              <div class="product-info">
                <!-- id값에 제품번호를 설정. text에 가격 설정 -->
                <span id="${Test.itemNumber}" class="price">${Test.price}</span>
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
        <div class="balance-display">
          <span id="balance">ddd</span>
        </div>
        <div class="bill-acceptor">
          <span>지폐 투입구</span>
        </div>
        <div class="coin-changer">
          <span>거스름돈</span>
        </div>
        <div class="coin-insert">
          <span>동전 투입구</span>
        </div>
        <div class="coin-return">
          <span>거스름돈 반환구</span>
        </div>
      </div>
    </div>
    <div class="casher-popup">
      <img class="coin 10yen" id="10yen" src="image/10yen.jpg" alt="" srcset="">
      <img class="coin 50yen" id="50yen" src="image/50yen.jpg" alt="" srcset="">
      <img class="coin 100yen" id="100yen" src="image/100yen.jpg" alt="" srcset="">
      <img class="coin 500yen" id="500yen" src="image/500yen.jpg" alt="" srcset="">
    </div>
  </div>
  <script src="js/main.js"></script>
  <script src="js/purchase.js"></script>
  <script src="js/balance.js"></script>
  <script src="js/constant.js"></script>
</body>
</html>