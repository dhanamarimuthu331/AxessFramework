package Common;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class excelUtil{
    public static Map<String,String>getTestdata(String FilePath,String SheetName,String tcid) throws IOException {
        Map<String, String> data = new HashMap<>();
        try {
            FileInputStream fis = new FileInputStream(FilePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(SheetName);
            Row headerRow = sheet.getRow(0);
            for (int i = 1; i < sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row.getCell(0).getStringCellValue().equalsIgnoreCase(tcid)) {
                    System.out.println("Success");
                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        data.put(headerRow.getCell(j).getStringCellValue(), row.getCell(j).toString());
                    }
                    break;
                }

            }
            workbook.close();
            fis.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return data;

    }
}
