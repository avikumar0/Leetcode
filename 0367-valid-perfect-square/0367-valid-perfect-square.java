class Solution {
    public boolean isPerfectSquare(int num) {
        int l=1;
        int r=num;

        while(l<=r){
            int m=(l+r)/2;
            long msq = (long) m*m;

            if(num == msq){
                return true;
            }else if(msq<num){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return false;
    }
}