package com.disenotuweb.segurizarAplicacion.service;


import com.disenotuweb.segurizarAplicacion.models.ERole;
import com.disenotuweb.segurizarAplicacion.models.Role;
import org.springframework.beans.factory.annotation.Autowired;

import com.disenotuweb.segurizarAplicacion.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RolService {
    @Autowired
    RoleRepository rolRepository;

    public Optional<Role> getName(ERole name){
        return rolRepository.findByName(name);
    }
    public void save(Role rol){
        rolRepository.save(rol);
    }
}