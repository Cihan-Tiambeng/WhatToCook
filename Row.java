import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;

public class Row {

	// PROPERTIES
	private ArrayList<String> tags;	
	private ArrayList<String> values;

	// CONTRUCTORS	

	public Row ( int size ) {
		tags = new ArrayList<String>();
		values = new ArrayList<String>();
		for(int i = 0; i < size; i++) {
			values.add("");
		}
	}
	
	public Row( ArrayList<String> tags, ArrayList<String> values){
		
		this.tags = new ArrayList<String>( tags);
		this.values = new ArrayList<String>( values);
	}
	
	public void addTag ( String tag ) {
		tags.add(tag);
	}		

	// METHODS	

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
			System.out.println("here " + tag);
			return null;
		} else {
			return values.get(index);
		}
	}

	/**
		Returns a set of values of a group of tags.
	*/
	public ArrayList<String> getValues (ArrayList<String> tags) {
		
		if (tags == null)System.out.println(" is null" );
		
		int size = 6;
		ArrayList<String> returnValues = new ArrayList<String>();

		for (int i = 0; i < size; i++) {
			returnValues.add(getValue(tags.get(i)));
		}
		return returnValues;
	}
	
	public ArrayList<String> getValues (){
		
		return new ArrayList( values);
	}

	/**
		Sets the tag and corresponding value into the tags and values properties.
	*/
	public boolean setValue(int index, String value) {
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
	public boolean	setValue(String tag, String value) {
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
	public boolean setValues (ArrayList<String> values) {
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
		Sets the given tags properties accordingly.
	*/
	public boolean setValues (ArrayList<String> tags, ArrayList<String> values) {
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

	/**
		Returns all the properties of the Row in an order and separated by commas6
	*/
	public String toString() {
		String rep = "";

		for (Iterator<String> iterator = values.iterator(); iterator.hasNext();) {
		        rep += iterator.next() + (iterator.hasNext() ? "," : "");
		}

		return rep;
	}
	
	public ArrayList<String> getTags() {
		
		return tags;
	}

	// Main method
}