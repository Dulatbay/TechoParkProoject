package techpark.net.userms.service.impl;

import lombok.AllArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.springframework.stereotype.Service;
import techpark.net.userms.service.KeycloakService;

@Service
@AllArgsConstructor
public class KeycloakServiceImpl implements KeycloakService {

    private final Keycloak keycloak;
    private final static String KEYCLOAK_REALM_NAME = "techno-park";

    @Override
    public UserResource getUserById(String id) {
        return keycloak.realm(KEYCLOAK_REALM_NAME).users().get(id);
    }

    @Override
    public UsersResource getUsers() {
        return keycloak.realm(KEYCLOAK_REALM_NAME).users();
    }
}