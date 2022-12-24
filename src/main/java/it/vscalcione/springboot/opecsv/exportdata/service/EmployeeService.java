package it.vscalcione.springboot.opecsv.exportdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.vscalcione.springboot.opecsv.exportdata.model.Employee;
import it.vscalcione.springboot.opecsv.exportdata.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> fetchAll() {
		return (List<Employee>)employeeRepository.findAll();
	}
}
