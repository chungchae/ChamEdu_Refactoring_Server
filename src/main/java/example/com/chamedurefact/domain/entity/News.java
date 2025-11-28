package example.com.chamedurefact.domain.entity;

import example.com.chamedurefact.domain.enums.NewsCategory;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "news")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class News extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 기사 제목
    @Column(nullable = false, length = 300)
    private String title;

    // 원문 링크(URL)
    @Column(nullable = false, length = 500)
    private String link;

    // 언론사 / 출처 (예: 조선일보, 교육부, 평가원 등)
    @Column(length = 100)
    private String source;

    // 카테고리 (NEWS / OFFICIAL / DATA)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private NewsCategory category;

    // 기사/공지 발행 시각
    private LocalDateTime publishedAt;

    // LLM이 요약한 내용 (2~3줄)
    @Column(columnDefinition = "TEXT")
    private String summary;

    // 태그(정시, 수시, 수능, 정책변경 등)
    @Column(length = 300)
    private String tags;
}
