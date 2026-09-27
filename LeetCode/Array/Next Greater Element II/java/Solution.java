class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int arr[]=new int[nums.length];
        int nrr[]=new int[nums.length];
        Arrays.fill(arr,-1);
        Arrays.fill(nrr,-1);
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                arr[stack.peek()]=nums[i];
                stack.pop();
            }
            stack.push(i);
        }
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                arr[stack.peek()]=nums[i];
                stack.pop();
            }
            stack.push(i);
        }
        return arr;
    }
}