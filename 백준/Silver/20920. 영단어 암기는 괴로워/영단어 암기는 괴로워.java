import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 1. 단어 빈도수를 저장할 Map
        Map<String, Integer> wordMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
        }

        // 2. Map의 Key(단어)들을 리스트로 변환
        List<String> words = new ArrayList<>(wordMap.keySet());

        // 3. 정렬 기준 부여 (이 부분이 핵심!)
        words.sort((s1, s2) -> {
            // 빈도수 가져오기
            int count1 = wordMap.get(s1);
            int count2 = wordMap.get(s2);

            // 1순위: 빈도수 내림차순
            if (count1 != count2) {
                return count2 - count1;
            }

            // 2순위: 단어 길이 내림차순
            if (s1.length() != s2.length()) {
                return s2.length() - s1.length();
            }

            // 3순위: 사전순 오름차순
            return s1.compareTo(s2);
        });

        // 4. 결과 출력 (StringBuilder 사용)
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append("\n");
        }
        System.out.print(sb.toString());
    }
}