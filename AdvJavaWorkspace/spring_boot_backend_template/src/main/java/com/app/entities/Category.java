package com.app.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category extends BaseEntity {
	@Column(length = 40 , unique = true)
	private String type;
	private String description;
}
