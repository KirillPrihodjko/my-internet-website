package website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import website.entity.order.OrderEntity;
import website.entity.order.OrderStatus;
import website.entity.product.ProductEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    OrderEntity findOrderByCustomerName(String customerName);

    OrderEntity findOrderByOrderDate(LocalDateTime orderDate);

    OrderEntity findOrderByStatus(OrderStatus status);

    OrderEntity findOrderByOrderProducts(List<ProductEntity> orderProducts);

    OrderEntity findOrderByTotalPrice(BigDecimal totalPrice);
}
