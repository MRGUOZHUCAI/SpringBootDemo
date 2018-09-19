
package com.gzc.Producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.sql.SQLOutput;
import java.util.Properties;

public class Producer01 {

    public static void main(String[] args){
        Properties properties = new Properties();

        properties.put("bootstrap.servers","192.168.94.128:9092");
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String ,String> producer= null;

        try {
            producer = new KafkaProducer<String,String>(properties);
           for(int i = 0;i < 10; i++ ){
                String msg = "Message info"+i;
               System.out.println("send:"+msg);
                producer.send(new ProducerRecord<String,String>("Topic01",msg));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            producer.close();
        }

    }
}

