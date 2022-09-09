class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i=0;
        int j=0;
        while(i<name.length() && j<typed.length()){
            if(name.charAt(i)!=typed.charAt(j)){
                return false;
            }
            while(i<name.length() && j<typed.length() && name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }
            while(i>0 && j<typed.length() && name.charAt(i-1)==typed.charAt(j)){
                j++;
            }
        }
        if(i<name.length() || j<typed.length()){
            return false;
        }
        return true;
    }
}