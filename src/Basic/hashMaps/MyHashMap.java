package hashMaps;

public class MyHashMap<k, v> {
    private class Entry<k, v>{
        private k key;
        private v value;
        private Entry<k, v> next;

        //constructor
        public Entry(k key, v value){
            this.key = key;
            this.value = value;
        }
        public k getKey() {
            return this.key;
        }

        public v getValue() {
            return this.value;
        }

        public void setValue(v value) {
            this.value = value;
        }
        @Override
        public String toString() {
            Entry<k,v> temp = this;
            StringBuilder sb = new StringBuilder();
            while (temp != null) {
                sb.append(temp.key + " -> " + temp.value + ",");
                temp = temp.next;
            }
            return sb.toString();
        }
    }
    private  final  int SIZE=5;
    private  Entry<k, v> table[];
    public MyHashMap(){
        table = new Entry[SIZE];
    }
    public  void put(k key, v value){
        int hash = key.hashCode() % SIZE;
        Entry<k , v> e = table[hash];
        if (e == null)
            table[hash] = new Entry<k, v>(key, value);
        else {
            while (e.next != null){
                if(e.getKey() == key){
                    e.setValue(value);
                    return;
                }
                e = e.next;
            }
            if(e.getKey() == key){
                e.setValue(value);
                return;
            }
            e.next = new Entry<k, v>(key, value);
        }
    }
    public  v get(k key){
        int hash = key.hashCode() % SIZE;
        Entry<k , v> e = table[hash];
        if (e == null){
            return null;
        }
        while (e.next!= null){
            if(e.getKey() == key){
                return e.getValue();
            }
            e = e.next;
        }
        return  null;
    }
    public Entry<k, v> remove(k key){
        int hash = key.hashCode() % SIZE;
        Entry<k , v> e = table[hash];

        if (e == null){
            return null;
        }
        if(e.getKey() == key){
            table[hash] = e.next;
            e.next = null;
            return e;
        }
        Entry<k , v> prev = e;
        e = e.next;
        while (e != null){
            if(e.getKey() == key){

                prev.next = e.next;
                e.next = null;
                return  e;
            }
            prev = e;
            e = e.next;
        }
        return  null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            if (table[i] != null) {
                sb.append(i + " " + table[i] + "\n");
            } else {
                sb.append(i + " " + "null" + "\n");
            }
        }

        return sb.toString();
    }

}
