package com.gliwka.springdataneo4joptimisticlockingrepro.ogm.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Version;

@NodeEntity
@Data
public class Organization {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Version
    private Long version;
}
