package collections;

public class MySimpleHashMap {
    // Set up base internal map/array
    // Set up variable to track the number of elements/pairs
    private Entry[] map;
    private int count;

    public MySimpleHashMap(){
        map = new Entry[103];
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
            Entry newEntry = new Entry(key, value);
            map[slot] = newEntry;
            count++;
            return null;
        }else if(map[slot].key.equals(key)){
            String oldValue = map[slot].value;
            map[slot].value = value;
            return oldValue;
        }
        throw new SlotOccupiedException("Supplied key does not match key found in calculated slot");
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
