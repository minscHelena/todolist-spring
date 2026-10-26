package br.edu.ifpr.todolist;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {

    @Bean 
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService
    userDetailsService(PasswordEncoder encoder)
    {

        UserDetails admin
            = User.withUsername("Ademir")
                  .password(encoder.encode("adm1234"))
                  .roles("ADMIN", "USER")
                  .build();

        UserDetails user
            = User.withUsername("Ursula")
                  .password(encoder.encode("usr1234"))
                  .roles("USER")
                  .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public SecurityFilterChain
    securityFilterChain(HttpSecurity http) throws Exception
    {
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests( auth -> auth
                .requestMatchers("/tarefas/cadastrar")
                       .authenticated()
                       .requestMatchers("/tarefas/listar")
                       .authenticated()
                       .requestMatchers("/tarefas/buscarPorId/{id}")
                       .authenticated()
                       .requestMatchers("/tarefas/excluir/{id}")
                       .hasRole("ADMIN")
                       .anyRequest().denyAll())
            .formLogin(form
                       -> form.defaultSuccessUrl(
                           "/tarefas/listar", true))
            .httpBasic(basic -> {});

        return http.build();
    }
}