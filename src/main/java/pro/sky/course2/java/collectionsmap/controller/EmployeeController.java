package pro.sky.course2.java.collectionsmap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course2.java.collectionsmap.Employee;
import pro.sky.course2.java.collectionsmap.service.EmployeeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("index") int index,
                                @RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName) {
        return employeeService.addEmployee(index, firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("index") int index,
                                   @RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName) {
        return employeeService.removeEmployee(index, firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("index") int index,
                                 @RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        return employeeService.findEmployee(index, firstName, lastName);
    }


    @GetMapping("/list")
    public Map<Integer, Employee> getList() {
        return employeeService.getList();
    }


}
