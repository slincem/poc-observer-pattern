import observable.Store;
import observer.Customer;

public class Application {

    public static void main(String[] args) {
        Store store = new Store("TechStore");
        Thread threadStore = new Thread(store);
        threadStore.start();

        Customer customer = new Customer("Santiago");
        customer.wantToBeNotifiedOf(store.getProducts().get(0));
    }
}
