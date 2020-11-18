package springboot.rest;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import domain.model.CoffeeOrderCVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springboot.messageq.KafkaProducer;
import springboot.service.CoffeeOrderServiceImpl;
import springboot.service.IMsaServiceCoffeeMember;

@RestController
public class CoffeeOrderRestController {

    @Autowired
    private CoffeeOrderServiceImpl coffeeOrderServiceImpl;

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private IMsaServiceCoffeeMember iMsaServiceCoffeeMember;

    @HystrixCommand //장애 극복 어노테이션 (spring cloud Hystrix)
    @RequestMapping(value = "/coffeeOrder", method = RequestMethod.POST)
    public ResponseEntity<CoffeeOrderCVO> coffeeOrder(@RequestBody CoffeeOrderCVO coffeeOrderCVO){

        // is Member ?
        if(iMsaServiceCoffeeMember.coffeeMember(coffeeOrderCVO.getCustomerName())){
            System.out.println(coffeeOrderCVO.getCustomerName() + " is a member!");
        }

        // Coffee Order
        coffeeOrderServiceImpl.coffeeOrder(coffeeOrderCVO);

        //kafka send
        kafkaProducer.send("hoony-kafka-test", coffeeOrderCVO);
        return new ResponseEntity<CoffeeOrderCVO>(coffeeOrderCVO, HttpStatus.OK);
    }
}
