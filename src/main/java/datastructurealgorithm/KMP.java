public class KMP {
    private int[] next;
    private void buildNext(char[] p) {
        next = new int[p.length];
        int i = 1, now = 0;
        while (i < p.length) {
            if (p[i] == p[now]) {
                now++;
                next[i++] = now;
            } else if (now != 0) {
                now = next[now-1];
            } else {
                next[i++] = now;
            }
        }
    }
    // 返回第一个匹配的下标
    public int search(char[] s, char[] p) {
        if (p == null || p.length == 0) {
            return 0;
        }
        buildNext(p);
        int i = 0, now = 0;
        while (i < s.length) {
            if (s[i] == p[now]) {
                i++;
                now++;
            } else if (now != 0) {
                now = next[now-1];
            } else {
                i++;
            }
            if (now == p.length) {
                return i - now;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String s = "asbdac", p = "bda";
        KMP kmp = new KMP();
        System.out.println(kmp.search(s.toCharArray(), p.toCharArray()));
    }
}
