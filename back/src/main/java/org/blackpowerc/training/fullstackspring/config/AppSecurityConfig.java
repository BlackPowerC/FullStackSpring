package org.blackpowerc.training.fullstackspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class AppSecurityConfig
{
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity
            .authorizeHttpRequests(req -> req.anyRequest().authenticated())
            .cors(Customizer.withDefaults())
            .csrf(csrf -> csrf.ignoringRequestMatchers("/**"))
            .httpBasic(Customizer.withDefaults()) ;

        return httpSecurity.build() ;
    }

    @Bean
    public UserDetailsService userManager()
    {
        var admin = User
                .withUsername("jojo")
                .disabled(false)
                .accountExpired(false)
                .accountLocked(false)
                .passwordEncoder(passwordEncoder()::encode)
                .password("mon_super_mot_de_passe_1234")
                .roles("ADMIN")
                .build() ;

        var client = User
                .withUsername("client")
                .disabled(false)
                .accountExpired(false)
                .accountLocked(false)
                .passwordEncoder(passwordEncoder()::encode)
                .password("le_mot_de_pass_du_client_1234")
                .roles("CLIENT")
                .build() ;

        return new InMemoryUserDetailsManager(admin, client) ;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder() ;
    }
}
