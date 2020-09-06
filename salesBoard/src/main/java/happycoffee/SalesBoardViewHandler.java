package happycoffee;

import happycoffee.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class SalesBoardViewHandler {


    @Autowired
    private SalesBoardRepository salesBoardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdered_then_CREATE_1 (@Payload Ordered ordered) {
        try {
            if (ordered.isMe()) {
                // view 객체 생성
                SalesBoard salesBoard = new SalesBoard();
                // view 객체에 이벤트의 Value 를 set 함
                salesBoard.setOrderId(ordered.getOrderId());
                salesBoard.setMemberId(ordered.getMemberId());
                salesBoard.setProductId(ordered.getProductId());
                salesBoard.setOrderCnt(ordered.getOrderCnt());
                salesBoard.setOrderPrice(ordered.getOrderPrice());
                salesBoard.setOrderDate(ordered.getOrderDate());
                salesBoard.setOrderStatus(ordered.getOrderStatus());
                // view 레파지 토리에 save
                salesBoardRepository.save(salesBoard);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_UPDATE_1(@Payload OrderCanceled orderCanceled) {
        try {
            if (orderCanceled.isMe()) {
                // view 객체 조회
                Optional<SalesBoard> salesBoardOptional = salesBoardRepository.findByOrderId(orderCanceled.getOrderId());
                if( salesBoardOptional.isPresent()) {
                    SalesBoard salesBoard = salesBoardOptional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    salesBoard.setOrderStatus(orderCanceled.getOrderStatus());
                    // view 레파지 토리에 save
                    salesBoardRepository.save(salesBoard);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenMade_then_UPDATE_2(@Payload Made made) {
        try {
            if (made.isMe()) {
                // view 객체 조회
                Optional<SalesBoard> salesBoardOptional = salesBoardRepository.findByOrderId(made.getOrderId());
                if( salesBoardOptional.isPresent()) {
                    SalesBoard salesBoard = salesBoardOptional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    salesBoard.setMakeStatus(made.getMakeStatus());
                    // view 레파지 토리에 save
                    salesBoardRepository.save(salesBoard);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenMade_then_DELETE_1(@Payload Made made) {
        try {
            if (made.isMe()) {
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}