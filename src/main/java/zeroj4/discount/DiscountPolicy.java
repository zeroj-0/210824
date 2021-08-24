package zeroj4.discount;

import zeroj4.member.Member;

public interface DiscountPolicy {

    //여기서의 return값은 할인 대상 금액(=할인이 얼마되었는가에 대한 금액)
   int discount(Member member, int price);
}
