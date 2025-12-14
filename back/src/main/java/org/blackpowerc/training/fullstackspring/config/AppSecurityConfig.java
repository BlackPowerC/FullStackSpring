package org.blackpowerc.training.fullstackspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class AppSecurityConfig
{
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity.cors(Customizer.withDefaults()) ;
        httpSecurity.csrf(Customizer.withDefaults()) ;
        httpSecurity.httpBasic(Customizer.withDefaults()) ;
        return httpSecurity.build() ;
    }

    @Bean
    @Primary
    public UserDetailsService userManager()
    {
        var defaultUser = new  User("jojo", "mon_super_mot_de_passe_1234", List.of(new SimpleGrantedAuthority("ROLE_ADMIN"))) ;
        return new InMemoryUserDetailsManager(defaultUser) ;
    }
}
