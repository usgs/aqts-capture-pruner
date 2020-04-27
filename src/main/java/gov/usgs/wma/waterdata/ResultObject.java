package gov.usgs.wma.waterdata;

public class ResultObject {
	private String pruneStatus;
	private String pruneFailMessage;

	public String getPruneStatus() {
		return pruneStatus;
	}

	public void setPruneStatus(String pruneStatus) {
		this.pruneStatus = pruneStatus;
	}

	public String getPruneFailMessage() {
		return pruneFailMessage;
	}

	public void setPruneFailMessage(String pruneFailMessage) {
		this.pruneFailMessage = pruneFailMessage;
	}
}