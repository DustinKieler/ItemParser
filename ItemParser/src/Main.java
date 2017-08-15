import java.io.File;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		ItemParser itemParser = new ItemParser(new File("item.cfg"));
		itemParser.parseItemConfig();
		ItemToJsonConverter.convert(itemParser.getItems(), new File("item.json"));
	}

}
