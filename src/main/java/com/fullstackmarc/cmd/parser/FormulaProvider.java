package com.fullstackmarc.cmd.parser;

import com.fullstackmarc.cmd.parser.formulas.Formula;
import com.fullstackmarc.cmd.parser.formulas.KeywordFormula;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class FormulaProvider {

    private Map<String, Formula> formulaMap;
    private Class defaultFormulaClass;

    public FormulaProvider(Collection<KeywordFormula> formulas, Class defaultFormulaClass) {
        this.defaultFormulaClass = defaultFormulaClass;
        initialize(formulas);
    }

    public Collection<Formula> provide(Collection<String> keywords) {
        Collection<Formula> formulas = new ArrayList();
        for (String keyword : keywords) {
            formulas.add(getFormula(keyword));
        }
        return formulas;
    }

    private Formula getFormula(String keyword) {
        if (formulaMap.containsKey(keyword)) {
            return formulaMap.get(keyword);
        } else {
            try {
                return (Formula) defaultFormulaClass.getConstructor(String.class).newInstance(keyword);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                // TODO: Handle
                e.printStackTrace();
            }
        }
        return null;
    }


    private void initialize(Collection<KeywordFormula> formulas) {
        formulaMap = new HashMap();
        for (KeywordFormula keywordFormula : formulas) {
            formulaMap.put(keywordFormula.getKeywordName(), keywordFormula);
        }
    }


}
