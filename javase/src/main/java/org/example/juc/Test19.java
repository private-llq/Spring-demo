package org.example.juc;


import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.juc
 * @date 2023/11/22 0:07
 * @description: 公司
 * list 集合，我在下标1和下标3各放置一个元素，那么下标2有元素吗或者说元素为null?
 */
public class Test19 {
    public static void main(String[] args) {
        String str = "gwwgwgee84hhfagf3f32r2";
        char mostFrequentChar = getMostFrequentChar(str);
        int frequency = getCharFrequency(str, mostFrequentChar);
        System.out.println("The most frequent character is " + mostFrequentChar + ", and its frequency is " + frequency + ".");
    }

    public static char getMostFrequentChar(String str) {
        Map<Character, Long> charFrequencyMap = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        char mostFrequentChar = charFrequencyMap.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElseThrow(IllegalArgumentException::new);
        return mostFrequentChar;
    }

    public static int getCharFrequency(String str, char c) {
        int frequency = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == c) {
                frequency++;
            }
            if (frequency > 0 && str.charAt(i) != c) {
                break;
            }
        }
        return frequency;
    }
}