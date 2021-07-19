package views;

import java.awt.Color;
import java.awt.Font;

public class Constant {

	//Dirreciones Url
	public static final String PATH_FILE_IN = "resources/in/Entrada.in";
	public static final String PATH_FILE_OUT = "resources/out/Salida.out";
	
	public static final String IMG_WRITE= "/images/write.png";
	public static final String IMG_ICON_MAIN= "/images/IconPayRoll.png";
	public static final String IMG_LOGO_MAIN= "/images/NominLogo.png";
	public static final String IMG_LOGO_TWITTER= "/images/logoTwitter.png";
	public static final String IMG_LOGO_FACEBOOK= "/images/logoFacebook.png";
	public static final String IMG_LOGO_INSTAGRAM = "/images/logoInstagram.png";
	public static final String IMG_BUTTON_BACK = "/images/buttonBack.png";
	public static final String IMG_BUTTON_NEXT = "/images/buttonNext.png";
	public static final String IMG_FILE = "/images/file.png";
	public static final String IMG_EXIT = "/images/exit.png";
	public static final String IMG_EXIT_USER = "/images/exitApp.png";
	public static final String IMG_SEARCH = "/images/search.png";
	public static final String IMG_DELETE = "/images/delete.png";
	public static final String IMG_STADISTIC = "/images/stadistic.png";
	public static final String IMG_DELETE_USER = "/images/deleteUser.png";
	public static final String IMG_ADD_USER = "/images/addUser.png";
	public static final String IMG_SEARCH_USER = "/images/searchUser.png";
	public static final String IMG_ADD = "/images/document.png";
	public static final String IMG_JDIALOG_NEW_PAYROLL= "/images/newJDialog.png";
	public static final String IMG_ARROW_RIGHT= "/images/arrowRight.png";
	public static final String IMG_ARROW_DOWN = "/images/arrowDown.png";
	public static final String IMG_REFRESH= "/images/refresh.png";
	public static final String IMG_CODE= "/images/Code.png";
	public static final String IMG_SPANISH = "/images/Spanish.png";
	public static final String IMG_ENGLISH = "/images/English.png";
	
	//Tipos de fuentes

	public static final Font FONT_ROCWELL = new Font("Rockwell",Font.PLAIN, 20);
	public static final Font FONT_NEW_ROMAN_13 = new Font("Times New Roman",Font.PLAIN, 13);
	public static final Font FONT_NEW_ROMAN_25 = new Font("Times New Roman",Font.PLAIN, 25);
	public static final Font FONT_COMPONENTS_DIALOG_COST = new Font("Bodoni MT", Font.PLAIN, 15);
	public static final Font FONT_ARIAL_ROUNDER_17 = new Font("Arial Rounded MT Bold", Font.PLAIN, 17);
	public static final Font FONT_ARIAL_ROUNDER_15 = new Font("Arial Rounded MT Bold", Font.PLAIN, 15);
	
	//Titulos Secundarios
	public static final String TXT_FACEBOOK = "Facebook";
	public static final String TXT_INSTAGRAM = "Instagram";
	public static final String TXT_TWITTER= "Twitter";
	
	//Titulos de la App
	
	public static final String ERROR_SELECT = "ok";
	public static final String NOT_SELECT_ITEM = "No a seleccionado ningun objeto";
	public static final String DELETE_SELECT_ITEM = "Desea eliminar el objeto seleccionado";
	public static final String ENTER_NAME = "Ingrese el nombre";
	public static final String ENTER_NIT = "Ingrese el Nit";
	public static final String NEW_SUBSIDY = "New_Subsidy";
	public static final String NAME_OF_COMPANY = "Name_Company";
	public static final String TYPE_OF_PERSON = "Type_Person";
	public static final String TYPE_OF_DOCU = "Type_Document";
	public static final String TYPE_OF_SOLI = "Type_Solicitude";
	public static final String NIT_OF_COMPANY = "Nit_Of_Company";
	public static final String NUMBER_EMPLEOYEES = "Number_Empleoyees";
	public static final String CREATE = "Create";
	public static final String CANCEL = "Cancel";
	public static final String TITLE_PAYROLL = "Subsidy_PayRoll";
	public static final String[] HEADERDS_TABLEMAIN = {"Code","Name","Type_Person","Type_Document","Type_Solicitude","Nit","Number_Empleoyees","Date","Bonus"};
	public static final String[] HEADERS_TYPE_PERSON = {"Legal_Person","Natural_Person","Nonprofit_Entity","temporary_Union"};
	public static final String[] HEADERS_TYPE_DOCUMENT= {"Identification_Personal","Identification_Foreigher","Passport"};
	public static final String[] HEADERS_TYPE_SOLICITUDE = {"First_Time","Second_Time","Third_Time"};
	public static final String[] HEADERS_TYPE_DATE = {"April","May","June"};
	public static final String[] HEADERS_TYPE_PERCENTAGE = {"P_Person","P_Document","P_Solicitude","P_Dates"};
	
	//Titulos del menu
	
	public static final String M_LANGUAGE = "Language";
	public static final String M_SPANISH = "Spanish";
	public static final String M_ENGLISH = "English";
	public static final String M_FILE = "File";
	public static final String M_SEARCH = "Search";
	public static final String M_DELETE = "Delete";
	public static final String M_ADD = "Add";
	public static final String M_EXIT = "Exit";
	public static final String M_STADISTIC = "Stadistic";
	public static final String M_LIST_REGISTER = "List_Register";
	public static final String M_LIST_PERCENTAGE_PERSON = "List_Percentage_Person";
	public static final String M_LIST_PERCENTAGE_DOCUMENT = "List_Percentage_Document";
	public static final String M_LIST_PERCENTAGE_SOLICITU = "List_Percentage_Solicitud";
	public static final String M_LIST_PERCENTAGE_DATE = "List_Percentage_Date";
	public static final String M_PERCENTAGE_TABLE = "Percentage_Table";
	public static final String M_PERCENTAGE_BAR = "Percentage_Bar";
	
	//Colores
	public static final Color COLOR_COMBO_BOX= Color.decode("#42A7FF");
	public static final Color COLOR_WHITE = Color.decode("#FFFFFF");
	public static final Color COLOR_DARK_BLUE = Color.decode("#304A4B");
	public static final Color COLOR_BLACK = Color.decode("#000000");
	public static final Color COLOR_LIGHT_BLUE = Color.decode("#33FFFC");
	public static final Color COLOR_LIGHT_GREEN= Color.decode("#F2F7D8");
	public static final Color COLOR_LIGHT_BLACK= Color.decode("#30373D");
	public static final Color COLOR_OF_HEADER_TABLE = Color.decode("#144073");
	public static final Color COLOR_OF_JOPTION = Color.decode("#FF3648");
	public static final Color COLOR_OF_DIALOG_PERC = Color.decode("#404040");
	public static final Color COLOR_BLUE_LIGHT = Color.decode("#337AB7");
	public static final Color COLOR_RED_LIGHT = Color.decode("#922B3E");

}
