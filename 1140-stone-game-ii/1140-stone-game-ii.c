int stoneGameII(int* piles, int pilesSize) {
    int suffix[101] = {0};
    int dp[101][102] = {0};

    for (int i = pilesSize - 1; i >= 0; i--) {
        suffix[i] = suffix[i + 1] + piles[i];
    }

    for (int i = pilesSize - 1; i >= 0; i--) {
        for (int M = 1; M <= pilesSize; M++) {
            int best = 0;

            for (int X = 1; X <= 2 * M && i + X <= pilesSize; X++) {
                int opponent = dp[i + X][M > X ? M : X];
                int current = suffix[i] - opponent;

                if (current > best)
                    best = current;
            }

            dp[i][M] = best;
        }
    }

    return dp[0][1];
}