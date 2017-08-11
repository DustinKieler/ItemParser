import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
	
	public static void main(String[] args) {
		
		ItemParser itemParser = new ItemParser();
		ArrayList<Item> items = new ArrayList<>();
		
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(new File("item.cfg")));
			String itemLine = fileReader.readLine();
			System.out.println("Parsing line: " + itemLine);
			while (null != itemLine) {				
				Item item = itemParser.parseItem(itemLine);
				if (null == item || null == item.itemBonuses())
					System.out.println("FOUND NULL...");
				else
					items.add(item);
				itemLine = fileReader.readLine();
				if (null != itemLine)
					System.out.println("Parsing line: " + itemLine);
			}
			fileReader.close();			
			convertToJSON(items);						
			System.out.println("Done!");		
		} catch (IOException ioex) {
			System.out.println("Failed to open the file!");
			ioex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Uncaught exception occurred at top level!");
			ex.printStackTrace();
		}
		
	}
	
	private static void convertToJSON(ArrayList<Item> items) {
		Gson gson = new GsonBuilder()
						.registerTypeAdapter(ItemBonuses.class, new ExcludeZeroSerializer())
						.setPrettyPrinting()
						.create();
		BufferedWriter fileWriter;
		try {
			fileWriter = new BufferedWriter(new FileWriter(new File("output.cfg")));
			for (Item i : items) {
				fileWriter.write(gson.toJson(i));
				fileWriter.newLine();
			}
			fileWriter.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
