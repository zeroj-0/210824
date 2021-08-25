package zeroj4.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zeroj4.AppConfig;

public class MemberServiceTest {

    MemberService memberService;

    //@BeforeEach는 Test가 진행되기전에 반드시 진행되는 것
    @BeforeEach
    public  void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    /**
     * 기존 코드
    //테스트 코드 만들기
    MemberService memberService = new MemberServiceImpl();
     */

    @Test
    void join(){
        //given
        Member member = new Member(1L,"memberA",Grade.VIP);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
