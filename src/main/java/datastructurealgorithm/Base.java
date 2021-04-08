package datastructurealgorithm;

// 16进制字符串转byte数组
public class Base {
    public static void main(String[] args) {
        String str = "1a1a1";
        int len = str.length() / 2 + str.length() % 2;
        byte[] bytes = new byte[len];
        int j = 0;
        for (int i = 0; i < bytes.length - str.length() % 2; i++) {
            bytes[i] = (byte) Integer.parseInt(str.substring(j, j + 2), 16);
            j += 2;
        }
        if (str.length() % 2 == 1) {
            bytes[bytes.length-1] = (byte) Integer.parseInt(str.substring(str.length() - 1), 16);
        }
        System.out.println(bytes.length);
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
    }
}
