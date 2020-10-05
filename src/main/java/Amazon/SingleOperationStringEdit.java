package Amazon;

import org.junit.Test;

public class SingleOperationStringEdit {
    public static boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }

    static final String IMPOSSIBLE = "IMPOSSIBLE";
    static final String INSERT = "INSERT ";
    static final String REMOVE = "REMOVE ";
    static final String MOVE = "MOVE ";
    static final String NOTHING = "NOTHING";

    public String solution(String s, String t) {
        if (isEmpty(s)) return IMPOSSIBLE;
        if (isEmpty(t)) return IMPOSSIBLE;
        int m = s.length(), n = t.length();
        int operation = n - m;
        if (Math.abs(operation) > 1) return IMPOSSIBLE;

        StringBuilder sB = new StringBuilder(s);
        StringBuilder tB = new StringBuilder(t);
        switch (operation) {
            case 1: // INSERT
            {
                for (int i = 0; i < m; ++i) {
                    if (sB.charAt(i) != tB.charAt(i)) {
                        sB.insert(i, tB.charAt(i));
                        if (sB.toString().equals(tB.toString())) {
                            return INSERT + tB.charAt(i);
                        }
                        break;
                    }
                }
                sB.append(tB.charAt(tB.length() - 1));
                if (sB.toString().equals(tB.toString())) {
                    return INSERT + tB.charAt(tB.length() - 1);
                }
                return IMPOSSIBLE;
            }
            case 0: // EQUAL length
            {
                if (s.equals(t)) return NOTHING;
                // check for swap
                return swap(sB, tB);
            }
            case -1: // REMOVE
            {
                for (int i = 0; i < n; ++i) {
                    if (sB.charAt(i) != tB.charAt(i)) {
                        char c = sB.charAt(i);
                        sB.delete(i, i + 1);
                        if (sB.toString().equals(tB.toString())) return REMOVE + c;
                        break;
                    }
                }
                char c = sB.charAt(sB.length() - 1);
                sB.delete(sB.length() - 1, sB.length());
                if (sB.toString().equals(tB.toString())) return REMOVE + c;
                return IMPOSSIBLE;
            }
        }
        return IMPOSSIBLE;
    }

    public String swap(StringBuilder sb, StringBuilder tb) {
        for (int i = 0; i < sb.length(); ++i) {
            if (sb.charAt(i) != tb.charAt(i)) {
                char c = sb.charAt(i);
                sb.delete(i, i + 1);
                for (int j = sb.length() - 1; j >= 0; --j) {
                    if (sb.charAt(j) != tb.charAt(j)) {
                        sb.insert(j, c);
                        if (sb.toString().equals(tb.toString())) return MOVE + c;
                        return IMPOSSIBLE;
                    }
                }
            }
        }
        return IMPOSSIBLE;
    }

    @Test
    public void test() {
        System.out.println(solution("niece", "nieces"));
        System.out.println(solution("nice", "niece"));
        System.out.println(solution("crow", "cow"));
        System.out.println(solution("beans", "banes"));
        System.out.println(solution("odd", "o"));
    }
}