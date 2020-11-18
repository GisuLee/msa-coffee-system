package springboot.repository;

import domain.model.OrderEntity;
import domain.repository.ICoffeeOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import springboot.repository.jpa.ICoffeeOrderJpaRepository;
import springboot.repository.jpa.OrderEntityJPO;

public class CoffeOrderRepository implements ICoffeeOrderRepository {

    @Autowired
    private ICoffeeOrderJpaRepository iCoffeeOrderJpaRepository;

    @Override
    public String coffeeOrderSave(OrderEntity orderEntity) {
        OrderEntityJPO orderEntityJPO = new OrderEntityJPO();
        orderEntityJPO.setOrderNumber(orderEntity.getOrderNumber());
        orderEntityJPO.setCoffeeCount(orderEntity.getCoffeeCount());
        orderEntityJPO.setCoffeeName(orderEntity.getCoffeeName());
        orderEntityJPO.setCustomerName(orderEntity.getCustomerName());

        iCoffeeOrderJpaRepository.save(orderEntityJPO);

        return orderEntityJPO.getId();
    }
}
