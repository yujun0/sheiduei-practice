package homework.verify.lv1;

import java.io.*;
import java.util.Arrays;

public class IdVerifyHelper {

    public static void main(String[] args) {
        String fileName = "idList1.txt";
        validate(fileName);
    }

    public static void validate(String fileName) {
        File file = new File(fileName);

        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {

                if (check(line)) {
                    System.out.println("====您輸入的身分證字號 " + line + "====\n" + "====驗證成功====");
                } else {
                    System.out.println("====您輸入的身分證字號 " + line+ "====\n" + "====驗證失敗====");
                }
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("超出檢驗長度 ");
            System.out.println("錯誤訊息：" + e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // 檢驗規則，回傳boolean值
    public static boolean check(String str) {
        char[] charArray = new char[26];
        int[] intArray = {10, 11, 12, 13, 14, 15, 16, 17, 34, 18, 19, 20, 21, 22, 35, 23, 24, 25, 26, 27, 28, 29, 32, 30, 31, 33};
        int[] strArray = new int[26];

        // 轉大寫
        str = str.toUpperCase();
        // 提取第一個字母
        Character firstWord = str.charAt(0);
        // 將A~Z塞進charArray
        alphabet(charArray);
        for (int i = 1; i <= str.length() - 1; i++) {
            strArray[i] = str.charAt(i) - 48;
        }

        // 判斷字串是否只有英數字
        if (str.matches("[a-zA-Z0-9]+")) {
            // 找尋第一個字母的index
            int index = Arrays.binarySearch(charArray, firstWord);
            int firstNum = intArray[index];
            // 初始化餘數
            int modulo;
            // 個位數
            int unitsDigit = firstNum % 10;
            // 十位數
            int tensDigit = firstNum / 10;
            // 數字總和
            int sum = tensDigit * 1 + unitsDigit * 9 + strArray[1] * 8 + strArray[2] * 7 + strArray[3] * 6
                    + strArray[4] * 5 + strArray[5] * 4 + strArray[6] * 3 + strArray[7] * 2 + strArray[8] * 1;

            // 判斷除10餘數
            if (sum % 10 == 0) {
                modulo = 0;
            } else {
                modulo = 10 - (sum % 10);
            }

            // 判斷是否與檢查號碼相等
            if (modulo == strArray[9]) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    // 創建A~Z陣列
    static void alphabet(char[] array) {
        for (int i = 0; i < 26; i++) {
            array[i] = (char) (i + 65);
        }
    }

}
