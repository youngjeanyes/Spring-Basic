package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixedAmountDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

/**
 * * 구성영역
 * */
public class AppConfig {

    /**
     * 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자로 주입(연결)함
     * */

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    public DiscountPolicy discountPolicy(){
//        return new FixedAmountDiscountPolicy();
        return new RateDiscountPolicy();        //-> 할인 정책 변경 (이것만 변경)
                                                //-> *** 사용 영역은 바꿀 이유가 전혀 없다!!
    }


}
