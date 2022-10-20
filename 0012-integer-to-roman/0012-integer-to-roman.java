class Solution {
    public String intToRoman(int num) {
        StringBuilder sb=new StringBuilder();
        while(num>0){
            if(num>=1000){
                sb.append("M");
                num-=1000;
            }else if(num>=900){
                sb.append("CM");
                num-=900;
            }else if(num>=400){
                if(num>=500){
                    sb.append("D");
                    num-=500;
                }else{
                    sb.append("CD");
                    num-=400;
                }
            }else if(num>=90){
                if(num>=100){
                    sb.append("C");
                    num-=100;
                }else{
                    sb.append("XC");
                    num-=90;
                }
            }else if(num>=40){
                if(num>=50){
                    sb.append("L");
                    num-=50;
                }else{
                    sb.append("XL");
                    num-=40;
                }
            }else if(num>=9){
                if(num>=10){
                    sb.append("X");
                    num-=10;
                }else{
                    sb.append("IX");
                    num-=9;
                }
            }else if(num>=4){
                if(num>=5){
                    sb.append("V");
                    num-=5;
                }else{
                    sb.append("IV");
                    num-=4;
                }
            }else{
                for(int i=0;i<num;i++){
                    sb.append("I");
                }
                num=0;
            }
        }
        return sb.toString();
    }
}