package project.capstone.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.capstone.dto.LoginRequest;
import project.capstone.dto.LoginResponse;

@RestController
@RequestMapping ("/api/auth")
public class AuthController {
   @PostMapping ("/login")
    public LoginResponse login (@RequestBody LoginRequest request) {
    LoginResponse response = new LoginResponse();
    response.setToken(request.getEmail());
    return response;
    }
}
