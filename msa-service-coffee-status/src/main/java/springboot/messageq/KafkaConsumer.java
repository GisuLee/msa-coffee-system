package springboot.messageq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import springboot.repository.ICoffeeStatusMapper;
import springboot.repository.dvo.OrderStatusDVO;

@Service
public class KafkaConsumer {

    @Autowired
    ICoffeeStatusMapper iCoffeeStatusMapper;

    @KafkaListener(topics = "hoony-kafka-test")
    public void processMessage(String kafkaMessage){
        System.out.println("kafka Message ==========> " + kafkaMessage);

        OrderStatusDVO orderStatusDVO = new OrderStatusDVO();
        orderStatusDVO.setOrderHistory(kafkaMessage);

        iCoffeeStatusMapper.insertCoffeeOrderStatus(orderStatusDVO);
    }
}
