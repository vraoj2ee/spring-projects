package spring.data.jpa.crud.service;

import spring.data.jpa.crud.entity.Employee;

import java.util.List;
import java.util.Optional;

/**
 * 	•	Use @Service when you need a dedicated layer for business logic, separating it from data access (repositories) and presentation (controllers).
 * 	•	It allows you to manage transactions, organize complex logic, improve testability, and keep your application modular.
 * 	•	For simple CRUD applications, you may skip @Service, but in a larger application, it’s often beneficial to use it for better structure and scalability.
 */

public interface EmployeeService {
    
    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employeeDetails);

    void deleteEmployeeById(Long id);
}