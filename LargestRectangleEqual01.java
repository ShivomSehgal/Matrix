Given a binary matrix. The problem is to find the largest area rectangular sub-matrix with equal number of 1’s and 0’s. Examples:

Input : mat[][] = { {0, 0, 1, 1},
                    {0, 1, 1, 0},
                    {1, 1, 1, 0},
                    {1, 0, 0, 1} }
Output : 8 sq. units
(Top, left): (0, 0)
(Bottom, right): (3, 1)

Input : mat[][] = { {0, 0, 1, 1},
                    {0, 1, 1, 1} }            
Output : 6 sq. units










class Solution {
    
    public int getLength(int[] temp){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int len = 0, sum = 0;
        
        for(int i=0;i<temp.length;i++){
            sum += temp[i];
            
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }else{
                len = Math.max(len, i - map.get(sum));
            }
        }
        return len;
    }
    
    public int maxArea(int arr[][], int n, int m) {
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j] == 0){
                    arr[i][j] = -1;
                }
            }
        }
        
        int[] temp = new int[n];
        int maxAreaa = 0;
        
        for(int i=0;i<n;i++){
            
            for(int j=0;j<n;j++){
                temp[j] = 0;
            }
            
            for(int j=i;j<m;j++){
                 for(int k=0;k<n;k++){
                     
                temp[j] += arr[k][j];
                
              int  length = getLength(temp);
              int  breadth = j - i+1;
                
                maxAreaa = Math.max(length*breadth, maxAreaa);
            }
        }
        }
        return maxAreaa;
    }
}
