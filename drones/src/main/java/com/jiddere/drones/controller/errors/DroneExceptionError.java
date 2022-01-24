package com.jiddere.drones.controller.errors;


public class DroneExceptionError extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DroneExceptionError(String message) {
		super(message);
	}

	public DroneExceptionError(String message, Throwable cause) {
		super(message, cause);
	}

}
