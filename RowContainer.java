import java.util.*;

public class RowContainer {
	// PROPERTIES
	private List<Row> list;

	// CONSTRUCTORS
	public RowContainer () {
		list = new ArrayList<Row>();
	}

	public RowContainer (List<Row> list) {
		this.list = list;
	}

	// METHODS
	public void addRow (Row row) {
		list.add(row);
	}

	public Row getRow (int index) {
		if(0 <= index && index < list.size()) {
			return list.get(index);
		} else {
			return null;
		}
	}

	public void removeRow (int index) {
		if(0 <= index && index < list.size()) {
			list.remove(index);
		}  			
	}

	public int size () {
		return list.size();
	}
}