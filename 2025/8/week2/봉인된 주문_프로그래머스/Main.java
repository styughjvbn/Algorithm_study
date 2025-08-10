import java.util.*;

class Solution {
    static final long[] POW = new long[12]; // 26^0 .. 26^11

    static {
        POW[0] = 1L;
        for (int i = 1; i < POW.length; i++) POW[i] = POW[i - 1] * 26L;
    }

    public String solution(long n, String[] bans) {
        Arrays.sort(bans, (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return a.length() - b.length();
        });
        long skipCount = 0;
        for (String s : bans) {
            long sIdx = toIdx(s);
            if (sIdx - skipCount > n) {
                break;
            } else {
                skipCount++;
            }
        }

        return toResult(n + skipCount);
    }

    public long toIdx(String s) {
        long idx = 0;
        int len = s.length() - 1;
        int i = 0;
        for (char c : s.toCharArray()) {
            idx += (long) POW[len--] * (c + 1 - 'a');
        }
        return idx;
    }

    public String toResult(long n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--; //1-base -> 0-base로 변환
            char c = (char) ('a' + n % 26);
            sb.append(c);
            n /= 26;
        }
        sb.reverse();
        return sb.toString();
    }
}