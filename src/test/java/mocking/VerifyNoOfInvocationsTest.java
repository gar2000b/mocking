package mocking;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.LinkedList;

import org.junit.Test;

public class VerifyNoOfInvocationsTest {

	@Test
	public void noOfInvocationsTest() {
		LinkedList<String> mockedList = mock(LinkedList.class);

		mockedList.add("once");

		mockedList.add("twice");
		mockedList.add("twice");

		mockedList.add("three times");
		mockedList.add("three times");
		mockedList.add("three times");

		verify(mockedList).add("once");
		verify(mockedList, times(1)).add("once");

		verify(mockedList, times(2)).add("twice");
		verify(mockedList, times(3)).add("three times");

		verify(mockedList, never()).add("never happened");

		verify(mockedList, atLeastOnce()).add("three times");
		verify(mockedList, atLeast(2)).add("three times");
		verify(mockedList, atMost(5)).add("three times");
	}

}
