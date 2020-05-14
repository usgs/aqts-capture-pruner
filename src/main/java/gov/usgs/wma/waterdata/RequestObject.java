package gov.usgs.wma.waterdata;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class RequestObject {
	// default cloudwatch event rule sends a json property called "time"
	// in utc format "2020-01-01T18:44:49Z"
	private String time;

	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	public LocalDate getDate() {
		return time == null ? null : LocalDate.ofInstant(Instant.parse(time), ZoneId.of(ZoneOffset.UTC.getId()));
	}
}