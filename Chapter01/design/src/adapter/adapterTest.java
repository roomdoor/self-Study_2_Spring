package adapter;

public class adapterTest {

    // 콘센트
    public static void connect(Electronic110V electronic110V) {
        electronic110V.PowerOn();
    }

    public static void main(String[] args) {

        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);

        AirConditioner airConditioner = new AirConditioner();
        adapter = new SocketAdapter(airConditioner);
        connect(adapter);

    }
}
