package aop;

import org.w3c.dom.ls.LSOutput;
import proxy.IBrowser;

import java.util.concurrent.atomic.AtomicLong;

public class AopTest {
    public static void main(String[] args) {

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                () -> {
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                () -> {
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                }
        );

        aopBrowser.show();
        System.out.println("loading time : " + end);

        aopBrowser.show();
        System.out.println("loading time : " + end);
    }
}
