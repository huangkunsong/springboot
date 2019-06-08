package com.hks.consumer.amqpRecevice;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.SendTo;

import java.util.Map;

/**
 * 绑定器：将一个或多个接口类作为参数，这些接口类包含表示可绑定组件
 * 用于绑定MQ,如：RabbitMQ中的exchange
 * 在接口中声明需要绑定的exchange
 *     Input为输入绑定,用于接收消息,会自动生成一个绑定的exchange(topic类型)和一个queue
 *     Output为输出绑定,用于输出消息,会自动生成一个绑定的exchange(topic类型)
 * spring自带的input和output绑定可以使用配置修改绑定的名称:
 *      spring.cloud.stream.bindings.input.destination=exchangeName
 *      spring.cloud.stream.bindings.output.destination=exchangeName
 *
 * 消息分组,同一组内的只有每次只有一个实例会获得消息,
 * 将同一应用设置一个group,可以避免一个消息被同应用不同实例多次消费
 * 定义了group在RabbitMQ中生成持久化的{destination}.{group}格式的queue
 * 未声明group的queue为auto-delete的
 *      spring.cloud.stream.bindings.<exchange>.group=queueName
 * 消息分区,同一个组内的消息每次只会被一个实例接收,
 * 无法保证多条消息被同一个组内的同一实例接收处理
 * 消息分区
 *      发生端通过设置分区partition-key表示发送消息的分区ID
 *      接收端设置同一id可以保证该分组内分区ID相同的消息只会被该实例消费
 *      未进行分区指定的实例还是可以接收消息
 * 服务端设置：
 *      设置分区总数
 *      spring.cloud.stream.bindings.{exchange}.producer.partition-count=2
 *      表示该消息发送到分区1(支持使用SpEL表达式根据实际输出消息规则配置分区键)
 *      spring.cloud.stream.bindings.{exchange}.producer.partition-key-expression=1
 * 消费端设置：
 *      表示启用消息分区功能
 *      spring.cloud.stream.bindings.{exchange}.consumer.partitioned=true
 *      表示消息分区的消费端节点数量为2个
 *      spring.cloud.stream.instance-count=2
 *      分区ID为0
 *      spring.cloud.stream.instance-index=0
 *  消息分区本质就是根据分区ID生成的queue为：
 *      {exchange}.{group}.{分区id}
 * 指定消息格式：一般不用指定
 *      spring.cloud.stream.bindings.<exchange>.content-type: application/json
 */
@EnableBinding({Sink.class, Source.class})
public class StreamLisener {

    /**
     * 对绑定的exchang进行监听
     * 有返回值时,可以使用@SendTo注解将返回值转到指定的exchange中
     * StreamListener使用condition指定处理匹配的消息(SpEL)
     *      可以实现消息分发功能
     *      如2个方法
     *          A : @StreamListener(Sink.INPUT, condition="headers['type']=='A'")
     *          B : @StreamListener(Sink.INPUT, condition="headers['type']=='B'")
     * @param
     */
    @StreamListener(Sink.INPUT)
    @SendTo(Source.OUTPUT)
    public String process(Message message, @Headers Map<String, Object> headers) {
        System.out.println(message.getPayload());
        System.out.println(headers);
        return "转发消息";
    }

    @StreamListener(Source.OUTPUT)
    public void outputListener(Message message) {
        System.out.println(message.getPayload());
    }
}
