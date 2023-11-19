package techpark.net.userms.config;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/main/*", "/home")
                        .permitAll()
                        .anyRequest()
                        .permitAll()
                );


        return http.build();
    }

    @Bean
    public Keycloak keycloak() {

        return KeycloakBuilder.builder()
                .serverUrl("http://localhost:8080/")
                .realm("techno-park")
                .grantType(OAuth2Constants.PASSWORD)
                .username("admin")
                .password("admin_password")
                .clientId("admin-cli")
                .build();
    }
}

