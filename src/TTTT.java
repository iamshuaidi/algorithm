public enum TTTT {
    ONE;
    int a = 10;

    public static TTTT f() {
        return TTTT.ONE;
    }

    public static void main(String[] agrs) {
        System.out.println(f().a);
    }
}
