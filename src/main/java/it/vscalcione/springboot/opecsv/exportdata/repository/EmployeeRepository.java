package it.vscalcione.springboot.opecsv.exportdata.repository;

import org.springframework.data.repository.CrudRepository;

import it.vscalcione.springboot.opecsv.exportdata.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
