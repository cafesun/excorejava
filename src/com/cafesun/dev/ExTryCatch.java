package com.cafesun.dev;

import java.io.IOException;
class SimpleException extends Exception {

    public SimpleException() {

    }

    public SimpleException(String strEx) {

        super(strEx);
    }
}

public class ExTryCatch {

    // 如果声明的异常规范与显式throw语句抛出的异常类型不同，则编译不通过
    // 如果没有声明异常规范，但有显式的调用throw语句，则也同样编译不过.
    // 如果没有声明异常规范或者声明了异常规范，但没有显式调用throw语句抛出异常，而是运行时产生的异常，可以编译通过
    public void doException() throws SimpleException {
        System.out.println("throw SimpleException!");
        throw new SimpleException("Hello Exception");
    }

    // C++中异常规范用throw从句表达，Java则是用throws表达;C++中没有声明异常规范可以抛出任何异常，而Java没有声明异常规范，不能在当前方法中显式的抛出任何异常
    public void doNullException() {
        String strNull = null;
        //System.out.println(strNull.length());
    }

    public static void main(String[] args) {

        try {
            ExTryCatch oTryEx = new ExTryCatch();
            oTryEx.doException();
            //oTryEx.doNullException();

        }
        catch (SimpleException ex) {
            System.out.println("Catch SimpleException!");
            System.out.println("What() = " + ex.getMessage());
            System.out.println("ToString() = " + ex.toString());
            ex.printStackTrace(System.out);
        }
        catch (Exception ex) {
            // 捕获所有的异常.
            System.out.println("Catch Exception :" + ex.getMessage());
            System.out.println("ToString() = " + ex.toString());
            ex.printStackTrace(System.out);
        }
        finally {
            // 即使捕获了异常，也会执行finally从句中的内容. finally从句中用于关闭资源.
            System.out.println("Catch UnKnownException!");
        }

    }
}
