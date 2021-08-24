package zeroj4;

import zeroj4.member.Grade;
import zeroj4.member.Member;
import zeroj4.member.MemberService;
import zeroj4.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args){
        MemberService memberService = new MemberServiceImpl();
        //1L(L붙인거는 Long타입이라 붙여준거 안해주면 오류남)
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        //가입 확인
        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());

    }
}
