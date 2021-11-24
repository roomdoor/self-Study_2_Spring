package singleton;

import singleton.AClazz;
import singleton.BClazz;
import singleton.SocketClient;

public class SingletonTest {

    public static void main(String[] args) {

        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println("두개의 객체(class)가 동일한가??");
        System.out.println(aClient.equals(bClient ));
    }




}
