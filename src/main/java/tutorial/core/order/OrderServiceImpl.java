package tutorial.core.order;

import tutorial.core.discount.DiscountPolicy;
import tutorial.core.discount.FixDiscountPolicy;
import tutorial.core.member.Member;
import tutorial.core.member.MemberRepository;
import tutorial.core.member.MemoryMemberRepository;

// 주문 서비스 구현체
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); //주문에서는 할인에 관한 설정 안함 - 단일책임원칙이 잘 지켜진 것을 볼 수 있음

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
