package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixedAmountDiscountPolicy implements DiscountPolicy{

    //고정 할인 금액
    private int discountFixedAmount = 1000;

    @Override
    public int discount(Member member,
                        int price) {
        //enum 값은 == 사용
        if(member.getGrade() == Grade.VIP){
            return discountFixedAmount;
        } else {
            return 0;
        }
    }
}
