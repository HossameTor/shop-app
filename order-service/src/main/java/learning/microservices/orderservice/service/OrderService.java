package learning.microservices.orderservice.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import learning.microservices.orderservice.dto.OrderLineItemsDto;
import learning.microservices.orderservice.dto.OrderRequest;
import learning.microservices.orderservice.model.Order;
import learning.microservices.orderservice.model.OrderLineItems;
import learning.microservices.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderLineItemsList(orderRequest.getOrderLineItemsDtoList().stream()
                .map(orderLineItemDto -> orderLineItemsMapper(orderLineItemDto)).toList());
        order.setOrderNumber(UUID.randomUUID().toString());
        orderRepository.save(order);
    }

    private OrderLineItems orderLineItemsMapper(OrderLineItemsDto orderLineItemsDto){
        OrderLineItems orderLineItems =new OrderLineItems();
        orderLineItems.setId(orderLineItemsDto.getId());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
