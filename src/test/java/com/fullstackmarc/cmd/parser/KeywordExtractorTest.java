package com.fullstackmarc.cmd.parser;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

public class KeywordExtractorTest {

    @Test
    public void testExtract() {
        String input = "HelloWorld + random + Suffix";
        KeywordExtractor keywordExtractor = new KeywordExtractor();
        List<String> keywords = keywordExtractor.extract(input);
        Assert.assertThat(keywords, notNullValue());
        Assert.assertThat(keywords.size(), is(3));
        Assert.assertThat(keywords.get(0), is("HelloWorld"));
        Assert.assertThat(keywords.get(1), is("random"));
        Assert.assertThat(keywords.get(2), is("Suffix"));
    }
}
