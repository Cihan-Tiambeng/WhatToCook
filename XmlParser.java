import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* XmlParser.java
 * 
 * @author : Selçuk Gülcan
 * @date : 06.05.12
 * 
 * Description 
 */
public class XmlParser implements Iterable<String[]>, Iterator<String[]> {

	//PROPERTIES
	private File 				file;
	private ArrayList<String> 	nodeName, nodeValue;
	private int					counter;
	private String				parentNodeName; //Determines which node will be parsed.

	//CONSTRUCTORS
	public XmlParser() {

		parentNodeName = null;
		counter = 0;
		nodeName = new ArrayList<String>();
		nodeValue = new ArrayList<String>();
	}
	
	public XmlParser( String parent) {
		
		setParentNode( parent);
		counter = 0;
		nodeName = new ArrayList<String>();
		nodeValue = new ArrayList<String>();
	}
	
	public XmlParser( String parent, File file) {
		
		setParentNode( parent);
		counter = 0;
		this.file = file;
		nodeName = new ArrayList<String>();
		nodeValue = new ArrayList<String>();
		convert();
	}
	
	//METHODS
	public void setFile( File file) {
		
		this.file = file;
		convert();
	}
	
	public void setParentNode( String parent) {
		
		parentNodeName = parent;
	}
	
	public void convert() {
		
		if( file == null || parentNodeName == null) {
			
			nodeName = null;
			nodeValue = null;
			//Exception ???
		}
		
		else { //needed ?
			
			try {
				
				DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				Document doc = dBuilder.parse( file);
				if( doc.hasChildNodes()) {
					
					parse( doc.getChildNodes());
				}
			}
			catch( Exception e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public void parse( NodeList list) {
		
		for( int i = 0; i < list.getLength(); i++) {
			
			Node tempNode = list.item( i);
			
			if( tempNode.getNodeType() == Node.ELEMENT_NODE) {
				
				if( tempNode.getNodeName() == parentNodeName) {
					
					NodeList contentNodes = tempNode.getChildNodes();
					for( int j = 0; j < contentNodes.getLength(); j++) {
						
						if( contentNodes.item( j).getNodeType() == Node.ELEMENT_NODE) {
							
							nodeName.add( contentNodes.item( j).getNodeName());
							nodeValue.add( contentNodes.item( j).getTextContent());
						}
					}
					
					break;
				}
				
				if( tempNode.hasChildNodes())
					parse( tempNode.getChildNodes());
			}
		}
	}

	@Override
	public boolean hasNext() {
	
		return ( counter == nodeName.size() ? false : true);
	}

	@Override
	public String[] next() {
		
		if( counter == nodeName.size())
			throw new UnsupportedOperationException();
		
		else{
			
			String[] returned = new String[] { nodeName.get( counter), nodeValue.get( counter)};
			counter++;
			return returned;
		}
	}

	@Override
	public void remove() {
		
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterator<String[]> iterator() {

		return this;
	}
	
	public int size() {
		
		return nodeValue.size();
	}
}
