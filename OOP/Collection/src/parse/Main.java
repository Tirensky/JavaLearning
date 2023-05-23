package parse;

public class Main {
    public static void main(String[] args) {
        String s1 = "1000";
        String s2 = "2000";
        int i1 = Integer.parseInt(s1);
        int i2 = Integer.parseInt(s2);
        System.out.println(i1 + i2);

        String s3 = "true";
        boolean b1 = Boolean.parseBoolean(s3);
        System.out.println(b1);

        String s4 = "Name. Post.";
        String name = s4.substring(0, 4);
        String post = s4.substring(6, 10);
        System.out.println(name + " " + post);
    }
}
