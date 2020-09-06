package happycoffee;

public class PaymentApproved extends AbstractEvent {

    private Long id;

    public PaymentApproved(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
