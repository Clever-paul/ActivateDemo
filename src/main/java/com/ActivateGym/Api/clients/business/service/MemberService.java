package com.ActivateGym.Api.clients.business.service;

import com.ActivateGym.Api.clients.domain.entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MemberService {

    //devolver una lista de los miembros
    List<Member> findAll();

    //busca por dni y trae el objeto
    Optional<Member> findByDni(String dni);

    //te debuelve un objeto a partir de un nombre
    List<Member> findByNombre(String nombre);

    //guardar un miembro
    Member saveMember(Member member);

    //para actualizar por dni
    Optional<Member> updateByDni(String dni, Member member);



    /*Member registerNewMember(Long membershipId, Member memberData) throws Exception;
    // Otros métodos como getAllMembers, getMemberById, etc.*/
}
