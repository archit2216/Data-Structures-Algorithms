class TimeMap {
    HashMap<Integer,HashMap<String,String>> values;
    HashMap<String,ArrayList<Integer>> keyTimes;
    public TimeMap() {
        values=new HashMap<>();
        keyTimes=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(values.containsKey(timestamp)){
            HashMap<String,String> hm=values.get(timestamp);
            hm.put(key,value);
            values.put(timestamp,hm);
        }else{
            HashMap<String,String> hm=new HashMap<>();
            hm.put(key,value);
            values.put(timestamp,hm);
        }
        
        if(keyTimes.containsKey(key)){
            ArrayList<Integer> al=keyTimes.get(key);
            al.add(timestamp);
            keyTimes.put(key,al);
        }else{
            ArrayList<Integer> al=new ArrayList<>();
            al.add(timestamp);
            keyTimes.put(key,al);
        }
    }
    
    public String get(String key, int timestamp) {
        if(keyTimes.containsKey(key)){
            if(values.containsKey(timestamp)){
                return values.get(timestamp).get(key);
            }
            
            ArrayList<Integer> al=keyTimes.get(key);
            int last=-1;
            int beg=0;
            int end=al.size()-1;
            while(beg<=end){
                int mid=(beg+end)/2;
                if(al.get(mid)==timestamp){
                    return values.get(mid).get(key);
                }
                if(al.get(mid)<timestamp){
                    last=al.get(mid);
                    beg=mid+1;
                }else{
                    end=mid-1;
                }
            }
            
            if(last!=-1 && values.containsKey(last)){
                return values.get(last).get(key);
            }else{
                return "";
            }
        }else{
            return "";
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */