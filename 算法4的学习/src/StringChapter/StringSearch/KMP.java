package StringChapter.StringSearch;

public class KMP {

    private final int R;
    private int[][] dfa;

    private char[] pattern;
    private String pat;



    public KMP(String pat){
        this.R = 256;
        this.pat = pat;

        int m = pat.length();
        dfa = new int[R][m];
        dfa[pat.charAt(0)][0] = 1;
        for(int x = 0,j = 1; j < m; j++){
            for(int c = 0; c < R;c++){
                dfa[c][j] = dfa[c][x];
            }
            dfa[pat.charAt(j)][j] = j+1;
            x = dfa[pat.charAt(j)][x];
        }

    }

    public KMP(char[] pattern, int R) {
        this.R = R;
        this.pattern = new char[pattern.length];
        for (int j = 0; j < pattern.length; j++)
            this.pattern[j] = pattern[j];

        // build DFA from pattern
        int m = pattern.length;
        dfa = new int[R][m];
        dfa[pattern[0]][0] = 1;
        for (int x = 0, j = 1; j < m; j++) {
            for (int c = 0; c < R; c++)
                dfa[c][j] = dfa[c][x];     // Copy mismatch cases.
            dfa[pattern[j]][j] = j+1;      // Set match case.
            x = dfa[pattern[j]][x];        // Update restart state.
        }
    }

    public static void main(String[] args) {
        String pat = "ABABC";
        String txt = "ABABABCAABB";

        KMP kmp1 = new KMP(pat);

    }

}
