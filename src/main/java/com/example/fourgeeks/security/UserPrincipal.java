package com.example.fourgeeks.security;

import com.example.fourgeeks.model.Grupo;
import com.example.fourgeeks.model.Permiso;
import com.example.fourgeeks.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class UserPrincipal implements UserDetails {
    private Usuario user;
    private Grupo grupo;
    private List<Permiso> permisos;

    public UserPrincipal(Usuario user, Grupo grupo, List<Permiso> permisos){

        this.user = user;
        this.grupo = grupo;
        this.permisos = permisos;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        // Extrae la lista de permisos (name)
        this.permisos.forEach(p -> {
            GrantedAuthority authority = new SimpleGrantedAuthority(p.getNombre());
            authorities.add(authority);
        });

        // Extrae la lista de grupos o roles (ROLE_name)
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + this.grupo.getNombre());
            authorities.add(authority);
            return authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
