package techpark.net.userms.service;

import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;

public interface KeycloakService {
    UserResource getUserById(String id);
    UsersResource getUsers();
}