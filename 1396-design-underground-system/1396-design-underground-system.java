class UndergroundSystem {
    public static class Pair{
        String SName;
        int time;
        Pair(String SName,int time){
            this.SName=SName;
            this.time=time;
        }
    }
    HashMap<String,long[]> sMap;
    HashMap<Integer,Pair> idMap;
    public UndergroundSystem() {
        idMap=new HashMap<>();
        sMap=new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        idMap.put(id,new Pair(stationName,t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair p=idMap.get(id);
        
        idMap.remove(id);
        if(!sMap.containsKey(p.SName+" "+stationName)){
            sMap.put(p.SName+" "+stationName,new long[]{0,0});
        }
        long[] arr=sMap.get(p.SName+" "+stationName);
        arr[0]+=(t-p.time);
        arr[1]++;
        
    }
    
    public double getAverageTime(String startStation, String endStation) {
        long[] arr=sMap.get(startStation+" "+endStation);
        return (arr[0]*1.0)/(arr[1]*1.0);
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */