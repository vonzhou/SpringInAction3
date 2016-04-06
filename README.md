# Spring In Action 3rd
---

2016.3.31  阅读《Spring实战3rd》

之前间歇的阅读过，但是只是停留在理解的层面上，想要把每个例子跑通也需要一定的折腾。

## 1. Spring之旅

* 依赖注入
* AOP
* bean的初始化过程
* spring容器
* Spring还有很多值得学习的框架，如安全

[knights](https://github.com/vonzhou/SpringInAction3/tree/master/knights/src/main/java/com/vonzhou/springinaction/knights)

## 2. 装配Bean

* “initialization on demand holder”创建单例模式的理解,参考 [Initialization-on-demand holder idiom](https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom)
* Spring中单例的概念限于Spring上下文中，遵守约定
* 内部bean适用于setter注入和构造器注入，内部bean不能被复用
* SpEL表达式

[springidol](https://github.com/vonzhou/SpringInAction3/tree/master/springidol)

## 3. 最小化Spring XML配置

* 4 种自动装配 byName, byType, contructor, autodetect
* 可以在一个应用上下文中定义多个配置文件，每个配置文件设置自己的默认自动装配策略(default-autowire)
* 如果使用constructor自动装配策略，就不能混合使用constructor-arg
* 注解方式可以实现更细粒度的自动装配，Spring容器默认禁用注解装配，要在配置文件中开启
* \<context:component-scan> 配置自动扫描
* 在基于Java的配置中使用@Configuration注解的Java类，等价于XML配置中的\<beans>元素

[springidol-autodiscovery](https://github.com/vonzhou/SpringInAction3/tree/master/springidol-autodiscovery)

## 4. 面向切面Spring

* Spring只支持方法连接点
* 体会切面的应用场景
* before, after, around advice
* 为advice传递参数
* introduction为已有的接口引入新接口
* at aspect

[springidol-aop](https://github.com/vonzhou/SpringInAction3/tree/master/springidol-aop)

[springidol-aspectj](https://github.com/vonzhou/SpringInAction3/tree/master/springidol-aspectj)

## 5. 征服数据库

* Spring在数据访问层使用模板方法设计模式，模板template管理数据访问过程中固定的部分，回调callback处理自定义的数据访问细节
* 想要控制的越多就越复杂，更多的冗余逻辑，tradeoff
* 使用MySQL数据库
* 体会各种持久化方法的使用




