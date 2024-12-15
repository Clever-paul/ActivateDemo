package com.ActivateGym.Api.clients.repository;

import com.ActivateGym.Api.clients.domain.entity.MemberAttendance;
import org.springframework.data.repository.CrudRepository;

public interface MemberAttendanceRepository extends CrudRepository<MemberAttendance, Long> {
}
