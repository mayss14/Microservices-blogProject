package projet.blog.Blog_authms.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterResponse {
    private String username;
    private String password;
    private String nom;
    private String prenom;
    private String email;
}
