package demo.src.main.java.student_portal_management19.DTO;

public class AuthResponse {
 
 
    private String token;
    private String type = "Bearer";
    private String username;
    private long expiresIn;
 
 
    public AuthResponse() {
    }
 
    public AuthResponse(String token) {
        this.token = token;
    }
 
    public AuthResponse(String token, String username, long expiresIn) {
        this.token = token;
        this.username = username;
        this.expiresIn = expiresIn;
    }
 
 
    public String getToken() {
        return token;
    }
 
    public void setToken(String token) {
        this.token = token;
    }
 
    public String getType() {
        return type;
    }
 
    public void setType(String type) {
        this.type = type;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public long getExpiresIn() {
        return expiresIn;
    }
 
    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }
 
 
    @Override
    public String toString() {
        return "AuthResponse{" +
                "token='" + token + '\'' +
                ", type='" + type + '\'' +
                ", username='" + username + '\'' +
                ", expiresIn=" + expiresIn +
                '}';
    }
}
 
