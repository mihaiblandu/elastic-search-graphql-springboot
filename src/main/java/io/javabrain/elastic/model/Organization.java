package io.javabrain.elastic.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Organization {
    private Long id;
    private String name;
    private String address;
}

