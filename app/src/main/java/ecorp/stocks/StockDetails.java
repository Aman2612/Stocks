package ecorp.stocks;

/**
 * Created by Aman on 12/03/17.
 */

public class StockDetails {

    String symbol;
    String change;
    String bid;
    String currency;

    public StockDetails()
    {

    }

    public StockDetails(String symbol, String change, String bid, String currency) {
        this.symbol = symbol;
        this.change = change;
        this.bid = bid;
        this.currency = currency;
    }


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }



}
