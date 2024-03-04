package collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    void remove_removingFromMiddle_PopulatedList() {
        // Set up list to remove from
        ArrayList<Integer> startingData = new ArrayList();
        for(int i = 0; i < 10; i++){
            startingData.add(i);
        }
        MyLinkedList list = new MyLinkedList();
        for(int i: startingData){
            list.add(i);
        }

        // Set expected results
        int expectedRemove = 5;

        // Test remove

        // Did the method return correctly?
        int removed = list.remove(5);
        assertEquals(expectedRemove, removed);

        // Did the value get deleted?
        int oldResult = 5;
        int currentValue = list.get(5);
        assertNotEquals(oldResult, currentValue);

        // Did the size change appropriately?
        assertEquals(startingData.size()-1, list.size());

        startingData.remove(5);
        for(int i = 0; i < startingData.size(); i++){
            assertEquals(startingData.get(i), list.get(i));
        }
        int lastElement = startingData.get(startingData.size()-1);
        int tailElement = list.tail();
        assertEquals(lastElement, tailElement);
    }
}