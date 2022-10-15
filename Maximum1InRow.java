Given a boolean 2D array of n x m dimensions where each row is sorted. Find the 0-based index of the first row that has the maximum number of 1's.

Example 1:

Input: 
N = 4 , M = 4
Arr[][] = {{0, 1, 1, 1},
           {0, 0, 1, 1},
           {1, 1, 1, 1},
           {0, 0, 0, 0}}
Output: 2
Explanation: Row 2 contains 4 1's (0-based
indexing).

Example 2:

Input: 
N = 2, M = 2
Arr[][] = {{0, 0}, {1, 1}}
Output: 1
Explanation: Row 1 contains 2 1's (0-based
indexing).




class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        int maxCounter = 0, maxIdx = -1;
        for(int i=0;i<n;i++){
            
            int counter = m - binarySearch(1,arr[i],m);
            
            if(maxCounter < counter){
                maxCounter = counter;
                maxIdx = i;
            }
        }
        return maxIdx;
    }
    
    int binarySearch(int target, int[] array, int m){
        int p = 0, r = array.length-1;
        
        while(p<=r){
            int q = (p+r)/2;
            
            // if( q ==array.length-1 && array[q] != target) return 
            
            if(q == 0 && array[q] == target  ||
            q>0 && array[q-1] < target && array[q] == target) return q;
            
            else if(array[q] < array[r]){
                p = q+1;
            }else{
                r = q-1;
            }
        }
        return m;
    }
}
