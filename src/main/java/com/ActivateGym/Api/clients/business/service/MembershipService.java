package com.ActivateGym.Api.clients.business.service;

import com.ActivateGym.Api.clients.domain.entity.Membership;

import java.util.List;
import java.util.Optional;

public interface MembershipService {
    //crear nueva membresia
    Membership saveNewMembership(Membership membership);

    //listar todos las membresias
    List<Membership> findAllMemberships();

    //editar membersia
    Optional<Membership> updateMembership(Long id, Membership membership);

    //eliminar una membresia
    Optional<Membership> deleteMembership(Long id);

    //bucar membresia por id
    Optional<Membership> findByIdMembership(Long id);

    //buscar por normbre de membresia
    Optional<Membership> findByNombre(String nombre);
}
