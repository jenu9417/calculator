package com.jana.calculator.core;

import java.util.List;

import com.jana.calculator.evaluator.EvaluatorStrategy;
import com.jana.calculator.evaluator.PostfixEvaluator;
import com.jana.calculator.exception.OutputFailedException;
import com.jana.calculator.input.InputService;
import com.jana.calculator.output.OutputService;
import com.jana.calculator.tokenizer.Tokenizer;
import com.jana.calculator.validator.InputValidator;

/**
*
* Contains the core logic of calculator app. Executes the various stages such as input, validation, tokenizing, evaluation and output
* in serial order. Serves as the context for expression evaluation.
* <br><br>
* Uses the default evaluator strategy, unless the user overrides.
* <br>
* Default evaluator strategy used : {@link PostfixEvaluator}
*
* @author Janardhanan V S
*/
public class Calculator {

	private InputService inputService;

	private InputValidator inputValidator;

	private Tokenizer tokenizer;

	private OutputService outputService;
	
	private EvaluatorStrategy evaluatorStrategy;

	public Calculator(InputService inputService, InputValidator inputValidator, Tokenizer tokenizer, OutputService outputService) {
		this.inputService = inputService;
		this.inputValidator = inputValidator;
		this.tokenizer = tokenizer;
		this.outputService = outputService;
		setDefaultEvaluatorStrategy();
	}
	
	/**
	 * Sets the {@link EvaluatorStrategy} to {@link PostfixEvaluator}
	 */
	private void setDefaultEvaluatorStrategy() {
		setEvaluatorStrategy(new PostfixEvaluator());
	}
	
	/**
	 * Sets the {@link EvaluatorStrategy} to be used while expression evaluation.
	 * 
	 * @param evaluatorStrategy - instance of {@link EvaluatorStrategy}
	 * 
	 */
	public void setEvaluatorStrategy(EvaluatorStrategy evaluatorStrategy) {
		this.evaluatorStrategy = evaluatorStrategy;
	}

	/**
	 * The method {@code execute()} executes the various stages such as input, validation, tokenizing, evaluation 
	 * and output in serial order.
	 * 
	 */
	public void execute() {
		String response = "";
		try {
			String inputExpression = inputService.getInput();
			inputValidator.validate(inputExpression);
			List<String> tokens = tokenizer.tokenize(inputExpression);
			Float output = evaluatorStrategy.evaluate(tokens);
			response = output.toString();
		} catch (Exception e) {
			response = e.getMessage();
		} finally {
			displayOutput(response);
		}
	}
	
	/**
	 * Displays the output via {@link OutputService} instance configured.
	 * 
	 * @param response - response string
	 */
	private void displayOutput(String response) {
		try {
			outputService.displayOutput(response);
		} catch (OutputFailedException e) {
			String failureMessage = String.format("Output Failed : %s. Exception : %s", response, e.getMessage());
			System.out.println(failureMessage);
		}
	}

}
