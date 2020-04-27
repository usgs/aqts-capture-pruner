package gov.usgs.wma.waterdata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ActiveProfiles("it")
public class TimeSeriesDaoIT extends BaseTestDao {

	@Autowired
	private TimeSeriesDao tsDao;
	RequestObject request;

	@BeforeEach
	public void setup() {
		request = new RequestObject();
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneJanuary/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneJanuaryPartitionWithTimestamp() {
		request.setDate(JANUARY_TIMESTAMP);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneJanuary/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneJanuaryPartitionWithDate() {
		request.setDate(JANUARY_DATE);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneJanuary/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneJanuaryPartitionWithTimestampWithTimezone() {
		request.setDate(JANUARY_TIMESTAMP_TZ);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneFebruary/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneFebruaryPartition() {
		request.setDate(FEBRUARY_TIMESTAMP);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneMarch/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneMarchPartition() {
		request.setDate(MARCH_TIMESTAMP);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneApril/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneAprilPartition() {
		request.setDate(APRIL_TIMESTAMP);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneMay/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneMayPartition() {
		request.setDate(MAY_TIMESTAMP);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneJune/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneJunePartition() {
		request.setDate(JUNE_TIMESTAMP);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneJuly/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneJulyPartition() {
		request.setDate(JULY_TIMESTAMP);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneAugust/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)

	public void testPruneAugustPartition() {
		request.setDate(AUGUST_TIMESTAMP);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneSeptember/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneSeptemberPartition() {
		request.setDate(SEPTEMBER_TIMESTAMP);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneOctober/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneOctoberPartition() {
		request.setDate(OCTOBER_TIMESTAMP);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneNovember/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneNovemberPartition() {
		request.setDate(NOVEMBER_TIMESTAMP);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneDecember/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneDecemberPartition() {
		request.setDate(DECEMBER_TIMESTAMP);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	public void testInvalidDate() {
		request.setDate(INVALID_DATE);
		assertThrows(DataIntegrityViolationException.class, () -> {
			// Bad value for type timestamp/date/time: {1};
			tsDao.pruneTimeSeries(request.getDate());
		}, "should have thrown an exception but did not");
	}
}
