package happycoffee;

import happycoffee.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverProductOutOfStock_OutOfStockCancel(@Payload ProductOutOfStock productOutOfStock){

        if(productOutOfStock.isMe()){
            System.out.println("##### listener OutOfStockCancel : " + productOutOfStock.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverProductOutOfStock_OutOfStockCancel(@Payload ProductOutOfStock productOutOfStock){

        if(productOutOfStock.isMe()){
            System.out.println("##### listener OutOfStockCancel : " + productOutOfStock.toJson());
        }
    }

}
