package example.com.chamedurefact.repository;

import example.com.chamedurefact.domain.entity.News;
import example.com.chamedurefact.domain.enums.NewsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {

    // 카테고리별 최신 n개
    List<News> findTop10ByCategoryOrderByPublishedAtDesc(NewsCategory category);

    // limit 바꾸기
    List<News> findTop50ByCategoryOrderByPublishedAtDesc(NewsCategory category);

    // 키워드 검색 (제목 + 요약)
    List<News> findByCategoryAndTitleContainingIgnoreCaseOrCategoryAndSummaryContainingIgnoreCase(
            NewsCategory c1, String titleKeyword,
            NewsCategory c2, String summaryKeyword
    );

    // 날짜 범위 + 카테고리
    List<News> findByCategoryAndPublishedAtBetweenOrderByPublishedAtDesc(
            NewsCategory category, LocalDateTime start, LocalDateTime end
    );
}
