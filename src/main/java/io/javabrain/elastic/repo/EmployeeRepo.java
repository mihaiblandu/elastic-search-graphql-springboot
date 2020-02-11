package io.javabrain.elastic.repo;

import io.javabrain.elastic.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee,Long> {
    List<Employee> findByOrganizationName(String name);
    List<Employee> findByName(String name);
    Optional<Employee> findByCnp(String cnp);
}
