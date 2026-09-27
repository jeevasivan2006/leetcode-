class Solution {
    public static void transpose(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }}
        public static void reverse(int arr[]){
            int left=0;
            int right=arr.length-1;
            while(left<right){
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;
            }
        }

    
    public void rotate(int[][] matrix) {
        transpose(matrix);
        for(int arr[]:matrix){
            reverse(arr);
        }
    }
}