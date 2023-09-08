package com.gliwka.springdataneo4joptimisticlockingrepro.sdn.domain;

import lombok.Data;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
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
