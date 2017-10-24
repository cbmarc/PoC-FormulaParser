package com.fullstackmarc.cmd.parser;

import com.fullstackmarc.cmd.parser.formulas.Formula;

import java.util.Collection;
import java.util.List;

public class FormulaService {

    private KeywordExtractor keywordExtractor;
    private FormulaProvider formulaProvider;
    private FormulaExecutor formulaExecutor;

    public FormulaService(KeywordExtractor keywordExtractor, FormulaProvider formulaProvider, FormulaExecutor formulaExecutor) {
        this.keywordExtractor = keywordExtractor;
        this.formulaProvider = formulaProvider;
        this.formulaExecutor = formulaExecutor;
    }

    public String calculate(String input) {
        List<String> keywords = keywordExtractor.extract(input);
        Collection<Formula> formulas = formulaProvider.provide(keywords);
        return formulaExecutor.execute(formulas);
    }
}
