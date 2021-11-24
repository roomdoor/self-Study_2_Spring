public class DollarCalculator implements ICalculator {


    private int pirce = 1;
    private MarketApi marketApi;

    public DollarCalculator(MarketApi marketApi) {
        this.marketApi = marketApi;
    }

    public void init() {
        this.pirce = marketApi.connect();
    }


    @Override
    public int sum(int x, int y) {
        x *= pirce;
        y *= pirce;
        return x + y;
    }

    @Override
    public int minus(int x, int y) {
        x *= pirce;
        y *= pirce;
        return x - y;
    }
}
