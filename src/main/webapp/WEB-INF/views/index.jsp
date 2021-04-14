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
					<div class="item1">
						<!-- 제품이미지 설정 -->
						<img src="" alt="" srcset="">
						<div class="purchase-button">
							<div class="product-state">
								<!-- 매진플래그 설정 -->
								<input type="hidden" class="sold-out-flag" value=""/>
							</div>
							<div class="product-info">
								<!-- id값에 제품번호를 설정. text에 가격 설정 -->
								<span id="productNumber1" class="price">1</span>
							</div>
						</div>
					</div>
					<div class="item2">
						<img src="" alt="" srcset="">
						<div class="purchase-button">
							<div class="product-state">
								<input type="hidden" class="sold-out-flag" value=""/>
							</div>
							<div class="product-info">
								<span id="productNumber2" class="price">2</span>
							</div>
						</div>
					</div>
					<div class="item3">
						<img src="" alt="" srcset="">
						<div class="purchase-button">
							<div class="product-state">
								<input type="hidden" class="sold-out-flag" value=""/>
							</div>
							<div class="product-info">
								<span id="productNumber3" class="price">3</span>
							</div>
						</div>
					</div>
					<div class="item4">
						<img src="" alt="" srcset="">
						<div class="purchase-button">
							<div class="product-state">
								<input type="hidden" class="sold-out-flag" value=""/>
							</div>
							<div class="product-info">
								<span id="productNumber4" class="price">4</span>
							</div>
						</div>
					</div>
					<div class="item5">
						<img src="" alt="" srcset="">
						<img src="" alt="" srcset="">
						<div class="purchase-button">
							<div class="product-state">
								<input type="hidden" class="sold-out-flag" value=""/>
							</div>
							<div class="product-info">
								<span id="productNumber5" class="price">5</span>
							</div>
						</div>
					</div>
					<div class="item6">
						<img src="" alt="" srcset="">
						<div class="purchase-button">
							<div class="product-state">
								<input type="hidden" class="sold-out-flag" value=""/>
							</div>
							<div class="product-info">
								<span id="productNumber6" class="price">6</span>
							</div>
						</div>
					</div>
					<div class="item7">
						<img src="" alt="" srcset="">
						<div class="purchase-button">
							<div class="product-state">
								<input type="hidden" class="sold-out-flag" value=""/>
							</div>
							<div class="product-info">
								<span id="productNumber7" class="price">7</span>
							</div>
						</div>
					</div>
					<div class="item8">
						<img src="" alt="" srcset="">
						<div class="purchase-button">
							<div class="product-state">
								<input type="hidden" class="sold-out-flag" value=""/>
							</div>
							<div class="product-info">
								<span id="productNumber8" class="price">8</span>
							</div>
						</div>
					</div>
					<div class="item9">
						<img src="" alt="" srcset="">
						<div class="purchase-button">
							<div class="product-state">
								<input type="hidden" class="sold-out-flag" value=""/>
							</div>
							<div class="product-info">
								<span id="productNumber9" class="price">9</span>
							</div>
						</div>
					</div>
					<div class="item10">
						<img src="" alt="" srcset="">
						<div class="purchase-button">
							<div class="product-state">
								<input type="hidden" class="sold-out-flag" value=""/>
							</div>
							<div class="product-info">
								<span id="productNumber10" class="price">10</span>
							</div>
						</div>
					</div>
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
			<div class="coin">10yen
				<img id="10yen" src="" alt="" srcset="">
			</div>
			<div class="coin">50yen
				<img id="50yen" src="" alt="" srcset="">
			</div>
			<div class="coin">100yen
				<img id="100yen" src="" alt="" srcset="">
			</div>
			<div class="coin">500yen
				<img id="500yen" src="" alt="" srcset="">
			</div>
		</div>
	</div>
	<script src="js/main.js"></script>
	<script src="js/purchase.js"></script>
	<script src="js/balance.js"></script>
	<script src="js/constant.js"></script>
</body>
</html>
