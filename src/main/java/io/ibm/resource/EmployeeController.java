package io.ibm.resource;

import java.util.List;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(name = "Employee Staffing API", description = "Provides a Platform to Details about Employee", stage = ApiStage.RC)
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/employee")
	@ApiMethod(description = "Get All the Employee List")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@RequestMapping("/employee/{empid}")
	@ApiMethod(description = "Get Employee Based on the ID")
	public Employee getEmployee(@ApiPathParam(name = "empid") @PathVariable("empid") String id) {
		return employeeService.getEmployee(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/employee")
	@ApiMethod(description = "Add a Employee")
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/employee/{id}")
	@ApiMethod(description = "Update Employee Based on ID")
	public void updateEmployee(@ApiPathParam(name = "id") @RequestBody Employee employee, @PathVariable String id) {
		employeeService.updateEmployee(id, employee);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/employee/{id}")
	public void deleteEmployee(@ApiPathParam(name = "id") @PathVariable String id) {
		employeeService.deleteEmployee(id);
	}

}
