package com.fullstackmarc.cmd.parser.formulas;

import java.util.Date;
import java.util.Random;

public class RandomFormula implements KeywordFormula {

    private static final String COMMAND_NAME = "random";

    public String getKeywordName() {
        return COMMAND_NAME;
    }

    public String execute() {
        Random random = new Random(new Date().getTime());
        return "" + random.nextInt(Integer.SIZE - 1);
    }
}
