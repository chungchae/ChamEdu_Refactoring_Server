package example.com.chamedurefact.batch;
import example.com.chamedurefact.service.NewsCrawlerService;
import example.com.chamedurefact.service.NewsService;
import example.com.chamedurefact.service.NewsSummarizer;
import example.com.chamedurefact.web.dto.news.ExternalNewsItem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class NewsBatchJob {

    @Autowired
    private NewsCrawlerService crawlerService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private NewsSummarizer newsSummarizer;

    // 매일 06:00, 12:00, 18:00에 실행
    @Scheduled(cron = "0 0 6,12,18 * * *")
    public void collectExamNews() {
        log.info("[NewsBatch] 입시 뉴스 수집 시작");
        List<ExternalNewsItem> items = crawlerService.fetchExamNews();
        newsService.saveExternalNewsBatch(items, newsSummarizer);
        log.info("[NewsBatch] 입시 뉴스 수집 완료: {}건", items.size());
    }

    @Scheduled(cron = "0 10 6,12,18 * * *")
    public void collectOfficialNotices() {
        log.info("[NewsBatch] 공식 공지 수집 시작");
        List<ExternalNewsItem> items = crawlerService.fetchOfficialNotices();
        newsService.saveExternalNewsBatch(items, newsSummarizer);
        log.info("[NewsBatch] 공식 공지 수집 완료: {}건", items.size());
    }
}
