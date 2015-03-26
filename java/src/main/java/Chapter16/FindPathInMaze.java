package Chapter16;

import java.util.LinkedList;

/**
 * Created by Carl Shen on 3/25/15.
 * Problem 16.1:
 * A little variant from the book, we define 0 means empty and 1 means obstacle.
 *
 * Solution:
 * Model the maze as an undirected graph, each vertex
 */
public class FindPathInMaze {

    static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Coordinate)) {
                return false;
            }
            Coordinate o = (Coordinate)other;
            return this.x == o.x && this.y == o.y;
        }

        @Override
        public String toString() {
            return "(" + this.x + ", " + this.y + ")";
        }
    }

    public LinkedList<Coordinate> searchMaze(int[][] maze) {
        LinkedList<Coordinate> path = new LinkedList<Coordinate>();
        Coordinate start = new Coordinate(0, 0), end = new Coordinate(maze.length - 1, maze[0].length - 1);
        maze[0][0] = 1; // visited pixel marked as 1
        path.add(start);
        if (!dfs(maze, path, start, end)) {
            path.removeLast();
        }
        return path;
    }

    public boolean dfs(int[][] maze, LinkedList<Coordinate> path, final Coordinate curr, final Coordinate end) {
        if (curr.equals(end)) {
            return true;
        }

        // only two directions are allowed
        int[] x = {0, 1}, y = {1, 0};
        for (int i = 0; i < 2; i++) {
            Coordinate next = new Coordinate(curr.x + x[i], curr.y + y[i]);
            if (isValid(next, maze)) {
                maze[next.x][next.y] = 1;
                path.add(next);
                if (dfs(maze, path, next, end)) {
                    return true;
                }
                path.removeLast();
            }
        }
        return false;
    }

    public boolean isValid(final Coordinate curr, int[][] maze) {
        return (curr.x >= 0 && curr.x < maze.length) && (curr.y >= 0 && curr.y < maze[0].length)
                && (maze[curr.x][curr.y] == 0);
    }

    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}
        };
        FindPathInMaze sol = new FindPathInMaze();
        LinkedList<Coordinate> res = sol.searchMaze(maze);
        System.out.println(res);
    }
}
