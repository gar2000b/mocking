package mocking;

import java.util.List;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class VerifyTest {

	@Test
	public void simpleVerifyTest() {
		List mockedList = mock(List.class);
		
		mockedList.add("one");
		mockedList.clear();
		
		verify(mockedList).add("one");
		verify(mockedList).clear();
	}
	
	@Test(expected = org.mockito.exceptions.verification.junit.ArgumentsAreDifferent.class)
	public void simpleVerifyThrowsExceptionTest() {
		List mockedList = mock(List.class);
		
		mockedList.add("one");
		mockedList.clear();
		
		verify(mockedList).add("two");
		verify(mockedList).clear();
	}
}
