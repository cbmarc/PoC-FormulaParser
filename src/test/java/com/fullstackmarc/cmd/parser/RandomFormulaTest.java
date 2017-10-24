package com.fullstackmarc.cmd.parser;

import com.fullstackmarc.cmd.parser.formulas.KeywordFormula;
import com.fullstackmarc.cmd.parser.formulas.RandomFormula;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Pattern;

public class RandomFormulaTest {

    private KeywordFormula randomFormula;

    @Before
    public void setUp() {
        randomFormula = new RandomFormula();
    }

    @Test
    public void testGetCommandName() {
        String name = randomFormula.getKeywordName();
        Assert.assertNotNull("Command name is null.", name);
        Assert.assertEquals("Name is not 'random'.", name, "random");
    }

    @Test
    public void testCompute() {
        String computedValue = randomFormula.execute();
        Pattern testingPattern = Pattern.compile("[0-9]+");
        Assert.assertNotNull("Computed value is null.", computedValue);
        Assert.assertTrue("Incorrect computed value.", testingPattern.matcher(computedValue).matches());
    }
}
