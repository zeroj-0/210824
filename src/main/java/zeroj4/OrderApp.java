package zeroj4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zeroj4.member.Grade;
import zeroj4.member.Member;
import zeroj4.member.MemberService;
import zeroj4.member.MemberServiceImpl;
import zeroj4.order.Order;
import zeroj4.order.OrderService;
import zeroj4.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {

        //스프링으로 변환한 코드
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService",OrderService.class);

        /**
         * 순수 자바 코드
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
         */

//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
