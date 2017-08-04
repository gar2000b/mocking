package mocking;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.LinkedList;

import org.junit.Test;
import org.mockito.ArgumentMatcher;

public class ArgumentMatchers {

	@Test
	public void simpleAnyIntArgMatcherTest() {
		LinkedList<String> mockedList = mock(LinkedList.class);

		when(mockedList.get(anyInt())).thenReturn("element");

		assertEquals("element", mockedList.get(999));
	}

	@Test
	public void simpleArgThatMatchesTest() {
		LinkedList<String> mockedList = mock(LinkedList.class);

		ArgumentMatcher<String> am = new ArgumentMatcher<String>() {
			@Override
			public boolean matches(String argument) {
				if (argument != null && !argument.isEmpty())
					return true;
				return false;
			}
		};

		when(mockedList.contains(argThat(am))).thenReturn(true);

		assertEquals(true, mockedList.contains("some value"));
	}
	
	@Test
	public void simpleArgThatDoesntMatchTest() {
		LinkedList<String> mockedList = mock(LinkedList.class);

		ArgumentMatcher<String> am = new ArgumentMatcher<String>() {
			@Override
			public boolean matches(String argument) {
				if (argument != null && !argument.isEmpty())
					return true;
				return false;
			}
		};

		when(mockedList.contains(argThat(am))).thenReturn(true);
		assertEquals(false, mockedList.contains(""));
	}
}
