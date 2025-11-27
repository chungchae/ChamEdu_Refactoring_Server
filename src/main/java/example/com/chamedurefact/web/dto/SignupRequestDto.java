package example.com.chamedurefact.web.dto;

import lombok.Data;

@Data
public class SignupRequestDto {
    private String email;
    private String password;
    private String nickname;
}