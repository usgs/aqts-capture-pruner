package gov.usgs.wma.waterdata;

import org.junit.jupiter.api.BeforeEach;
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

@SpringBootTest(webEnvironment=WebEnvironment.NONE,
		classes={DBTestConfig.class, TimeSeriesDao.class, PruneTimeSeries.class})

@DatabaseSetup("classpath:/testData/january.xml")
@DatabaseSetup("classpath:/testData/february.xml")
@DatabaseSetup("classpath:/testData/march.xml")
@DatabaseSetup("classpath:/testData/april.xml")
@DatabaseSetup("classpath:/testData/may.xml")
@DatabaseSetup("classpath:/testData/june.xml")
@DatabaseSetup("classpath:/testData/july.xml")
@DatabaseSetup("classpath:/testData/august.xml")
@DatabaseSetup("classpath:/testData/september.xml")
@DatabaseSetup("classpath:/testData/october.xml")
@DatabaseSetup("classpath:/testData/november.xml")
@DatabaseSetup("classpath:/testData/december.xml")

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

	// A few date formats
	public static final String JANUARY_UTC = "2020-01-01T18:44:49Z";

	// Test all other months
	public static final String FEBRUARY_UTC = "2020-02-01T10:10:10Z";
	public static final String MARCH_UTC = "2020-03-01T10:10:10Z";
	public static final String APRIL_UTC = "2020-04-01T10:10:10Z";
	public static final String MAY_UTC = "2020-05-01T10:10:10Z";
	public static final String JUNE_UTC = "2020-06-01T10:10:10Z";
	public static final String JULY_UTC = "2020-07-01T10:10:10Z";
	public static final String AUGUST_UTC = "2020-08-01T10:10:10Z";
	public static final String SEPTEMBER_UTC = "2020-09-01T10:10:10Z";
	public static final String OCTOBER_UTC = "2020-10-01T10:10:10Z";
	public static final String NOVEMBER_UTC = "2020-11-01T10:10:10Z";
	public static final String DECEMBER_UTC = "2020-12-01T10:10:10Z";

	// Bad input
	public static final String INVALID_DATE = "notADate";

	@Autowired
	protected TimeSeriesDao tsDao;
	RequestObject request;

	@BeforeEach
	public void setup() {
		request = new RequestObject();
	}
}
