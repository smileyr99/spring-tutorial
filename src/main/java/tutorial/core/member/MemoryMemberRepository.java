package tutorial.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    // 동시성 문제가 있을 수 있음 but 예제 이므로 이렇게 진행
    private static Map<Long, Member> store = new HashMap<>();

    // member의 id 저장
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    // Id 찾기
    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
