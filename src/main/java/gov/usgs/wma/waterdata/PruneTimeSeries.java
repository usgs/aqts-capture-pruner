package gov.usgs.wma.waterdata;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PruneTimeSeries implements Function<RequestObject, ResultObject> {

	private static final Logger LOG = LoggerFactory.getLogger(PruneTimeSeries.class);
	public static final String FAIL_STATUS = "failed";
	public static final String SUCCESS_STATUS = "success";
	public static final String FAIL_MESSAGE_NULL_DATE = "date was null";
	public static final String SUCCESS_MESSAGE = "Successfully pruned time series data";

	private final TimeSeriesDao tsDao;

	@Autowired
	public PruneTimeSeries(TimeSeriesDao tsDao) {
		this.tsDao = tsDao;
	}

	@Override
	public  ResultObject apply(RequestObject request) {
		ResultObject result = processRequest(request);
		if (FAIL_STATUS.equals(result.getPruneStatus())) {
			throw new RuntimeException(result.getPruneFailMessage());
		} else {
			return result;
		}
	}

	protected ResultObject processRequest(RequestObject request) {

		String date = request.getTime();
		ResultObject result = new ResultObject();

		if (null != date) {
			tsDao.pruneTimeSeries(date);
			result.setPruneStatus(SUCCESS_STATUS);
			LOG.debug(SUCCESS_MESSAGE);
		} else {
			LOG.debug(FAIL_MESSAGE_NULL_DATE);
			result.setPruneStatus(FAIL_STATUS);
			result.setPruneFailMessage(FAIL_MESSAGE_NULL_DATE);
		}
		return result;
	}
}
