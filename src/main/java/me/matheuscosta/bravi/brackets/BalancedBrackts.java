package me.matheuscosta.bravi.brackets;

import java.util.Stack;

import org.springframework.util.StringUtils;

/**
 * 
 * @author matheusCosta
 *
 */
public class BalancedBrackts {
	
	public static void main(String[] args) {
		System.out.println("Para String \"(){()}{}\" = " + balanced("(){()}{}"));
		System.out.println("Para String \"{()\" = " + balanced("{()"));
		System.out.println("Para String \"A(8/){[0-9]/A-Z}\" = " + balanced("A(8/){[0-9]/A-Z}"));
		System.out.println("Para String \"(){)}{}\" = " + balanced("(){)}{}"));
		
	}

	/**
	 * Metodo que verifica se a expressao esta dentro do pradrao.
	 * Ao receber a String, cria um array de String cada caracter sera um indice.
	 * Percorre todo o array e mapea as aberturas do padrao.
	 * Se o caracter for um dos fechametos do padrao, valida se ele fecha a ultima abetura.
	 * Se nao fecha retorna um false, no final do processo verifica e retorna se a lista de aberturas esta vazia.
	 * @param expression
	 * @return
	 */
	private static boolean balanced(String expression) {
		Stack<String> stack = new Stack<>();
		String[] splitExpression = expression.split("");
		
		if(StringUtils.isEmpty(expression)) {
			return false;
		}
		
		for (int i = 0; i < splitExpression.length; i++) {
			String caracter = splitExpression[i];
			if(caracter.equals("(") || caracter.equals("{") || caracter.equals("[")) {
				stack.push(caracter);
				continue;
			}
			
			String lastCaracter = null;
			switch (caracter) {
			case ")":
				lastCaracter = (!stack.isEmpty() ? stack.pop() : null);
				if(StringUtils.isEmpty(lastCaracter) || lastCaracter.equals("{") || lastCaracter.equals("[")) {
					return false;
				}
				break;
			
			case "}":
				lastCaracter = (!stack.isEmpty() ? stack.pop() : null);
				if(StringUtils.isEmpty(lastCaracter) || lastCaracter.equals("(") || lastCaracter.equals("[")) {
					return false;
				}
				break;
				
			case "]":
				lastCaracter = (!stack.isEmpty() ? stack.pop() : null);
				if(StringUtils.isEmpty(lastCaracter) || lastCaracter.equals("{") || lastCaracter.equals("(")) {
					return false;
				}
				break;
			}
		}
		
		return stack.isEmpty();
	}
}
