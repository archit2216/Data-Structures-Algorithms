class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
        {
            return false;
        }
        int copy=x;
        int d=x;
        int count=0;
        while(d>0)
        {
            d=d/10;
            count++;
        }
        count--;
        int num=0;
        while(x>0)
        {
            int r=x%10;
            int mul=(int)Math.pow(10,count);
            num=num+(r*mul);
            count--;
            x=x/10;
        }
        if(num==copy)
        {
            return true;
        }
        return false;
    }
}