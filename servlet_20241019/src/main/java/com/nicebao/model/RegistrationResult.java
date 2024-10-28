package com.nicebao.model;

import lombok.Data;

/**
 * @name: RegistrationResult
 * @author: IhaveBB
 * @date: 2024-10-20 12:25
 **/
@Data
public class RegistrationResult {
	private boolean success;
	private String errorMessage;

	public RegistrationResult(boolean success, String errorMessage) {
		this.success = success;
		this.errorMessage = errorMessage;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
