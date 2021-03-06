package com.example.EEmployee.control;

import com.example.EEmployee.service.EmployeeService;
import com.example.EEmployee.collection.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeControl {

    @Autowired
    private EmployeeService employeeService;
    private final Logger LOGGER= LoggerFactory.getLogger(EmployeeControl.class);

    @PostMapping("/Employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        LOGGER.info("Inside Of POST Employee");
        return employeeService.addEmployee(employee);
    }
    @GetMapping("/Employee/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id") String id) throws Exception {
        LOGGER.info("INSIDE OF GET EMPLOYEE BY ID");
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/login")
    public String login(){
        return "DONE";
    }
    @GetMapping("/Employee")
    public List<Employee> getEmployees(){
        return employeeService.getAllEmployees();
    }
    @PutMapping("/Employee/")
    public Employee updateEmployee(@RequestParam(name = "id") String id ,@RequestBody Employee employee) throws Exception {
        return employeeService.updateEmployee(id,employee);
    }
    @DeleteMapping("/Employee/private/v1")
    public void deleteAllEmployees(){
        employeeService.deleteAllEmployee();
    }
    @DeleteMapping("/Employee/{id}")
    public Employee deleteEmployee(@PathVariable(name = "id") String id) throws Exception {
        LOGGER.info("INSIDE OF DELETE EMPLOYEE BY ID");
        return employeeService.deleteEmployee(id);
    }
    @GetMapping("/Employee/email/{email}")
    public Employee findEmployeeByEmail(@PathVariable(name = "email") String email) {
        return employeeService.findByEmail(email);

    }

}
