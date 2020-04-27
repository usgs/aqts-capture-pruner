package gov.usgs.wma.waterdata;

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

@ExpectedDatabase(value="classpath:/testData/jsonData/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
@ExpectedDatabase(value="classpath:/testData/timeSeriesApprovals/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
@ExpectedDatabase(value="classpath:/testData/timeSeriesGapTolerances/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
@ExpectedDatabase(value="classpath:/testData/timeSeriesGrades/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
@ExpectedDatabase(value="classpath:/testData/timeSeriesHeaderInfo/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
@ExpectedDatabase(value="classpath:/testData/timeSeriesInterpolationTypes/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
@ExpectedDatabase(value="classpath:/testData/timeSeriesMethods/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
@ExpectedDatabase(value="classpath:/testData/timeSeriesQualifiers/", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)

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
public abstract class BaseTestDao {

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
}
