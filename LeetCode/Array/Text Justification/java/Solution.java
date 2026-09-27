class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list=new ArrayList<>();
        int tc=0,wc=0,start=0;
        for(int i=0;i<words.length;i++){
            tc+=words[i].length();
            wc++;
            if(tc+wc-1>maxWidth){
                i--;
                text(words,maxWidth,list,start,i,false);
                start=i+1;
                tc=0;wc=0;
            }
        }
        text(words,maxWidth,list,start,words.length-1,true);
        return list;
    }
    public static void text(String words[],int maxWidth,List<String>list,int start,int end,boolean lastLine){
        if(lastLine || start==end){
            StringBuilder ss=new StringBuilder();
            for(int i=start;i<=end;i++){
                ss.append(words[i]);
                if(i!=end)ss.append(" ");
            }
            while(ss.length()<maxWidth){
                ss.append(" ");
            }
            list.add(ss.toString());
            return;
        }
        List<StringBuilder> temp=new ArrayList<>();
        int tc=0;
        for(int i=start;i<=end;i++){
            temp.add(new StringBuilder(words[i]));
            tc+=words[i].length();
        }
        int remainingSpace=maxWidth-tc;
        int ind=0;
        while(remainingSpace>0){
            temp.get(ind).append(" ");
            ind++;
            remainingSpace--;
            if(ind==temp.size()-1) ind=0;
        }
        StringBuilder sb=new StringBuilder();
        for(StringBuilder word: temp)sb.append(word);
        list.add(sb.toString());
    }
}