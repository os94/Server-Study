package com.example.demo;

import java.util.List;

public class ArticleDto {
    private String title;
    private List<String> contents;

    public ArticleDto() {
    }

    public ArticleDto(String title, List<String> contents) {
        this.title = title;
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getContents() {
        return contents;
    }
}
