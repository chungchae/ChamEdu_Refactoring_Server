package example.com.chamedurefact.web.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginResponseDto {
    private String email;
    private String nickname;
    private boolean newUser;
    private String token;
    private String role;
}
