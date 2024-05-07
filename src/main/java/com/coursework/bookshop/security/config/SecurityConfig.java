package com.coursework.bookshop.security.config;

import com.coursework.bookshop.user.entity.Role;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Value("${app.api.path.version.v1}")
    private String PATH_VERSION;
    @Value("${app.api.path.book.getBooks}")
    private String PATH_BOOKS;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(PATH_VERSION+PATH_BOOKS)
                        .authenticated()

                        .requestMatchers("/api/v1/book")
                        .hasAnyAuthority(Role.ADMIN.toString(), Role.MANAGER.toString())

                        .requestMatchers(HttpMethod.DELETE)
                        .hasAuthority(Role.ADMIN.toString())

                        .requestMatchers(HttpMethod.POST)
                        .hasAnyAuthority(Role.ADMIN.toString(), Role.MANAGER.toString())

                        .anyRequest()
                        .permitAll()


                )
//        form->form.loginPage("/api/v1/signin")
                .formLogin(withDefaults());
//                .httpBasic(withDefaults());
        return http.build();
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}