package zeroj4;

import zeroj4.member.Grade;
import zeroj4.member.Member;
import zeroj4.member.MemberService;
import zeroj4.member.MemberServiceImpl;
import zeroj4.order.Order;
import zeroj4.order.OrderService;
import zeroj4.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
