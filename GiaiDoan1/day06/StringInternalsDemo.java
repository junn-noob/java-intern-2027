package GiaiDoan1.day06;

public class StringInternalsDemo {
    public static void main(String[] args) {
        String s1 = "JavaBackend";
        String s2 = "JavaBackend";
        String s3 = new String("JavaBackend");
        String s4 = s3.intern();

        System.out.println(s1 == s2); // true vi cung tro ve 1 chuoi trong String Pool
        System.out.println(s1 == s3); // false vi s3 chay new 1 doi tuong moi tren Heap
        System.out.println(s1.equals(s3)); // true vi so sanh gia tri cua 2 chuoi giong nhau
        System.out.println(s1 == s4); // true vi intern da dua s3 vao String Pool

        String str = "";
        long startString = System.currentTimeMillis();
        for (int i = 0; i < 50_000; i++) {
            str += "a";
        }
        long endString = System.currentTimeMillis();
        System.out.println(endString - startString);

        StringBuilder sb = new StringBuilder();
        long startSB = System.currentTimeMillis();
        for (int i = 0; i < 50_000; i++) {
            sb.append("a");
        }
        String finalStr = sb.toString();
        long endSB = System.currentTimeMillis();
        System.out.println(endSB - startSB);
    }
}
