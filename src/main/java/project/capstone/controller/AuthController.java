package project.capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.capstone.dto.LoginRequest;
import project.capstone.dto.LoginResponse;
import project.capstone.entities.User;
import project.capstone.services.UserService;
import project.capstone.util.JWTUtil;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

 @Autowired
 private UserService userService;

 @Autowired
 private JWTUtil jwtUtil;

 @PostMapping("/login")
 public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
  User user = userService.findByEmailAndPassword(request.getEmail(), request.getPassword());
  if (user != null) {
   String token = jwtUtil.generateToken(request.getEmail());
   LoginResponse response = new LoginResponse();
   response.setToken(token);
   return ResponseEntity.ok(response);
  } else {
   return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
  }
 }
}
