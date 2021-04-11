package com.disenotuweb.segurizarAplicacion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disenotuweb.segurizarAplicacion.models.ERole;
import com.disenotuweb.segurizarAplicacion.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}