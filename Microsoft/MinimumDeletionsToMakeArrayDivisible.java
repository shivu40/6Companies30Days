class Solution {

    public static int getGcd(int[] numsDivide){
        int gcd = numsDivide[0];

        for(int i = 1; i < numsDivide.length; i++){
            gcd = calcGcd(gcd, numsDivide[i]);
        }

        return gcd;
    }

    public static int calcGcd(int dividend, int divisor){
        if(divisor == 0) return dividend;

        return calcGcd(divisor, dividend % divisor);
    }

    public int minOperations(int[] nums, int[] numsDivide) {
        
        int gcd = getGcd(numsDivide);

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            if(gcd % nums[i] == 0) return i;
        }

        return -1;
    }
}