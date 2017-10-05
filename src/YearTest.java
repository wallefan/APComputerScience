import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

public class YearTest {
	static GregorianCalendar g = new GregorianCalendar();

	@Parameters
	public static Collection<Object[]> data() {
		ArrayList<Object[]> result = new ArrayList<Object[]>();
		for (int i = 0; i <= 2000; i++) {
			result.add(new Object[] { i });
		}
		return result;
	}

	@Parameter
	int i;

	@Test
	public void test() {
		assertEquals(g.isLeapYear(i), new Year(i).isLeapYear());
	}

}
