package TestNgAPi.Excel;

import java.io.FileInputStream;
import java.util.Properties;

public class config
{
	public Properties prop;
	public String excelPath;
	//构造函数
	public void Api() {
		try {
			prop = new Properties();
		} catch (Exception e) {
			e.printStackTrace();
		}
		excelPath=prop.getProperty("C:\\Users\\Administrator\\Desktop\\Excel\\config\\Test.xls");
	}
}
