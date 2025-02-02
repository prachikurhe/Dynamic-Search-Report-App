package in.ashokit.reports;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import in.ashokit.bindings.PlanResponse;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class PdfReportGenerator {
    public void export(List<PlanResponse> plans, HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLACK);

        Paragraph p = new Paragraph("List of Plans", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 1.5f, 2.0f, 3.0f, 2.0f});
        table.setSpacingBefore(10);

        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.RED);
        cell.setPadding(5);

        Font font1 = FontFactory.getFont(FontFactory.HELVETICA);
        font1.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Plan ID", font1));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Plan Name", font1));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Holder Name", font1));
        table.addCell(cell);

        cell.setPhrase(new Phrase("SSN", font1));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Status", font1));
        table.addCell(cell);
        //for adding data 
        for (PlanResponse plan:plans){
            table.addCell(plan.getPlanId()+"");
            table.addCell(plan.getPlanName());
            table.addCell(plan.getPlanHolderName());
            table.addCell(plan.getPlanHolderSsn()+"");
            table.addCell(plan.getPlanStatus());
        }

        document.add(table);
        document.close();


    }

}
