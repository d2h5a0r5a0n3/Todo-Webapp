package com.mypackage.springboot.todowebapp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        UserDetails userdetails = createNewUser("Dharan", "1264");
        UserDetails userdetails1 = createNewUser("Dharane", "1264");
        return new InMemoryUserDetailsManager(userdetails, userdetails1);
    }

    private UserDetails createNewUser(String username, String password) {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
        UserDetails userdetails = User.builder().passwordEncoder(passwordEncoder).username(username).password(password).roles("USER", "ADMIN").build();
        return userdetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // http.authorizeHttpRequests(
        //         auth -> auth
        //                 .requestMatchers(
        //                         "/register",
        //                         "/",
        //                         "/h2-console/**",
        //                         "/forgot_password",
        //                         "/reset_password",
        //                         "/change_password"
        //                 )
        //                 .permitAll()
        //                 .anyRequest()
        //                 .authenticated()
        // )
        //         .formLogin(
        //                 form -> form
        //                         .loginPage("/login")
        //                         .loginProcessingUrl("/login")
        //                         .usernameParameter("username")
        //                         .passwordParameter("password")
        //                         .defaultSuccessUrl("/", true)
        //                         .failureUrl("/login?error")
        //                         .permitAll()
        //         )
        //         .logout(logout -> logout
        //         .logoutUrl("/logout")
        //         .logoutSuccessUrl("/")
        //         .permitAll()
        //         )
        //         .rememberMe(remember -> remember
        //         .rememberMeParameter("rememeber-me")
        //         );

        http.authorizeHttpRequests(auth->auth
        .anyRequest().authenticated()
        );
        http.formLogin(withDefaults());
        return http.build();
    }
}
