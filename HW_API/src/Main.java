import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        NetUtils netUtils = new NetUtils();
        List<Stock> stocks = netUtils.getStocks();

        stocks.sort(new Comparator<Stock>() {
            @Override
            public int compare(Stock o1, Stock o2) {
                Float val1 = o1.getValue();
                Float val2 = o2.getValue();
                return val1.compareTo(val2);
            }
        });

        System.out.println("Самая дешевая была " + stocks.get(0).getDate() +
                " по цене " + stocks.get(0).getValue());

        System.out.println("Самая дорогая была " + stocks.get(stocks.size() - 1).getDate() +
                " по цене " + stocks.get(stocks.size() - 1).getValue());

    }
}