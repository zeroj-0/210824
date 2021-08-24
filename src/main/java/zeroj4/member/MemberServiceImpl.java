package zeroj4.member;

public class MemberServiceImpl implements MemberService{

    //회원 가입을하고 회원을 찾으려면 MemberRepository 인터페이스 필요
    //인터페이스만 가지면 null포지션이 터지기 때문에 구현체 설정해주어야함
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        //다형성에 의해서 MemoryMemberReopository의 save() 메소드가 호출됨
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
