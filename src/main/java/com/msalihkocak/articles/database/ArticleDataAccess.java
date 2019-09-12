package com.msalihkocak.articles.database;

import com.msalihkocak.articles.article.Article;

import java.util.List;

public interface ArticleDataAccess {
    List<Article> getTodaysArticle();
}
