package zeroj4.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long MemberId);
}
