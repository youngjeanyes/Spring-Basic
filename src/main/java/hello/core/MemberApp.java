package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member memberA = new Member(1L, "member_A", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);

        if(memberA.getName().equals(findMember.getName())){
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
    }
}
