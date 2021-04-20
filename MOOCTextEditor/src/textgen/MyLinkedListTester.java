/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++) {
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet() {
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i < LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove() {
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		int b = list1.remove(1);
		assertEquals("Remove: check a is correct ", 42, b);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 1, list1.size());

		try {
			int c = list1.remove(-1);
			fail("Check out of bounds");
		} catch(IndexOutOfBoundsException e) {

		}

		try {
			int d = list1.remove(2);
			fail("Check out of bounds");
		} catch(IndexOutOfBoundsException e) {

		}
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd() {
        // TODO: implement this test
		String element = null;
		try {
			shortList.add(element);
			fail("Check out when adding a null element");
		} catch (NullPointerException e) {

		}
		boolean add = shortList.add("C");
		assertTrue("testAddEnd: check add is correct ", add);
		int size = shortList.size;
		assertEquals("testAddEnd: check size ", 3, size);
		String elem = shortList.get(2);
		assertEquals("testAddEnd: check elem added", "C", elem);

	}

	
	/** Test the size of the list */
	@Test
	public void testSize() {
		// TODO: implement this test
		assertEquals("testSize: test an empty list",0,emptyList.size);
		assertEquals("testSize: test a list with elements",2,shortList.size);
		shortList.add("C");
		assertEquals("testSize: adding an element to a list with elements",3,shortList.size);
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex() {
        // TODO: implement this test
		try {
			longerList.add(-1, 15);
			fail("Check out of bounds");
		} catch(IndexOutOfBoundsException e) {

		}

		try {
			longerList.add(15, 15);
			fail("Check out of bounds");
		} catch(IndexOutOfBoundsException e) {

		}

		longerList.add(0, 15);
		Integer a = longerList.get(0);
		assertEquals("", 15, a.intValue());
		Integer b = longerList.get(1);
		assertEquals("", 0, b.intValue());

		longerList.add(1, 30);
		Integer c = longerList.get(1);
		assertEquals("", 30, c.intValue());
		Integer d = longerList.get(2);
		assertEquals("", 0, d.intValue());
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet() {
	    // TODO: implement this test
		try {
			// test in an empty list
			Integer d = emptyList.set(0,5);
			fail("Check out of bounds");
		} catch(IndexOutOfBoundsException e) {

		}
		try {
			// check bounds in a list with elements
			String a = shortList.set(-1,"Z");
			fail("Check out of bounds");
		} catch(IndexOutOfBoundsException e) {

		}

		try {
			// check bounds in a list with elements
			String a = shortList.set(7,"Z");
			fail("Check out of bounds");
		} catch(IndexOutOfBoundsException e) {

		}

		String a = shortList.set(0,"Z");
		assertEquals("testSet: if it's working correctly","A",a);
		assertEquals("testSet: if it's working correctly","Z",shortList.get(0));
	}
	
	
	// TODO: Optionally add more test methods.
	
}
