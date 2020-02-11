package io.javabrain.elastic.graphqlResolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import io.javabrain.elastic.model.Employee;
import io.javabrain.elastic.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
  private EmployeeRepo employeeRepo;

  @Autowired
  public Query(EmployeeRepo employeeRepo) {
    this.employeeRepo = employeeRepo;
  }

  public Iterable<Employee> findAll() {
    return employeeRepo.findAll();
  }

  public Employee findByCnp(String cnp) {
    return employeeRepo.findByCnp(cnp).get();
  }


  public long count() {
    return employeeRepo.count();
  }


}