// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null ||nums.length==0) return new int[] {-1,-1};
        if(target<nums[0]||target>nums[nums.length-1]) return new int[] {-1,-1};

        int first= binarySearchFirst(nums, target);
        if(first == -1) return new int[] {-1,-1};
        int last= binarySearchLast(nums, target);

        return new int[] {first,last};
    }

    private int binarySearchFirst(int [] nums, int target){
        int low=0;
        int high=nums.length-1;
        while (low<=high){
            int mid= low +(high-low)/2;
            if( nums[mid]==target){
                if(mid ==0 ||nums[mid-1]<nums[mid]){
                    return mid;
                }
                else{
                    high=mid-1;
                }
            }
            else if(target< nums[mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }

    private int binarySearchLast(int [] nums, int target){
        int low=0;
        int high=nums.length-1;
        while (low<=high){
            int mid= low +(high-low)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1 || nums[mid+1]>nums[mid]){
                    return mid;
                }
                else{
                    low=mid+1;
                }
            }
            else if(target< nums[mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
} 
