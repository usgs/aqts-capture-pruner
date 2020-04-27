package gov.usgs.wma.waterdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

import static gov.usgs.wma.waterdata.PruneTimeSeries.FAIL_STATUS;
import static gov.usgs.wma.waterdata.PruneTimeSeries.SUCCESS_STATUS;

@Component
public class TimeSeriesDao {

	private static final Logger LOG = LoggerFactory.getLogger(TimeSeriesDao.class);

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Value("classpath:sql/pruneTimeSeries.sql")
	protected Resource sqlQuery;

	public Object pruneTimeSeries(String date) {
		Object result = null;
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
					.withFunctionName("prune_time_series_data")
					.withSchemaName("schema_name");
			SqlParameterSource in = new MapSqlParameterSource().addValue("date", date);
			result =  simpleJdbcCall.executeFunction(String.class, in);
//			String sql = new String(FileCopyUtils.copyToByteArray(sqlQuery.getInputStream()));
//			result = jdbcCall.executeFunction(
//					sql,
////					"select ${AQTS_SCHEMA_NAME}.prune_time_series_data(TIMESTAMP ?)",
////					"select prune_time_series_data(?::timestamp)",
//					date
//					);
		} catch (EmptyResultDataAccessException e) {
			LOG.info(e.getLocalizedMessage());
		}
//		catch (IOException e) {
//			LOG.error("Unable to get SQL statement", e);
//			throw new RuntimeException(e);
//		}
		return result;
	}
}
