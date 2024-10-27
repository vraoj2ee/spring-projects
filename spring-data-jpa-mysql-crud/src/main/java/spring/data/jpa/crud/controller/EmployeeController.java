package spring.data.jpa.crud.controller;

import spring.data.jpa.crud.entity.Employee;
import spring.data.jpa.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.data.jpa.crud.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // health
    @GetMapping("ping")
    public String ping() {
        return "Working";
    }

    // Get all employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // Get a single employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Update an existing employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Optional<Employee> employeeOptional = employeeService.getEmployeeById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setFirstName(employeeDetails.getFirstName());
            employee.setLastName(employeeDetails.getLastName());
            employee.setEmail(employeeDetails.getEmail());

            Employee updatedEmployee = employeeService.saveEmployee(employee);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Partial Update of an Employee (using PATCH)
    @PatchMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeePartially(@PathVariable Long id, @RequestBody Employee partialUpdate) {
        Optional<Employee> employeeOptional = employeeService.getEmployeeById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = getEmployee(partialUpdate, employeeOptional);
            Employee updatedEmployee = employeeService.saveEmployee(employee);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private static Employee getEmployee(Employee partialUpdate, Optional<Employee> employeeOptional) {
        Employee employee = employeeOptional.get();
        // Apply only the fields that are not null in the incoming request
        if (partialUpdate.getFirstName() != null) {
            employee.setFirstName(partialUpdate.getFirstName());
        }
        if (partialUpdate.getLastName() != null) {
            employee.setLastName(partialUpdate.getLastName());
        }
        if (partialUpdate.getEmail() != null) {
            employee.setEmail(partialUpdate.getEmail());
        }
        return employee;
    }

    // Delete an employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        if (employeeService.getEmployeeById(id).isPresent()) {
            employeeService.deleteEmployeeById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
