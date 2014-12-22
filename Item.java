import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;

public class Item {

	// PROPERTIES
	private ArrayList<String> tags;	
	private ArrayList<String> values;

	private DBConnection databaseConnection;
	private DBTable itemTable;

	// CONTRUCTORS
	public Item (DBConnection databaseConnection) throws Exception {
		this.databaseConnection = databaseConnection;
		itemTable = new DBTable(databaseConnection);

		tags = new ArrayList<String>();
		tags.add("ID");
		tags.add("date");
		tags.add("type");
		tags.add("brand");
		tags.add("model");
		tags.add("color");
		tags.add("description");
		tags.add("lostLocation");
		tags.add("keptLocation");
		tags.add("status");
		tags.add("reclaimerInformation");
		tags.add("returnDate");
		tags.add("imagePath");

		values = new ArrayList<String>();
		for(int i = 0; i < tags.size(); i++) {
			values.add("");
		}
		
		/* wtf is this.
		setValue("ID", Integer.toString(itemTable.generateId("ItemTable")) );
		setValue("date", Long.toString(new Date().getTime()) );
		setValue("status", "Found");
		
		itemTable.insertRow(toString(),"ItemTable");
		*/
	}
	
	public Item( DBConnection databaseConnection, ArrayList<String> values) throws Exception {
		
		this( databaseConnection);
		setValues( values);
	}
	
	public Item (DBConnection databaseConnection, String id) throws Exception {
		
		this.databaseConnection = databaseConnection;
		itemTable = new DBTable(databaseConnection);

		tags = new ArrayList<String>();
		tags.add("ID");
		tags.add("date");
		tags.add("type");
		tags.add("brand");
		tags.add("model");
		tags.add("color");
		tags.add("description");
		tags.add("lostLocation");
		tags.add("keptLocation");
		tags.add("status");
		tags.add("reclaimerInformation");
		tags.add("returnDate");
		tags.add("imagePath");
		
		values = new ArrayList<String>();
		
		for(int i = 0; i < tags.size(); i++) {
			values.add("");
		}
		
		Row row = itemTable.readRow(  "WHERE ID = " + id, "*" , "ItemTable" );
		for( int i = 0; i < tags.size();i ++) {
			setValue( tags.get(i), row.getValue( tags.get(i)));
			System.out.println( row.getValue( tags.get(i)));
		}
		
	}


	// Gets 8 properties from [Add Item] and saves these Strings accordingly
	// These properties listed as following:
	// type, brand, model, color, description, lostLocation, keptLocation, imagePath
	public Item (ArrayList<String> values, DBConnection databaseConnection) throws Exception {
		this(databaseConnection);

		if(values.size() == 8) {
			editEightValues(values);
		} else {
			System.out.println("<<Invalid Length Error>> in Properties Class Constructor!");
		}
	}		

	// METHODS	
	
	public void insert() throws Exception {
		
		setValue("ID", Integer.toString(itemTable.generateId("ItemTable")) );
		setValue("date", Long.toString(new Date().getTime()) );
		setValue("status", "Found");
		
		itemTable.insertRow(toString(),"ItemTable");
	}

	/**
		Returns the value of a specific index.
	*/
	public String getValue (int index) {
		if( index < tags.size()) {
			return values.get(index);
		} else {
			return null;
		}
	}	

	/**
		Returns the value of a specific tag.
	*/
	public String getValue (String tag) {
		int index = tags.indexOf(tag);

		// index is -1 if the tag does not exist
		if( index == -1) {
			return null;
		} else {
			return values.get(index);
		}
	}

	/**
		Returns a set of values of a group of tags.
	*/
	public ArrayList<String> getValues (ArrayList<String> tags) {
		int size = tags.size();
		ArrayList<String> returnValues = new ArrayList<String>();

		for (int i = 0; i < size; i++) {
			returnValues.add(getValue(tags.get(i)));
		}
		return returnValues;
	}

	/**
		Sets the tag and corresponding value into the tags and values properties.
	*/
	public boolean setValue(int index, String value) throws Exception {
		if( 0 <= index && index < tags.size() ) {
			values.set(index, value);
			return true;
		} else {
			return false;
		}
	}

	/**
		Sets the tag and corresponding value into the tags and values properties.
	*/
	public boolean	setValue(String tag, String value) throws Exception {
		int index = tags.indexOf(tag);

		// index is -1 if the tag does not exist
		if( index == -1) {
			return false;
		} else {
			values.set(index, value);
			return true;
		}
	}

	/**
		Default tags sets the given tags properties accordingly.
	*/
	public boolean setValues (ArrayList<String> values) throws Exception {
		int size = values.size();

		if(tags.size() != size) {
			return false;
		}

		ArrayList<String> returnValues = new ArrayList<String>();

		for (int i = 0; i < size; i++) {
			setValue(tags.get(i), values.get(i));
		}
		return true;
	}

	/**
		Sets the given tags' properties accordingly.
	*/
	public boolean setValues (ArrayList<String> tags, ArrayList<String> values) throws Exception {
		int size = tags.size();

		if(values.size() != size) {
			return false;
		}

		ArrayList<String> returnValues = new ArrayList<String>();

		for (int i = 0; i < size; i++) {
			setValue(tags.get(i), values.get(i));
		}
		return true;
	}

	// Used in [Edit Item] and Constructor that use [Add Item]
	public void editEightValues (ArrayList<String> values) throws Exception {
			
		if (getValue("status") == "Found") {
			ArrayList<String> editTags;
			editTags = new ArrayList<String>(); 
			editTags.add("type");
			editTags.add("brand");
			editTags.add("model");
			editTags.add("color");
			editTags.add("description");
			editTags.add("lostLocation");
			editTags.add("keptLocation");
			editTags.add("imagePath");
			setValues(editTags, values);
			save();
		}
	}

	// Returns item
	public void returnItem (String reclaimerInformation) throws Exception {
		setValue("reclaimerInformation", reclaimerInformation);
		setValue("returnDate", Long.toString(new Date().getTime()) );
		setValue("status", "Returned");
	}

	public void save () throws Exception {
		ArrayList<String> setStringUnit = new ArrayList<String>();
		for (int i = 0; i < values.size(); i++) {
			setStringUnit.add(tags.get(i) + "='" + values.get(i) + "'");
		}

		String setString = "";
		for (Iterator<String> iterator = setStringUnit.iterator(); iterator.hasNext();) {
		        setString += iterator.next() + (iterator.hasNext() ? "," : "");
		}

		System.out.println();
		System.out.println();
		System.out.println(setString);
		System.out.println("ID=" + getValue("ID"));
		System.out.println("ItemTable");
		itemTable.editRow(setString,"ID=" + getValue("ID"), "ItemTable");
	}

	// Returns dates for Sorting
	public Date getDate () {
		return new Date(Long.valueOf(getValue("date")));
	}

	public Date getReturnDate () {
		return new Date(Long.valueOf(getValue("returnDate")));
	}

	/**
		Returns the size of the Arraylists used in the properties. Returns -1 if there is a problem.
	*/
	public int size () {
		int size1 = tags.size();
		int size2 = values.size();

		if (size1 == size2) {
			return size1;
		} else {
			return -1;
		}
	}

	/**
		Returns all the properties of the Item in an order and separated by commas.
	*/
	public String toString() {
		String rep = "";

		for (Iterator<String> iterator = values.iterator(); iterator.hasNext();) {
		        rep += iterator.next() + (iterator.hasNext() ? "," : "");
		}
		return rep;
	}
}
