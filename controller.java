package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class controller {

	@RequestMapping(method = RequestMethod.GET, value = "/sum")
	public String calculation(String number1, String number2, String operation) {

		int result;

		int n1 = Integer.parseInt(number1);
		int n2 = Integer.parseInt(number2);

		switch (operation) {

		case "PLUS":
			result = n1 + n2;
			System.out.println(n1 + " + " + n2 + " = " + result);
			return "<h2>" + n1 + " + " + n2 + " = " + result + "</h2>";

		case "MINUS":
			result = n1 - n2;
			System.out.println(n1 + " - " + n2 + " = " + result);
			return "<h2>" + n1 + " - " + n2 + " = " + result + "</h2>";

		case "TIMES":
			result = n1 * n2;
			System.out.println(n1 + " * " + n2 + " = " + result);
			return "<h2>" + n1 + " * " + n2 + " = " + result + "</h2>";

		case "DIVIDE":
			result = n1 / n2;
			System.out.println(n1 + " / " + n2 + " = " + result);
			return "<h2>" + n1 + " / " + n2 + " = " + result + "</h2>";

		default:
			System.out.println("Invalid operator!");
			return "<h2>Invalid operator!</h2>";
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/sum2")
	public String calculation2(String input) {

		System.out.println(input);
		
		String operators[] = input.split("[0-9]");
		String operands[] = input.split("[+-/*]");
		
		int sum = Integer.parseInt(operands[0]);
		
		for (int i = 1; i < operands.length; i++) {
			if (operators[i].equals("+"))
			{
				sum += Integer.parseInt(operands[i]);
			} else if (operators[i].equals("-"))
			{
				sum -= Integer.parseInt(operands[i]);
			} else if (operators[i].equals("*"))
			{
				sum *= Integer.parseInt(operands[i]);
			} else if (operators[i].equals("/"))
			{
				sum /= Integer.parseInt(operands[i]);
			}
		}
		
		System.out.println(sum);
		
		String result = Integer.toString(sum);
		return "<h2>" + input + " = " + result + "</h2>";
	}

}
