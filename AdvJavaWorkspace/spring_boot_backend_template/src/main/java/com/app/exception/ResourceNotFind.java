package com.app.exception;


public class ResourceNotFind extends RuntimeException {
	public ResourceNotFind(String errMesg) {
		super(errMesg);
	}
}
