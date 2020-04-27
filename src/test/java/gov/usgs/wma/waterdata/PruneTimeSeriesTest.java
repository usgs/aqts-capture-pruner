package gov.usgs.wma.waterdata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static gov.usgs.wma.waterdata.PruneTimeSeries.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

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

	@Test
	public void testFound() {
		when(tsDao.pruneTimeSeries(anyString())).thenReturn(Object.class);
		ResultObject result = pruneTs.apply(request);
		assertNotNull(result);
		assertEquals(SUCCESS_STATUS, result.getPruneStatus());
	}

	@Test
	public void testNullDate() {
		request.setDate(null);
		ResultObject result = pruneTs.processRequest(request);
		assertNotNull(result);
		assertEquals(FAIL_STATUS, result.getPruneStatus());
		assertEquals(FAIL_MESSAGE_NULL_DATE, result.getPruneFailMessage());
		assertThrows(RuntimeException.class, () -> {
			pruneTs.apply(request);
		}, "should have thrown an exception but did not");
	}
}
