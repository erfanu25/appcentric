package org.erfan.appcentric.repository;

import org.erfan.appcentric.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "CustomerEntity", path = "CustomerEntity")
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    List<CustomerEntity>  findByFirstName(@Param("name") String name);

    List<CustomerEntity>  findById(@Param("Id") String Id);
}
