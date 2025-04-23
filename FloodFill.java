package week6;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int oldColor = image[sr][sc];

        if(oldColor == color) return image;
        image[sr][sc] = color;
        int m = image.length;
        int n = image[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        int[][] directions = new int[][]{{0,-1}, {-1,0}, {0,1}, {1,0}};


        while(!q.isEmpty()){
            int[] curr = q.poll();

            for(int[] dir: directions) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                if(r>= 0 && c>=0 && r<m && c<n && image[r][c] == oldColor) {
                    image[r][c] = color;
                    q.add(new int[]{r, c});
                }
            }
        }
        return image;
    }


    public int[][] floodFillDFS(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if(oldColor == color) return image;

        dfs(image, sr, sc, oldColor, color);
        return image;

    }

    private void dfs(int[][] image, int sr, int sc, int oldColor, int color){
        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        image[sr][sc] = color;

        for(int[] dir : dirs) {
            int r = sr + dir[0];
            int c = sc + dir[1];

            if (r >= 0 && c >= 0 && r < image.length && c < image[0].length && image[r][c] == oldColor) {
                dfs(image, r, c, oldColor, color);
            }
        }
    }

}
