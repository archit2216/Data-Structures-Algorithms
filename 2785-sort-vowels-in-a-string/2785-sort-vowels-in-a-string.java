class Solution {
    public String sortVowels(String s) {
        ArrayList<Character> al=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='a'|| ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
                al.add(ch);
            }
        }
        
        Collections.sort(al);
        
        StringBuilder sb=new StringBuilder();
        int x=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='a'|| ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
                sb.append(al.get(x));
                x++;
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}