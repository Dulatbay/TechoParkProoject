package techpark.net.userms.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import techpark.net.userms.service.impl.KeycloakServiceImpl;

@RestController
@Slf4j
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final KeycloakServiceImpl keycloakService;

    @GetMapping("/test")
    public String getTest(){
        return "test";
    }

    @GetMapping("/{id}")
    public UserResource getById(@PathVariable String id){
        return keycloakService.getUserById(id);
    }

    @GetMapping("/everyone")
    public UsersResource getUsers(){
        return keycloakService.getUsers();
    }

}
