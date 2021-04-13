package com.vending.dao;

public class vendingVO {
		String item_Number;
		int item_Quantity;
		int max_Item_Quantity;
		
		public vendingVO(String item_Number, int item_Quantity, int max_Item_Quantity) {
			this.item_Number = item_Number;
			this.item_Quantity = item_Quantity;
			this.max_Item_Quantity = max_Item_Quantity;
		}

		public String getItem_Number() {
			return item_Number;
		}

		public void setItem_Number(String item_Number) {
			this.item_Number = item_Number;
		}

		public int getItem_Quantity() {
			return item_Quantity;
		}

		public void setItem_Quantity(int item_Quantity) {
			this.item_Quantity = item_Quantity;
		}

		public int getMax_Item_Quantity() {
			return max_Item_Quantity;
		}

		public void setMax_Item_Quantity(int max_Item_Quantity) {
			this.max_Item_Quantity = max_Item_Quantity;
		}
		
}
