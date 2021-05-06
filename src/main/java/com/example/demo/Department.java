package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Department {
    @Id
    private String id;
    private String name;
    @OneToMany
    private List<Employee> employee;

    public Department(){

    }

    public Department(String id, String name, List<Employee> employee){
        this.id = id;
        this.name = name;
        this.employee = employee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Employee data, String id) {
        for(Employee e : employee){
            if(e.getId().equals(id)){
                return;
            }
        }
        this.employee.add(data);
    }
}
