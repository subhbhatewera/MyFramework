package util;

import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	int rows ;
	int columns ;

	public ExcelReader(String filePath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(filePath);
			sheet = workbook.getSheet(sheetName);
			rows = sheet.getPhysicalNumberOfRows();
			columns = sheet.getRow(0).getPhysicalNumberOfCells();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}	

	public Object[][] getData() {
		Object data[][] = new Object[rows-1][columns];		
		for(int i = 1 ; i < rows ; i++) {			
			for(int j = 0 ; j < columns ; j++) {
				CellType cellType = sheet.getRow(i).getCell(j).getCellType();
				if(cellType==CellType.STRING) 
					data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();				
				else if(cellType==CellType.NUMERIC) 
					data[i-1][j] = NumberToTextConverter.toText(sheet.getRow(i).getCell(j).getNumericCellValue());								
			}			
		}
		return data;
	}

}
