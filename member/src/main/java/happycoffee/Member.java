package happycoffee;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Member_table")
public class Member {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long memberId;
    private String memberName;
    private String nickName;
    private String tel;
    private String grade;
    private String birth;
    private Integer orderCnt;

    @PostPersist
    public void onPostPersist(){
        MemberRegistered memberRegistered = new MemberRegistered();
        BeanUtils.copyProperties(this, memberRegistered);
        memberRegistered.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){
        MemberChanged memberChanged = new MemberChanged();
        BeanUtils.copyProperties(this, memberChanged);
        memberChanged.publishAfterCommit();


    }

    @PreRemove
    public void onPreRemove(){
        MemberDeleted memberDeleted = new MemberDeleted();
        BeanUtils.copyProperties(this, memberDeleted);
        memberDeleted.publishAfterCommit();


    }


    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
    public Integer getOrderCnt() {
        return orderCnt;
    }

    public void setOrderCnt(Integer orderCnt) {
        this.orderCnt = orderCnt;
    }




}
