class Solution {
    public int islandPerimeter(int[][] grid) {
        
        if(grid == null || grid.length == 0)
            return 0;
        
        int res = 0;
        
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    res += 4;
                    if(i > 0 && grid[i-1][j] == 1)
                        res -= 2;
                    if(j > 0 && grid[i][j-1] == 1)
                        res -= 2;
                }    
            }
        }
        return res;
    }
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int r = sc.nextInt();
    int c = sc.nextInt();
    int[][] arr = new int[r][c];
    for(int i = 0; i < r; i++)
    {
      for(int j = 0; j < c; j++)
      {
        arr[i][j] = sc.nextInt();
      }
    }
    int res = islandPerimeter(arr);
    System.out.println(res);
}
