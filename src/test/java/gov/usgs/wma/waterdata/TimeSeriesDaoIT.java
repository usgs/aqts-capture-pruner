package gov.usgs.wma.waterdata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

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
	public void testPruneJanuaryPartition() {
		request.setDate(JANUARY_DATE);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneFebruary/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneFebruaryPartition() {
		request.setDate(FEBRUARY_DATE);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneMarch/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneMarchPartition() {
		request.setDate(MARCH_DATE);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneApril/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneAprilPartition() {
		request.setDate(APRIL_DATE);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneMay/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneMayPartition() {
		request.setDate(MAY_DATE);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneJune/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneJunePartition() {
		request.setDate(JUNE_DATE);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneJuly/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneJulyPartition() {
		request.setDate(JULY_DATE);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneAugust/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)

	public void testPruneAugustPartition() {
		request.setDate(AUGUST_DATE);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneSeptember/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneSeptemberPartition() {
		request.setDate(SEPTEMBER_DATE);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneOctober/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneOctoberPartition() {
		request.setDate(OCTOBER_DATE);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneNovember/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneNovemberPartition() {
		request.setDate(NOVEMBER_DATE);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneDecember/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneDecemberPartition() {
		request.setDate(DECEMBER_DATE);
		tsDao.pruneTimeSeries(request.getDate());
	}
}
