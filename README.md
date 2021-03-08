ocr-rabbitmq-es-demo
===

测试 rabbitmq、es和ocr，目前ocr尚未开始。


## 搭建项目
https://start.spring.io/

选择： 
- Spring Boot 2.4.3
- Spring Boot DevToos
- Lombok
- Spring Web
- Spring for RabbitMQ
- Spring Data Elasticsearch


## docker 配置 rabbitmq、elasticsearch的环境

### docker 建网络如：somenetwork
```s
docker network create somenetwork
```

### docker 启动 rabbitmq
版本： 3-management

```s
## https://www.rabbitmq.com/download.html
docker run -it --rm --name rabbitmq  --net somenetwork -p 5672:5672 -p 15672:15672 rabbitmq:3-management
```
#### 实现延迟队列需要用到插件：[rabbitmq-delayed-message-exchange](https://github.com/rabbitmq/rabbitmq-delayed-message-exchange)
下载：
wget https://github.com/rabbitmq/rabbitmq-delayed-message-exchange/releases/download/3.8.9/rabbitmq_delayed_message_exchange-3.8.9-0199d11c.ez

存放目录： /plugins/

启用：
```s
rabbitmq-plugins enable rabbitmq_delayed_message_exchange
```

### docker 启动 elasticsearch 和 kibana
版本： 7.10.1

```s
## https://hub.docker.com/_/elasticsearch
docker run -d --name elasticsearch --net somenetwork -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" elasticsearch:7.10.1

## https://hub.docker.com/_/kibana
docker run -d --name kibana --net somenetwork -p 5601:5601 kibana:7.10.1
```

## 实现功能：
- elasticsearch数据保存和查询（已完成）
- 消息队列发送和接收，以及延迟消息（消息发送和接收完成，延迟消息未完成，因尚未启用延迟消息插件）
- ocr识别pdf（未开始）

## todo
1. 制作启用延迟插件的镜像，因windows下制作会提示目录问题，所以最好下载插件后制作

尚未测试
```dockerfile
FROM rabbitmq:3.8.14-management
COPY ./rabbitmq_delayed_message_exchange-3.8.9-0199d11c.ez /plugins/

RUN rabbitmq-plugins enable --offline rabbitmq_delayed_message_exchange
```

2. 实现延迟消息(把QueueConfig中的注释取消)

3. ocr