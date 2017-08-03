package mocking;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.LinkedList;

import org.junit.Test;

public class MockingTest {

	@Test
	public void simpleMockingTest() {
		LinkedList<String> mockedList = mock(LinkedList.class);

		// stubbing
		when(mockedList.get(0)).thenReturn("first");

		assertEquals("first", mockedList.get(0));
	}

	@Test(expected = RuntimeException.class)
	public void simpleMockingThrowsRuntimeExceptionTest() {
		LinkedList<String> mockedList = mock(LinkedList.class);
		when(mockedList.get(0)).thenThrow(new RuntimeException());
		mockedList.get(0);
	}
}
