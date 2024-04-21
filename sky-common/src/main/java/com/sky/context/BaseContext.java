package com.sky.context;

public class BaseContext {

    public static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    /*
    该函数是一个Java静态方法，它的作用是为当前线程设置一个名为"threadLocal"的本地变量，
    并将其值设置为传入的id参数。这个方法经常在多线程编程中使用，用于在线程之间保存一些独立的状态或配置信息，
    而不影响其他线程。具体来说，它通过调用Java ThreadLocal类的set()方法，
    将id参数设置到当前线程所关联的ThreadLocal变量中。
    这样，在当前线程的其他代码中，就可以通过访问该ThreadLocal变量来获取和使用保存的id值。
     */
    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal.get();
    }

    public static void removeCurrentId() {
        threadLocal.remove();
    }

}
