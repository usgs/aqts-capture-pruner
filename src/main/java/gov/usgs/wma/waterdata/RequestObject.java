package gov.usgs.wma.waterdata;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class RequestObject {
	// default cloudwatch event rule sends a json property called "time"
	// in utc format "2020-01-01T18:44:49Z"
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate time;

	public LocalDate getTime() {
		return time;
	}
	public void setTime(LocalDate time) {
		this.time = time;
	}
}