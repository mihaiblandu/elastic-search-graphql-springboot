package io.javabrain.elastic.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;

import io.javabrain.elastic.model.Employee;
import io.javabrain.elastic.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeResolver implements GraphQLResolver<Employee> {
  @Autowired
  private EmployeeRepo employeeRepo;

  public EmployeeResolver(EmployeeRepo employeeRepo) {
    this.employeeRepo = employeeRepo;
  }

  public Employee getEmployee(Long id) {
    return employeeRepo.findById(id).orElseThrow(null);
  }
}