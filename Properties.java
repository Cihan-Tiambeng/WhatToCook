import java.util.ArrayList;
/**
	Stores the properties of the Item Class in 2 parallel ArrayLists.

	@date: 1 May 2013
	@contact: emrehan.tuzun@gmail.com
*/
public class Properties {

	// PROPERTIES
	private ArrayList<String> tags;	
	private ArrayList<String> values;

	// CONTRUCTORS
	public Properties () {
		tags = new ArrayList<String>();
		values = new ArrayList<String>();
	}	

	public Properties (ArrayList<String> tags) {
		this.tags = tags;
		values = new ArrayList<String>();
		for (int i = 0; i < tags.size(); i++) {
			values.add(null);
		}
	}	

	public Properties (ArrayList<String> tags, ArrayList<String> values) {
		this();

		if ( tags.size() == values.size() ) {
			add(tags, values);
		}
	}	

	// METHODS
	/**
		Returns the value of a specific tag.
	*/
	public String getValue (String tag) {
		int index = tags.indexOf(tag);

		// index is -1 if the tag does not exist
		if( index == -1) {
			return null;
		} else {
			return tags.get(index);
		}
	}

	/**
		Returns the value of a specific index.
	*/
	public String getIndexValue (int index) {
		if( index < tags.size()) {
			return values.get(index);
		} else {
			return null;
		}
	}	

	/**
		Returns the tag of a specific index.
	*/
	public String getIndexTag (int index) {
		if( index < tags.size()) {
			return tags.get(index);
		} else {
			return null;
		}
	}

	/**
		Returns a set of values of a group of tags.
	*/
	public ArrayList<String> getValue (ArrayList<String> tag) {
		int size = tag.size();
		ArrayList<String> returnValues = new ArrayList<String>();

		for (int i = 0; i < size; i++) {
			returnValues.add(getValue(tag.get(i)));
		}
		return returnValues;
	}

	/**
		Returns whether the object contains the same values of the tags determined in parameters. 
		It can be used to filter items.
		Warning:	Did not tested!
		Warning: 	Case sensitive about tags.
		Warning:	Returns true even if one of the values with same tag is null.
	*/
	public boolean contains (Properties inputProperties) {
		String inputValue;
		String thisValue;
		for (int i = 0; i < tags.size(); i++) {
			if (inputProperties.getValue(this.getIndexTag(i)) != null) {
				inputValue = inputProperties.getValue(this.getIndexTag(i));

				if (this.getValue(this.getIndexTag(i)) != null) {
					thisValue = this.getValue(this.getIndexTag(i));
				
					if ( !inputValue.equalsIgnoreCase(thisValue) ) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
		Adds the tag and corresponding value into the tags and values properties.
	*/
	public void	add( String tag, String value) {
		tags.add(tag);
		values.add(value);
	}

	/**
		Similiar to the other add method. This take sets as parameters and adds them into the properties.
		Warning:	Did not tested!
	*/
	public boolean	add( ArrayList<String> tags, ArrayList<String> values) {
		if (tags.size() == values.size()) {
			this.values.addAll(values);
			this.tags.addAll(tags);	
			return true;			
		} else {
			return false;
		}
	}
	

	/**
		Returns the size of tags ArrayList.
	*/
	public int size () {
		return tags.size();
	}

	/* To compile :) */ public static void main (String[] args) {}
}