package io.javabrain.elastic.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Document(indexName = "sample", type = "employee")
public class Employee {

    @Id
    private Long ID;
    @Field(type = FieldType.Object)
    private Organization organization;
    @Field(type = FieldType.Object)
    private Departament departament;
    @Field(type = FieldType.Object)
    private IDNP idnp;
    private String cnp;
    private String name;
    private int age;
    private String position;

}