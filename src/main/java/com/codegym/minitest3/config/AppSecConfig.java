package com.codegym.minitest3.config;

import com.codegym.minitest3.service.appuser.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class AppSecConfig {
    @Autowired
    private AppUserService userService;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorsize) -> {
            authorsize.requestMatchers("/computer/**").hasAnyRole("ADMIN","USER");
            authorsize.requestMatchers("/type/**").hasAnyRole("ADMIN","USER");
            authorsize.requestMatchers("/computer/create").hasRole("ADMIN");
            authorsize.requestMatchers("/computer/update").hasRole("ADMIN");
            authorsize.requestMatchers("/computer/delete").hasRole("ADMIN");
            authorsize.requestMatchers("/type/create").hasRole("ADMIN");
            authorsize.requestMatchers("/type/update").hasRole("ADMIN");
            authorsize.requestMatchers("/type/delete").hasRole("ADMIN");
            authorsize.requestMatchers("/user").hasRole("USER");
        }).formLogin((authorizie)->authorizie.defaultSuccessUrl("/computer"));
        return http.build();
    }
    @Bean
    public DaoAuthenticationProvider passwordEncoder(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
//        authenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return  authenticationProvider;
    }
    @Bean
    public static PasswordEncoder beanPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userService) // config để biết class này dùng để check user login
                .passwordEncoder(beanPasswordEncoder()); // loại mã hóa password
    }
}
