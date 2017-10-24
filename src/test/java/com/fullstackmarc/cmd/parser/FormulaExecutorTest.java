package com.fullstackmarc.cmd.parser;

import com.fullstackmarc.cmd.parser.formulas.DefaultFormula;
import com.fullstackmarc.cmd.parser.formulas.Formula;
import com.fullstackmarc.cmd.parser.formulas.RandomFormula;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;

public class FormulaExecutorTest {

    @Test
    public void shouldExecute() {
        FormulaExecutor formulaExecutor = new FormulaExecutor();
        List<Formula> formulas = new ArrayList<>();
        formulas.add(new DefaultFormula("HelloWorld"));
        formulas.add(new RandomFormula());
        formulas.add(new DefaultFormula("Suffix"));

        String result = formulaExecutor.execute(formulas);
        Pattern testingPattern = Pattern.compile("HelloWorld[0-9]+Suffix");
        Assert.assertTrue("Formula result is incorrect: " + result, testingPattern.matcher(result).matches());
    }

}
