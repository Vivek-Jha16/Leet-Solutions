char* convert(char* s, int numRows) {
    int len = strlen(s);

    if (numRows == 1 || numRows >= len)
        return s;

    char *result = (char *)malloc((len + 1) * sizeof(char));
    int k = 0;
    int cycle = 2 * numRows - 2;

    for (int row = 0; row < numRows; row++) {
        for (int j = row; j < len; j += cycle) {
            result[k++] = s[j];

            int second = j + cycle - 2 * row;
            if (row != 0 && row != numRows - 1 && second < len) {
                result[k++] = s[second];
            }
        }
    }

    result[k] = '\0';
    return result;
}