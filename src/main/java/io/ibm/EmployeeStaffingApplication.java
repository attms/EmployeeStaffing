package io.ibm;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJSONDoc
public class EmployeeStaffingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeStaffingApplication.class, args);
	}
}
