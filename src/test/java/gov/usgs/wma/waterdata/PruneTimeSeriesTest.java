package gov.usgs.wma.waterdata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static gov.usgs.wma.waterdata.BaseTestDao.JANUARY_UTC;
import static gov.usgs.wma.waterdata.PruneTimeSeries.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class PruneTimeSeriesTest {

	@MockBean
	private TimeSeriesDao tsDao;
	private PruneTimeSeries pruneTs;
	private RequestObject request;

	@BeforeEach
	public void beforeEach() {
		pruneTs = new PruneTimeSeries(tsDao);
		request = new RequestObject();
	}

	@Test
	public void testFound() {
		request.setTime(JANUARY_UTC);
		when(tsDao.pruneTimeSeries(any(LocalDate.class))).thenReturn(Object.class);
		ResultObject result = pruneTs.apply(request);
		assertNotNull(result);
		assertEquals(SUCCESS_STATUS, result.getPruneStatus());
	}

	@Test
	public void testNullDate() {
		request.setTime(null);
		ResultObject result = pruneTs.processRequest(request);
		assertNotNull(result);
		assertEquals(FAIL_STATUS, result.getPruneStatus());
		assertEquals(FAIL_MESSAGE_NULL_DATE, result.getPruneFailMessage());
		assertThrows(RuntimeException.class, () -> pruneTs.apply(request), "should have thrown an exception but did not");
	}

	@Test
	public void testNoTimeProvided() {
		// explicitly not setting the time
		assertNull(request.getTime());
		ResultObject result = pruneTs.processRequest(request);
		assertNotNull(result);
		assertEquals(FAIL_STATUS, result.getPruneStatus());
		assertEquals(FAIL_MESSAGE_NULL_DATE, result.getPruneFailMessage());
		assertThrows(RuntimeException.class, () -> pruneTs.apply(request), "should have thrown an exception but did not");
	}
}
