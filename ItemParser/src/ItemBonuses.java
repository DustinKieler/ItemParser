
public class ItemBonuses {
	
	private final int stabBonus;
	private final int slashBonus;
	private final int crushBonus;
	private final int magicAttackBonus;
	private final int rangedAttackBonus;
	private final int stabDefenceBonus;
	private final int slashDefenceBonus;
	private final int crushDefenceBonus;
	private final int magicDefenceBonus;
	private final int rangedDefenceBonus;
	private final int strengthBonus;
	private final int prayerBonus;
	
	public int attackBonus() {
		return stabBonus;
	}
	
	public int slashBonus() {
		return slashBonus;
	}
	
	public int crushBonus() {
		return crushBonus;
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
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append(stabBonus).append(" ")
				.append(slashBonus).append(" ")
				.append(crushBonus).append(" ")
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
	
	public static class Builder {
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
		
		public Builder stabBonus(int stabBonus) {
			this.stabBonus = stabBonus;
			return this;
		}
		
		public Builder slashBonus(int slashBonus) {
			this.slashBonus = slashBonus;
			return this;
		}
		
		public Builder crushBonus(int crushBonus) {
			this.crushBonus = crushBonus;
			return this;
		}
		
		public Builder magicAttackBonus(int magicAttackBonus) {
			this.magicAttackBonus = magicAttackBonus;
			return this;
		}
		
		public Builder rangedAttackBonus(int rangedAttackBonus) {
			this.rangedAttackBonus = rangedAttackBonus;
			return this;
		}
		
		public Builder stabDefenceBonus(int stabDefenceBonus) {
			this.stabDefenceBonus = stabDefenceBonus;
			return this;
		}
		
		public Builder slashDefenceBonus(int slashDefenceBonus) {
			this.slashDefenceBonus = slashDefenceBonus;
			return this;
		}
		
		public Builder crushDefenceBonus(int crushDefenceBonus) {
			this.crushDefenceBonus = crushDefenceBonus;
			return this;
		}
		
		public Builder magicDefenceBonus(int magicDefenceBonus) {
			this.magicDefenceBonus = magicDefenceBonus;
			return this;
		}
		
		public Builder rangedDefenceBonus(int rangedDefenceBonus) {
			this.rangedDefenceBonus = rangedDefenceBonus;
			return this;
		}
		
		public Builder strengthBonus(int strengthBonus) {
			this.strengthBonus = strengthBonus;
			return this;
		}
		
		public Builder prayerBonus(int prayerBonus) {
			this.prayerBonus = prayerBonus;
			return this;
		}
		
		public ItemBonuses build() {
			return new ItemBonuses(this);
		}
		
	}
	
	private ItemBonuses(Builder builder) {
		this.stabBonus = builder.stabBonus;
		this.slashBonus = builder.slashBonus;
		this.crushBonus = builder.crushBonus;
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

}
