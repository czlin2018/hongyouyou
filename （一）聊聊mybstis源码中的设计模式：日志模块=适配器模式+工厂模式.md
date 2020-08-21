## 适配器模式+工厂模式

* 位置
  mybatis基础支持层面-日志模块（org.apache.ibatis.logging）
* 背景
  mybatis日志是开发者的重要的调试工具，帮助了开发者更好的定位问题解决问题。java开发常用的日志框架有Log4j,Log4j2,Apache Commons Log,Java.until.logging.sLF4j等，
  这些工具的对外接口不见相同，为了统一工具的接口，mybatis定义一套统一的接口提供上层使用，并使用适配器模式适配常用的日志框架，
  将组件日志转换成mybatis定义的日志。

```
2020-08-21 17:17:09,870|DEBUG|c.i.c.d.m.B.listByKeys|debug|dao|[http-nio-8090-exec-3]|xlk|icu|127.0.0.1|133455757jhbr2ty5|75007|==>  Preparing: SELECT * FROM department WHERE id IN ( ? ) 
2020-08-21 17:17:09,871|DEBUG|c.i.c.d.m.B.listByKeys|debug|dao|[http-nio-8090-exec-3]|xlk|icu|127.0.0.1|133455757jhbr2ty5|75007|==> Parameters: 3647(Integer)
2020-08-21 17:17:09,875|DEBUG|c.i.c.d.m.B.listByKeys|debug|dao|[http-nio-8090-exec-3]|xlk|icu|127.0.0.1|133455757jhbr2ty5|75007|<==      Total: 1
```

* 日志适配器
  mybatis将来日志级别统一为trance，debug，warn，error四个级别，

  提供了org.apache.ibatis.logging.Log 接口，各个框架的适配器实现类实现此接口。

* 日志适配器工厂
  众多的日志组件适配器由org.apache.ibatis.logging.LogFactory 工厂类进行管理,
  LogFactory中的属性logConstructor 用来记录当前使用的第三方日子组件的适配器
  在

``` 
//记录当前使用的第三方日志主键对应适配器的构造方法
 private static Constructor<? extends Log> logConstructor;

//6个线程加载
按序加载 依次去尝试设置LogFactory会用哪一种Log实现去做日志。
 第一个成功的会塞入logConstructor，用于后面创建mybatis的通用日志接口Logger
 最优先的是slf4j。从上到下一次排列
    
  static {
    tryImplementation(LogFactory::useSlf4jLogging);
    tryImplementation(LogFactory::useCommonsLogging);
    tryImplementation(LogFactory::useLog4J2Logging);
    tryImplementation(LogFactory::useLog4JLogging);
    tryImplementation(LogFactory::useJdkLogging);
    tryImplementation(LogFactory::useNoLogging);
  }
```

以常用的useSlf4jLogging为例

LogFactory::useSlf4jLogging：

```
public static synchronized void useSlf4jLogging() {
    setImplementation(org.apache.ibatis.logging.slf4j.Slf4jImpl.class);
  }
```

setImplementation(Class<? extends Log> implClass)

```
  private static void setImplementation(Class<? extends Log> implClass) {
    try {
    
    //获得适配器的构造函数
      Constructor<? extends Log> candidate = implClass.getConstructor(String.class);
      
    //实例化适配器
      Log log = candidate.newInstance(LogFactory.class.getName());
      
      //检查是否开启
      if (log.isDebugEnabled()) {
        log.debug("Logging initialized using '" + implClass + "' adapter.");
      }
      
      //保存logConstructor参数，记录当前使用的第三方日志主键对应适配器的构造方法
      logConstructor = candidate;
    } catch (Throwable t) {
      throw new LogException("Error setting Log implementation.  Cause: " + t, t);
    }
  }
```

* 启示
  适配器模式可进行接口的相互兼容，工厂可管理众多同类，简介高效。但适配器会增加接口的不可控，当适配器众多，需要考虑重构

