package com.gliwka.springdataneo4joptimisticlockingrepro.ogm.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.*;

@NodeEntity
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Relationship
    private Organization organization;

    @Version
    private Long version;
}
