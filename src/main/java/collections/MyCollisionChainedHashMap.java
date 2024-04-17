package collections;

import java.util.LinkedList;

public class MyCollisionChainedHashMap {
    // Set up base internal map/array
    // Set up variable to track the number of elements/pairs
    private LinkedList<Entry>[] map;
    private int count;

    public MyCollisionChainedHashMap(){
        map = new LinkedList[103];
        count = 0;
    }

    private int calcSlot(String key){
        int slot = Math.abs(key.hashCode());
        slot = slot % map.length;
        return slot;
    }
    
    public String remove(String key){
        int slot = calcSlot(key);
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
        int slot = calcSlot(key);
        if(map[slot] == null){
            return null;
        }
        if(map[slot].key.equals(key))
            return map[slot].value;
        else{
            return null;
        }
    }

    public String put(String key, String value){
        int slot = calcSlot(key);
        if(map[slot] == null){
            LinkedList<Entry> slotList = new LinkedList();
            map[slot] = slotList;
        }
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
