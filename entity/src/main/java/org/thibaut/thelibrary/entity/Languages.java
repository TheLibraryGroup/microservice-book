package org.thibaut.thelibrary.entity;

import lombok.Getter;

@Getter
public enum Languages {
	FR("Français"),
	UK("Anglais"),
	ES("Espagnol"),
	IT("Italien");

	private final String value;

	private Languages( String value ) {
		this.value = value;
	}
}
