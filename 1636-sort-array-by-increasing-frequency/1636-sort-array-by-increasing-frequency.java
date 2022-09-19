class Solution {
    public int[] frequencySort(int[] arr) {
        HashMap<Integer,Integer> countMap=new HashMap<>();
        HashMap<Integer,Integer> indexMap=new HashMap<>();
        
        List<Integer> al=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            al.add(arr[i]);
        }
        for(int i=0;i<arr.length;i++){
            if(countMap.containsKey(arr[i])){
                int val=countMap.get(arr[i]);
                countMap.put(arr[i],val+1);
            }else{
                countMap.put(arr[i],1);
                indexMap.put(arr[i],i);
            }
        }
        
        Collections.sort(al,new Comparator<Integer>(){
            public int compare(Integer a,Integer b){
                int f1=countMap.get(a);
                int f2=countMap.get(b);
                if(f1!=f2){
                    return f1-f2;
                }
                return b-a;
            }
        });
        for(int i=0;i<al.size();i++){
            arr[i]=al.get(i);
        }
        return arr;
    }
}