package com.example.newsrecommendationsystem;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public final class ArticleTest {
    ///region Test suites for executable com.example.newsrecommendationsystem.Article.getActions

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getActions()

    /**
     * @utbot.classUnderTest {@link Article}
     * @utbot.methodUnderTest {@link Article#getActions()}
     * @utbot.returnsFrom {@code return actions;}
     */
    @Test
    @DisplayName("getActions: -> return actions")
    public void testGetActions_ReturnActions() {
        Article article = new Article(0, null, null, null, null, null, null);

        String actual = article.getActions();

        assertNull(actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.Article.getCategory

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getCategory()

    /**
     * @utbot.classUnderTest {@link Article}
     * @utbot.methodUnderTest {@link Article#getCategory()}
     * @utbot.returnsFrom {@code return category;}
     */
    @Test
    @DisplayName("getCategory: -> return category")
    public void testGetCategory_ReturnCategory() {
        Article article = new Article(0, null, null, null, null, null, null);

        String actual = article.getCategory();

        assertNull(actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.Article.getDescription

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getDescription()

    /**
     * @utbot.classUnderTest {@link Article}
     * @utbot.methodUnderTest {@link Article#getDescription()}
     * @utbot.returnsFrom {@code return description;}
     */
    @Test
    @DisplayName("getDescription: -> return description")
    public void testGetDescription_ReturnDescription() {
        Article article = new Article(0, null, null, null, null, null, null);

        String actual = article.getDescription();

        assertNull(actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.Article.getGuid

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getGuid()

    /**
     * @utbot.classUnderTest {@link Article}
     * @utbot.methodUnderTest {@link Article#getGuid()}
     * @utbot.returnsFrom {@code return guid;}
     */
    @Test
    @DisplayName("getGuid: -> return guid")
    public void testGetGuid_ReturnGuid() {
        Article article = new Article(0, null, null, null, null, null, null);

        String actual = article.getGuid();

        assertNull(actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.Article.getId

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getId()

    /**
     * @utbot.classUnderTest {@link Article}
     * @utbot.methodUnderTest {@link Article#getId()}
     * @utbot.returnsFrom {@code return id;}
     */
    @Test
    @DisplayName("getId: -> return id")
    public void testGetId_ReturnId() {
        Article article = new Article(-255, null, null, null, null, null, null);

        int actual = article.getId();

        assertEquals(-255, actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.Article.getLink

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getLink()

    /**
     * @utbot.classUnderTest {@link Article}
     * @utbot.methodUnderTest {@link Article#getLink()}
     * @utbot.returnsFrom {@code return link;}
     */
    @Test
    @DisplayName("getLink: -> return link")
    public void testGetLink_ReturnLink() {
        Article article = new Article(0, null, null, null, null, null, null);

        String actual = article.getLink();

        assertNull(actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.Article.getPubDate

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getPubDate()

    /**
     * @utbot.classUnderTest {@link Article}
     * @utbot.methodUnderTest {@link Article#getPubDate()}
     * @utbot.returnsFrom {@code return pubDate;}
     */
    @Test
    @DisplayName("getPubDate: -> return pubDate")
    public void testGetPubDate_ReturnPubDate() {
        Article article = new Article(0, null, null, null, null, null, null);

        Date actual = article.getPubDate();

        assertNull(actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.Article.getTitle

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getTitle()

    /**
     * @utbot.classUnderTest {@link Article}
     * @utbot.methodUnderTest {@link Article#getTitle()}
     * @utbot.returnsFrom {@code return title;}
     */
    @Test
    @DisplayName("getTitle: -> return title")
    public void testGetTitle_ReturnTitle() {
        Article article = new Article(0, null, null, null, null, null, null);

        String actual = article.getTitle();

        assertNull(actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.Article.scrapeArticleContent

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method scrapeArticleContent(java.lang.String)

    /**
     * @utbot.classUnderTest {@link Article}
     * @utbot.methodUnderTest {@link Article#scrapeArticleContent(String)}
     * @utbot.executesCondition {@code (!articleContent.isEmpty()): False}
     * @utbot.invokes {@link java.io.PrintStream#println(String)}
     * @utbot.returnsFrom {@code return content;}
     */
    @Test
    @DisplayName("scrapeArticleContent: !articleContent.isEmpty() : False -> return content")
    public void testScrapeArticleContent_ArticleContentIsEmpty() throws IOException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(Jsoup.class);
            Connection connectionMock = mock(Connection.class);
            Document documentMock = mock(Document.class);
            (when(documentMock.title())).thenReturn(((String) null));
            Elements elementsMock = mock(Elements.class);
            (when(elementsMock.isEmpty())).thenReturn(true);
            (when(documentMock.select(any(String.class)))).thenReturn(elementsMock);
            (when(connectionMock.get())).thenReturn(documentMock);
            (mockedStatic.when(() -> Jsoup.connect(any()))).thenReturn(connectionMock);

            String actual = Article.scrapeArticleContent(null);

            String expected = "";

            assertEquals(expected, actual);
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link Article}
     * @utbot.methodUnderTest {@link Article#scrapeArticleContent(String)}
     * @utbot.executesCondition {@code (!articleContent.isEmpty()): True}
     * @utbot.invokes {@link Elements#iterator()}
     * @utbot.returnsFrom {@code return content;}
     */
    @Test
    @DisplayName("scrapeArticleContent: !articleContent.isEmpty() : True -> return content")
    public void testScrapeArticleContent_NotArticleContentIsEmpty() throws IOException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(Jsoup.class);
            Connection connectionMock = mock(Connection.class);
            Document documentMock = mock(Document.class);
            (when(documentMock.title())).thenReturn(((String) null));
            Elements elementsMock = mock(Elements.class);
            (when(elementsMock.isEmpty())).thenReturn(false);
            ArrayList arrayList = new ArrayList();
            Iterator iterator = arrayList.iterator();
            (when(elementsMock.iterator())).thenReturn(iterator);
            (when(documentMock.select(any(String.class)))).thenReturn(elementsMock);
            (when(connectionMock.get())).thenReturn(documentMock);
            (mockedStatic.when(() -> Jsoup.connect(any()))).thenReturn(connectionMock);

            String actual = Article.scrapeArticleContent(null);

            String expected = "";

            assertEquals(expected, actual);
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method scrapeArticleContent(java.lang.String)

    /**
     * @utbot.classUnderTest {@link Article}
     * @utbot.methodUnderTest {@link Article#scrapeArticleContent(String)}
     * @utbot.executesCondition {@code (!articleContent.isEmpty()): True}
     * @utbot.iterates iterate the loop {@code for(Element block: articleContent)} once
     * @utbot.throwsException {@link ClassCastException} in: for(Element block: articleContent)
     */
    @Test
    @DisplayName("scrapeArticleContent: for(Element block: articleContent) -> ThrowClassCastException")
    public void testScrapeArticleContent_ThrowClassCastException() throws IOException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(Jsoup.class);
            Connection connectionMock = mock(Connection.class);
            Document documentMock = mock(Document.class);
            (when(documentMock.title())).thenReturn(((String) null));
            Elements elementsMock = mock(Elements.class);
            (when(elementsMock.isEmpty())).thenReturn(false);
            ArrayList arrayList = new ArrayList();
            arrayList.add(null);
            arrayList.add(null);
            arrayList.add(null);
            arrayList.add(null);
            arrayList.add(null);
            arrayList.add(null);
            arrayList.add(null);
            Iterator iterator = arrayList.iterator();
            (when(elementsMock.iterator())).thenReturn(iterator);
            (when(documentMock.select(any(String.class)))).thenReturn(elementsMock);
            (when(connectionMock.get())).thenReturn(documentMock);
            (mockedStatic.when(() -> Jsoup.connect(any()))).thenReturn(connectionMock);

            /* This test fails because method [com.example.newsrecommendationsystem.Article.scrapeArticleContent] produces [java.lang.ClassCastException: The object with type java.lang.Object can not be casted to org.jsoup.nodes.Element] */
            Article.scrapeArticleContent(null);
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link Article}
     * @utbot.methodUnderTest {@link Article#scrapeArticleContent(String)}
     * @utbot.throwsException {@link NullPointerException} in: Document doc = Jsoup.connect(url).get();
     */
    @Test
    @DisplayName("scrapeArticleContent: doc = Jsoup.connect(url).get() : True -> ThrowNullPointerException")
    public void testScrapeArticleContent_ThrowNullPointerException() {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(Jsoup.class);
            (mockedStatic.when(() -> Jsoup.connect(any()))).thenReturn(((Connection) null));

            /* This test fails because method [com.example.newsrecommendationsystem.Article.scrapeArticleContent] produces [java.lang.NullPointerException] */
            Article.scrapeArticleContent(null);
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link Article}
     * @utbot.methodUnderTest {@link Article#scrapeArticleContent(String)}
     * @utbot.throwsException {@link NullPointerException} in: String title = doc.title();
     */
    @Test
    @DisplayName("scrapeArticleContent: title = doc.title() : True -> ThrowNullPointerException")
    public void testScrapeArticleContent_ThrowNullPointerException_1() throws IOException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(Jsoup.class);
            Connection connectionMock = mock(Connection.class);
            (when(connectionMock.get())).thenReturn(((Document) null));
            (mockedStatic.when(() -> Jsoup.connect(any()))).thenReturn(connectionMock);

            /* This test fails because method [com.example.newsrecommendationsystem.Article.scrapeArticleContent] produces [java.lang.NullPointerException] */
            Article.scrapeArticleContent(null);
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link Article}
     * @utbot.methodUnderTest {@link Article#scrapeArticleContent(String)}
     * @utbot.throwsException {@link NullPointerException} when: !articleContent.isEmpty()
     */
    @Test
    @DisplayName("scrapeArticleContent: !articleContent.isEmpty() -> ThrowNullPointerException")
    public void testScrapeArticleContent_ThrowNullPointerException_2() throws IOException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(Jsoup.class);
            Connection connectionMock = mock(Connection.class);
            Document documentMock = mock(Document.class);
            (when(documentMock.title())).thenReturn(((String) null));
            (when(documentMock.select(any(String.class)))).thenReturn(((Elements) null));
            (when(connectionMock.get())).thenReturn(documentMock);
            (mockedStatic.when(() -> Jsoup.connect(any()))).thenReturn(connectionMock);

            /* This test fails because method [com.example.newsrecommendationsystem.Article.scrapeArticleContent] produces [java.lang.NullPointerException] */
            Article.scrapeArticleContent(null);
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link Article}
     * @utbot.methodUnderTest {@link Article#scrapeArticleContent(String)}
     * @utbot.executesCondition {@code (!articleContent.isEmpty()): True}
     * @utbot.throwsException {@link NullPointerException} in: for(Element block: articleContent)
     */
    @Test
    @DisplayName("scrapeArticleContent: for(Element block: articleContent) -> ThrowNullPointerException")
    public void testScrapeArticleContent_ThrowNullPointerException_3() throws IOException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(Jsoup.class);
            Connection connectionMock = mock(Connection.class);
            Document documentMock = mock(Document.class);
            (when(documentMock.title())).thenReturn(((String) null));
            Elements elementsMock = mock(Elements.class);
            (when(elementsMock.isEmpty())).thenReturn(false);
            (when(elementsMock.iterator())).thenReturn(((Iterator) null));
            (when(documentMock.select(any(String.class)))).thenReturn(elementsMock);
            (when(connectionMock.get())).thenReturn(documentMock);
            (mockedStatic.when(() -> Jsoup.connect(any()))).thenReturn(connectionMock);

            /* This test fails because method [com.example.newsrecommendationsystem.Article.scrapeArticleContent] produces [java.lang.NullPointerException] */
            Article.scrapeArticleContent(null);
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link Article}
     * @utbot.methodUnderTest {@link Article#scrapeArticleContent(String)}
     * @utbot.executesCondition {@code (!articleContent.isEmpty()): True}
     * @utbot.iterates iterate the loop {@code for(Element block: articleContent)} once
     * @utbot.throwsException {@link NullPointerException} in: content += block.text() + "\n";
     */
    @Test
    @DisplayName("scrapeArticleContent: content += block.text() + \"\\n\" -> ThrowNullPointerException")
    public void testScrapeArticleContent_ThrowNullPointerException_4() throws IOException {
        MockedStatic mockedStatic = null;
        try {
            mockedStatic = mockStatic(Jsoup.class);
            Connection connectionMock = mock(Connection.class);
            Document documentMock = mock(Document.class);
            (when(documentMock.title())).thenReturn(((String) null));
            Elements elementsMock = mock(Elements.class);
            (when(elementsMock.isEmpty())).thenReturn(false);
            ArrayList arrayList = new ArrayList();
            arrayList.add(null);
            arrayList.add(null);
            arrayList.add(null);
            arrayList.add(null);
            arrayList.add(null);
            arrayList.add(null);
            Iterator iterator = arrayList.iterator();
            (when(elementsMock.iterator())).thenReturn(iterator);
            (when(documentMock.select(any(String.class)))).thenReturn(elementsMock);
            (when(connectionMock.get())).thenReturn(documentMock);
            (mockedStatic.when(() -> Jsoup.connect(any()))).thenReturn(connectionMock);

            /* This test fails because method [com.example.newsrecommendationsystem.Article.scrapeArticleContent] produces [java.lang.NullPointerException] */
            Article.scrapeArticleContent(null);
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///region FUZZER: SECURITY for method scrapeArticleContent(java.lang.String)

    /**
     * @utbot.classUnderTest {@link Article}
     * @utbot.methodUnderTest {@link Article#scrapeArticleContent(String)}
     */
    @Test
    @DisplayName("scrapeArticleContent: arg_0 = null")
    @Disabled(value = "Disabled due to sandbox")
    public void testScrapeArticleContent() {
        assertThrows(ExceptionInInitializerError.class, () -> Article.scrapeArticleContent(null));
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.Article.setActions

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setActions(java.lang.String)

    /**
     * @utbot.classUnderTest {@link Article}
     * @utbot.methodUnderTest {@link Article#setActions(String)}
     */
    @Test
    @DisplayName("setActions: ")
    public void testSetActions() {
        Article article = new Article(0, null, null, null, null, null, null);

        article.setActions(null);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.Article.setCategory

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setCategory(java.lang.String)

    /**
     * @utbot.classUnderTest {@link Article}
     * @utbot.methodUnderTest {@link Article#setCategory(String)}
     */
    @Test
    @DisplayName("setCategory: ")
    public void testSetCategory() {
        Article article = new Article(0, null, null, null, null, null, null);

        article.setCategory(null);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.Article.setDescription

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setDescription(java.lang.String)

    /**
     * @utbot.classUnderTest {@link Article}
     * @utbot.methodUnderTest {@link Article#setDescription(String)}
     */
    @Test
    @DisplayName("setDescription: ")
    public void testSetDescription() {
        Article article = new Article(0, null, null, null, null, null, null);

        article.setDescription(null);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.Article.setGuid

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setGuid(java.lang.String)

    /**
     * @utbot.classUnderTest {@link Article}
     * @utbot.methodUnderTest {@link Article#setGuid(String)}
     */
    @Test
    @DisplayName("setGuid: ")
    public void testSetGuid() {
        Article article = new Article(0, null, null, null, null, null, null);

        article.setGuid(null);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.Article.setId

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setId(int)

    /**
     * @utbot.classUnderTest {@link Article}
     * @utbot.methodUnderTest {@link Article#setId(int)}
     */
    @Test
    @DisplayName("setId: ")
    public void testSetId() {
        Article article = new Article(-255, null, null, null, null, null, null);

        article.setId(-255);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.Article.setLink

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setLink(java.lang.String)

    /**
     * @utbot.classUnderTest {@link Article}
     * @utbot.methodUnderTest {@link Article#setLink(String)}
     */
    @Test
    @DisplayName("setLink: ")
    public void testSetLink() {
        Article article = new Article(0, null, null, null, null, null, null);

        article.setLink(null);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.Article.setPubDate

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setPubDate(java.util.Date)

    /**
     * @utbot.classUnderTest {@link Article}
     * @utbot.methodUnderTest {@link Article#setPubDate(Date)}
     */
    @Test
    @DisplayName("setPubDate: ")
    public void testSetPubDate() {
        Article article = new Article(0, null, null, null, null, null, null);

        article.setPubDate(null);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.example.newsrecommendationsystem.Article.setTitle

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setTitle(java.lang.String)

    /**
     * @utbot.classUnderTest {@link Article}
     * @utbot.methodUnderTest {@link Article#setTitle(String)}
     */
    @Test
    @DisplayName("setTitle: ")
    public void testSetTitle() {
        Article article = new Article(0, null, null, null, null, null, null);

        article.setTitle(null);
    }
    ///endregion

    ///endregion
}
