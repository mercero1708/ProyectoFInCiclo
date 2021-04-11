package com.disenotuweb.segurizarAplicacion.models;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

//@Entity
public enum ERole {
        ROLE_USER,
        ROLE_COORDINADOR,
        ROLE_ADMIN;
        private ERole myValue;
        @Enumerated(EnumType.STRING)
        private ERole getMyValue() {
                return myValue;
        }

}