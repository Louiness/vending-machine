<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="kr">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="style/style.css">
  <title>VendingMachine</title>
</head>
<body>
	<div class="container">
		<div class="vending-machine">
			<div class="display-board">
				<div class="items">
					<div class="item1">
						<div class="purchase-button">
							<div class="product-state"></div>
							<div class="product-info"></div>
						</div>
					</div>
					<div class="item2">
						<div class="purchase-button">
							<div class="product-state"></div>
							<div class="product-info"></div>
						</div>
					</div>
					<div class="item3">
						<div class="purchase-button">
							<div class="product-state"></div>
							<div class="product-info"></div>
						</div>
					</div>
					<div class="item4">
						<div class="purchase-button">
							<div class="product-state"></div>
							<div class="product-info"></div>
						</div>
					</div>
					<div class="item5">
						<div class="purchase-button">
							<div class="product-state"></div>
							<div class="product-info"></div>
						</div>
					</div>
					<div class="item6">
						<div class="purchase-button">
							<div class="product-state"></div>
							<div class="product-info"></div>
						</div>
					</div>
					<div class="item7">
						<div class="purchase-button">
							<div class="product-state"></div>
							<div class="product-info"></div>
						</div>
					</div>
					<div class="item8">
						<div class="purchase-button">
							<div class="product-state"></div>
							<div class="product-info"></div>
						</div>
					</div>
					<div class="item9">
						<div class="purchase-button">
							<div class="product-state"></div>
							<div class="product-info"></div>
						</div>
					</div>
					<div class="item10">
						<div class="purchase-button">
							<div class="product-state"></div>
							<div class="product-info"></div>
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
	</div>
</body>
</html>
