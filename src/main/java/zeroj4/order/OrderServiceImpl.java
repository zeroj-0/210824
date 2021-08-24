package zeroj4.order;

import zeroj4.discount.DiscountPolicy;
import zeroj4.discount.FixDiscountPolicy;
import zeroj4.discount.RateDiscountPolicy;
import zeroj4.member.Member;
import zeroj4.member.MemberRepository;
import zeroj4.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    /**
     * 추상에만 의존하지 않고 구체클래스에도 의존했었음 (DIP 위반)
     * 그리고 구체클래스를 바꾸는 순간 클라이언트인 OrderServiceImpl의 클래스에서 코드를 변경해주어야함 (OCP 위반)
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final  DiscountPolicy discountPolicy = new RateDiscountPolicy();
     따라서 인터페이스에만 의존하게 하기 위해서는
     */
    //인터페이스에만 의존하도록 설계
    private  DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //주문요청이 들어오면 회원조회를 먼저 한 다음
        Member member = memberRepository.findById(memberId);

        //할인 정책에다가 회원을 넘김
        //최종적으로 할인된 금액 받음
        /**OrderServcie에서의 입장에선 할인같은거 잘모르겠으니 DiscountPolicy 니네가 알아서 해줘, 결과만 나한테 던져줘라는 느낌
        따라서 단일체계원칙이 잘 지켜진것임, 잘 설계된것 */
        int discountPrice = discountPolicy.discount(member, itemPrice);

        //최종 생성된 주문을 반환
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
