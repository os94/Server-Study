package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    private ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void save(ArticleDto articleDto) {
        Article article = new Article(articleDto.getTitle());
        articleDto.getContents().forEach(
                content -> article.addComment(content)
        );
        articleRepository.save(article);
    }
}
