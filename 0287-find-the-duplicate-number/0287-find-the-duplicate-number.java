class Solution {
    // TC -> O(n)
    // SC -> O(1)
    public int findDuplicate(int[] nums) {
        // HashSet<Integer> set = new HashSet<>() ;

        // for(int val : nums) {
        //     if(set.contains(val)) {
        //         return val ;
        //     }
        //     set.add(val) ;
        // }
        // return -1 ;


        // slow - fast pointer approach -> 
        // int slow = nums[0] , fast = nums[0] ;

        // do {
        //     slow = nums[slow] ; // +1
        //     fast = nums[nums[fast]] ; // +2
        // } while(slow != fast) ;

        // slow = nums[0] ;
        // while(slow != fast) {
        //     slow = nums[slow] ; // +1
        //     fast = nums[fast] ; // +1
        // }
        // return fast ; // or slow ;
        for (int i = 0; i < nums.length; i++) {
            int p = Math.abs(nums[i]);
            if (nums[p - 1] > 0) {
                nums[p - 1] = -nums[p - 1];
            } else return p;
        }
        return 0;
    }
}