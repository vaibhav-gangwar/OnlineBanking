package com.banking.system.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class DefaultFloatConverter implements AttributeConverter<Float,Float> {
	
	@Override
	public Float convertToEntityAttribute(Float inputValue) {
		if (inputValue==null) {
			return (float) 0.0;
		}
		return inputValue;
	}
	
	@Override
	public Float convertToDatabaseColumn(Float inputValue) {
		if (inputValue==null) {
			return (float) 0.0;
		}
		return inputValue;
	}

}
