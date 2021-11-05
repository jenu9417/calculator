package com.jana.calculator;

import com.jana.calculator.core.Calculator;
import com.jana.calculator.evaluator.InfixEvaluator;
import com.jana.calculator.input.InputService;
import com.jana.calculator.input.SystemPropertiesInputService;
import com.jana.calculator.output.ConsoleOutputService;
import com.jana.calculator.output.OutputService;
import com.jana.calculator.tokenizer.RegexTokenizer;
import com.jana.calculator.tokenizer.Tokenizer;
import com.jana.calculator.validator.InputValidator;
import com.jana.calculator.validator.StringInputValidator;

/**
 *
 * Entry point of the Calculator App.<br>
 * Initializes the necessary components and invokes execution.
 * <br>
 * <br>
 * <b>[How to Run]</b>
 * <br>
 * java -Dinput=2+2+2 -jar path/to/jar
 *
 * @author Janardhanan V S
 *
 */
public class Main 
{
    public static void main(String[] args) {
       InputService inputService = new SystemPropertiesInputService();
       InputValidator inputValidator = new StringInputValidator();
       Tokenizer tokenizer = new RegexTokenizer();
       OutputService outputService = new ConsoleOutputService();
       
       Calculator calculator = new Calculator(inputService, inputValidator, tokenizer, outputService);
       calculator.setEvaluatorStrategy(new InfixEvaluator());
       calculator.execute();
    }
}
