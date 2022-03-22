package com.example.demo;

import java.util.Properties;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer09;
import org.apache.flink.streaming.util.serialization.SimpleStringSchema;



public class ReadFromKafka {


  public static void main(String[] args) throws Exception {
    // create execution environment
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

    Properties properties = new Properties();
    properties.setProperty("bootstrap.servers", "localhost:9092");
    properties.setProperty("group.id", "flink_consumer");


    DataStream<String> stream = env
            .addSource(new FlinkKafkaConsumer09<>("flink-demo", new SimpleStringSchema(), properties));

    stream.map(new MapFunction<String, String>() {
      private static final long serialVersionUID = -6867736771747690202L;

      @Override
      public String map(String value) throws Exception {
        return "Stream Value: " + value;
      }
    }).print();

    env.execute();
  }


}