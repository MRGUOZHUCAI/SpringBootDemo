package com.gzc.Controller;






import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//@EnableAutoConfiguration
@RestController
public class kafkaController{
    public static Logger logger = LoggerFactory.getLogger(kafkaController.class);

    @Autowired
    private KafkaTemplate<String,String> template;

    @RequestMapping("/addMessage")
    public String addMessage(String topic,String key,String data){
        template.send(topic,key,data);
        return "success";
    }

    @KafkaListener(id="t1",topics = "Topic01")
    public void listenT1(ConsumerRecord<?,?> cr)throws Exception{
        logger.info("{} - {} : {}",cr.topic(),cr.key(),cr.value());
    }

    @KafkaListener(id="t2",topics = "Topic02")
    public void listenT2(ConsumerRecord<?,?> cr)throws Exception{
        logger.info("{} - {} : {}",cr.topic(),cr.key(),cr.value());
    }
}
