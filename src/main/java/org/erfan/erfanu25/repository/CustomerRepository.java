package org.erfan.erfanu25.repository;

import org.erfan.erfanu25.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer>  findByName(@Param("name") String name);
}
