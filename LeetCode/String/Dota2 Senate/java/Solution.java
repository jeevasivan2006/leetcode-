class Solution {
    public String predictPartyVictory(String s) {
        Queue<Integer> r=new LinkedList<>();
        Queue<Integer> d=new LinkedList<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='R') r.offer(i);
            else d.offer(i);
        }
        while(!r.isEmpty()&&!d.isEmpty()){
            int ri=r.poll();
            int di=d.poll();
            if(ri<di){
                r.offer(ri+n);
            }
            else d.offer(di+n);
        }
        if(r.isEmpty()) return "Dire";
        else return "Radiant";
    }
}