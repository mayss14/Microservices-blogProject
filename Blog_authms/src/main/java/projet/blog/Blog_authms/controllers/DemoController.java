package projet.blog.Blog_authms.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/auth/demo")
public class DemoController {
    @GetMapping
    ResponseEntity<String> SayHello(){
        return ResponseEntity.ok("Hello from secured endpoint");
    }
}
