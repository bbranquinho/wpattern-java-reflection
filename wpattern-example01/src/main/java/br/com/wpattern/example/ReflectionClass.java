package br.com.wpattern.example;

import java.lang.reflect.Field;

import org.apache.log4j.Logger;

import br.com.wpattern.example.abstracts.Abstract03;
import br.com.wpattern.example.interfaces.INested;

public class ReflectionClass extends Abstract03 {

	private static final Logger logger = Logger.getLogger(ReflectionClass.class);

	private static final String FIELD_NAME = "nested";

	public void invokeNested() {

		try {
			Field fieldNested = getField(getClass(), FIELD_NAME);

			fieldNested.setAccessible(true);

			INested nestedField = (INested)fieldNested.get(this);

			nestedField.nestedMethod();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	private static Field getField(Class<?> classType, String fieldName) throws NoSuchFieldException {
		try {
			return classType.getDeclaredField(fieldName);
		} catch (NoSuchFieldException e) {
			Class<?> superClass = classType.getSuperclass();

			if (superClass == null) {
				throw e;
			} else {
				return getField(superClass, fieldName);
			}
		}
	}

}
