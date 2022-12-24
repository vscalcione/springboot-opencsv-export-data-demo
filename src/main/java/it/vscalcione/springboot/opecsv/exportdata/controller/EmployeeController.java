package it.vscalcione.springboot.opecsv.exportdata.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import it.vscalcione.springboot.opecsv.exportdata.model.Employee;
import it.vscalcione.springboot.opecsv.exportdata.service.EmployeeService;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/export-csv")
	public void exportCSV(HttpServletResponse response) throws Exception{
		String fileName = "Employee-List.csv";
		
		response.setContentType("text/csv");
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"");
		
		//Create a CSV Writer
		StatefulBeanToCsv<Employee> writer = new StatefulBeanToCsvBuilder<Employee>(
				response.getWriter())
				.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
				.withSeparator(CSVWriter.DEFAULT_SEPARATOR)
				.withOrderedResults(true).build();
	
		writer.write(employeeService.fetchAll());
	}
}
