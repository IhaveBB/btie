package com.nicebao.anglecalculator.service;

import com.nicebao.anglecalculator.model.Degree;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DegreeService {
	public Degree add(Degree d1, Degree d2) {
		double totalSeconds = (d1.getDegree() * 3600 + d1.getMinute() * 60 + d1.getSecond())
				+ (d2.getDegree() * 3600 + d2.getMinute() * 60 + d2.getSecond());

		int totalDegrees = (int) Math.floor(totalSeconds / 3600);
		int totalMinutes = (int) Math.floor((totalSeconds % 3600) / 60);
		double totalSecondsRemainder = totalSeconds % 60;

		return new Degree(totalDegrees, totalMinutes, totalSecondsRemainder);
	}

	public Degree subtract(Degree d1, Degree d2) {
		double diffSeconds = (d1.getDegree() * 3600 + d1.getMinute() * 60 + d1.getSecond())
				- (d2.getDegree() * 3600 + d2.getMinute() * 60 + d2.getSecond());

		int totalDegrees = (int) Math.floor(diffSeconds / 3600);
		int totalMinutes = (int) Math.floor((diffSeconds % 3600) / 60);
		double totalSecondsRemainder = diffSeconds % 60;

		return new Degree(totalDegrees, totalMinutes, totalSecondsRemainder);
	}

	public Degree multiply(Degree d1, double num) {
		double totalSeconds = ((d1.getDegree() * 3600 + d1.getMinute() * 60 + d1.getSecond())
				* num);
		log.info("totalSeconds:"+totalSeconds);
		log.info("num:"+num);
		log.info("d/m/s:"+d1.getDegree()+"/"+d1.getMinute()+"/"+d1.getSecond());

		int totalDegrees = (int) Math.floor(totalSeconds / 3600);
		int totalMinutes = (int) Math.floor((totalSeconds % 3600) / 60);
		double totalSecondsRemainder = totalSeconds % 60;

		return new Degree(totalDegrees, totalMinutes, totalSecondsRemainder);
	}

	public Degree divide(Degree d1, double num) {
		double quotientSeconds = ((d1.getDegree() * 3600 + d1.getMinute() * 60 + d1.getSecond())
				/ num);

		int totalDegrees = (int) Math.floor(quotientSeconds / 3600);
		int totalMinutes = (int) Math.floor((quotientSeconds % 3600) / 60);
		double totalSecondsRemainder = quotientSeconds % 60;

		return new Degree(totalDegrees, totalMinutes, totalSecondsRemainder);
	}
}