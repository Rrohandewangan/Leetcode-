

class TimeMap {
    HashMap<String, ArrayList<Pair<String, Integer>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
         String res = "";
         if(map.containsKey(key)) {
            List<Pair<String, Integer>> temp = map.get(key);
            // binary search 
            int st = 0, end = temp.size() - 1;
            while(st <= end) {
                int mid = st + (end - st)/ 2;
                if(temp.get(mid).getValue() <= timestamp) {
                    res = temp.get(mid).getKey();
                    st = mid + 1;
                } else {
                    end = mid - 1;
                }
            } 
         }
         return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */