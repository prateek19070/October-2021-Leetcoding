// Erect the Fence

class Solution {
      public int[][] outerTrees(int[][] trees) {
        int n = trees.length;
        Arrays.sort(trees,(a,b)->((a[0]==b[0])?Integer.compare(a[1],b[1]):Integer.compare(a[0],b[0]))); 
        
        List<int[]> lowerHull = new ArrayList();
        List<int[]> upperHull = new ArrayList();
        List<int[]> hull = new ArrayList();
        
        for(int i =0;i<n;i++){
            int tree[] = trees[i];
            while(lowerHull.size()>=2&&cross(lowerHull.get(lowerHull.size()-2),lowerHull.get(lowerHull.size()-1),tree)<0){
                lowerHull.remove(lowerHull.size()-1);
            }
            lowerHull.add(tree);
        }
        
        for(int i =n-1;i>=0;i--){
            int tree[] = trees[i];
            while(upperHull.size()>=2&&cross(upperHull.get(upperHull.size()-2),upperHull.get(upperHull.size()-1),tree)<0){
                upperHull.remove(upperHull.size()-1);
            }
            upperHull.add(tree);
        }
        
        List<int[]> temp = new ArrayList();
        for(int tree[] : lowerHull) temp.add(tree);
        for(int tree[] : upperHull) temp.add(tree);
        Collections.sort(temp,(a,b)->((a[0]==b[0])?Integer.compare(a[1],b[1]):Integer.compare(a[0],b[0]))); 
        
        hull.add(temp.get(0));
        for(int i =1;i<temp.size();i++){
            if(equal(temp.get(i),hull.get(hull.size()-1))) continue;
            hull.add(temp.get(i));
        }
        
        return hull.toArray(new int[hull.size()][2]);
    }
    
    private boolean equal(int a[] , int b[]){
        if(a[0]==b[0]&&a[1]==b[1]) return true;
        return false;
    }
    
    private int cross(int o[] , int a[] , int b[]){ 
        return (b[1]-o[1])*(a[0]-o[0]) - (a[1]-o[1])*(b[0]-o[0]); 
    }
}
