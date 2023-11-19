package techpark.net.userms.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/users")
public class TestController {


    @Value("${eureka.instance.instance-id}")
    private String port;

    @GetMapping("/test")
    public String getTest(){
        return port;
    }
}
