package inventoryjava1;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class xlsCreate {
	public xlsCreate() {
		
		
	}
	
	public XSSFWorkbook book1 = new XSSFWorkbook();
	
public void ProductsWriteToExcel(ResultSet Rs1) throws SQLException, IOException {
	
    ResultSetMetaData rsmd = Rs1.getMetaData();
    List<String> columns = new ArrayList<String>() {{
    	for(int i=1; i<= rsmd.getColumnCount(); i++) {
    		add(rsmd.getColumnLabel(i));
    	}
    	
    	
    }};
	List<String> labels = new ArrayList<String>(); 
		labels.add("No.");
		labels.add("Part No.");
		labels.add("Parça Adı");
		labels.add("Miktar");
		labels.add("Açıklama");
		labels.add("Kategori");
    
    
    	 XSSFSheet sheet = book1.createSheet();
    	 XSSFRow header = sheet.createRow(0);
    	 
    	/* for(int i = 0; i< columns.size();i++) {
    		 XSSFCell cell = header.createCell(i);
    		 cell.setCellValue(columns.get(i));
    	 }*/
    	 int rowIndex = 2;
    	 String date = GetToday();
    	 header.createCell(0).setCellValue(date+" Tarihli BUvHA Yenişehir Envanter Listesi");
    	 
    	 XSSFRow row = sheet.createRow(rowIndex);
    	 for(int i=0; i<labels.size();i++) {
 			XSSFCell cell = row.createCell(i); 
 			String val = labels.get(i); 
 			cell.setCellValue(val);	
 		 }
    	 
    	 int ListNo=1;
    	 while(Rs1.next()) {
    		row = sheet.createRow(++rowIndex);
    		
    		row.createCell(0).setCellValue(ListNo);
    		 for(int i=0; i<columns.size();i++) {
    			XSSFCell cell = row.createCell(i+1); 
    			String val = Objects.toString(Rs1.getObject(columns.get(i)),""); 
    			cell.setCellValue(val);
    			
    		 
    		}
    		 ListNo++;
    		// try(FileOutputStream fos = new FileOutputStream(Filename)){
    		//	 book1.write(fos);
    		// }
    	 }
    	
    
    
    
}
private String GetToday(){
    //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
     DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDateTime now = LocalDateTime.now();
    //System.out.println(dtf.format(now));
    return dtf.format(now);
}

}

