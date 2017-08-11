import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ItemParser {
	
	public Item parseItem(String itemInformation) {		
		try {
			Queue<String> itemDefs = new LinkedList<String>(Arrays.asList(itemInformation.split("\\s+")));
			itemDefs.remove(); // Get rid of "item"
			itemDefs.remove(); // Get rid of "="
			if (itemDefs.peek().equals("13597"))
				System.out.println("OK");
			Item item = new Item.Builder()
								.itemID(Integer.parseInt(itemDefs.remove()))
								.name(itemDefs.remove())
								.description(itemDefs.remove())
								.shopPrice(Integer.parseInt(removeDecimal(itemDefs.remove()))) // Make sure this and the next two lines are ordered correctly.
								.lowAlchPrice(Integer.parseInt(removeDecimal(itemDefs.remove())))
								.highAlchPrice(Integer.parseInt(removeDecimal(itemDefs.remove())))
								.itemBonuses(parseItemBonuses(itemDefs))
								.build();
			return item;
		} catch (NumberFormatException numberFormatException) {
			System.out.println("There was an issue converting data types.");
			numberFormatException.printStackTrace();
			return null;
		}		
	}
	
	private ItemBonuses parseItemBonuses(Queue<String> bonuses) {
		try {
			ItemBonuses itemBonuses = new ItemBonuses.Builder()
					.stabBonus(Integer.parseInt(bonuses.remove()))
					.slashBonus(Integer.parseInt(bonuses.remove()))
					.crushBonus(Integer.parseInt(bonuses.remove()))
					.magicAttackBonus(Integer.parseInt(bonuses.remove()))
					.rangedAttackBonus(Integer.parseInt(bonuses.remove()))
					.stabDefenceBonus(Integer.parseInt(bonuses.remove()))
					.slashDefenceBonus(Integer.parseInt(bonuses.remove()))
					.crushDefenceBonus(Integer.parseInt(bonuses.remove()))
					.magicDefenceBonus(Integer.parseInt(bonuses.remove()))
					.rangedDefenceBonus(Integer.parseInt(bonuses.remove()))
					.strengthBonus(Integer.parseInt(bonuses.remove()))
					.prayerBonus(Integer.parseInt(bonuses.remove()))
					.build();
			
			if (!bonuses.isEmpty()) {
				System.out.println("-----There were not 20 elements for this item!-----");
			}
			
			return itemBonuses;
			
		} catch (NoSuchElementException nsee) {
			System.out.println("The queue is already empty! Not enough elements!");
			nsee.printStackTrace();
			return null;
		}
	}
	
	private String removeDecimal(String string) {
		return string.contains(".") ? string.substring(0, string.indexOf(".")) : string;
	}

}
