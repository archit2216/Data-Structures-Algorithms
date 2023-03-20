class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length==1){
            if(flowerbed[0]==1){
                if(n==0){
                    return true;
                }else{
                    return false;
                }
            }else{
                if(n<=1){
                    return true;
                }else{
                    return false;
                }
            }
        }
        boolean flag=true;
        double count=0;
        int x=0;
        while(x<flowerbed.length && flowerbed[x]!=1){
            count++;
                x++;
        }
        if(x==flowerbed.length){
            n-=Math.ceil(count/2);
            if(n<=0){
            return true;
        }
        }
        else if(count>=2){
            n-=Math.floor(count/2);
        }
        count=0;
        for(int i=x;i<flowerbed.length;i++){
            if(flowerbed[i]==0){
                count++;
            }else{
                if(count>=3){
                    if(count%2==0){
                        count--;
                    }
                    n-=Math.floor(count/2);
                }
                if(n<=0){
                    return true;
                }
                count=0;
            }
        }
        if(count>=2){
            n-=Math.floor(count/2);
        }
        if(n>0){
            return false;
        }
        return true;
    }
}