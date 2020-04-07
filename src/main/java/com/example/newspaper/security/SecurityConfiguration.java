package com.example.newspaper.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private UserPrincipalDetailsService userPrincipalDetailsService;

    public SecurityConfiguration(UserPrincipalDetailsService userPrincipalDetailsService) {
        this.userPrincipalDetailsService = userPrincipalDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
//                .antMatchers("/index.html").permitAll()
                .antMatchers("/index.html").permitAll() // TODOS
                .antMatchers("/categoria/tecnologia").authenticated() // TODOS LOGUEADOS
                .antMatchers("/categoria/videojuegos").hasRole("EDITOR") // SOLO EDITORES
                .antMatchers("/categoria/cine%20y%20series").hasAuthority("POSTSECCION_READ") // SOLO ESCRITORES Y USER
                .antMatchers("/categoria/cultura").hasAuthority("COMENTARIO_READ") // SOLO USER
                .antMatchers("/nuevoArticulo").hasAuthority("ADMIN") // SOLO USER
                .antMatchers("/articulo/7").permitAll()
                //                .antMatchers("/").hasRole("ADMIN")
//                .antMatchers("/").hasRole("CREATE_POST")
//                .antMatchers("/profile/**").authenticated()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/management/**").hasAnyRole("ADMIN", "MANAGER")
//                .antMatchers("/api/v1/test1").hasAuthority("ACCESS_TEST1")
//                .antMatchers("/api/v1/usuario").hasAuthority("ADMIN")
//                .antMatchers("/api/v1/**").hasRole("ADMIN")
                .antMatchers("/api/v1/usuario").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/v1/usuario").permitAll()
                .and()
                .formLogin()
                .loginProcessingUrl("/signin")
                .loginPage("/login").permitAll()
                .usernameParameter("txtUsername")
                .passwordParameter("txtPassword")
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/")
                .and()
                .rememberMe().tokenValiditySeconds(2592000).key("mySecret!").rememberMeParameter("checkRememberMe");
                }

    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);

        return daoAuthenticationProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
