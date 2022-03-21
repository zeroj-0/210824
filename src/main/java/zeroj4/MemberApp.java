package zeroj4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zeroj4.member.Grade;
import zeroj4.member.Member;
import zeroj4.member.MemberService;
import zeroj4.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args){

        //스프링을 사용하는 버전
        //얘네가 다 관리해줌(@Bean처리한 것들)
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        /**
         * 순수자바코드로만 구성된 코드드
       AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
         */

        /**
         * 기존에는 main메소드에서 MemberServiceImpl을 직접 입력해줬음
         * 하지만 위의 코드로 appConfig에서 다 결정됨
        MemberService memberService = new MemberServiceImpl();
         */
        //1L(L붙인거는 Long타입이라 붙여준거 안해주면 오류남)
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        //가입 확인
        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());


    }
}
