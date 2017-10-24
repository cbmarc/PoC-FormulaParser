package com.fullstackmarc.cmd.parser;

import com.fullstackmarc.cmd.parser.formulas.DefaultFormula;
import com.fullstackmarc.cmd.parser.formulas.RandomFormula;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;

public class FormulaServiceTest {

    private FormulaService formulaService;

    @Before
    public void setUp() throws Exception {
        formulaService = new FormulaService(
                new KeywordExtractor(),
                new FormulaProvider(Lists.newArrayList(new RandomFormula()), DefaultFormula.class),
                new FormulaExecutor());
    }

    @Test
    public void shouldExecute() throws Exception {
        String input = "HelloWorld + random + Suffix";

        String result = formulaService.calculate(input);

        Pattern testingPattern = Pattern.compile("HelloWorld[0-9]+Suffix");
        Assert.assertTrue("Formula result is incorrect: " + result, testingPattern.matcher(result).matches());
    }

    @Test
    public void shouldReturnEmptyWithBlank() throws Exception {
        String input = "        ";
        String result = formulaService.calculate(input);
        Assert.assertThat(result, is(""));
    }

    @Test
    public void shouldReturnEmptyWithNull() throws Exception {
        String input = null;
        String result = formulaService.calculate(input);
        Assert.assertThat(result, is(""));
    }

    @Test
    public void shouldReturnEmptyWithEmpty() throws Exception {
        String input = "";
        String result = formulaService.calculate(input);
        Assert.assertThat(result, is(""));
    }
}