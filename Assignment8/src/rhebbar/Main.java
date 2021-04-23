package rhebbar;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        printSeparator();

        ///////////////////////////////////////////////////////////////////////////

        //Q1: Given a graph and a source vertex in the graph, find shortest paths from source to all vertices in the given graph.
        System.out.println("Q1: Find shortest path");

        int[][] graph = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        System.out.println("Input: ");
        printMatrix(graph);

        System.out.println("Printing shortest path: ");
        findShortestPath(graph, 0);

        printSeparator();

        ///////////////////////////////////////////////////////////////////////////

        //Q2: Course schedule
        System.out.println("Q2: Course schedule");

        System.out.println("Pass 1: ");
        int numOfCourses = 2;
        int[][] prerequisites = {{1,0}};

        System.out.println("For " + numOfCourses + " courses, the pre-requisites are: ");
        printMatrix(prerequisites);

        System.out.println("Can finish all courses: " + canFinishCourse(numOfCourses, prerequisites));

        System.out.println("Pass 2: ");
        numOfCourses = 2;
        prerequisites = new int[][] {{1,0}, {0,1}};

        System.out.println("For " + numOfCourses + " courses, the pre-requisites are: ");
        printMatrix(prerequisites);

        System.out.println("Can finish all courses: " + canFinishCourse(numOfCourses, prerequisites));

        printSeparator();

        ///////////////////////////////////////////////////////////////////////////

        //Q3: Word ladder
        System.out.println("Q3: Word ladder");

        System.out.println("Pass 1: ");
        String beginWord = "hit";
        String endWord = "cog";

        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        System.out.println("Begin word : " + beginWord + " and end word: " + endWord);
        System.out.println("Word list: " + wordList);
        System.out.println("Number of words: " + ladderLength(beginWord, endWord, wordList));

        System.out.println("Pass 2: ");
        beginWord = "hit";
        endWord = "cog";

        wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");

        System.out.println("Begin word : " + beginWord + " and end word: " + endWord);
        System.out.println("Word list: " + wordList);
        System.out.println("Number of words: " + ladderLength(beginWord, endWord, wordList));

        printSeparator();

        ///////////////////////////////////////////////////////////////////////////

        //Q4: Number of islands
        System.out.println("Q4: Number of islands");

        System.out.println("Pass 1: ");

        char[][] islandMatrix = {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};

        System.out.println("Input matrix is: ");
        printCharacterMatrix(islandMatrix);

        System.out.println("Number of islands found are: " + numIslands(islandMatrix));

        System.out.println("Pass 1: ");

        islandMatrix = new char[][]  {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};

        System.out.println("Input matrix is: ");
        printCharacterMatrix(islandMatrix);

        System.out.println("Number of islands found are: " + numIslands(islandMatrix));

        printSeparator();
    }

    //Solution functions

    //Q1
    private static void findShortestPath(int[][] graph, int src) {
        //using Dijkstra's algorithm
        int[] dist = new int[graph.length]; // The output array. dist[i] will hold the shortest distance from src to i

        // setOfShortestPaths[i] will true if vertex i is included in shortest path tree or shortest distance from src to i is finalized
        boolean[] setOfShortestPaths = new boolean[graph.length];

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < graph.length; i++) {
            dist[i] = Integer.MAX_VALUE;
            setOfShortestPaths[i] = false;
        }

        // Distance of source vertex from itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < graph.length - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, setOfShortestPaths);

            // Mark the picked vertex as processed
            setOfShortestPaths[u] = true;

            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < graph.length; v++)

                // Update dist[v] only if is not in setOfShortestPaths, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!setOfShortestPaths[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        // print the constructed distance array
        printSolution(dist);
    }

    private static int minDistance(int[] dist, boolean[] sptSet) {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < dist.length; v++)
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    private static void printSolution(int[] dist) {
        System.out.println("Node \t\t Distance");
        for (int i = 0; i < dist.length; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    //Q2
    private static boolean canFinishCourse(int numCourses, int[][] prerequisites) {
        if(numCourses == 0)
            return true;

        int[] course = new int[numCourses];

        //increment the dependency each course has
        for (int[] prerequisite : prerequisites) {
            course[prerequisite[1]]++;
        }

        boolean[] visited = new boolean[prerequisites.length];

        boolean flag = true;

        while(flag) {
            flag = false;

            for(int i=0; i<prerequisites.length; i++) {
                if(! visited[i]) {
                    if(course[prerequisites[i][0]] == 0) {
                        visited[i] = true;
                        course[prerequisites[i][1]]--;
                        flag = true;
                    }
                }
            }
        }

        for (int j : course) {
            if (j != 0)
                return false;
        }

        return true;
    }

    //Q3
    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                char[] current = queue.poll().toCharArray();

                for (int j = 0; j < current.length; j++) {
                    char tmp = current[j]; //hold current word

                    for (char c = 'a'; c <= 'z'; c++) { // change 1 letter at a time
                        current[j] = c;
                        String next = new String(current);

                        // check if next word is in the set
                        if (set.contains(next)) {
                            if (next.equals(endWord))
                                return count + 1;

                            queue.add(next);
                            set.remove(next);
                        }
                    }

                    current[j] = tmp; // reset to old word
                }
            }

            count++; //iteration done - one letter changed
        }
        return 0;
    }

    //Q4
    private static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;

        int numOfIslands = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    numOfIslands += dfs(grid, i, j);
                }
            }
        }

        return numOfIslands;
    }

    private static int dfs(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 ||
                i >= grid.length || j >= grid[i].length ||
                grid[i][j] == '0') {
            return 0;
        }

        //mark the spot as visited to avoid revisiting
        grid[i][j] = '0';

        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);

        return 1;
    }

    //Helper functions
    private static void printSeparator() {
        System.out.println();
        System.out.println("/*  *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   */");
        System.out.println();
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(" " + ints[j]);
            }
            System.out.println();
        }
    }

    private static void printCharacterMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(" " + chars[j]);
            }
            System.out.println();
        }
    }
}