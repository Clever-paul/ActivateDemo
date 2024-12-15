package com.ActivateGym.Api.clients.repository;

import com.ActivateGym.Api.clients.domain.entity.Membership;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MembershipRepository extends CrudRepository<Membership, Long> {
    Optional<Membership> findById(Long id);

    Optional<Membership> findByNombre(String nombre);
}
