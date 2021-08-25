package zeroj4.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zeroj4.AppConfig;
import zeroj4.member.Grade;
import zeroj4.member.Member;
import zeroj4.member.MemberService;
import zeroj4.member.MemberServiceImpl;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public  void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    /**
     * 기존 코드
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();
     */

    @Test
    void createOrder(){
        //객체 생성 단계에서 null이 들어갈수도 있어서 wrapperClass 사용한 것 (= Long타입)
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
