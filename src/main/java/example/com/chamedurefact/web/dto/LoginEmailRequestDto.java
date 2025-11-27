package example.com.chamedurefact.web.dto;

import lombok.Data;

@Data
public class LoginEmailRequestDto {
    private String email;
    private String password;
}
