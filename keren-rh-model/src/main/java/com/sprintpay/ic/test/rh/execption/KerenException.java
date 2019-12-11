/**
 * 
 */
package com.sprintpay.ic.test.rh.execption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author SPRINT-PAY-NTW
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class KerenException extends RuntimeException {
	
	private String resourceName;
	private String fieldName;
	private Object fieldValue;

	public KerenException(String resourceName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getResourceName() {
		return resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}

}
