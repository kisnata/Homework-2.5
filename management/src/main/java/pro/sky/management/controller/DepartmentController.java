package pro.sky.management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.management.model.Employee;
import pro.sky.management.service.DepartmentService;

import java.awt.*;

@RestController
@RequestMapping("/departmens")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee findEmployeeWithMaxSalaryFromDepartment(
            @RequestParam("departmentId") int department) {
        return departmentService.findEmployeeWithMaxSalaryFromDepartment(department);
    }

    @GetMapping("/min-salary")
    public Employee findEmployeeWithMinSalaryFromDepartment(
            @RequestParam("departmentId") int department) {
        return departmentService.findEmployeeWithMinSalaryFromDepartment(department);
    }

    @GetMapping(value = "/all", params = "departmentId")
    public List findEmployeesFromDepartment(@RequestParam("departmentId") int department) {
        return departmentService.findAllEmployeesFromDepartment(department);
    }

    @GetMapping("/all")
    public Object findEmployees() {
        return departmentService.findEmployeesByDepartment();
    }
}

