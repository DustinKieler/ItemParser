package main.java.com.github.dustinkieler.itemparser.items;

/**
 * Represents an item which contains an item ID, name, description, prices (shop, low alchemy, high alchemy),
 * and item bonuses. This object is immutable.
 * @author Dustin Kieler
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
    
    /**
     * @return The ID of this {@code Item}.
     */
    public int itemID() {
        return itemID;
    }
    
    /**
     * @return The name of this {@code Item}.
     */
    public String name() {
        return name;
    }

    /**
     * @return The description of this {@code Item}.
     */
    public String description() {
        return description;
    }
    
    /**
     * @return The shop price of this {@code Item}.
     */    
    public int shopPrice() {
        return shopPrice;
    }
    
    /**
     * @return The low alchemy price of this {@code Item}.
     */    
    public int lowAlchPrice() {
        return lowAlchPrice;
    }

    /**
     * @return The high alchemy price of this {@code Item}.
     */
    public int highAlchPrice() {
        return highAlchPrice;
    }
    
    /**
     * @return The {@link ItemBonuses} of this {@code Item}.
     */    
    public ItemBonuses itemBonuses() {
        return bonuses;
    }
    
    /**
     * @return A {@link String} of the item's attributes separated by a space.
     */
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
    
    /**
     * A Builder used to produce the immutable {@link Item}.
     * "The builder is mutable, the object it produces should be immutable! No setters! -Jon Skeet
     * @author Dustin Kieler
     *
     */
    public static class ItemBuilder {
        
        private int itemID;
        private String name;
        private String description;
        private int shopPrice;
        private int lowAlchPrice;
        private int highAlchPrice;
        private ItemBonuses bonuses;
        
        /**
         * Constructs a new builder with default field values.
         */
        public ItemBuilder() {
            this.itemID = -1;
            this.name = "";
            this.description = "";
            this.shopPrice = 0;
            this.lowAlchPrice = 0;
            this.highAlchPrice = 0;
            this.bonuses = null;
        }
        
        /**
         * Sets the item ID of the {@link Item} being constructed.
         * @param itemID The ID of the {@link Item}.
         * @return The current {@link Item} under construction.
         */
        public ItemBuilder itemID(final int itemID) {
            this.itemID = itemID;
            return this;
        }

        /**
         * Sets the name of the {@link Item} being constructed.
         * @param name The name of the {@link Item}.
         * @return The current {@link Item} under construction.
         */
        public ItemBuilder name(final String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the description of the {@link Item} being constructed.
         * @param description The description describing the {@link Item}.
         * @return The current {@link Item} under construction.
         */
        public ItemBuilder description(final String description) {
            this.description = description;
            return this;
        }
        
        /**
         * Sets the shop price of the {@link Item} being constructed.
         * @param shopPrice The shop price of the {@link Item}.
         * @return The current {@link Item} under construction.
         */        
        public ItemBuilder shopPrice(final int shopPrice) {
            this.shopPrice = shopPrice;
            return this;
        }
        
        /**
         * Sets the low alchemy price of the {@link Item} being constructed.
         * @param lowAlchPrice The low alchemy price of the {@link Item}.
         * @return The current {@link Item} under construction.
         */        
        public ItemBuilder lowAlchPrice(final int lowAlchPrice) {
            this.lowAlchPrice = lowAlchPrice;
            return this;
        }
        
        /**
         * Sets the high alchemy price of the {@link Item} being constructed.
         * @param highAlchPrice The high alchemy price of the {@link Item}.
         * @return The current {@link Item} under construction.
         */        
        public ItemBuilder highAlchPrice(final int highAlchPrice) {
            this.highAlchPrice = highAlchPrice;
            return this;
        }
        
        /**
         * Sets the item bonuses of the {@link Item} being constructed.
         * @param bonuses The {@link ItemBonuses} of the {@link Item}.
         * @return The current {@link Item} under construction.
         */        
        public ItemBuilder itemBonuses(final ItemBonuses bonuses) {
            this.bonuses = bonuses;
            return this;
        }
        
        /**
         * Builds the {@link Item} and returns it.
         * @return The constructed {@link Item}.
         */
        public Item build() {
            return new Item(this);
        }
        
    }
    
    /**
     * Creates a new {@code Item} given a {@link ItemBuilder} for the {@code Item}.
     * @param builder The {@link ItemBuilder} that will be used for this {@code Item}.
     */
    private Item(final ItemBuilder builder) {
        this.itemID = builder.itemID;
        this.name = builder.name;
        this.description = builder.description;
        this.shopPrice = builder.shopPrice;
        this.lowAlchPrice = builder.lowAlchPrice;
        this.highAlchPrice = builder.highAlchPrice;
        this.bonuses = builder.bonuses;
    }

}
