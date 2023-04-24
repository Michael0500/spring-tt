package ru.chitu.startertemplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/admin").hasRole("ADMIN")
                .requestMatchers("/user").hasRole("USER")
                .requestMatchers("/light", "/dark").hasAnyRole("ADMIN", "USER")
                .requestMatchers("/css/**", "/js/**", "/fonts/**", "/img/**").permitAll()
                .requestMatchers("/hello").permitAll()
                //.requestMatchers("/login").permitAll()
                .and()
                .formLogin().permitAll()
                .loginPage("/login")
                .usernameParameter("profile")
                .passwordParameter("password")
                .defaultSuccessUrl("/");

        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }
}
