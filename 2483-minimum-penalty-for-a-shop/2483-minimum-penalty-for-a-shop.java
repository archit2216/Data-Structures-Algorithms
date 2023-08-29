class Solution {
    public int bestClosingTime(String customers) {
        int[] arr=new int[customers.length()+1];
        
        int cno=0;
        for(int i=0;i<customers.length();i++){
            char ch=customers.charAt(i);
            if(ch=='N'){
                cno++;
            }
        }
        int min=Integer.MAX_VALUE;
        int minNum=0;
        int cyes=0;
        for(int i=customers.length();i>0;i--){
            char ch=customers.charAt(i-1);
            if(ch=='Y'){
                arr[i]=cyes+cno;
                cyes++;
            }else{
                arr[i]=cyes+cno;
                cno--;
            }
            if(min>=arr[i]){
                min=arr[i];
                minNum=i;
            }
        }
        arr[0]=cyes+cno;
        if(min>=arr[0]){
            min=arr[0];
            minNum=0;
        }
        return minNum;
        
    }
}