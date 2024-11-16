class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] maxl = new int[n];
        int[] maxr = new int[n];
        int lwall=0,rwall=0;
        for(int i=0;i<n;i++){
            int j=n-i-1;
            maxl[i]=lwall;
            maxr[j]=rwall;
            lwall=Math.max(lwall,height[i]);
            rwall=Math.max(rwall,height[j]);
        }

        int sum=0;
        for(int i=0;i<n;i++){
            int pot=Math.min(maxl[i],maxr[i]);
            sum+=Math.max(0,pot-height[i]);
        }

        return sum;
        
    }
}