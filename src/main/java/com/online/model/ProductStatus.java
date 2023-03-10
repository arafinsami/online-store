package com.online.model;

public enum ProductStatus {
	ACTIVE("Active"), IN_ACTIVE("InActive");

	private String label;

	ProductStatus(String label) {
		this.label = label;
	}

	public String getlabel() {
		return label;
	}
}
