package domain.service;

import domain.model.CoffeeOrderCVO;
import domain.model.OrderEntity;
import domain.repository.ICoffeeOrderRepository;
import org.hibernate.criterion.Order;

public class CoffeeOrder implements ICoffeeOrder{

    private ICoffeeOrderRepository iCoffeeOrderRepository;

    public CoffeeOrder(ICoffeeOrderRepository iCoffeeOrderRepository) {
        this.iCoffeeOrderRepository = iCoffeeOrderRepository;
    }

    @Override
    public String coffeeOrder(CoffeeOrderCVO coffeeOrderCVO) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderNumber(coffeeOrderCVO.getOrderNumber());
        orderEntity.setCoffeeCount(coffeeOrderCVO.getCoffeeCount());
        orderEntity.setCoffeeName(coffeeOrderCVO.getCoffeeName());
        orderEntity.setCustomerName(coffeeOrderCVO.getCustomerName());

        iCoffeeOrderRepository.coffeeOrderSave(orderEntity);

        return orderEntity.getId();
    }
}
