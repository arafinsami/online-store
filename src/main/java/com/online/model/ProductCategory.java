package com.online.model;

public enum ProductCategory {
	HARDWARE("Hardware"), SOFTWARE("Software");

	private String label;

	ProductCategory(String label) {
		this.label = label;
	}

	public String getlabel() {
		return label;
	}
}
