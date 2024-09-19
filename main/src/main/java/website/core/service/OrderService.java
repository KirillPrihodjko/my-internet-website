package website.core.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import website.repository.OrderRepository;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
}
