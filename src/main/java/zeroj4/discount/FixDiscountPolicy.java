package zeroj4.discount;

import zeroj4.member.Grade;
import zeroj4.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; // 항상 1000원할인으로 고정

    @Override
    public int discount(Member member, int price) {
        //Enum타입은 ==써도 됨
        if (member.getGrade() == Grade.VIP){
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
