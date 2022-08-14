package de.gie.tool.commontasks.general.security;

import de.gie.tool.commontasks.general.security.jwt.JwtUtil;
import de.gie.tool.commontasks.general.security.model.AuthDTO;
import de.gie.tool.commontasks.general.security.model.UserCredential;
import de.gie.tool.commontasks.general.security.model.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserCredentialRepository userCredentialRepository;

    private PasswordEncoder passwordEncoder;

    private AuthenticationManager authenticationManager;

    private JwtUtil jwtUtil;

    @Autowired
    public AuthController(UserCredentialRepository userCredentialRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userCredentialRepository = userCredentialRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    // ----------------- Currently new user is manually added by admin ---------------

//    @PostMapping(value = "/register")
//    public ResponseEntity<UserCredential> register(@RequestBody AuthDTO authRequest) {
//        Optional<UserCredential> userOptional = userCredentialRepository.findByUserName(authRequest.getUserName());
//
//        if (userOptional.isPresent()) {
//            return ResponseEntity.badRequest().build();
//        }
//
//        UserCredential userCredential = new UserCredential();
//        userCredential.setUserName(authRequest.getUserName());
//        userCredential.setPassword(passwordEncoder.encode(authRequest.getPassword()));
//
//        UserCredential created = userCredentialRepository.save(userCredential);
//        return ResponseEntity.ok(created);
//    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody AuthDTO authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUserName(),
                        authRequest.getPassword()
                )
        );
        return ResponseEntity.ok(jwtUtil.generateToken(authentication));
    }

}
