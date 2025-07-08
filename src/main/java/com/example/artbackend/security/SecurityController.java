package com.example.artbackend.security;

import com.example.artbackend.Entities.Utilisateur;
import com.example.artbackend.Repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })

public class SecurityController {
    @Autowired
    private UtilisateurRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager1;
    private final JwtEncoder jwtEncoder;



    @GetMapping("/profile")

    public Authentication profile(Authentication authentication) {
        return authentication;
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        try {
            // Authenticate the user
            Authentication authentication = authenticationManager1.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            // Get user details (assuming you have a UserDetailsService or User entity)
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            // Retrieve user ID from your database or your user entity
            // Example: If you're using a JPA repository to fetch the user:
            Utilisateur userOptional = userRepository.findUtilisateurByEmail(username);
            Integer userId = userOptional.getId();

            // Get roles
            String roles = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.joining(","));

            // Generate JWT token
            Instant now = Instant.now();
            JwtClaimsSet claims = JwtClaimsSet.builder()
                    .issuer("self")
                    .issuedAt(now)
                    .expiresAt(now.plus(10, ChronoUnit.MINUTES))
                    .subject(authentication.getName())
                    .claim("ROLE", roles)
                    .build();

            JwtEncoderParameters jwtParams = JwtEncoderParameters.from(
                    JwsHeader.with(MacAlgorithm.HS512).build(),
                    claims
            );

            String token = jwtEncoder.encode(jwtParams).getTokenValue();

            // Return response with token and user details
            Map<String, Object> response = new HashMap<>();
            response.put("access_token", token);
            response.put("id", userId); // Include user ID
            response.put("user", authentication.getName());
            response.put("roles", roles);

            return ResponseEntity.ok(response);

        } catch (AuthenticationException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid username or password");
        }
    }

    @PostMapping("/registre")
    public void saveUser(@RequestBody  Utilisateur userDto) {
        Utilisateur user = new Utilisateur();
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(userDto.getRole());
        userRepository.save(user);
    }
}
