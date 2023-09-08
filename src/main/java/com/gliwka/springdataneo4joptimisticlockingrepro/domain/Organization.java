package com.gliwka.springdataneo4joptimisticlockingrepro.domain;

import lombok.Data;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
@Data
public class Organization {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Version
    private Long version;
}
