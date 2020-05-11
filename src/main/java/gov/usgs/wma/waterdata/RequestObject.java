package gov.usgs.wma.waterdata;

public class RequestObject {
	// default cloudwatch event rule sends a json property called "time"
	private String time;

	public String getTime() {
		return time;
	}
	public void setTime(String date) {
		this.time = date;
	}
}