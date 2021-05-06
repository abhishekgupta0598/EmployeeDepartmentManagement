package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller{
    @Autowired
    Services services;

    @GetMapping("/department")
    public Iterable<Department> getAllDepartment(){
        return services.getAllDepartment();
    }
    @GetMapping("/department/{id}")
    public Department getDepartment(@PathVariable String id){
        return services.getDepartment(id);
    }
    @GetMapping("/department/{id}/employee")
    public List<Employee> getAllEmployee(@PathVariable String id){
        Department department =  services.getAllEmployee(id);
        return department.getEmployee();
    }
    @GetMapping("/department/{departmentId}/employee/{id}")
    public Employee getEmployee(@PathVariable String departmentId, @PathVariable String id){
        Department department = services.getEmployee(departmentId);
        List<Employee> employee = department.getEmployee();
        for(Employee x: employee){
            if(x.getId().equals(id)){
                return x;
            }
        }
        return null;
    }
    @PostMapping("/department")
    public void createDepartment(@RequestBody Department department){
        services.createDepartment(department);
    }
    @PostMapping("/department/{departmentId}/employee")
    public void createEmployee(@RequestBody Employee employee, @PathVariable String departmentId){
        services.createEmployee(employee, departmentId);
    }
    @PutMapping("/department/{id}")
    public void updateDepartment(@RequestBody Department department){
        services.updateDepartment(department);
    }
    @PutMapping("/department/{departmentId}/employee/{id}")
    public void updateEmployee(@RequestBody Employee employee, @PathVariable String departmentId, @PathVariable String id){
        services.updateEmployee(employee, departmentId, id);
    }
    @DeleteMapping("/department/{id}")
    public void deleteDepartment(@PathVariable String id){
        services.deleteDepartment(id);
    }
    @DeleteMapping("/department/{departmentId}/employee/{id}")
    public void deleteEmployee(@PathVariable String id, @PathVariable String departmentId){
        services.deleteEmployee(id, departmentId);
    }
}
