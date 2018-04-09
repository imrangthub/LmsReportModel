package com.imran.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imran.model.Loan;
import com.imran.service.LoanService;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;

@Controller
@RequestMapping(value = "/report")
public class ReportModelOneController {
	
	 
	@Autowired
	LoanService loanService;
	
	@RequestMapping(value = "/reportModelOne", method = RequestMethod.GET)
	public String index(ModelMap map) {	
		return "report/modelOne/reportModelOne";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/view", method = RequestMethod.POST)
	public ResponseEntity<byte[]>  view(ModelMap map, HttpServletRequest request, HttpServletResponse resp) throws JRException, IOException {
		
		List<Loan> filteredList = new ArrayList<>();
		
		// Report Formate info			
		System.out.println("========================= Filter ==============");
		String reportFormate = request.getParameter("reportFormate");
		
		// Filter info			
		System.out.println("========================= Filter ==============");
		String filterByBranch = request.getParameter("filterByBranch");
		String filterByLoanType = request.getParameter("filterByLoanType");
		
		//Print Column Name		
		System.out.println("========================= Column ==============");
		Boolean isCaseNoShow = Boolean.parseBoolean(request.getParameter("isCaseNoShow"));
		Boolean loanNameColumn = Boolean.parseBoolean(request.getParameter("loanNameColumn"));
		Boolean isAmountShow = Boolean.parseBoolean(request.getParameter("isAmountShow"));
		Boolean isLoanTypeShow = Boolean.parseBoolean(request.getParameter("isLoanTypeShow"));
		Boolean isBranchNameShow = Boolean.parseBoolean(request.getParameter("isBranchNameShow"));
		Boolean isDateShow = Boolean.parseBoolean(request.getParameter("isDateShow"));
		
		//calcute operation
		System.out.println("========================= calcute ==============");		
		Boolean isSumShow = Boolean.parseBoolean(request.getParameter("isSumShow"));
		Boolean isAverageShow = Boolean.parseBoolean(request.getParameter("isAverageShow"));

		List<Loan> loanList =  loanService.loanList();
		
			// filtering loan type  
		    filteredList = loanService.filteringByLoanType(loanList, filterByLoanType);
		    if(!filterByBranch.equals("") || filterByBranch != null) {
			    filteredList = loanService.filteringByBranchName(filteredList, filterByBranch);
		    }
			
		
		
	       JRDataSource loanDataSource = new JRBeanCollectionDataSource(filteredList);
		
		   Map<String, Object> parameterMap = new HashMap<String, Object>();
		   
		   //column show/hide parameter
		   parameterMap.put("isCaseNoShow",isCaseNoShow);
		   parameterMap.put("isLoanTypeShow",isLoanTypeShow);
		   parameterMap.put("isBranchNameShow",isBranchNameShow);
		   parameterMap.put("isDateShow",isDateShow);
		   parameterMap.put("isAmountColumnShow",isAmountShow);
		   
		   // calculation parameter
		   parameterMap.put("isCalcuteShow",false);
		   parameterMap.put("isSumShow",isSumShow);
		   parameterMap.put("isAverageShow",isAverageShow);
		   if(isSumShow == true || isAverageShow==true) {
			   parameterMap.put("isCalcuteShow",true);
		   }
		   
	       parameterMap.put("title", "CS-INFOTECH");
	       parameterMap.put("reportFooter", "csinfotech@bd.com");
	       parameterMap.put("companyName", "Current Loan History");
		
			JasperReport jasperReport = null;
			JasperPrint jasperPrint = null;
		 	HttpHeaders headers = null;				
			byte[] bytes = null;	
			headers = new HttpHeaders();
				
			 File initialFile = new File("F:\\IMRAN_HOSSAIN\\IMRAN_PROJECT\\LMS_REPORT_DEMO_PROJECT\\LmsReportModel\\src\\main\\webapp\\resources\\report\\demoReportOne.jrxml");
		    InputStream jasperStream = null;
				try {
					
					jasperStream = new FileInputStream(initialFile);
					jasperReport = JasperCompileManager.compileReport(jasperStream);
				    jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, loanDataSource);
				    
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				 if(reportFormate.equals("cvs")) {
						headers.setContentType(MediaType.parseMediaType("text/plain"));
						headers.set("Content-Disposition", "inline; filename=demo_report.xlsx");
						
					    JRXlsxExporter xlsxExporter = new JRXlsxExporter();
					    ByteArrayOutputStream xlsReport = new ByteArrayOutputStream();
					    xlsxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
					    xlsxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, xlsReport);
					    xlsxExporter.exportReport();
					    bytes = xlsReport.toByteArray();
					    xlsReport.close();
				    	
				    }else {
				    	
				    	bytes = JasperExportManager.exportReportToPdf(jasperPrint);
				    	headers.setContentType(MediaType.parseMediaType("application/pdf"));
						String filename = "demo_report.pdf";
						headers.setContentDispositionFormData(filename, filename);
				    }

				headers.setContentLength(bytes.length);
			 return new ResponseEntity<byte[]>(bytes,headers, HttpStatus.OK);                     
	}

}