package com.bookStore.common.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ReflectUtil {

	public static Class<?> getSuperClassGenricType(Class<?> clazz) {
		return getSuperClassGenricType(clazz, 0);
	}

	public static Class<?> getSuperClassGenricType(Class<?> clazz, int index) {
		Type type = clazz.getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			Type[] typeClass = ((ParameterizedType) type).getActualTypeArguments();
			int length = typeClass.length;
			if (index < 0 || index > length - 1) {
				return null;
			}
			if (typeClass[index] instanceof Class) {
				return (Class<?>) typeClass[index];
			}
		}
		return null;
	}
}
