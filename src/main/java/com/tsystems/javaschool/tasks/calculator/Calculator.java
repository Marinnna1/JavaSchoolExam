package com.tsystems.javaschool.tasks.calculator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Calculator {

    /**
     * Evaluate statement represented as string.
     *
     * @param statement mathematical statement containing digits, '.' (dot) as decimal mark,
     *                  parentheses, operations signs '+', '-', '*', '/'<br>
     *                  Example: <code>(1 + 38) * 4.5 - 1 / 2.</code>
     * @return string value containing result of evaluation or null if statement is invalid
     */
    public String evaluate(String statement) {

        // check if statement is valid or not
        try {
            if (statement.contains("//") || statement.contains("**") || statement.contains("++") || statement.contains("--") || statement.contains(",") || statement.contains("..")) {
                return null;
            }
        }
        catch (NullPointerException e) {
            return null;
        }

        // define format and count the result
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");
        DecimalFormat decimalFormat = new DecimalFormat("###.####");
        try {
            BigDecimal result = new BigDecimal(scriptEngine.eval(statement).toString());
            return (decimalFormat.format(result).replaceAll(",","."));
        } catch (Exception e) {
            return null;
        }
    }



}
