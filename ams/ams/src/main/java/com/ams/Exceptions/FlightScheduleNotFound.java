package com.ams.Exceptions;

public class FlightScheduleNotFound extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FlightScheduleNotFound(String str) {
		super(str);
	}

}