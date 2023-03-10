package com.online.model;

public enum ProductCondition {
	NEW("New"), USED("Used");

	private String label;

	ProductCondition(String label) {
		this.label = label;
	}

	public String getlabel() {
		return label;
	}
}
