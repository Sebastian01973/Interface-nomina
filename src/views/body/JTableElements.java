package views.body;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


import utilities.Utilities;
import utilities.UtilitiesViews;
import views.Constant;

public class JTableElements extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel dtmElements;
	private JTable jtElements;
	private JScrollPane jScrollPane;
	
	public JTableElements() {
		initComponents();
	}
	
	private void initComponents() {
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.setBackground(Constant.COLOR_WHITE);
		dtmElements = new DefaultTableModel() {

			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				return false;
			}
			
		};
		dtmElements.setColumnIdentifiers(Utilities.getConstants(Constant.HEADERDS_TABLEMAIN));
		jtElements = new JTable();
		jtElements.setModel(dtmElements);
		jtElements.setIntercellSpacing(new Dimension(0, 0));
		jtElements.getTableHeader().setReorderingAllowed(false);
		jtElements.getTableHeader().setBackground(Constant.COLOR_OF_HEADER_TABLE);
		jtElements.getTableHeader().setPreferredSize(new Dimension(0, 60));
		jtElements.getTableHeader().setFont(Constant.FONT_ARIAL_ROUNDER_17);
		jtElements.getTableHeader().setForeground(Constant.COLOR_WHITE);
		jtElements.setBackground(Constant.COLOR_WHITE);
		jtElements.setFont(Constant.FONT_ARIAL_ROUNDER_15);
		jtElements.setFillsViewportHeight(false);
		jtElements.setRowHeight( 35 );
		jtElements.setBorder(null);
		
		UtilitiesViews.getModelColumn(jtElements, 6, 60, 90,80 );
		UtilitiesViews.getModelColumn(jtElements, 0, 60, 80, 70);
		
		jScrollPane = new JScrollPane(jtElements);
		jScrollPane.setForeground(Color.white);
		jScrollPane.setBorder(null);
		jScrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.add(jScrollPane, BorderLayout.PAGE_END);
		this.setBorder(null);
		
	}

	public DefaultTableModel getDefaultTableModel() {
		return dtmElements;
	}
	
	public void setDefaultTableModel(DefaultTableModel defaultTableModel) {
		this.dtmElements = defaultTableModel;
	}
	
	public void addElementToTable(Object[] vector){
		vector[8] = UtilitiesViews.toDecimalFormat( (Double)vector[8] );
		vector[3] = Utilities.getConstant((String)vector[3]);
		vector[2] = Utilities.getConstant((String)vector[2]);
		vector[4] = Utilities.getConstant((String)vector[4]);
		dtmElements.addRow(vector);
	}
	
	public void cleanRowsTable() {
		dtmElements.setNumRows(0);
	}
	
	public int getSelectRow() {
		return jtElements.getSelectedRow();
	}
	
	public String getSelectedRow() {
		if (jtElements.getSelectedRow() ==-1) {
			return Constant.ERROR_SELECT;
		}else {
			return (String) dtmElements.getValueAt(jtElements.getSelectedRow(), 0);
		}
	}
	
	private void centerText() {
		DefaultTableCellRenderer centeRenderer = new DefaultTableCellRenderer();
		centeRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < jtElements.getColumnCount(); i++) {
			jtElements.getColumnModel().getColumn(i).setCellRenderer(centeRenderer);
		}
	}

	public void addElementToTable(ArrayList<Object[]> data) {
		cleanRowsTable();
		dtmElements.setColumnIdentifiers(Utilities.getConstants(Constant.HEADERDS_TABLEMAIN));
		for (Object[] objects : data) {
			addElementToTable(objects);
		}
		UtilitiesViews.getModelColumn(jtElements, 6, 60, 90,80 );
		UtilitiesViews.getModelColumn(jtElements, 0, 60, 80, 70);
	}


	public void updatePayRoll(double bonus) {
		
	}

	public void showPercentageDatas(Object[] objects,String[] headers) {
		cleanRowsTable();
		dtmElements.setColumnIdentifiers(Utilities.getConstants(headers));
		for (int i = 0; i < objects.length; i++) {
			objects[i] = UtilitiesViews.toFloatFormatPercentage((float)objects[i]);
		}
		dtmElements.addRow(objects);
	}

	public void deletePayroll(int index) {
		dtmElements.removeRow(index);
	}

	public void changeLanguage() {
		dtmElements.setColumnIdentifiers(Utilities.getConstants(Constant.HEADERDS_TABLEMAIN));
	}
}
