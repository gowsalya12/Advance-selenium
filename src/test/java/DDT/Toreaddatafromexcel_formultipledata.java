package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Toreaddatafromexcel_formultipledata {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis =new FileInputStream(".//src/test/resources/Testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Product");
		int rowcount = sh.getLastRowNum();
		for(int i=1;i<=rowcount;i++)
		{
			Row r=sh.getRow(i);
			String ProductCategory = r.getCell(0).getStringCellValue();
			String Productname = r.getCell(1).getStringCellValue();
			System.out.println(ProductCategory+"===="+Productname);
		}

	}

}
