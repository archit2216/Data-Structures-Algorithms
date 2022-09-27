class Solution {
    public String pushDominoes(String dominoes) {
        char[] arr=new char[dominoes.length()];
        
        int i=0;
        char prevChar='0';
        int prevIdx=-1;
        boolean flag=false;
        
        char firstChar='1';
        int firstIdx=-1;
        char lastChar='1';
        int lastIdx=-1;
        while(i<dominoes.length()){
            char ch=dominoes.charAt(i);
            if(prevIdx!=-1 && ch!='.'){
                if(prevChar=='L'){
                    if(ch=='L'){
                        Arrays.fill(arr,prevIdx,i+1,'L');
                    }else{
                        Arrays.fill(arr,prevIdx,i+1,'.');
                        arr[prevIdx]=prevChar;
                        arr[i]=ch;
                    }
                }else{
                    if(ch=='L'){
                        Arrays.fill(arr,prevIdx,((i+prevIdx)/2)+1,'R');
                        Arrays.fill(arr,((i+prevIdx)/2)+1,i+1,'L');
                        if((i-prevIdx)%2==0){
                            arr[(i+prevIdx)/2]='.';
                        }
                    }else{
                        Arrays.fill(arr,prevIdx,i+1,'R');
                    }
                }
            }
            if(ch=='L' || ch=='R'){
                if(flag==false){
                    firstChar=ch;
                    firstIdx=i;
                    flag=true;
                }
                lastChar=ch;
                lastIdx=i;
                
                prevChar=ch;
                prevIdx=i;
            }
            i++;
        }
        if(firstIdx!=-1){
            if(firstChar=='L'){
                Arrays.fill(arr,0,firstIdx+1,'L');
            }else{
                if(firstIdx==0){
                    arr[0]='R';
                }else{
                    Arrays.fill(arr,0,firstIdx,'.');
                }
            }
        }
        
        if(lastChar!=-1){
            if(lastChar=='R'){
                Arrays.fill(arr,lastIdx,arr.length,'R');
            }else{
                if(lastIdx==arr.length-1){
                    arr[lastIdx]='L';
                }else{
                    Arrays.fill(arr,lastIdx+1,arr.length,'.');
                }
            }
        }
        return new String(arr);
    }
}