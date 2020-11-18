package springboot.service;

import domain.model.CoffeeOrderCVO;
import domain.repository.ICoffeeOrderRepository;
import domain.service.CoffeeOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CoffeeOrderServiceImpl extends CoffeeOrder {

    public CoffeeOrderServiceImpl(ICoffeeOrderRepository iCoffeeOrderRepository){
        super(iCoffeeOrderRepository);
    }
}
