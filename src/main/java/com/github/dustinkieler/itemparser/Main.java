package com.github.dustinkieler.itemparser;

import java.io.File;

import com.github.dustinkieler.itemparser.items.ItemParser;
import com.github.dustinkieler.itemparser.json.ItemToJsonConverter;

/**
 * Contains the main method.
 * This creates a new parser that will parse through item.cfg,
 * parses the file, and then calls to convert the parsed file to JSON
 * through the {@link ItemToJsonConverter} and output it to a file
 * called item.json.
 * @author Dustin Kieler
 *
 */
public class Main {

    /**
     * Main method. See class comment for functionality of this method.
     * @param args is unused
     */
    public static void main(String[] args) {
        ItemParser itemParser = new ItemParser(new File("item.cfg"));
        itemParser.parseItemConfig();
        ItemToJsonConverter.convert(itemParser.getItems(), new File("item.json"));
    }

}
