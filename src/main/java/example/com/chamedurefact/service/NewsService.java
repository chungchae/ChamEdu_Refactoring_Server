package example.com.chamedurefact.service;

import example.com.chamedurefact.domain.entity.News;
import example.com.chamedurefact.domain.enums.NewsCategory;
import example.com.chamedurefact.repository.NewsRepository;
import example.com.chamedurefact.web.dto.NewsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public List<NewsResponseDto> getLatestNews(NewsCategory category, int limit) {

        List<News> list = newsRepository.findTop10ByCategoryOrderByPublishedAtDesc(category);

        return list.stream()
                .map(this::toDto)
                .toList();
    }

    private NewsResponseDto toDto(News n) {
        return NewsResponseDto.builder()
                .id(n.getId())
                .title(n.getTitle())
                .link(n.getLink())
                .source(n.getSource())
                .category(n.getCategory())
                .publishedAt(n.getPublishedAt())
                .summary(n.getSummary())
                .tags(n.getTags())
                .build();
    }
}
