class Solution {
    public String solution(String new_id) {
        StringBuilder str = new StringBuilder(new_id);
        
        //1단계
        for(int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            if((int)c>=65 && (int)c <=90) {
                str.setCharAt(i, (char)(c+32));
            }
        }
        //2단계
        for(int i=0;i<str.length();i++) {
            int c = (int)str.charAt(i);
            if(c>=97 && c<=122) continue;
            if(c==45 || c==95 || c==46) continue;
            if(c>=48 && c<=57) continue;
            str.deleteCharAt(i);
            i--;
        }
        
        //3단계
        int node=999;
        for(int i=0;i<str.length();i++) {
            int c = (int)str.charAt(i);
            if(c==46) {
                if(i-1==node) {
                    str.deleteCharAt(i);
                    i--;
                }
                node=i;
            }
        }
        
        //4단계
        if(str.length()>=1 && str.charAt(0)=='.') str.deleteCharAt(0);
        if(str.length()>=1 && str.charAt(str.length()-1)=='.') str.deleteCharAt(str.length()-1);
        
        //5단계
        if(str.length() == 0) str.append("a");
        
        //6단계
        if(str.length()>15) {
            str.delete(15,str.length());
        }
        if(str.length()>=1 && str.charAt(str.length()-1)=='.') str.deleteCharAt(str.length()-1);
        
        //7단계
        while (str.length() < 3) {
            str.append(str.charAt(str.length() - 1));
        }
        return str.toString();
    }
}