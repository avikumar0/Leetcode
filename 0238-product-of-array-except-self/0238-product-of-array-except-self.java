class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l_mult=1;
        int r_mult=1;
        int n=nums.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=l_mult;
            l_mult*=nums[i];
        }

        for(int j=n-1;j>=0;j--){
            res[j]*=r_mult;
            r_mult*=nums[j];
        }

        return res;

    }
}