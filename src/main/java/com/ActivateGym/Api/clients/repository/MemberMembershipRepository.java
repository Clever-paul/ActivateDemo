package com.ActivateGym.Api.clients.repository;

import com.ActivateGym.Api.clients.domain.entity.MemberMembership;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberMembershipRepository extends CrudRepository<MemberMembership, Long> {
    // Metodo para encontrar la membresía activa más reciente de un miembro
    @Query("SELECT mm FROM MemberMembership mm WHERE mm.member.id = :memberId AND mm.estado = 'A' ORDER BY mm.fechaFin DESC")
    Optional<MemberMembership> findActiveMembershipByMemberId(@Param("memberId") Long memberId);

}
