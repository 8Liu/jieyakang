package com.liudehuang.jieyakang.utils;

import org.springframework.beans.BeanUtils;

public class MeiteBeanUtils<T, S> {

	/**
	 *
	 * 
	 * @param voEntity
	 * @param dtoClass
	 * @return
	 */
	public static <T> T t2s(Object voEntity, Class<T> dtoClass) {
		// 判断VoSF是否为空!
		if (voEntity == null) {
			return null;
		}
		// 判断DtoClass 是否为空
		if (dtoClass == null) {
			return null;
		}
		try {
			T newInstance = dtoClass.newInstance();
			BeanUtils.copyProperties(voEntity, newInstance);
			// Dto转换Do
			return newInstance;
		} catch (Exception e) {
			return null;
		}
	}


}