package com.ActivateGym.Api.clients.business.service.impl;

import com.ActivateGym.Api.clients.business.service.MembershipService;
import com.ActivateGym.Api.clients.domain.entity.Membership;
import com.ActivateGym.Api.clients.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembershipServiceImpl implements MembershipService {

    @Autowired
    private MembershipRepository membershipRepository;

    @Override
    public Membership saveNewMembership(Membership membership) {
        return membershipRepository.save(membership);
    }

    @Override
    public List<Membership> findAllMemberships() {
        return (List<Membership>) membershipRepository.findAll();
    }

    @Override
    public Optional<Membership> updateMembership(Long id, Membership membership) {
        //buscamos la membresia por dni
        Optional<Membership> existingMembership = findByIdMembership(id);

        if(existingMembership.isPresent()){
            Membership membershipDB = existingMembership.get();

            membershipDB.setNombre(membership.getNombre());
            membershipDB.setCosto(membership.getCosto());

            return Optional.of(saveNewMembership(membershipDB));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Membership> deleteMembership(Long id) {
        Optional<Membership> membershipOptional = membershipRepository.findById(id);
        membershipOptional.ifPresent(productDB -> {
            membershipRepository.delete(productDB);
        });
        return membershipOptional;
    }

    @Override
    public Optional<Membership> findByIdMembership(Long id) {
        return membershipRepository.findById(id);
    }

    @Override
    public Optional<Membership> findByNombre(String nombre) {
        return membershipRepository.findByNombre(nombre);
    }

}
