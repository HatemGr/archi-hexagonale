package com.hexagonalarchi.demo.infra.configuration;

import com.hexagonalarchi.demo.infra.adapters.repository.cassandra.SpringDataCassandraOrderRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@EnableCassandraRepositories(basePackageClasses = SpringDataCassandraOrderRepository.class)
public class CassandraConfiguration {

}
