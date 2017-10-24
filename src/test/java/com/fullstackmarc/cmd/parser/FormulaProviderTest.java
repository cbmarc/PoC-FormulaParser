package com.fullstackmarc.cmd.parser;

import com.fullstackmarc.cmd.parser.formulas.DefaultFormula;
import com.fullstackmarc.cmd.parser.formulas.Formula;
import com.fullstackmarc.cmd.parser.formulas.KeywordFormula;
import com.fullstackmarc.cmd.parser.formulas.RandomFormula;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;

public class FormulaProviderTest {

    private FormulaProvider formulaProvider;

    @Before
    public void setUp() {
        Collection<KeywordFormula> formulas = new ArrayList();
        formulas.add(new RandomFormula());
        formulaProvider = new FormulaProvider(formulas, DefaultFormula.class);
    }

    @Test
    public void testProvide() {
        List<String> keywords = Lists.newArrayList("HelloWord", "random", "Suffix");
        List<Formula> formulas = (List<Formula>) formulaProvider.provide(keywords);
        Assert.assertThat(formulas, notNullValue());
        Assert.assertThat(formulas.size(), is(keywords.size()));
        Assert.assertThat(formulas.get(0), instanceOf(DefaultFormula.class));
        Assert.assertThat(formulas.get(1), instanceOf(RandomFormula.class));
        Assert.assertThat(formulas.get(2), instanceOf(DefaultFormula.class));
    }
}
