package domain.repository;

import domain.model.OrderEntity;

public interface ICoffeeOrderRepository {

    public String coffeeOrderSave(OrderEntity orderEntity);
}
