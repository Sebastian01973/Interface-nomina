package utilities;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.TableColumn;



public class UtilitiesViews {

	public static final String SPLIT_CHARACTER= "\\?+"; 
	public static final String SPLIT_DATE_CHARACTER= "/+";
	public static final String SPLIT_TIME_CHARACTER= ":+";

	public String[] splitLine(String line){
		return line.split(SPLIT_CHARACTER);
	}

	public String[] splitDate(String date){
		return date.split(SPLIT_DATE_CHARACTER);
	}

	public String[] splitTime(String date){
		return date.split(SPLIT_TIME_CHARACTER);
	}

	public Calendar sendDate(String[] date){
		Calendar dateV = Calendar.getInstance();
		dateV.set(Integer.parseInt(date[2]), Integer.parseInt(date[0])-1, Integer.parseInt(date[1]));
		return dateV;
	}

	public Calendar sendTime(String[] record){
		Calendar time = Calendar.getInstance();
		time.set(0, 0, 0, Integer.parseInt(record[0]), Integer.parseInt(record[1]), Integer.parseInt(record[2]));
		return time;
	}

	public static Calendar parseDateToCalendar(Date date) { 
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}
	
	public static LocalDate parseDateToLocalDate(Date date) { 
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public static String toStringCalendar(Calendar calendar){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY");
		return simpleDateFormat.format(calendar.getTime());
		
	}
	
	public static String toDecimalFormat( double value ) {
		DecimalFormat df = (DecimalFormat)NumberFormat.getInstance();
		df.applyPattern( "###########,###.## $" );
		String strValue = df.format( value );
		return strValue;		
	}
	
	public static String toDecimalFormatNegative( double value ) {
		DecimalFormat df = (DecimalFormat)NumberFormat.getInstance();
		df.applyPattern( "- ###########,###.## $" );
		String strValue = df.format( value );
		return strValue;		
	}
	
	public static int toConverterObject(Object object) {
		return Integer.parseInt(object.toString());
	}
	
	public static String toFloatFormatPercentage(float value) {
		DecimalFormat df = (DecimalFormat)NumberFormat.getInstance();
		df.applyPattern( "% ####,##" );
		String strValue = df.format(value);
		return strValue;
	}
	
	public static void getModelColumn(JTable jTable,int numCol,int minWidth,int maxWidth,int preferWidth) {
		TableColumn column;
		column = jTable.getColumnModel().getColumn(numCol);
		column.setPreferredWidth(preferWidth);
		column.setMaxWidth(maxWidth);
		column.setMinWidth(minWidth);
	}
	
}
