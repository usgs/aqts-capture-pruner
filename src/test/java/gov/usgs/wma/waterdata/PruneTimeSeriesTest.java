package gov.usgs.wma.waterdata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static gov.usgs.wma.waterdata.PruneTimeSeries.SUCCESS_STATUS;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.NONE)
public class PruneTimeSeriesTest {

	@MockBean
	private TimeSeriesDao tsDao;
	private PruneTimeSeries pruneTs;
	private RequestObject request;

	@BeforeEach
	public void beforeEach() {
		pruneTs = new PruneTimeSeries(tsDao);
		request = new RequestObject();
		request.setDate("2020-01-01 10:10:10");
	}

//	@Test
//	public void testNotFound() {
//		when(tsDao.pruneTimeSeries(anyString()).thenReturn(result.set));
//		ResultObject result = pruneTs.apply(request);
//		assertNotNull(result);
//		assertEquals(SUCCESS_STATUS, result.getPruneStatus());
//	}

//	@Test
//	public void testFoundGeneric() {
//		List<TimeSeries> expectedTimeSeriesList = Arrays.asList(
//				new TimeSeries("uniqueId"),
//				new TimeSeries("anotherUniqueId"));
//		when(tsDao.pruneTimeSeries(anyLong())).thenReturn(expectedTimeSeriesList);
//		ResultObject result = pruneTs.apply(request);
//		assertNotNull(result);
//		assertEquals(result.getTimeSeriesList(), expectedTimeSeriesList);
//	}
}
