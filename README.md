# xRPC
 
####目的:构建一个优秀的服务治理RPC框架
- 基于kryo和FST构建序列化,可自助扩展thrift或者protobuf等序列化协议
- netty5
- 高性能、集群策略丰富、Server端限流、Client Load balance (一致性hash,轮询,随机,低并发优先).
- 弱依赖Spring、考虑SPI扩展
- ZK发现服务、失败重试（Failover)、快速失败（Failfast),[Hystrix](https://github.com/Netflix/Hystrix)容错
- 流量控制、压缩、[Metrics](https://github.com/dropwizard/metrics)统计

>这将是一个漫长的过程..

