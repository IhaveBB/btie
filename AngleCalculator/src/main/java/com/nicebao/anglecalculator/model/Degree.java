package com.nicebao.anglecalculator.model;

import lombok.Data;

import java.util.Objects;

@Data
public class Degree {
	private int degree; // 度
	private int minute; // 分
	private double second; // 秒

	public Degree(String degreeStr) {
		String[] parts = degreeStr.split("/");
		this.degree = Integer.parseInt(parts[0]);
		this.minute = Integer.parseInt(parts[1]);
		this.second = Double.parseDouble(parts[2]);
	}
	public Degree(int degree,int minute,double second) {
		this.degree = degree;
		this.minute = minute;
		this.second = second;

	}



}