import java.util.*;

class Product implements Comparable<Product>{
    String id;
    String price;
    public Product(String id, String price){
        this.id = id;
        this.price = price;
    }
    @Override
    public boolean equals(Object product){
        if(!((Product)product).id.equals(id))
            return false;
        if(!((Product)product).price.equals(price))
            return false;
        return true;
    }
    @Override
    public int hashCode(){
        return (id.hashCode()*37+100+price.hashCode())+100;
    }
    @Override
    public int compareTo(Product product){
        int result = id.compareTo(product.id);
        if(result!=0)
            return result;
        else{
            return price.compareTo(product.price);
        }
    }
}

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Set<Product> preSet = new HashSet<Product>();
        Set<Product> nowSet = new HashSet<Product>();
        for(int i=0; i<n; i++){
            int m = in.nextInt();
            in.nextLine();
            nowSet = new HashSet<Product>();
            for(int j=0; j<m; j++){
                String line = in.nextLine();
                String[] items = line.split(" ");
                String id = items[0];
                String price = items[2];
                Product product = new Product(id, price);
                if(i==0){
                    nowSet.add(product);
                }
                else{
                    if(preSet.contains(product))
                        nowSet.add(product);
                }
            }
            preSet = nowSet;
        }
        Set<Product> sortSet = new TreeSet<>();
        Iterator<Product> it = nowSet.iterator();
        while(it.hasNext()){
            sortSet.add(it.next());
        }
        it = sortSet.iterator();
        while(it.hasNext()){
            System.out.println(it.next().id);
        }
    }
}
