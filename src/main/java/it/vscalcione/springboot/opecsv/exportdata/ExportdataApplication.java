package it.vscalcione.springboot.opecsv.exportdata;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.vscalcione.springboot.opecsv.exportdata.model.Employee;
import it.vscalcione.springboot.opecsv.exportdata.repository.EmployeeRepository;

@SpringBootApplication
public class ExportdataApplication implements CommandLineRunner{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ExportdataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	    List<Employee> employees = new ArrayList<>();
	    
	    // add employees
	    employees.add(new Employee(
	    		"Mario", 
	    		"Rossi", 
	    		"mrossi@gmail.com", 
	    		"ITALY", 
	    		"Architect"));
	    
	    employees.add(new Employee(
	    		"Guerino", 
	    		"Udinesi", 
	    		"gudenesi@gmail.com", 
	    		"ITALY", 
	    		"Junior Developer"));
	    
	    employees.add(new Employee(
	    		"Filippo", 
	    		"De Rossi", 
	    		"fderossi@gmail.com", 
	    		"ITALY", 
	    		"Senior Developer"));
	    
	    employees.add(new Employee(
	    		"Maria", 
	    		"Baresi", 
	    		"mbaresi@gmail.com", 
	    		"ITALY", 
	    		"HR Recruiter"));
	    
	    employees.add(new Employee(
	    		"Marco", 
	    		"De Luca", 
	    		"mdeluca@gmail.com", 
	    		"ITALY", 
	    		"Network Admin"));     
	    
	    employeeRepository.saveAll(employees);
	}

	
}
