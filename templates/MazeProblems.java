package templates;
import java.util.*;

public class MazeProblems {
    public static ArrayList<String> findPath(int[][] arr, int n) {
        if(arr[0][0] == 0 || arr[n-1][n-1] == 0){
            ArrayList<String> invalid = new ArrayList<>();
            invalid.add("-1");
            return invalid;
        }
        
        int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
        char dirS[] = {'U','D','L','R'};
        
        ArrayList<String> list = new ArrayList<>();
        solve(arr, 0, 0, n-1, n-1, "", dir, dirS, list);
        
        return list;
    }
    
    public static int solve(int arr[][], int sr, int sc, int dr, int dc, String asf, int dir[][], char dirS[], ArrayList<String> list){
        
        if(sr == dr && sc == dc){
            list.add(asf);
            return 1;
        }
        
        arr[sr][sc] = 0;
        
        int count = 0;
        for(int d=0; d<dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            
            if(r>=0 && c>=0 && r<=dr && c<=dc && arr[r][c] != 0){
                count += solve(arr,r,c,dr,dc, asf+dirS[d],dir,dirS,list);
            }
        }
        arr[sr][sc] = 1;
        
        return count;
    }
}


