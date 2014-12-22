import java.util.*;

public class ItemContainer {
	// PROPERTIES
	private List<Item> list;

	// CONSTRUCTORS
	public ItemContainer () {
		list = new ArrayList<Item>();
	}

	public ItemContainer (List<Item> list) {
		this.list = list;
	}

	// METHODS
	public void addItem (Item item) {
		list.add(item);
	}

	public Item getItem (int index) {
		if(0 <= index && index < list.size()) {
			return list.get(index);
		} else {
			return null;
		}
	}
	
	//	replaceItem Method
	//	replaces the Item in the ItemContainer with item given in a specified index
	public void replaceItem ( Item item, int index){
		list.set( index, item);
	}

	public void removeItem (int index) {
		if(0 <= index && index < list.size()) {
			list.remove(index);
		}  			
	}
	
	public ItemContainer clone(){
		return new ItemContainer( list);
	}

	public int size (Item item) {
		return list.size();
	}
}