package io.javabrain.elastic.graphqlMutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import io.javabrain.elastic.model.Employee;
import io.javabrain.elastic.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    private EmployeeRepo employeeRepo;

    @Autowired
    public Mutation(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee createEmployee(Employee employee) {

        employeeRepo.save(employee);

        return employee;
    }



}