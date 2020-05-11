package gov.usgs.wma.waterdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;

@Component
public class TimeSeriesDao {

	private static final Logger LOG = LoggerFactory.getLogger(TimeSeriesDao.class);

	private static final String PRUNE_TIME_SERIES_DATA_FUNCTION_NAME = "prune_time_series_data";

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Value("${AQTS_SCHEMA_NAME}")
	private String aqtsSchemaName;

	@Value("${MONTHS_TO_KEEP}")
	private int monthsToKeep;

	public Object pruneTimeSeries(LocalDate date) {
		Object result = null;
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
					.withFunctionName(PRUNE_TIME_SERIES_DATA_FUNCTION_NAME)
					.withSchemaName(aqtsSchemaName);
//			SqlParameterSource in = new MapSqlParameterSource().addValue("prunedate", processDate(date));
			SqlParameterSource in = new MapSqlParameterSource().addValue("prunedate", processDate(date));
			result =  simpleJdbcCall.executeFunction(String.class, in);
		} catch (Exception e) {
			// TODO for now, just throw whatever exception we encounter, harden when we have a better idea
			LOG.info(e.getLocalizedMessage());
			throw new RuntimeException(e);
		}
		return result;
	}

	public LocalDate processDate(LocalDate date) {
		return date.minusMonths(monthsToKeep);
	}
}
