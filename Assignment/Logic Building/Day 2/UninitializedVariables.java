class UninitializedVariables {

    byte a;
    short b;
    int c;
    long d;
    float e;
    double f;
    char g;
    boolean h;

    public static void main(String[] args) {

        UninitializedVariables obj = new UninitializedVariables();

        System.out.println("byte: " + obj.a);
        System.out.println("short: " + obj.b);
        System.out.println("int: " + obj.c);
        System.out.println("long: " + obj.d);
        System.out.println("float: " + obj.e);
        System.out.println("double: " + obj.f);
        System.out.println("char: " + obj.g);
        System.out.println("boolean: " + obj.h);
    }
}