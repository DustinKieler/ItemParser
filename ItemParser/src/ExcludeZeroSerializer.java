import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class ExcludeZeroSerializer implements JsonSerializer<ItemBonuses> {

	@Override
	public JsonElement serialize(ItemBonuses arg0, Type arg1, JsonSerializationContext arg2) {
		Gson gson = new Gson();
		JsonObject jObj = (JsonObject) gson.toJsonTree(arg0);
		List<String> toRemove = new ArrayList<>();
		for (Map.Entry<String, JsonElement> entry : jObj.entrySet()) {
			if (entry.getValue().getAsInt() == 0)
				toRemove.add(entry.getKey());
		}
		for (String keyToRemove : toRemove) {
			jObj.remove(keyToRemove);
		}
		// We are serializing only the inner bonuses object here of the Item object, so we check if it's empty.
		// JSON won't serialize nulls, so we'll return null if all bonuses are 0.
		if (jObj.entrySet().isEmpty())
			return null;
		
		return jObj;
	}
	
}
