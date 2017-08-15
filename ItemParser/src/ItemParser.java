import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Parses a typical RS2 emulation item.cfg file into {@link Item}s.
 * To parse a given file, create the {@code ItemParser} with the configuration file.
 * Call the {@code parseItemConfig} method to parse the file into an {@link ArrayList} of {@link Item}s.
 * You can then access these {@link Item}s by calling the {@code getItems} function.
 * @author Dustin Kieler
 *
 */
public class ItemParser {
    
    // This file follows the format of a typical item.cfg file of the early RS2 emulations.
    private File configurationFileToParse;
    
    // The items created from parsing the configuration file.
    private ArrayList<Item> items;
    
    /**
     * Creates a new ItemParser that will parse the given {@code configurationFileToparse}.
     * @param configurationFileToParse The {@link File} containing the item configurations to parse.
     */
    public ItemParser(final File configurationFileToParse) {
        this.configurationFileToParse = configurationFileToParse;
        this.items = new ArrayList<>();
    }
    
    /**
     * Reads a line of the {@code configurationFileToParse} until EOF.
     * Each line will be parsed into an {@link Item} and stored into a
     * list. Once this method is finished executing, the stored {@link Item}s
     * may be accessed by using {@code getItems}.
     */
    public void parseItemConfig() {        
        try {
            final BufferedReader fileReader = new BufferedReader(new FileReader(configurationFileToParse));
            String itemLine = fileReader.readLine();
            
            System.out.println("Parsing line: " + itemLine);
            while (null != itemLine) {                
                parseItem(itemLine);
                itemLine = fileReader.readLine();
                if (null != itemLine)
                    System.out.println("Parsing line: " + itemLine);
            }
            
            fileReader.close();            
            System.out.println("Done!");        
        } catch (IOException ioex) {
            System.out.println("Failed to open the file!");
            ioex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Uncaught exception occurred at top level!");
            ex.printStackTrace();
        }
        
    }
    
    /**
     * Parses a line of the {@code configurationFileToParse} into an {@link Item} and
     * adds it to {@code items}.
     * If a {@link NumberFormatException} is thrown, {@code items} will not change.
     * @param itemInformation The line containing the information about the item.
     */
    private void parseItem(final String itemInformation) {        
        try {
            Queue<String> itemDefs = new LinkedList<String>(Arrays.asList(itemInformation.split("\\s+")));        
            itemDefs.remove(); // Get rid of "item"
            itemDefs.remove(); // Get rid of "="
            final Item item = new Item.ItemBuilder()
                                .itemID(Integer.parseInt(itemDefs.remove()))
                                .name(itemDefs.remove().replaceAll("_", " "))
                                .description(itemDefs.remove().replaceAll("_", " "))
                                .shopPrice(Integer.parseInt(removeDecimal(itemDefs.remove()))) // Make sure this and the next two lines are ordered correctly.
                                .lowAlchPrice(Integer.parseInt(removeDecimal(itemDefs.remove())))
                                .highAlchPrice(Integer.parseInt(removeDecimal(itemDefs.remove())))
                                .itemBonuses(buildItemBonuses(itemDefs))
                                .build();
            items.add(item);        
        } catch (NumberFormatException numberFormatException) {
            System.out.println("There was an issue converting data types.");
            numberFormatException.printStackTrace();
        }        
    }
    
    /**
     * Builds a {@link Queue} of {@link String}s containing the ordered bonuses of the parsed item
     * into an {@link ItemBonuses} object.
     * This function checks whether or not the queue has the exact number of bonuses an item is expected to have.
     * @param bonuses A {@link Queue} of {@link String}s where each element in the queue represents a bonus.
     * @return An {@link ItemBonuses} object that contains the correct bonuses for the item.
     */
    private ItemBonuses buildItemBonuses(Queue<String> bonuses) {    
        try {            
            final ItemBonuses itemBonuses = new ItemBonuses.ItemBonusesBuilder()
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
                return null;
            }
            
            return itemBonuses;
            
        } catch (NoSuchElementException nsee) {
            System.out.println("The queue is already empty! Not enough elements!");
            nsee.printStackTrace();
            return null;
        }
    }
    
    /**
     * Returns a {@link String} with a decimal and any trailing characters removed.
     * For example, "1234.212443" => "1234"
     *                 "123.123.125" => "123"
     * If the {@link String} does not contain any decimals, the input is returned.
     * @param string The {@link String} to remove decimals and trailing characters from.
     * @return A string with the first decimal and trailing characters removed.
     */
    private String removeDecimal(final String string) {
        return string.contains(".") ? string.substring(0, string.indexOf(".")) : string;
    }
    
    /**
     * Returns an {@link ArrayList} of {@link Item}s that have been parsed.
     * If nothing has been parsed yet, this will return an empty {@link ArrayList}.
     * @return The parsed items, if any.
     */
    public ArrayList<Item> getItems() {
        return items;
    }

}
