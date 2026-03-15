package demo.src.main.java.student_portal_management19.Controller;
import java.net.Authenticator;

import javax.smartcardio.ResponseAPDU;
import javax.swing.text.PasswordView;


import demo.src.main.java.student_portal_management19.DTO.AuthRequest;
import demo.src.main.java.student_portal_management19.Security.JwtUtil;
import demo.src.main.java.student_portal_management19.Security.UserDetailsServiceImpl;
 
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") 
public class AuthController {
 
    @Autowired
    private Authenticator authenticationManager;
 
    @Autowired
    private JwtUtil jwtUtil;
 
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
 
    @Autowired
    private PasswordView passwordEncoder;
 
 
    @PostMapping("/login")
    public ResponseAPDU<?> login(@RequestMapping(value = "") AuthRequest request) {
        try {
            
            ((Object) authenticationManager).authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid username or password");
        }
 
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
 
        String token = jwtUtil.generateToken(userDetails);
 
        return ResponseEntity.ok(new AuthResponse(token));
    }
 
 
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequest request) {
        try {
           
            String encodedPassword = passwordEncoder.encode(request.getPassword());
 
 
            return ResponseEntity.ok("User registered successfully");
 
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Registration failed: " + e.getMessage());
        }
    }
 
 
    @GetMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String authHeader) {
        try {
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                String token = authHeader.substring(7);
                boolean isValid = jwtUtil.validateToken(token);
                return ResponseEntity.ok("Token is valid: " + isValid);
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing token");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
    }
}
 
