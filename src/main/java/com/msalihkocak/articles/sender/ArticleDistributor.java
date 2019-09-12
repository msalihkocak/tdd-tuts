package com.msalihkocak.articles.sender;

import com.msalihkocak.articles.article.Article;
import com.msalihkocak.articles.client.Channel;
import com.msalihkocak.articles.client.EntertainmentChannel;
import com.msalihkocak.articles.client.OtherChannel;
import com.msalihkocak.articles.client.SportsChannel;
import com.msalihkocak.articles.database.ArticleDataAccess;

public class ArticleDistributor {
    private SportsChannel sport;
    private EntertainmentChannel entertainment;
    private OtherChannel other;
    private ArticleDataAccess dataAccess;

    public ArticleDistributor(SportsChannel sport, EntertainmentChannel entertainment, OtherChannel other, ArticleDataAccess dataAccess) {
        this.sport = sport;
        this.entertainment = entertainment;
        this.other = other;
        this.dataAccess = dataAccess;
    }

    public void distributeTodays() {
        for(Article article : dataAccess.getTodaysArticle()){
            switch (article.getType()){
                case SPORT:
                    sport.accept(article);
                    break;
                case ENTERTAINMENT:
                    entertainment.accept(article);
                    break;
                default:
                    other.accept(article);
                    break;
            }
        }
    }
}
