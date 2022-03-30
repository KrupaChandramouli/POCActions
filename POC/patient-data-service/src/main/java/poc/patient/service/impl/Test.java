package poc.patient.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class Test {
	public static void main(String[] args) {
		LocalDateTime start = LocalDateTime.now();
		ZonedDateTime startZone = start.atZone(ZoneOffset.of("+05:30"));
		startZone.toInstant();
		System.out.println(" from time : " + startZone.minusSeconds(5).toInstant().toEpochMilli());
		System.out.println(" to time   : " + startZone.toInstant().toEpochMilli());
	}
}
