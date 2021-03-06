package happycoffee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="MyPage_table")
public class MyPage {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long memberId;
        private Long orderId;
        private Long productId;
        private Integer orderCnt;
        private Long orderPrice;
        private String orderDate;
        private String orderStatus;


        public Long getMemberId() {
            return memberId;
        }

        public void setMemberId(Long memberId) {
            this.memberId = memberId;
        }
        public Long getOrderId() {
            return orderId;
        }

        public void setOrderId(Long orderId) {
            this.orderId = orderId;
        }
        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }
        public Integer getOrderCnt() {
            return orderCnt;
        }

        public void setOrderCnt(Integer orderCnt) {
            this.orderCnt = orderCnt;
        }
        public Long getOrderPrice() {
            return orderPrice;
        }

        public void setOrderPrice(Long orderPrice) {
            this.orderPrice = orderPrice;
        }
        public String getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(String orderDate) {
            this.orderDate = orderDate;
        }
        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

}
