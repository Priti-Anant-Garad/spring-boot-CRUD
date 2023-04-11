package com.example.employee.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.entity.Employee;;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    List<Employee> empList=new ArrayList<>();

    @PostMapping("save")
    public Employee saveEmployee(@RequestBody Employee employee)
    {
        empList.add(employee);
        return employee;
    }

    @GetMapping("getall")
    public List<Employee> getallemployee()
    {
        return empList;
    }

    @GetMapping("getbyid/{empid}")
    public Employee getemployeebyid(@PathVariable int empid)
    {
        for(Employee e: empList)
        {
            if(e.getEmpid()==empid)
            {
                return e;
            }
        }
        return new Employee();
    }

    @DeleteMapping("deletebyid/{empid}")
    public Employee deleteemployeebyid(@PathVariable int empid)
    {
        for(Employee e:empList)
        {
            if(e.getEmpid()==empid)
            {
                empList.remove(empid);
                return e;
            }
        }
        return new Employee();
    }

    @DeleteMapping("deleteall")
    public List<Employee> deleteall()
    {
        return empList;
    }
}
