package com.vending.vo;
/**
 * 自動販売機VO
 * @author 林基文
 *
 */
public class vendingVO {
		//　製品番号
		String itemNumber;
		//　金額
		int price;
		//　製品イメージ
		String itemImage;
		//　売り切れプラグ
		String soldOutFlag;
		
		/**
		 * 製品情報
		 * @param　String itemNumber（製品番号）
		 *         int price（金額）
		 *         String itemImage（製品イメージ）
		 *         String soldOutFlag（売り切れプラグ）
		 */
		public vendingVO(String itemNumber, int price, String itemImage, String soldOutFlag) {
			this.itemNumber = itemNumber;
			this.price = price;
			this.itemImage = itemImage;
			this.soldOutFlag = soldOutFlag;
		}

		/**
		 * 製品番号
		 * @return　itemNumber(製品番号)
		 */
		public String getitemNumber() {
			return itemNumber;
		}
		/**
		 * 製品番号
		 * @param　String itemNumber（製品番号）
		 */
		public void setitemNumber(String itemNumber) {
			this.itemNumber = itemNumber;
		}
		/**
		 * 金額
		 * @return　price(金額)
		 */
		public int getPrice() {
			return price;
		}
		/**
		 * 金額
		 * @param　int price（金額）
		 */
		public void setPrice(int price) {
			this.price = price;
		}
		/**
		 * 製品イメージ
		 * @return　itemImage(製品イメージ)
		 */
		public String getitemImage() {
			return itemImage;
		}
		/**
		 * 製品イメージ
		 * @param　int itemImage（製品イメージ）
		 */
		public void setitemImage(String itemImage) {
			this.itemImage = itemImage;
		}
		/**
		 * 売り切れプラグ
		 * @return　soldOutFlag(売り切れプラグ)
		 */
		public String getsoldOutFlag() {
			return soldOutFlag;
		}
		/**
		 * 売り切れプラグ
		 * @param　int soldOutFlag（売り切れプラグ）
		 */
		public void setsoldOutFlag(String soldOutFlag) {
			this.soldOutFlag = soldOutFlag;
		}
}
