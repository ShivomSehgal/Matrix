Given a grid of dimension nxm where each cell in the grid can have values 0, 1 or 2 which has the following meaning:
0 : Empty cell 
1 : Cells have fresh oranges 
2 : Cells have rotten oranges

We have to determine what is the minimum time required to rot all oranges. A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time. 
 

Example 1:

Input: grid = {{0,1,2},{0,1,2},{2,1,1}}
Output: 1
Explanation: The grid is-
0 1 2
0 1 2
2 1 1
Oranges at positions (0,2), (1,2), (2,0)
will rot oranges at (0,1), (1,1), (2,2) and 
(2,1) in unit time.
Example 2:

Input: grid = {{2,2,0,1}}
Output: -1
Explanation: The grid is-
2 2 0 1
Oranges at (0,0) and (0,1) can't rot orange at
(0,3).
  
  
  
  class Solution
{
    
    public boolean checkAll(int[][] array, int n, int m){
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(array[i][j] == 1){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isSafe(int[][] array, int n, int m, int i, int j){
        if(i < 0 || i >= n || j<0 || j>= m) return false;
        
        return true;
    }
    
    public boolean isDelimiter(Pair p){
        int i = p.row;
        int j = p.col;
        
        return i == -1 &&  j == -1;
    }
    
    class Pair{
        int row=0;
        int col=0;
        
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
    public int orangesRotting(int[][] grid)
    {
        Queue<Pair> queue = new LinkedList<>();
        Pair temp ;
        int days = 0;
        int n = grid.length, m = grid[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    queue.offer(new Pair(i,j));
                }
            }
        }
        queue.offer(new Pair(-1,-1));
        
        while(!queue.isEmpty()){
            boolean flag = false;
            
            while(!isDelimiter(queue.peek())){
                temp = queue.peek();
                
                if(isSafe(grid, n, m, temp.row+1 , temp.col) && grid[temp.row+1][temp.col] == 1){
                    if(!flag){
                        days++;
                        flag = true;
                    }
                    grid[temp.row+1][temp.col] = 2;
                    queue.offer(new Pair(temp.row+1, temp.col));
                }
                if(isSafe(grid, n, m, temp.row , temp.col+1) && grid[temp.row][temp.col+1] == 1){
                    if(!flag){
                        days++;
                        flag = true;
                    }
                    grid[temp.row][temp.col+1] = 2;
                    queue.offer(new Pair(temp.row, temp.col+1));
                }
                if(isSafe(grid, n, m, temp.row , temp.col-1) && grid[temp.row][temp.col-1] == 1){
                    if(!flag){
                        days++;
                        flag = true;
                    }
                    grid[temp.row][temp.col-1] = 2;
                    queue.offer(new Pair(temp.row, temp.col-1));
                }
                if(isSafe(grid, n, m, temp.row-1 , temp.col) && grid[temp.row-1][temp.col] == 1){
                    if(!flag){
                        days++;
                        flag = true;
                    }
                    grid[temp.row-1][temp.col] = 2;
                    queue.offer(new Pair(temp.row-1, temp.col));
                }
            
            queue.poll();
        }
         queue.remove();   
            if(!queue.isEmpty()){
                queue.offer(new Pair(-1,-1));
            }
        }
        return (!checkAll(grid, n , m)) ? days : -1;
    }
}
