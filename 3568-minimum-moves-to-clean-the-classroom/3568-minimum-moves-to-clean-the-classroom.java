class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0;
        List<int[]> litter = new ArrayList<>();

        // Start aur litter positions find karo
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (classroom[i].charAt(j) == 'S') {
                    sr = i;
                    sc = j;
                } else if (classroom[i].charAt(j) == 'L') {
                    litter.add(new int[]{i, j});
                }
            }
        }

        int k = litter.size();

        if (k == 0) return 0;

        // State: row, col, collected-mask, remaining-energy
        int totalMasks = 1 << k;

        int[][][][] dist = new int[m][n][totalMasks][energy + 1];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                for (int mask = 0; mask < totalMasks; mask++)
                    Arrays.fill(dist[i][j][mask], -1);

        Queue<int[]> q = new ArrayDeque<>();

        dist[sr][sc][0][energy] = 0;
        q.offer(new int[]{sr, sc, 0, energy});

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] state = q.poll();

            int r = state[0];
            int c = state[1];
            int mask = state[2];
            int e = state[3];

            int moves = dist[r][c][mask][e];

            // Saara litter collect ho gaya
            if (mask == totalMasks - 1) {
                return moves;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                // Grid ke bahar
                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                // Obstacle
                if (classroom[nr].charAt(nc) == 'X')
                    continue;

                // Energy khatam hai toh move nahi kar sakte
                if (e == 0)
                    continue;

                int ne = e - 1;

                // Reset area par full energy
                if (classroom[nr].charAt(nc) == 'R') {
                    ne = energy;
                }

                int newMask = mask;

                // Check karo kya yahan litter hai
                for (int i = 0; i < k; i++) {
                    if (litter.get(i)[0] == nr &&
                        litter.get(i)[1] == nc) {
                        newMask |= (1 << i);
                    }
                }

                if (dist[nr][nc][newMask][ne] == -1) {
                    dist[nr][nc][newMask][ne] = moves + 1;
                    q.offer(new int[]{nr, nc, newMask, ne});
                }
            }
        }

        return -1;
    }
}