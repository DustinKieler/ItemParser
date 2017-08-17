# ITEMPARSER #

Early RS2 emulations store their item configurations in a sloppy way using a regular text file. This file is often large, unlabeled, and slow to parse. Paired with this, due to its dirtiness, is often a poor loading structure that takes unnecessary memory and processing time. 

ItemParser parses this configuration file into clean and readable JSON that represents an Item object. The user can then utilize this Item object when loading their server's items, moving them into a set or map for quick lookup.

### How do I get set up? ###

Make sure that you're about to process the right file format. The below formatting was consistent for emulations even past 2010.

    item = 35	Excalibur	This_used_to_belong_to_King_Arthur.	160.036754819048	160.036754819048	181.443095635579	20	29	-2	0	0	0	3	2	1	0	25	0

 - ItemParser will raise exceptions and create a null Item if the line it parses does not contain the exact amount of expected tokens. Each item you have should be in the above format, with exactly 20 tokens (character strings separated by spaces). If a problem is encountered, run the program with the console attached to see exception output.

Move your configuration file (named **item.cfg**) into your projects main directory, and execute the Main class. An **output.json** file will be created in the main directory, which contains your beautiful JSON!

### Reloading the JSON ###
When the configuration file is parsed, each line is stored as an Item object and stored in an ArrayList of items. You can incorporate the below class to convert the JSON back into an ArrayList and use it as you wish. For `Type`, make sure you import `java.lang.reflect.Type`.

    private static final Type LOAD_TYPE = new TypeToken<ArrayList<Item>>(){}.getType();
    
    public ArrayList<Item> loadItems() throws IOException {
        JsonReader reader = new JsonReader(new FileReader("item.json"));
        ArrayList<Item> itemList = new Gson().fromJson(reader, LOAD_TYPE);
        return itemList;
    }

