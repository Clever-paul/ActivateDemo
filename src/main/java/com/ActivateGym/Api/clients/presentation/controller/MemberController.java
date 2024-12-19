package com.ActivateGym.Api.clients.presentation.controller;

import com.ActivateGym.Api.clients.business.service.MemberService;
import com.ActivateGym.Api.clients.domain.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/list")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberService.findAll();
        return ResponseEntity.ok(members);
    }


    @GetMapping("/dni/{dni}")
    public ResponseEntity<Member> getMemberByDni(@PathVariable("dni") String dni) {
        Optional<Member> member = memberService.findByDni(dni);
        return member.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Obtener un miembro por su nombre
    @GetMapping("/name/{nombre}")
    public ResponseEntity<List<Member>> getMemberByName(@PathVariable("nombre") String nombre) {
        List<Member> members = memberService.findByNombre(nombre);
        if (members.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(members);
    }

    // Crear un nuevo miembro
    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        Member savedMember = memberService.saveMember(member);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMember);
    }

    // Actualizar un miembro por DNI
    @PutMapping("/{dni}")
    public ResponseEntity<Member> updateMemberByDni(@PathVariable("dni") String dni, @RequestBody Member member) {
        Optional<Member> updatedMember = memberService.updateByDni(dni, member);
        return updatedMember.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
