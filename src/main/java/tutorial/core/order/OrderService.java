package tutorial.core.order;

// 주문 서비스 인터페이스
public interface OrderService {
    // (회원 ID, 상품명, 상품가격)으로 주문을 생성
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
