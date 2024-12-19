package com.ActivateGym.Api.clients.presentation.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize(value = "hasRole('ADMIN')")
public class MembershipController {
}
