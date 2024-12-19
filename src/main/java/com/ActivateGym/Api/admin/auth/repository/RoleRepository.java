package com.ActivateGym.Api.admin.auth.repository;

import com.ActivateGym.Api.admin.auth.domain.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends CrudRepository<RoleEntity, Long> {

}
