package strategy;

public class StrategyTest {
    public static void main(String[] args) {

        Encoder encoder = new Encoder();

        EncodingStrategy base64 = new Base64Strategy();

        EncodingStrategy normal = new NormalStrategy();

        EncodingStrategy appendStrategy = new AppendStrategy();

        String message = "hello java";

        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);
        System.out.println(base64Result);

        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);
        System.out.println(normalResult);

        encoder.setEncodingStrategy(appendStrategy);
        String appendStrategyResult = encoder.getMessage(message);
        System.out.println(appendStrategyResult);


    }
}
