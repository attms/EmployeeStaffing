package io.ibm.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeerepository;

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		employeerepository.findAll().forEach(employees::add);
		return employees;
	}

	public void addEmployee(Employee employee) {

		employeerepository.save(employee);
	}

	public Employee getEmployee(String id) {
		return employeerepository.findOne(id);
	}

	public void updateEmployee(String id, Employee employee) {
		employeerepository.save(employee);
	}

	public void deleteEmployee(String id) {

		employeerepository.delete(id);
	}

}
