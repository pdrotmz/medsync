package br.com.medsync.models;

import jakarta.persistence.Column;

public class Doctor extends User {

    @Column(name = "crm", length = 6, nullable = false, unique = true)
    private String crm;
}
