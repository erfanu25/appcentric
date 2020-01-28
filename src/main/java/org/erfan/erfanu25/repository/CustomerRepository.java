package org.erfan.erfanu25.repository;

import org.erfan.erfanu25.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "CustomerEntity", path = "CustomerEntity")
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    List<CustomerEntity>  findByName(@Param("name") String name);

    List<CustomerEntity>  findById(@Param("Id") String Id);
}
