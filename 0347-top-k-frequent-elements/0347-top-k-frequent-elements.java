class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        ArrayList<Integer> al=new ArrayList<>();
        
        HashMap<Integer,Integer> countMap=new HashMap<>();
        HashMap<Integer,Integer> indexMap=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            al.add(nums[i]);
            if(countMap.containsKey(nums[i])){
                int count=countMap.get(nums[i]);
                countMap.put(nums[i],count+1);
            }else{
                countMap.put(nums[i],1);
                indexMap.put(nums[i],i);
            }
        }
        
        Collections.sort(al,new Comparator<Integer>(){
            public int compare(Integer a,Integer b){
                int f1=countMap.get(a);
                int f2=countMap.get(b);
                if(f1!=f2){
                    return f2-f1;
                }else{
                    return b-a;
                }
            }
        });
        int[] arr=new int[k];
        arr[0]=al.get(0);
        int x=1;
        for(int i=1;i<nums.length;i++){
            if(x<k && arr[x-1]!=al.get(i)){
                arr[x]=al.get(i);
                x++;
            }
        }
        return arr;
        
    }
}