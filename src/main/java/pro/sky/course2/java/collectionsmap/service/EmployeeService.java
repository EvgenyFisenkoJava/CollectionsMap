package pro.sky.course2.java.collectionsmap.service;

import org.springframework.stereotype.Service;
import pro.sky.course2.java.collectionsmap.Employee;
import pro.sky.course2.java.collectionsmap.exeptions.EmployeeAlreadyAddedException;
import pro.sky.course2.java.collectionsmap.exeptions.EmployeeNotFoundException;
import pro.sky.course2.java.collectionsmap.exeptions.EmployeeStorageIsFullException;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    private static final int LIMIT = 10;

    private final Map<Integer, Employee> employees = new HashMap<>();

    public Employee addEmployee(int index, String firstName, String lastName) {
        Employee employee = new Employee(index, firstName, lastName);
        if (employees.containsValue(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.containsKey(index)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.put(index, employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }


    public Employee findEmployee(int index, String firstName, String lastName) {
        Employee employee = new Employee(index, firstName, lastName);
        if (!employees.containsValue(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public Employee removeEmployee(int index, String firstName, String lastName) {
        Employee employee = new Employee(index, firstName, lastName);
        if (!employees.containsValue(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(index, employee);
        return employee;
    }

    public Map<Integer, Employee> getList() {
        return new HashMap<>(employees);
    }

}
