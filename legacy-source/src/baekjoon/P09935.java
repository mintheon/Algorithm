package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @see <a href="boj.kr/1780">문자열 폭발</a>
 */
public class P01780 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text = br.readLine();
        String parseText = br.readLine();

        int answer = 0;
        int tLenth = parseText.length();

        int result = 0;
        do {
            int beforeParseLength = text.length();
            text = text.replace(parseText, "");
            result = (beforeParseLength - text.length()) / tLenth;
            answer += result;
        } while (result != 0);

        System.out.println(answer);
    }
}