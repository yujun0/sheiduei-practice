package com.example.configure.pk1;

import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AlphabetValues {

    private static final Map<Character, Integer> LETTERS_MAP = Map.ofEntries(
            Map.entry('A', 1), Map.entry('B', 2), Map.entry('C', 3), Map.entry('D', 4),
            Map.entry('E', 5), Map.entry('F', 6), Map.entry('G', 7), Map.entry('H', 8),
            Map.entry('I', 9), Map.entry('J', 10), Map.entry('K', 11), Map.entry('L', 12),
            Map.entry('M', 13), Map.entry('N', 14), Map.entry('O', 15), Map.entry('P', 16),
            Map.entry('Q', 17), Map.entry('R', 18), Map.entry('S', 19), Map.entry('T', 20),
            Map.entry('U', 21), Map.entry('V', 22), Map.entry('W', 23), Map.entry('X', 24),
            Map.entry('Y', 25), Map.entry('Z', 26)
    );

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入英文字母或字串：");

        // 欲要計算字串
        String str = scanner.nextLine();
        // String str = "values";
        // 一律轉大寫
        str = str.toUpperCase();

        // 中文檢核規則
        Pattern chineseReg = Pattern.compile("[\u4e00-\u9fa5]");
        if (chineseReg.matcher(str).find()) {
            System.err.println("字串含有中文");
            System.out.println("總和：" + 0);
            return;
        }

        // 數字檢核規則
        Pattern numReg = Pattern.compile("[0-9]");
        if (numReg.matcher(str).find()) {
            System.err.println("字串含有數字");
            System.out.println("總和：" + 0);
            return;
        }

        // 計算總和
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (LETTERS_MAP.containsKey(c)) {
                sum += LETTERS_MAP.get(c);
            } else {
                System.err.println("字串含有非英文字母");
                return;
            }
        }
//        int sum = str.chars()
//                .mapToObj(c -> (char) c)
//                .filter(LETTERS_MAP::containsKey)
//                .mapToInt(c -> LETTERS_MAP.getOrDefault(c, 0))
//                .sum();
        System.out.println("總和：" + sum);
    }

}
