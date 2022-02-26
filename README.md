# work-01

请参考课件内给的示例（[sa-spring/cashregister](https://github.com/sa-spring/cashregister) ），用Spring container的三种configuration中的任意一种，将[AsciiPanel](https://github.com/trystan/AsciiPanel)改造为一个构件系统，要求可以创建`AsciiPanel`和不同的`AsciiFont`构件，并将其进行组装并运行。

例如，可将`CP437_9x16`的`AsciiFont`组装进`AsciiPanel`，

![](https://www.plantuml.com/plantuml/png/SoWkIImgAStDuOfsB4xEp0n8p4lDYLNGrRLJW0YuvUULw3e7c1YRnrjM69h5SZcavgK0rGC0)

或将`CP437_8x8`的`AsciiFont`组装进`AsciiPanel`。

![](https://www.plantuml.com/plantuml/png/SoWkIImgAStDuOfsB4xEp0n8p4lDYLNGrRLJW0YuvUULw3e7c1YRnrjKMCHoEQJcfG2L0m00)

要求Maven工程项目代码，参考示例（[sa-spring/cashregister](https://github.com/sa-spring/cashregister) ），实现至少两个不同的构件系统configration，且包含可直接运行的main函数。

## 使用

（jre/jdk8）一般地构建项目AsciiPanel：

```
mvn install
```

执行`main`：

```
mvn exec:java -Dexec.mainClass="Main"
```


## 完成情况

使用annotation-based config方式配置构件系统。两个不同的具体配置见`src/main/resources/config_8x8`与`src/main/resources/config_16x16`.

Main函数对两个配置对应的实例化容器进行了探索，输出每个容器中Panel类的Font文件名.

```java
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext("config_8x8/config.xml")) {
            AsciiPanel panel1 = context1.getBean(AsciiPanel.class);
            System.out.println("use config for 8x8: " + panel1.getAsciiFont().getFontFilename());
        }
        try (ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext("config_16x16/config.xml")) {
            AsciiPanel panel2 = context2.getBean(AsciiPanel.class);
            System.out.println("use config for 16x16: " + panel2.getAsciiFont().getFontFilename());
        }
    }
```

成功运行，输出如下：

```
use config for 8x8: cp437_8x8.png
use config for 16x16: cp437_16x16.png
```