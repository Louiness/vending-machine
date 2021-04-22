package com.vending.vo;

public class vendingVO {
		String itemNumber;
		int price;
		String itemImage;
		Boolean soldOutPlag;
		
		public vendingVO(String itemNumber, int price, String itemImage, Boolean soldOutPlag) {
			this.itemNumber = itemNumber;
			this.price = price;
			this.itemImage = itemImage;
			this.soldOutPlag = soldOutPlag;
		}

		public String getitemNumber() {
			return itemNumber;
		}

		public void setitemNumber(String itemNumber) {
			this.itemNumber = itemNumber;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public String getitemImage() {
			return itemImage;
		}

		public void setitemImage(String itemImage) {
			this.itemImage = itemImage;
		}

		public Boolean getsoldOutPlag() {
			return soldOutPlag;
		}

		public void setsoldOutPlag(Boolean soldOutPlag) {
			this.soldOutPlag = soldOutPlag;
		}
}
