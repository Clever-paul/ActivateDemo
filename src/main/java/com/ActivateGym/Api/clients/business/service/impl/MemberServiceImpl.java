package com.ActivateGym.Api.clients.business.service.impl;

import com.ActivateGym.Api.clients.business.service.MemberService;
import com.ActivateGym.Api.clients.domain.entity.Member;
import com.ActivateGym.Api.clients.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {


    @Autowired
    private MemberRepository memberRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Member> findAll() {
        return (List<Member>) memberRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Member> findByDni(String dni) {
        return memberRepository.findByDni(dni);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Member> findByNombre(String nombre) {
        return memberRepository.findByNombre(nombre);
    }


    @Override
    @Transactional
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    @Transactional
    public Optional<Member> updateByDni(String dni, Member member) {
        //buscamos el miembro por dni
        Optional<Member> existingMember = findByDni(dni);

        if(existingMember.isPresent()){
            Member memberDB = existingMember.get();

            memberDB.setDni(member.getDni());
            memberDB.setNombre(member.getNombre());
            memberDB.setApellido(member.getApellido());
            memberDB.setTelefono(member.getTelefono());
            memberDB.setFechaNacimiento(member.getFechaNacimiento());
            memberDB.setDireccion(member.getDireccion());
            return Optional.of(saveMember(memberDB));
        }
        return Optional.empty();
    }
}
