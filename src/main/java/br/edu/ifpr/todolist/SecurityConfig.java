@Configuration
@EnableMethodSecurity
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
            .authorizeHttpRequests(
                auth
                -> auth.requestMatchers("/tarefas/cadastrar")
                       .authenticated()
                       .requestMatchers("/tarefas/listar")
                       .authenticated()
                       .requestMatchers("/tarefas/buscarPorId")
                       .authenticated()
                       .requestMatchers("/tarefas/excluir")
                       .hasRole("ADMIN")
                       .anyRequest().denyAll())
            .formLogin(form
                       -> form.defaultSuccessUrl(
                           "/tarefas/listar", true))
            .httpBasic();

        return http.build();
    }
}