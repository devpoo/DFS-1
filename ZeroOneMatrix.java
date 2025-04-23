package week6;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
        int m,n;
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            Queue<int[]> q = new LinkedList<>();
            for(int i=0 ;i<m ;i++) {
                for(int j=0; j<n ; j++){
                    if(mat[i][j] == 0) {
                        q.add(new int[]{i, j});
                    } else {
                        mat[i][j] *= -1;
                    }
                }
            }

            int dist = 1;
            while(!q.isEmpty()){
                int size = q.size();
                for(int i=0; i<size; i++) {
                    int[] curr = q.poll();
                    for(int[] dir: dirs) {
                        int r = curr[0] + dir[0];
                        int c = curr[1] + dir[1];

                        if(r>=0 && c>=0 && r<m && c<n && mat[r][c] == -1) {
                            mat[r][c] = dist;
                            q.add(new int[]{r, c});
                        }
                    }
                }
                dist++;
            }

            return mat;

        }
}
