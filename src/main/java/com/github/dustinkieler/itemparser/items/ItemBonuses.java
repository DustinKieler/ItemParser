package com.github.dustinkieler.itemparser.items;

/**
 * Represents the equipment bonuses of an item.
 * This object is immutable after creation.
 * An item may have the following bonuses:
 *     -Offensive/defensive stab
 *     -Offensive/defensive slash
 *     -Offensive/defensive crush
 *     -Offensive/defensive magic
 *     -Offensive/defensive ranged
 *     -Strength
 *     -Prayer
 * @author Dustin Kieler
 *
 */
public class ItemBonuses {
    
    /**
     * Current bonuses given to an item.
     * Getters are self-explanatory.
     */
    private final int stabAttackBonus;
    private final int slashAttackBonus;
    private final int crushAttackBonus;
    private final int magicAttackBonus;
    private final int rangedAttackBonus;
    private final int stabDefenceBonus;
    private final int slashDefenceBonus;
    private final int crushDefenceBonus;
    private final int magicDefenceBonus;
    private final int rangedDefenceBonus;
    private final int strengthBonus;
    private final int prayerBonus;
    
    public int stabAttackBonus() {
        return stabAttackBonus;
    }
    
    public int slashAttackBonus() {
        return slashAttackBonus;
    }
    
    public int crushAttackBonus() {
        return crushAttackBonus;
    }
    
    public int magicAttackBonus() {
        return magicAttackBonus;
    }
    
    public int rangedAttackBonus() {
        return rangedAttackBonus;
    }
    
    public int stabDefenceBonus() {
        return stabDefenceBonus;
    }
    
    public int slashDefenceBonus() {
        return slashDefenceBonus;
    }
    
    public int crushDefenceBonus() {
        return crushDefenceBonus;
    }
    
    public int magicDefencebonus() {
        return magicDefenceBonus;
    }
    
    public int rangedDefenceBonus() {
        return rangedDefenceBonus;
    }
    
    public int strengthBonus() {
        return strengthBonus;
    }
    
    public int prayerBonus() {
        return prayerBonus;
    }
    
    /**
     * Returns a {@link String} of the bonuses separated by a space.
     */
    @Override
    public String toString() {
        return new StringBuilder()
                .append(stabAttackBonus).append(" ")
                .append(slashAttackBonus).append(" ")
                .append(crushAttackBonus).append(" ")
                .append(magicAttackBonus).append(" ")
                .append(rangedAttackBonus).append(" ")
                .append(stabDefenceBonus).append(" ")
                .append(slashDefenceBonus).append(" ")
                .append(crushDefenceBonus).append(" ")
                .append(magicDefenceBonus).append(" ")
                .append(rangedDefenceBonus).append(" ")
                .append(strengthBonus).append(" ")
                .append(prayerBonus)
                .toString();
    }
    
    /**
     * A Builder used to produce the immutable {@link ItemBonuses}.
     * @author Dustin Kieler
     *
     */
    public static class ItemBonusesBuilder {
        private int stabBonus;
        private int slashBonus;
        private int crushBonus;
        private int magicAttackBonus;
        private int rangedAttackBonus;
        private int stabDefenceBonus;
        private int slashDefenceBonus;
        private int crushDefenceBonus;
        private int magicDefenceBonus;
        private int rangedDefenceBonus;
        private int strengthBonus;
        private int prayerBonus;
        
        /**
         * Sets the offensive stab bonus of the {@link ItemBonuses} being constructed.
         * @param stabBonus The offensive stab bonus.
         * @return The current {@link ItemBonuses} under construction.
         */        
        public ItemBonusesBuilder stabBonus(final int stabBonus) {
            this.stabBonus = stabBonus;
            return this;
        }
        
        /**
         * Sets the offensive slash bonus of the {@link ItemBonuses} being constructed.
         * @param slashBonus The offensive slash bonus.
         * @return The current {@link ItemBonuses} under construction.
         */            
        public ItemBonusesBuilder slashBonus(final int slashBonus) {
            this.slashBonus = slashBonus;
            return this;
        }
        
        /**
         * Sets the offensive crush bonus of the {@link ItemBonuses} being constructed.
         * @param crushBonus The offensive crush bonus.
         * @return The current {@link ItemBonuses} under construction.
         */            
        public ItemBonusesBuilder crushBonus(final int crushBonus) {
            this.crushBonus = crushBonus;
            return this;
        }
        
        /**
         * Sets the offensive magic bonus of the {@link ItemBonuses} being constructed.
         * @param magicAttackBonus The offensive magic bonus.
         * @return The current {@link ItemBonuses} under construction.
         */            
        public ItemBonusesBuilder magicAttackBonus(final int magicAttackBonus) {
            this.magicAttackBonus = magicAttackBonus;
            return this;
        }
        
        /**
         * Sets the offensive ranged bonus of the {@link ItemBonuses} being constructed.
         * @param rangedAttackBonus The offensive ranged bonus.
         * @return The current {@link ItemBonuses} under construction.
         */            
        public ItemBonusesBuilder rangedAttackBonus(final int rangedAttackBonus) {
            this.rangedAttackBonus = rangedAttackBonus;
            return this;
        }
        
        /**
         * Sets the defensive stab bonus of the {@link ItemBonuses} being constructed.
         * @param stabDefenceBonus The defensive stab bonus.
         * @return The current {@link ItemBonuses} under construction.
         */    
        public ItemBonusesBuilder stabDefenceBonus(final int stabDefenceBonus) {
            this.stabDefenceBonus = stabDefenceBonus;
            return this;
        }
        
        /**
         * Sets the defensive slash bonus of the {@link ItemBonuses} being constructed.
         * @param slashDefenceBonus The defensive slash bonus.
         * @return The current {@link ItemBonuses} under construction.
         */            
        public ItemBonusesBuilder slashDefenceBonus(final int slashDefenceBonus) {
            this.slashDefenceBonus = slashDefenceBonus;
            return this;
        }
        
        /**
         * Sets the defensive crush bonus of the {@link ItemBonuses} being constructed.
         * @param crushDefenceBonus The defensive crush bonus.
         * @return The current {@link ItemBonuses} under construction.
         */            
        public ItemBonusesBuilder crushDefenceBonus(final int crushDefenceBonus) {
            this.crushDefenceBonus = crushDefenceBonus;
            return this;
        }
        
        /**
         * Sets the defensive magic bonus of the {@link ItemBonuses} being constructed.
         * @param magicDefenceBonus The defensive magic bonus.
         * @return The current {@link ItemBonuses} under construction.
         */            
        public ItemBonusesBuilder magicDefenceBonus(final int magicDefenceBonus) {
            this.magicDefenceBonus = magicDefenceBonus;
            return this;
        }
        
        /**
         * Sets the defensive ranged bonus of the {@link ItemBonuses} being constructed.
         * @param rangedDefenceBonus The defensive ranged bonus.
         * @return The current {@link ItemBonuses} under construction.
         */            
        public ItemBonusesBuilder rangedDefenceBonus(final int rangedDefenceBonus) {
            this.rangedDefenceBonus = rangedDefenceBonus;
            return this;
        }
        
        /**
         * Sets the strength of the {@link ItemBonuses} being constructed.
         * @param strengthBonus The strength bonus.
         * @return The current {@link ItemBonuses} under construction.
         */            
        public ItemBonusesBuilder strengthBonus(final int strengthBonus) {
            this.strengthBonus = strengthBonus;
            return this;
        }
        
        /**
         * Sets the prayer bonus of the {@link ItemBonuses} being constructed.
         * @param prayerBonus The prayer bonus.
         * @return The current {@link ItemBonuses} under construction.
         */            
        public ItemBonusesBuilder prayerBonus(final int prayerBonus) {
            this.prayerBonus = prayerBonus;
            return this;
        }
        
        /**
         * Builds the {@link ItemBonuses} and returns it.
         * @return The constructed {@link ItemBonuses}.
         */
        public ItemBonuses build() {
            return new ItemBonuses(this);
        }
        
    }
    
    /**
     * Creates a new {@code ItemBonuses} given a {@link ItemBonusesBuilder} for the {@code ItemBonuses}.
     * @param builder The {@link ItemBonusesBuilder} that will be used for this {@code ItemBonuses} object.
     */
    private ItemBonuses(final ItemBonusesBuilder builder) {
        this.stabAttackBonus = builder.stabBonus;
        this.slashAttackBonus = builder.slashBonus;
        this.crushAttackBonus = builder.crushBonus;
        this.magicAttackBonus = builder.magicAttackBonus;
        this.rangedAttackBonus = builder.rangedAttackBonus;
        this.stabDefenceBonus = builder.stabDefenceBonus;
        this.slashDefenceBonus = builder.slashDefenceBonus;
        this.crushDefenceBonus = builder.crushDefenceBonus;
        this.magicDefenceBonus = builder.magicDefenceBonus;
        this.rangedDefenceBonus = builder.rangedDefenceBonus;
        this.strengthBonus = builder.strengthBonus;
        this.prayerBonus = builder.prayerBonus;
    }

    /**
     * Returns a unique hashcode for this {@code ItemBonuses} based on all bonuses.
     * @return The hashcode for this {@code ItemBonuses}.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + crushAttackBonus;
        result = prime * result + crushDefenceBonus;
        result = prime * result + magicAttackBonus;
        result = prime * result + magicDefenceBonus;
        result = prime * result + prayerBonus;
        result = prime * result + rangedAttackBonus;
        result = prime * result + rangedDefenceBonus;
        result = prime * result + slashAttackBonus;
        result = prime * result + slashDefenceBonus;
        result = prime * result + stabAttackBonus;
        result = prime * result + stabDefenceBonus;
        result = prime * result + strengthBonus;
        return result;
    }

    /**
     * Returns whether or not this {@code ItemBonuses} object is equal to the passed in {@link Object}.
     * If the {@code ItemBonuses} objects have fully equal bonuses, they are equal.
     * @param obj The {@link Object} to compare to.
     * @return True if this {@code ItemBonuses} is equal to {@code obj}, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ItemBonuses other = (ItemBonuses) obj;
        if (crushAttackBonus != other.crushAttackBonus)
            return false;
        if (crushDefenceBonus != other.crushDefenceBonus)
            return false;
        if (magicAttackBonus != other.magicAttackBonus)
            return false;
        if (magicDefenceBonus != other.magicDefenceBonus)
            return false;
        if (prayerBonus != other.prayerBonus)
            return false;
        if (rangedAttackBonus != other.rangedAttackBonus)
            return false;
        if (rangedDefenceBonus != other.rangedDefenceBonus)
            return false;
        if (slashAttackBonus != other.slashAttackBonus)
            return false;
        if (slashDefenceBonus != other.slashDefenceBonus)
            return false;
        if (stabAttackBonus != other.stabAttackBonus)
            return false;
        if (stabDefenceBonus != other.stabDefenceBonus)
            return false;
        if (strengthBonus != other.strengthBonus)
            return false;
        return true;
    }

}
