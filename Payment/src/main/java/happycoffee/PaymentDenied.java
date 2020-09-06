package happycoffee;

public class PaymentDenied extends AbstractEvent {

    private Long id;

    public PaymentDenied(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
