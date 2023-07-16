package com.vccaplication.vccapplication.config;


import com.vccaplication.vccapplication.security.CustomLoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private CustomLoginSuccessHandler successHandler;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers("/register/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/js/**", "/css/**", "/img/**" ,"/pressiplus", "/public/**", "/static/images/**", "/index", "/", "/login").permitAll()
                                .requestMatchers("/index").permitAll()
                                .requestMatchers("/users").hasRole("ADMINISTRATOR")
                                .requestMatchers("/profileEdit/**").hasRole("ADMINISTRATOR")
//                                .anyRequest().authenticated()
                                .requestMatchers("/appointment").authenticated()
                                .requestMatchers("/appointment/**").authenticated()
                                .requestMatchers("/appointment_creation").authenticated()
                                .requestMatchers("/my_appointments").authenticated()
                                .requestMatchers("/all_appointments").authenticated()
                                .requestMatchers("/all_appointmentsAdmin").authenticated()
                                .requestMatchers("/save").authenticated()
                                .requestMatchers("saveUser").authenticated()
                                .requestMatchers("/my_appointments").authenticated()
                                .requestMatchers("/mylist/**").authenticated()
                                .requestMatchers("/deleteMyAppointment/**").authenticated()
                                .requestMatchers("/deleteAppointment/**").authenticated()
                                .requestMatchers("/appointmentEdit/**").authenticated()
                                .requestMatchers("/save_appointment").authenticated()
                                .anyRequest().authenticated()

                ).formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .successHandler(successHandler)
//                                .defaultSuccessUrl("/appointment")
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}