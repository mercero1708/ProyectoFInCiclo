/**package com.disenotuweb.segurizarAplicacion.utils;

import com.disenotuweb.segurizarAplicacion.models.ERole;
import com.disenotuweb.segurizarAplicacion.models.Role;
import com.disenotuweb.segurizarAplicacion.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateRoles implements CommandLineRunner {// interfax implemee¡nto los metodos
@Autowired
    RolService rolService;
    @Override
    public void run(String... args) throws Exception {
        Role rolAdmin = new Role(ERole.ROLE_ADMIN);
        Role rolCoordinador = new Role(ERole.ROLE_COORDINADOR);
        Role rolUser = new Role(ERole.ROLE_USER);
        rolService.save(rolAdmin);
        rolService.save(rolCoordinador);
        rolService.save(rolUser);

    }
}
**/