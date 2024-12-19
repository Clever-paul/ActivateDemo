package com.ActivateGym.Api.admin.auth.repository;

import com.ActivateGym.Api.admin.auth.domain.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

    @Query(value = "select  u from UserEntity u where u.username = ?1")
    Optional<UserEntity> getUsername(String Username);
}
