package website.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /*private static final String ADMIN = UserxRole.ADMIN.name();
    private static final String MANAGER = UserxRole.MANAGER.name();
    private static final String EMPLOYEE = UserxRole.EMPLOYEE.name();
    private static final String LOGIN = "/login.xhtml";
    private static final String ACCESSDENIED = "/error/access_denied.xhtml";*/

    // @Autowired
    // DataSource dataSource;

    @Autowired
    JwtTokenFilter jwtTokenFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http
                .cors(c -> c.configurationSource(corsConfigurationSource()))
                .csrf(csrf -> csrf.disable())
                // .headers(headers -> headers.frameOptions(FrameOptionsConfig::sameOrigin)) // needed for H2 console
                .authorizeHttpRequests(authorize -> authorize

                        .requestMatchers("/users/**").permitAll()
                        .requestMatchers("/product/**").permitAll()
                        .requestMatchers("/").permitAll()
                        //.requestMatchers(new AntPathRequestMatcher("/users/login")).permitAll()
                        /*  .requestMatchers(new AntPathRequestMatcher("/swagger**")).permitAll()
                          .requestMatchers(new AntPathRequestMatcher("/jakarta.faces.resource/**")).permitAll()
                          .requestMatchers(new AntPathRequestMatcher("/error/**")).permitAll()
                          .requestMatchers(new AntPathRequestMatcher("/admin/**")).hasAnyAuthority("ADMIN")
                          .requestMatchers(new AntPathRequestMatcher("/secured/**")).hasAnyAuthority(ADMIN, MANAGER, EMPLOYEE)*/
                        .anyRequest().authenticated()
                );
        // http.exceptionHandling(ex->ex.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)));

        http.addFilterBefore(
                jwtTokenFilter,
                UsernamePasswordAuthenticationFilter.class
        );
        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.addAllowedHeader("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
