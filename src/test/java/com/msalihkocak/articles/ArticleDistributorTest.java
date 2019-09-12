package com.msalihkocak.articles;

import com.msalihkocak.articles.article.Article;
import com.msalihkocak.articles.article.Type;
import com.msalihkocak.articles.client.EntertainmentChannel;
import com.msalihkocak.articles.client.OtherChannel;
import com.msalihkocak.articles.client.SportsChannel;
import com.msalihkocak.articles.database.ArticleDataAccess;
import com.msalihkocak.articles.sender.ArticleDistributor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ArticleDistributorTest {

    @Mock
    SportsChannel sportsChannel;

    @Mock
    EntertainmentChannel entertainmentChannel;

    @Mock
    OtherChannel otherChannel;

    @Mock
    ArticleDataAccess dataAccess;

    @InjectMocks
    ArticleDistributor distributor;

    @Test
    public void sportGoesToSportAndPoliticsToOther(){

        // Given this list of articles is returned from database
        List<Article> list = asList(new Article("Sport is fun", Type.SPORT), new Article("Politics is sad", Type.POLITICS));
        when(dataAccess.getTodaysArticle()).thenReturn(list);

        // when we distribute
        distributor.distributeTodays();

        // then one goes to sport and one goes to other
        verify(sportsChannel).accept(any());
        verify(otherChannel).accept(any());
        verify(entertainmentChannel, never()).accept(any());
    }

}