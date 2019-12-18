package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private CommentRepository commentRepository;

    private ArticleService articleService;

    public CommentService(CommentRepository commentRepository, ArticleService articleService) {
        this.commentRepository = commentRepository;
        this.articleService = articleService;
    }

    public void save(Long articleId, CommentDto commentDto) {
        Article article = articleService.findArticleById(articleId);
        Comment comment = new Comment(commentDto.getContent(), article);
        commentRepository.save(comment);
    }
}
