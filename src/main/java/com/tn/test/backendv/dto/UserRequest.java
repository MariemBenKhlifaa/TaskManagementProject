package com.tn.test.backendv.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private String username;
    private String email;
    private String fullName;
    private String password; // pour la création ou la mise à jour

    // Role en paramètre si besoin
    private String role; // ADMIN, MANAGER, USER
}
