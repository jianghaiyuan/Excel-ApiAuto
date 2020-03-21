package TestNgAPi.Excel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;


public class Json extends config {
	Object[][] excelData;
	@Test
	public void Json() throws FileNotFoundException, IOException{
		 excelData = Excel.test(excelPath,1);
	       for(int i=0;i<excelData.length;i++){
			//从特定位置读取测试数据
			String address = excelData[i][0].toString();
			System.out.println(address);
			Map map=new HashMap();
			JSONObject jsonObject = new JSONObject(map);
			for(int j=0;j<excelData[i].length-1;j=j+2){
				//因为每种请求的参数个数不确定，在这里进行非空判断
				if(excelData[i][j]==null){
					break;
				}
				
				NameValuePair a = new BasicNameValuePair(excelData[i][j].toString(),excelData[i][j+1].toString());
				map.put(a.getName(), a.getValue());
			    //JSONObject jsonObject = new JSONObject(map);
			}
			System.out.print(jsonObject);
	}

}
}
