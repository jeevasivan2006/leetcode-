class Solution {
    public String largestNumber(int[] nums) {
        //convert each integer to String
        String[] str = new String[nums.length];
        for(int i=0; i < nums.length; i++){
            str[i] = Integer.toString(nums[i]);
        }

        //sort strings based on concatenated values
        Arrays.sort(str, (a,b) -> (b+a).compareTo(a+b));

        //handle cases where largest no is 0
        if(str[0].equals("0")){
            return "0";
        }

        //concatenate sorted string to form largest no
        StringBuilder sb= new StringBuilder();
        for(String strNum: str){
            sb.append(strNum);
        }
        return sb.toString();//to convert string[] to string
    }
}