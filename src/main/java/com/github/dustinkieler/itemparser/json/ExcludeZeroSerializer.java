package com.github.dustinkieler.itemparser.json;

import java.lang.reflect.Type;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import com.github.dustinkieler.itemparser.items.ItemBonuses;

/**
 * This {@link ItemBonuses} JSON serializer is used to ignore integer fields that
 * have the value of 0.
 * @author Dustin Kieler
 *
 */
public class ExcludeZeroSerializer implements JsonSerializer<ItemBonuses> {

    /**
     * Serializes an ItemBonuses object, ignoring integer fields with the value of 0.
     * Any integer fields with the value of 0 are removed from the JSON object tree.
     * If the entry set of the JSON object tree is empty once all zero-valued fields
     * are removed, the serialization will return a {@code null} {@link JsonElement}.
     */
    @Override
    public JsonElement serialize(ItemBonuses bonusesObject, Type type, JsonSerializationContext context) {
        final Gson gson = new Gson();
        JsonObject jObj = (JsonObject) gson.toJsonTree(bonusesObject);
        jObj.entrySet().stream()
                            .filter(entry -> entry.getValue().getAsInt() != 0)
                            .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
        // We are serializing only the inner bonuses object here of the Item object, so we check if it's empty.
        // JSON won't serialize nulls, so we'll return null if all bonuses are 0.
        if (jObj.entrySet().isEmpty())
            return null;
        
        return jObj;
    }
    
}
