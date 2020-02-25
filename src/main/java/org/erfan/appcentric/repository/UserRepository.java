package org.erfan.appcentric.repository;

import org.erfan.appcentric.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "UserEntity", path = "UserEntity")
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity>  findByFirstName(@Param("name") String name);

    UserEntity findByEmail(@Param("email") String email);

}
