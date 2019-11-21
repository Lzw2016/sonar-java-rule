class MyClass {
    MyClass(MyClass mc) {
    }

    int foo1() {
        return 0;
    }

    void foo2(int value) {
    }

    int foo3(int value) { // Noncompliant
        return 0;
    }

    Object foo4(int value) {
        return null;
    }

    MyClass foo5(MyClass value) { // Noncompliant
        return null;
    }

    int foo6(int value, String name) {
        return 0;
    }

    int foo7(int... values) {
        return 0;
    }
}