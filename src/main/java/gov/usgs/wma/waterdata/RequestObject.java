package gov.usgs.wma.waterdata;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class RequestObject {
	// default cloudwatch event rule sends a json property called "time"
//	private String time;
//
//	public String getTime() {
//		return time;
//	}
//	public void setTime(String date) {
//		this.time = date;
//	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate time;

	public LocalDate getTime() {
		return time;
	}
	public void setTime(LocalDate date) {
		this.time = date;
	}
}