package com.github.dustinkieler.itemparser.json;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.github.dustinkieler.itemparser.items.Item;
import com.github.dustinkieler.itemparser.items.ItemBonuses;

/**
 * Contains utilities to convert an {@link Item}(s) to JSON using Google GSON.
 * @author Dustin Kieler
 *
 */
public class ItemToJsonConverter {
    
    /**
     * Converts an {@link ArrayList} of {@link Item}s and outputs the JSON
     * to a given output file.
     * The {@link GsonBuilder} uses an {@link ExcludeZeroSerializer} to convert
     * the {@link Item}'s {@link ItemBonuses}, disables HTML escaping, and utilizes
     * pretty printing.
     * @param itemsToConvert The {@link ArrayList} of {@link Item}s to convert.
     * @param outputFile The file the JSON will be printed to.
     */
    public static void convert(final ArrayList<Item> itemsToConvert, File outputFile) {
        final Gson gson = new GsonBuilder()
                              .registerTypeAdapter(ItemBonuses.class, new ExcludeZeroSerializer())
                              .disableHtmlEscaping()
                              .setPrettyPrinting()
                              .create();
        BufferedWriter fileWriter;
        try {
            fileWriter = new BufferedWriter(new FileWriter(outputFile));
            fileWriter.write(gson.toJson(itemsToConvert));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}