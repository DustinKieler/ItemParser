/**
 * Immutable item class
 * Builder pattern - the builder is mutable, the object it produces should be immutable! No setters! -Jon Skeet
 * @author kielerd2
 *
 */
public class Item {
	
	private final int itemID;
	private final String name;
	private final String description;
	private final int shopPrice;
	private final int lowAlchPrice;
	private final int highAlchPrice;
	private final ItemBonuses bonuses;
	
	public int itemID() {
		return itemID;
	}
	
	public String name() {
		return name;
	}
	
	public String description() {
		return description;
	}
	
	public int shopPrice() {
		return shopPrice;
	}
	
	public int lowAlchPrice() {
		return lowAlchPrice;
	}
	
	public int highAlchPrice() {
		return highAlchPrice;
	}
	
	public ItemBonuses itemBonuses() {
		return bonuses;
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append(itemID).append(" ")
				.append(name).append(" ")
				.append(description).append(" ")
				.append(shopPrice).append(" ")
				.append(lowAlchPrice).append(" ")
				.append(highAlchPrice).append(" ")
				.append(bonuses.toString())
				.toString();
	}
	
	public static class Builder {
		
		private int itemID;
		private String name;
		private String description;
		private int shopPrice;
		private int lowAlchPrice;
		private int highAlchPrice;
		private ItemBonuses bonuses;
		
		public Builder() {
			this.itemID = -1;
			this.name = "";
			this.description = "";
			this.shopPrice = 0;
			this.lowAlchPrice = 0;
			this.highAlchPrice = 0;
			this.bonuses = null;
		}
		
		public Builder itemID(int itemID) {
			this.itemID = itemID;
			return this;
		}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder description(String description) {
			this.description = description;
			return this;
		}
		
		public Builder shopPrice(int shopPrice) {
			this.shopPrice = shopPrice;
			return this;
		}
		
		public Builder lowAlchPrice(int lowAlchPrice) {
			this.lowAlchPrice = lowAlchPrice;
			return this;
		}
		
		public Builder highAlchPrice(int highAlchPrice) {
			this.highAlchPrice = highAlchPrice;
			return this;
		}
		
		public Builder itemBonuses(ItemBonuses bonuses) {
			this.bonuses = bonuses;
			return this;
		}
		
		public Item build() {
			return new Item(this);
		}
		
	}
	
	private Item(Builder builder) {
		this.itemID = builder.itemID;
		this.name = builder.name;
		this.description = builder.description;
		this.shopPrice = builder.shopPrice;
		this.lowAlchPrice = builder.lowAlchPrice;
		this.highAlchPrice = builder.highAlchPrice;
		this.bonuses = builder.bonuses;
	}

}
