package happycoffee;

public class PaymentCancelApproved extends AbstractEvent {

    private Long id;

    public PaymentCancelApproved(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
