package com.example.newspaper.security;

import com.example.newspaper.model.Grupo;
import com.example.newspaper.model.Permiso;
import com.example.newspaper.model.Usuario;
import com.example.newspaper.repository.GrupoRep;
import com.example.newspaper.repository.PermisoRep;
import com.example.newspaper.repository.UsuarioRep;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private UsuarioRep usuarioRep;
    private PermisoRep permisoRep;
    private GrupoRep grupoRep;

    public UserPrincipalDetailsService(UsuarioRep usuarioRep, GrupoRep grupoRep, PermisoRep permisoRep) {
        this.usuarioRep = usuarioRep;
        this.permisoRep = permisoRep;
        this.grupoRep = grupoRep;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario user = this.usuarioRep.findByEmail(email);
        Grupo grupo = this.grupoRep.findByUser(email);
        List<Permiso> permisos = this.permisoRep.findByUser(email);
        UserPrincipal userPrincipal = new UserPrincipal(user, grupo, permisos);

        return userPrincipal;
    }


}
