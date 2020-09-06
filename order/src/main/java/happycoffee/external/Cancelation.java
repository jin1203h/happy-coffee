package happycoffee.external;

public class Cancelation {

    private Long makeId;
    private Long memberId;
    private Long orderId;
    private Long productId;
    private String status;

    public Long getMakeId() {
        return makeId;
    }
    public void setMakeId(Long makeId) {
        this.makeId = makeId;
    }
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}
