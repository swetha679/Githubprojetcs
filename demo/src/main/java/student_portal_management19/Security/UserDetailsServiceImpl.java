package demo.src.main.java.student_portal_management19.Security;

 
import java.util.List;
import java.util.stream.Collectors;
 
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private StudentRepository studentRepository; 
 
 
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
 
        StudentEntity student = studentRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User not found with username: " + username));
 
        List<SimpleGrantedAuthority> authorities = student.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role))
                .collect(Collectors.toList());
 
        return User.builder()
                .username(student.getUsername())
                .password(student.getPassword()) 
                .authorities(authorities)
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
