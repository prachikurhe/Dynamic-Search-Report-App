package in.ashokit.reports;

import in.ashokit.bindings.PlanResponse;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.List;

public class ExcelReportGenerator {
    public void export(List<PlanResponse> plans, HttpServletResponse response) throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Plans");
        XSSFRow headerRow = sheet.createRow(0);

        headerRow.createCell(0).setCellValue("Plan ID");
        headerRow.createCell(1).setCellValue("Holder Name");
        headerRow.createCell(2).setCellValue("Holder SSN");
        headerRow.createCell(3).setCellValue("Plan Name");
        headerRow.createCell(4).setCellValue("Plan Status");

        for (int i = 0; i < plans.size() ; i++) {
            PlanResponse plan=plans.get(i);
            XSSFRow dataRow=sheet.createRow(i+1);
            dataRow.createCell(0).setCellValue(plan.getPlanId());
            dataRow.createCell(1).setCellValue(plan.getPlanHolderName());
            dataRow.createCell(2).setCellValue(plan.getPlanHolderSsn());
            dataRow.createCell(3).setCellValue(plan.getPlanName());
            dataRow.createCell(4).setCellValue(plan.getPlanStatus());

        }
        //we need to download excel so we are taking output stream
        ServletOutputStream outputStream= response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();





    }
}
