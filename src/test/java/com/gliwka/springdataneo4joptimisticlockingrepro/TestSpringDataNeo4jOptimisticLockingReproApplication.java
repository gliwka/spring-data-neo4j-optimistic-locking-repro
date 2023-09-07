package com.gliwka.springdataneo4joptimisticlockingrepro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestSpringDataNeo4jOptimisticLockingReproApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringDataNeo4jOptimisticLockingReproApplication::main).with(TestSpringDataNeo4jOptimisticLockingReproApplication.class).run(args);
	}

}
