package example.com.chamedurefact.web.dto;

import example.com.chamedurefact.domain.enums.NewsCategory;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewsResponseDto {

    private Long id;
    private String title;
    private String link;
    private String source;
    private NewsCategory category;
    private LocalDateTime publishedAt;
    private String summary;
    private String tags;
}
