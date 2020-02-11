package io.javabrain.elastic;


import com.github.javafaker.Faker;

import io.javabrain.elastic.model.Departament;
import io.javabrain.elastic.model.Employee;
import io.javabrain.elastic.model.IDNP;
import io.javabrain.elastic.model.Organization;
import io.javabrain.elastic.repo.EmployeeRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Random;


@Component
public class DbInitializer implements CommandLineRunner {
    private EmployeeRepo employeeRepo;

    public DbInitializer(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.employeeRepo.deleteAll();
        Faker usFaker = new Faker(new Locale("en-GB"));


        for (int i = 0; i < 10000; i++) {
            Random r = new Random();
            Employee employee = new Employee();
            employee.setName(usFaker.name().name());
            employee.setAge(r.nextInt(82) + 18);
            employee.setPosition(usFaker.company().profession());
            employee.setCnp(usFaker.idNumber().validSvSeSsn());
            employee.setIdnp(new IDNP(usFaker.idNumber().ssnValid()));
            int departmentId = r.nextInt(500000);
            employee.setDepartament(new Departament((long) departmentId, usFaker.company().bs()));
            int organizationId = departmentId / 100;
            employee.setOrganization(new Organization((long) organizationId, usFaker.company().name(), usFaker.address().fullAddress()));
            employeeRepo.save(employee);
        }


        System.out.println(" -- Database has been initialized");
    }
}
