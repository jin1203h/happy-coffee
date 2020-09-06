package happycoffee;

public class PaymentCancelDenied extends AbstractEvent {

    private Long id;

    public PaymentCancelDenied(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
