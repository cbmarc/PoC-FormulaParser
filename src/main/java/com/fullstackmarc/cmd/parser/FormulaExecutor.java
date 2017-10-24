package com.fullstackmarc.cmd.parser;

import com.fullstackmarc.cmd.parser.formulas.Formula;

import java.util.Collection;

public class FormulaExecutor {

    public String execute(Collection<Formula> formulas) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Formula formula : formulas) {
            stringBuilder.append(formula.execute());
        }
        return stringBuilder.toString();
    }

}
