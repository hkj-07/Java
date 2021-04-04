class Solution {
    public int clumsy(int n) {
        int num = 0;
        if (n >= 4) {
            num = (n * (n - 1)) / (n - 2) + (n - 3);
            n -= 4;
        }
        return JC(num, n);
    }

    public static int JC(int num, int n) {
        if (n >= 4) {
            num = -((n * (n - 1)) / (n - 2)) + (n - 3);
            n -= 4;
            return JC(num, n);
        } else if (n == 3) {
            return num - 6;
        } else if (n == 2) {
            return num - 2;
        } else if (n == 1) {
            return num - 1;
        }
        return num;
    }
}

