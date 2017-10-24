package com.fullstackmarc.cmd.parser.formulas;

public class DefaultFormula implements Formula {

    private final String value;

    public DefaultFormula(String value) {
        this.value = value;
    }

    @Override
    public String execute() {
        return value;
    }
}
