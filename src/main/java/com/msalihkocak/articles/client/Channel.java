package com.msalihkocak.articles.client;

import com.msalihkocak.articles.article.Article;

public interface Channel {

    void accept(Article article);
}
