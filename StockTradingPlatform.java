import java.util.*;
class Stock{String symbol,name;double price;Stock(String s,String n,double p){symbol=s;name=n;price=p;}}
public class StockTradingPlatform{
    static Map<String,Stock> market=new HashMap<>();
    static Map<String,Integer> holdings=new HashMap<>();
    static double balance=10000;
    static List<String> history=new ArrayList<>();
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args){
        market.put("AAPL",new Stock("AAPL","Apple Inc",182.5));
        market.put("TCS",new Stock("TCS","TCS Ltd",3450));
        market.put("INFY",new Stock("INFY","Infosys",1450));
        market.put("RELIANCE",new Stock("RELIANCE","Reliance",2850));
        while(true){
            System.out.println("\n=== CodeAlpha Stock Trading ===");
            System.out.println("1.Market 2.Buy 3.Sell 4.Portfolio 5.History 6.Exit");
            System.out.print("Choose: ");int ch=sc.nextInt();
            if(ch==1){for(Stock s:market.values())System.out.println(s.symbol+" - "+s.name+" $"+s.price);}
            else if(ch==2){System.out.print("Symbol: ");String sym=sc.next().toUpperCase();System.out.print("Qty: ");int q=sc.nextInt();if(market.containsKey(sym)){double c=market.get(sym).price*q;if(balance>=c){balance-=c;holdings.put(sym,holdings.getOrDefault(sym,0)+q);history.add("BUY "+sym+" x"+q);System.out.println("Bought! Balance $"+balance);}else System.out.println("Low Balance");}}
            else if(ch==3){System.out.print("Symbol: ");String sym=sc.next().toUpperCase();System.out.print("Qty: ");int q=sc.nextInt();int own=holdings.getOrDefault(sym,0);if(own>=q){balance+=market.get(sym).price*q;holdings.put(sym,own-q);history.add("SELL "+sym+" x"+q);System.out.println("Sold! Balance $"+balance);}else System.out.println("Own "+own);}}
            else if(ch==4){System.out.println("Balance $"+balance+" Holdings "+holdings);}
            else if(ch==5){System.out.println(history);}else break;
        }
    }
}
