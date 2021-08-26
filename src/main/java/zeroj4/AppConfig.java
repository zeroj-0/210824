package zeroj4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zeroj4.discount.DiscountPolicy;
import zeroj4.discount.FixDiscountPolicy;
import zeroj4.discount.RateDiscountPolicy;
import zeroj4.member.MemberService;
import zeroj4.member.MemberServiceImpl;
import zeroj4.member.MemoryMemberRepository;
import zeroj4.order.OrderService;
import zeroj4.order.OrderServiceImpl;

//애플리케이션의 전제 동작 방식을 구성하기 위해, 구현객체를 생성하고 연결하는 책임을 가지는 별도의 클래스
//스프링 기반으로 바꾸기위한 어노테이션 작성(@Configuration, @Bean)
@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        //MemberServiceImpl을 만들고 내가 만든 Imple을 MemoryMemberRepository로 쓸거라는 뜻
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    //역할을 제대로 보여주기위해서 메소드로 빼놓은 것
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        //생성자로 MemoryMemberRepository, FixDiscountPolicy 넣음
        //OrderServiceImpl이 MemoryMemberRepository, FixDiscountPolicy 객체를 참조하도록 하고
        //완성된 OrderServiceImpl 객체를 반환
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
