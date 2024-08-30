package in.ashokit.restController;

import in.ashokit.bindings.PlanResponse;
import in.ashokit.bindings.SearchRequest;
import in.ashokit.reports.ExcelReportGenerator;
import in.ashokit.reports.PdfReportGenerator;
import in.ashokit.service.InsurancePlanService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InsuranceRestController {
    @Autowired
    private InsurancePlanService service;

    @GetMapping("/pdf")
    public void generatePdf(HttpServletResponse response) throws Exception {
        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=plans.pdf" ;
        response.setHeader(headerKey, headerValue);

        List<PlanResponse>plans=service.searchPlans(null);
        PdfReportGenerator pdfReport=new PdfReportGenerator();
        pdfReport.export(plans,response);

    }

    @GetMapping("/excel")
    public void generateExcel(HttpServletResponse response) throws Exception {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=plans" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

      List<PlanResponse>plans=service.searchPlans(null);
        ExcelReportGenerator excelReport=new ExcelReportGenerator();
        excelReport.export(plans,response);

    }
    @PostMapping("/plans")
    public ResponseEntity<List<PlanResponse>> getPlans(@RequestBody SearchRequest request){
        List<PlanResponse> searchPlans=service.searchPlans(request);
        return new ResponseEntity<>(searchPlans, HttpStatus.OK);

    }
    @GetMapping("/PlanName")
    public ResponseEntity<List<String>>getPlanName(){
       List<String>distinctPlanName= service.getPlanNames();
       return new ResponseEntity<>(distinctPlanName,HttpStatus.OK);
    }
    @GetMapping("/PlanStatus")
    public ResponseEntity<List<String>>getPlanStatus(){
        List<String>distinctPlanStatus= service.getPlanStatus();
        return new ResponseEntity<>(distinctPlanStatus,HttpStatus.OK);
    }
}
