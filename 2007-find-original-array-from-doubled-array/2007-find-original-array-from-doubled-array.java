class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length%2!=0){
            return new int[0];
        }
        Arrays.sort(changed);
        HashMap<Integer,Integer> hm=new HashMap<>();
        
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=0;i<changed.length;i++){
            if(changed[i]%2==0 && hm.containsKey(changed[i]/2)){
                al.add(changed[i]/2);
                int val=hm.get(changed[i]/2);
                if(val==1){
                    hm.remove(changed[i]/2);
                }else{
                    hm.put(changed[i]/2,val-1);
                }
            }else if(hm.containsKey(changed[i])){
                int val=hm.get(changed[i]);
                hm.put(changed[i],val+1);
            }else{
                hm.put(changed[i],1);
            }
        }
        if(al.size()==changed.length/2){
            int[] arr=new int[al.size()];
            for(int i=0;i<al.size();i++){
                arr[i]=al.get(i);
            }
            return arr;
        }
        return new int[0];
    }
}