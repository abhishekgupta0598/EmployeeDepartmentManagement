package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Services {


    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    public  Iterable<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }
    public Department getDepartment(String id){
        return departmentRepository.findById(id).orElseThrow(null);
    }
    public  Department getAllEmployee(String id){
        return departmentRepository.findById(id).orElseThrow(null);
    }
    public Department getEmployee(String departmentId){
        return departmentRepository.findById(departmentId).orElseThrow(null);
    }
    public void createDepartment(Department department){
        departmentRepository.save(department);
    }
    public void createEmployee(Employee employee, String id){
        Department d = getDepartment(id);
        d.setEmployee(employee, employee.getId());
        employeeRepository.save(employee);
    }
    public void updateDepartment(Department department){
        departmentRepository.save(department);
    }
    public void updateEmployee(Employee employee, String departmentId, String id){
        Department department = getDepartment(departmentId);
        List<Employee> employee1 = department.getEmployee();
        for(Employee x: employee1){
            if(x.getId().equals(id)){
                createEmployee(employee, departmentId);
            }
            else{
                createEmployee(x, departmentId);
            }
        }
    }
    public void deleteDepartment(String id){
        departmentRepository.deleteById(id);
    }
    public void deleteEmployee(String id, String departmentId){
        Department department = getDepartment(departmentId);
        List<Employee> employee1 = department.getEmployee();
        employee1.remove("id");
        employeeRepository.deleteById(id);
    }
}