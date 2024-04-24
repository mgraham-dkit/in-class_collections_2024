package collections;

import java.util.LinkedList;

public class MyCollisionChainedHashMap {
    // Set up base internal map/array
    // Set up variable to track the number of elements/pairs
    private final LinkedList<Entry>[] map;
    private int count;

    public MyCollisionChainedHashMap(){
        map = new LinkedList[103];
        count = 0;
    }

    private int hashFunction(String key){
        int slot = Math.abs(key.hashCode());
        slot = slot % map.length;
        return slot;
    }
    
    public String remove(String key){
        int slot = hashFunction(key);
        if(map[slot] == null){
            return null;
        }
        if(!map[slot].key.equals(key)){
            return null;
        }
        
        String toBeDeleted = map[slot].value;
        // Set the stored value to null
        map[slot].value = null;
        // Return the copy of the stored value
        return toBeDeleted;
    }

    public String get(String key){
        // VALIDATION!!!
        if(key == null){
            throw new IllegalArgumentException("Null cannot be used as a key");
        }
        if(count == 0){
            return null;
        }

        int slot = hashFunction(key);
        if(map[slot] == null){
            return null;
        }
        for(Entry e: map[slot]) {
            if (e.key.equals(key))
                return e.value;
        }

        return null;
    }

    public String put(String key, String value){
        int slot = hashFunction(key);
        if(map[slot] == null){
            LinkedList<Entry> slotList = new LinkedList<Entry>();
            map[slot] = slotList;
        }

        for(Entry e: map[slot]){
            if(e.key.equals(key)){
                String oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        Entry newEntry = new Entry(key, value);
        map[slot].add(newEntry);
        count++;

        return null;
    }

    private static class Entry{
        protected String key;
        protected String value;

        public Entry(String key, String value){
            this.key = key;
            this.value = value;
        }
    }
}
