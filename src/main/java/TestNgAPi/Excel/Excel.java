package TestNgAPi.Excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.testng.annotations.Test;

/**
 * Hello world!
 *
 */
public class Excel 
{
public static Object[][] test(String filePath,int sheetId) throws FileNotFoundException, IOException
	{
		// 创建 Excel 文件的输入流对象
		FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Desktop\\Excel\\config\\Test.xls");
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sheet = wb.getSheetAt(0);
        int numberOfRow = sheet.getPhysicalNumberOfRows();
        int numberOfCell = sheet.getRow(0).getLastCellNum();

        //将表单数据处理存入dtt对象
        Object[][] dttData = new Object[numberOfRow][numberOfCell];
        for(int i=0;i<numberOfRow;i++){
            if(null==sheet.getRow(i)||"".equals(sheet.getRow(i))){
                continue;
            }
            for(int j=0;j<numberOfCell;j++) {
                if(null==sheet.getRow(i).getCell(j)||"".equals(sheet.getRow(i).getCell(j))){
                    continue;
                }
                HSSFCell cell = sheet.getRow(i).getCell(j);
                cell.setCellType(CellType.STRING);
                dttData[i][j] = cell.getStringCellValue();
               // System.out.print(cell);
            }
        }
		return dttData;	 
       
    }
}
