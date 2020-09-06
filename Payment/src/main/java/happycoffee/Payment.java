package happycoffee;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Payment_table")
public class Payment {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @PostPersist
    public void onPostPersist(){
        PaymentApproved paymentApproved = new PaymentApproved();
        BeanUtils.copyProperties(this, paymentApproved);
        paymentApproved.publishAfterCommit();


        PaymentDenied paymentDenied = new PaymentDenied();
        BeanUtils.copyProperties(this, paymentDenied);
        paymentDenied.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){
        PaymentCancelApproved paymentCancelApproved = new PaymentCancelApproved();
        BeanUtils.copyProperties(this, paymentCancelApproved);
        paymentCancelApproved.publishAfterCommit();


        PaymentCancelDenied paymentCancelDenied = new PaymentCancelDenied();
        BeanUtils.copyProperties(this, paymentCancelDenied);
        paymentCancelDenied.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




}
