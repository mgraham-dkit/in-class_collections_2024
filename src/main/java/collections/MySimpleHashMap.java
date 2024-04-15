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

    public String get(String key){
        int slot = calcSlot(key);
        if(map[slot] == null){
            return null;
        }
        // todo: Add check to confirm the key found in the slot matches the key supplied
        return map[slot].value;
    }

    public String put(String key, String value){
        int slot = calcSlot(key);
        if(map[slot] == null){
            Entry newEntry = new Entry(key, value);
            map[slot] = newEntry;
            count++;
            // todo: Decide on return policy for successful vs occupied slot!
        }else if(map[slot].key.equals(key)){
            String oldValue = map[slot].value;
            map[slot].value = value;
            return oldValue;
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
