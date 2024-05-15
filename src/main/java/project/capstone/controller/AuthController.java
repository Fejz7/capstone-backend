package project.capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.capstone.dto.LoginRequest;
import project.capstone.dto.LoginResponse;
import project.capstone.services.UserService;
import project.capstone.util.JWTUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

 @Autowired
 private UserService userService;

 @Autowired
 private JWTUtil jwtUtil;

 @PostMapping("/login")
 public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {

  String token = jwtUtil.generateToken(request.getEmail());
  LoginResponse response = new LoginResponse();
  response.setToken(token);
  return ResponseEntity.ok(response);
 }
}
