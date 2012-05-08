package com.wp.carlos4web.utils.debug;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * Classe utilitária para fazer a formatação do debug
 * dos atributos de uma classe qualquer.
 * 
 * @author Carlos A. Junior
 */
public class StringHelper {
	
	public static StringBuilder reflectObject(Object object){
		
		StringBuilder builder = new StringBuilder();
		
		if(object == null){
			builder.append("O objeto informado está nulo.");
			
			return builder;
		}
		
		List<Field> fields = Arrays.asList(object.getClass().getDeclaredFields());
		
		int fator = 0;
		for (Field field : fields) {
			
			if(field.getName().length() > fator){
				fator = field.getName().length();
			}
		}
		
		for (Field field : fields)
		{
			field.setAccessible(true);

			String clazz = formatClassName(field.getName(), fator);

			try {
				builder.append(clazz + " = " + field.get(object) + "\n");
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		return builder;
	}
	
	/**
	 * Aplica o fator para determinar o número de espaços necessários
	 * para fechar o colchete no mesmo ponto.
	 * 
	 * @param field
	 * 
	 * @param max
	 * 
	 * @return
	 */
	private static String formatClassName(String field, int max){
		
		int rest = (max - field.length());
		
		if(rest > 0)
			field = field + String.format("%" + rest + "s", " ");
		
			
		return ("[" + field + "]");
	}
}
