package com.ActivateGym.Api.clients.repository;

import com.ActivateGym.Api.clients.domain.entity.MemberAttendance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberAttendanceRepository extends CrudRepository<MemberAttendance, Long> {
}
