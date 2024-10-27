package spring.data.jpa.crud.service;

import spring.data.jpa.crud.entity.Employee;
import spring.data.jpa.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 	•	Use @Service when you need a dedicated layer for business logic, separating it from data access (repositories) and presentation (controllers).
 * 	•	It allows you to manage transactions, organize complex logic, improve testability, and keep your application modular.
 * 	•	For simple CRUD applications, you may skip @Service, but in a larger application, it’s often beneficial to use it for better structure and scalability.
 */


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        
        if (existingEmployee.isPresent()) {
            Employee employee = existingEmployee.get();
            employee.setFirstName(employeeDetails.getFirstName());
            employee.setLastName(employeeDetails.getLastName());
            employee.setEmail(employeeDetails.getEmail());
            
            return employeeRepository.save(employee);
        } else {
            throw new RuntimeException("Employee not found with ID: " + id);
        }
    }

    @Override
    public void deleteEmployeeById(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Employee not found with ID: " + id);
        }
    }
}