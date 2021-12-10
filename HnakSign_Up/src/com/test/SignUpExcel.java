/**
 *
 */
package com.test;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author HNAK_Administrator
 *
 */
public class SignUpExcel {



    public static List<SignUpUser> getSignUpUser() throws Exception {
		List<SignUpUser> signUpUserList = new ArrayList<>();
        try (FileInputStream file = new FileInputStream(new File("./src/com/utility/resources/Sign_Up_Data.xlsx"))) {

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            //Used getSheet for sheet name or if we have to use indexing then we could use getSheetAt()
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            Iterator<Row> rowIterator = sheet.iterator();
            // to skip the header
			rowIterator.next();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                signUpUserList.add(assignRow(row));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return signUpUserList;

    }

    private static SignUpUser assignRow(Row row) {
        return new SignUpUser(row.getCell(0).getRichStringCellValue().getString(),
                row.getCell(1).getRichStringCellValue().getString(),
                row.getCell(2).getRichStringCellValue().getString(),
				row.getCell(3).getRichStringCellValue().getString());
    }

}
