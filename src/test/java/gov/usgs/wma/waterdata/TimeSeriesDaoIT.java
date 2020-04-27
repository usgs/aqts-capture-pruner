package gov.usgs.wma.waterdata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

@SpringBootTest(webEnvironment=WebEnvironment.NONE,
		classes={DBTestConfig.class, TimeSeriesDao.class, PruneTimeSeries.class})
@DatabaseSetup("classpath:/testData/jsonData/")
@DatabaseSetup("classpath:/testData/timeSeriesApprovals/")
@DatabaseSetup("classpath:/testData/timeSeriesGapTolerances/")
@DatabaseSetup("classpath:/testData/timeSeriesGrades/")
@DatabaseSetup("classpath:/testData/timeSeriesHeaderInfo/")
@DatabaseSetup("classpath:/testData/timeSeriesInterpolationTypes/")
@DatabaseSetup("classpath:/testData/timeSeriesMethods/")
@DatabaseSetup("classpath:/testData/timeSeriesQualifiers/")

@ActiveProfiles("it")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class,
		TransactionDbUnitTestExecutionListener.class })
@DbUnitConfiguration(dataSetLoader=FileSensingDataSetLoader.class)
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Transactional(propagation=Propagation.NOT_SUPPORTED)
@Import({DBTestConfig.class})
@DirtiesContext
public class TimeSeriesDaoIT {

	public static final String JANUARY_DATE = "2020-01-01 10:10:10";
	public static final String FEBRUARY_DATE = "2020-02-01 10:10:10";
	public static final String MARCH_DATE = "2020-03-01 10:10:10";
	public static final String APRIL_DATE = "2020-04-01 10:10:10";
	public static final String MAY_DATE = "2020-05-01 10:10:10";
	public static final String JUNE_DATE = "2020-06-01 10:10:10";
	public static final String JULY_DATE = "2020-07-01 10:10:10";
	public static final String AUGUST_DATE = "2020-08-01 10:10:10";
	public static final String SEPTEMBER_DATE = "2020-09-01 10:10:10";
	public static final String OCTOBER_DATE = "2020-10-01 10:10:10";
	public static final String NOVEMBER_DATE = "2020-11-01 10:10:10";
	public static final String DECEMBER_DATE = "2020-12-01 10:10:10";

	@Autowired
	private TimeSeriesDao tsDao;
	private RequestObject request = new RequestObject();

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneJanuary/jsonData/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneJanuary/timeSeriesApprovals/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneJanuary/timeSeriesGapTolerances/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneJanuary/timeSeriesGrades/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneJanuary/timeSeriesHeaderInfo/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneJanuary/timeSeriesInterpolationTypes/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneJanuary/timeSeriesMethods/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneJanuary/timeSeriesQualifiers/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneJanuaryPartition() {
		request.setDate(JANUARY_DATE);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneFebruary/jsonData/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneFebruary/timeSeriesApprovals/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneFebruary/timeSeriesGapTolerances/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneFebruary/timeSeriesGrades/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneFebruary/timeSeriesHeaderInfo/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneFebruary/timeSeriesInterpolationTypes/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneFebruary/timeSeriesMethods/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneFebruary/timeSeriesQualifiers/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneFebruaryPartition() {
		request.setDate(FEBRUARY_DATE);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneMarch/jsonData/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneMarch/timeSeriesApprovals/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneMarch/timeSeriesGapTolerances/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneMarch/timeSeriesGrades/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneMarch/timeSeriesHeaderInfo/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneMarch/timeSeriesInterpolationTypes/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneMarch/timeSeriesMethods/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneMarch/timeSeriesQualifiers/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneMarchPartition() {
		request.setDate(MARCH_DATE);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneApril/jsonData/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneApril/timeSeriesApprovals/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneApril/timeSeriesGapTolerances/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneApril/timeSeriesGrades/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneApril/timeSeriesHeaderInfo/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneApril/timeSeriesInterpolationTypes/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneApril/timeSeriesMethods/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneApril/timeSeriesQualifiers/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneAprilPartition() {
		request.setDate(APRIL_DATE);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneMay/jsonData/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneMay/timeSeriesApprovals/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneMay/timeSeriesGapTolerances/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneMay/timeSeriesGrades/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneMay/timeSeriesHeaderInfo/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneMay/timeSeriesInterpolationTypes/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneMay/timeSeriesMethods/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneMay/timeSeriesQualifiers/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneMayPartition() {
		request.setDate(MAY_DATE);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneJune/jsonData/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneJune/timeSeriesApprovals/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneJune/timeSeriesGapTolerances/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneJune/timeSeriesGrades/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneJune/timeSeriesHeaderInfo/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneJune/timeSeriesInterpolationTypes/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneJune/timeSeriesMethods/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneJune/timeSeriesQualifiers/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneJunePartition() {
		request.setDate(JUNE_DATE);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneJuly/jsonData/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneJuly/timeSeriesApprovals/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneJuly/timeSeriesGapTolerances/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneJuly/timeSeriesGrades/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneJuly/timeSeriesHeaderInfo/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneJuly/timeSeriesInterpolationTypes/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneJuly/timeSeriesMethods/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneJuly/timeSeriesQualifiers/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneJulyPartition() {
		request.setDate(JULY_DATE);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneAugust/jsonData/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneAugust/timeSeriesApprovals/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneAugust/timeSeriesGapTolerances/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneAugust/timeSeriesGrades/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneAugust/timeSeriesHeaderInfo/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneAugust/timeSeriesInterpolationTypes/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneAugust/timeSeriesMethods/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneAugust/timeSeriesQualifiers/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneAugustPartition() {
		request.setDate(AUGUST_DATE);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneSeptember/jsonData/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneSeptember/timeSeriesApprovals/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneSeptember/timeSeriesGapTolerances/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneSeptember/timeSeriesGrades/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneSeptember/timeSeriesHeaderInfo/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneSeptember/timeSeriesInterpolationTypes/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneSeptember/timeSeriesMethods/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneSeptember/timeSeriesQualifiers/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneSeptemberPartition() {
		request.setDate(SEPTEMBER_DATE);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneOctober/jsonData/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneOctober/timeSeriesApprovals/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneOctober/timeSeriesGapTolerances/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneOctober/timeSeriesGrades/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneOctober/timeSeriesHeaderInfo/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneOctober/timeSeriesInterpolationTypes/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneOctober/timeSeriesMethods/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneOctober/timeSeriesQualifiers/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneOctoberPartition() {
		request.setDate(OCTOBER_DATE);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneNovember/jsonData/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneNovember/timeSeriesApprovals/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneNovember/timeSeriesGapTolerances/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneNovember/timeSeriesGrades/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneNovember/timeSeriesHeaderInfo/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneNovember/timeSeriesInterpolationTypes/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneNovember/timeSeriesMethods/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneNovember/timeSeriesQualifiers/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneNovemberPartition() {
		request.setDate(NOVEMBER_DATE);
		tsDao.pruneTimeSeries(request.getDate());
	}

	@Test
	@ExpectedDatabase(value="classpath:/testResult/pruneDecember/jsonData/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneDecember/timeSeriesApprovals/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneDecember/timeSeriesGapTolerances/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneDecember/timeSeriesGrades/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneDecember/timeSeriesHeaderInfo/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneDecember/timeSeriesInterpolationTypes/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneDecember/timeSeriesMethods/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	@ExpectedDatabase(value="classpath:/testResult/pruneDecember/timeSeriesQualifiers/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void testPruneDecemberPartition() {
		request.setDate(DECEMBER_DATE);
		tsDao.pruneTimeSeries(request.getDate());
	}
}
