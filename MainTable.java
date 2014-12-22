import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;




public class MainTable extends JTable{
	Color alternate;
	Color classicBlue;
	//ImageIcon id, name, personFound, location, date, tags;
	JTableHeader header;

	public MainTable(Object[][] rowData, Object[] columnNames) {
		super(rowData, columnNames);
		alternate = new Color(221,221,221);
		classicBlue = new Color(78,166,234);

		CustomRenderer cr = new CustomRenderer(this.getDefaultRenderer(Object.class), classicBlue);
        this.setDefaultRenderer(Object.class, cr);

        setAutoCreateRowSorter(true);

        setRowHeight(30);

        //setAutoCreateColumnsFromModel(false);

        //setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        //headers
        header = this.getTableHeader();
        header.setForeground(new Color(127,118,110));
        header.setBackground(Color.WHITE);
        header.setFont((new Font("Calibri", Font.PLAIN, 20)));
        header.setBorder(BorderFactory.createMatteBorder(2,2,2,2, classicBlue));
	}

	//background color of rows
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component stamp = super.prepareRenderer(renderer, row, column);

        if (row % 2 == 0)
            stamp.setBackground(alternate);
        else
            stamp.setBackground(this.getBackground());
        return stamp;
    }

	//borders
	public static class CustomRenderer implements TableCellRenderer{
        TableCellRenderer render;
        Border b;

        public CustomRenderer(TableCellRenderer r, Color borderColor){
            render = r;

            b = BorderFactory.createCompoundBorder(b, BorderFactory.createMatteBorder(1,1,1,1,borderColor));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
            JComponent result = (JComponent)render.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            result.setBorder(b);
            return result;
        }

    }

	//they are about icons
	public class iconRenderer extends DefaultTableCellRenderer{
        public Component getTableCellRendererComponent(JTable table, Object obj,boolean isSelected, boolean hasFocus, int row, int column)
        {
			txtIcon i = (txtIcon)obj;
            if (obj == i) {
               setIcon(i.imageIcon);
               setText(i.txt);
            }
            setBorder(UIManager.getBorder("TableHeader.cellBorder"));
            setHorizontalAlignment(JLabel.CENTER);
            return this;
        }
    }

	public void SetIcon(JTable table, int col_index, ImageIcon icon,String name){
		table.getTableHeader().getColumnModel().getColumn(col_index).setHeaderRenderer(new iconRenderer());
		table.getColumnModel().getColumn(col_index).setHeaderValue(new txtIcon(name, icon));
	}

	public class txtIcon {
		String txt;
		ImageIcon imageIcon;
		txtIcon(String text, ImageIcon icon) {
			txt = text;
            imageIcon = icon;
        }
	}
}
