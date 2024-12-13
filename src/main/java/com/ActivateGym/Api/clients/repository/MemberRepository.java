package com.ActivateGym.Api.clients.repository;

import com.ActivateGym.Api.clients.domain.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface MemberRepository extends CrudRepository<Member, Long> {

    Optional<Member> findByDni(String dni);

    List<Member> findByNombre(String nombre);
}
