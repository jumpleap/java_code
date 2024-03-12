package practice;


public class Test {
}

interface Com {
    int M = 200;

    int f();
}

class ImpCom implements Com {
    //【代码】

    @Override
    public int f() {
        return M;
    }
}