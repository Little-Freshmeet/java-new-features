# java-new-features
describe java new features of every version.
Welcome to implement more new features of java new version.


# jdk1.5
1. Generic
2. Annotations
3. Autoboxing/unboxing
3. Static import
4. 
# jdk8(LTS)
1. Lambda expression
2. Function interface
3. Stream API
4. Method reference
5. Default method(日常开发中不要用，default method必须是public且是可以被覆盖的。当一个实现类继承多个接口时，且这些接口有相同的default方法定义，就存在了冲突，这时实现类必须要重写这个冲突的方法)
6. Repeatable annotation(相同的注解可以在一个地方使用多次)
7. New date type
8. Optional
9. Nashorn JavaScript（新的js引擎）
10. G1(正式版)
11. 新引入了一些并发工具类，CompletableFuture，StampedLock，LongAdder, LongAccumulator, DoubleAdder, DoubleAccumulator。

# jdk9(2017.9)
1. ***Module system (project jigsaw)***
2. ***JShell***
3. ***New http client tools(incubator module)***
4. ***String多了压缩处理，会对字符串内容先判断是否是latin1编码，如果是，则直接用latin1编码进行编码，提高效率***
5. 改进的javadoc功能，支持在文档是搜索模块信息。
6. 接口中可以有private方法，private方法必须是实现方法，抽象方法不能是private。因为default方法必须是public，为了将多个default方法中共同的逻辑抽象出来，并且不想让外部访问到，因此就有了private方法。
```java
public class PrivateMethodTest {
    public static void main(String[] args) {
        int i = 4, j = 5;
        MyInterface myInterface = new MyClass();
        myInterface.add(i, j);
        myInterface.product(i, j);
    }
}


interface MyInterface {
    private void log(String param) {
        System.out.println("private method in interface: " + param);
    }

    default void add(int i, int j) {
        log("add method in interface");
        System.out.println("i + j = " + (i + j));
    }

    default void product(int i, int j) {
        log("product method in interface");
        System.out.println("i * j = " + (i * j));
    }
}

class MyClass implements MyInterface {

}
```
7. ***提供了List.of, Map.of(), Set.of()和Map.ofEntries()方法, there can be no duplicate elements in Set.of()***
```java
public class ListOfTest {
    public static void main(String[] args) {
        List<String> list = List.of("a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d");
//        list.remove(1); // throw a exception because of immutable list
        System.out.println(list);

        Set<String> set = Set.of("a", "b", "c", "d");
        System.out.println(set);

        Map<Integer, String> map = Map.ofEntries(Map.entry(1, "a"), Map.entry(2, "b"), Map.entry(3, "c"));
//        map.put(4, "d");
        System.out.println(map);
    }
}
```
8. 多版本兼容jar包，允许可以出现多个不同jdk版本的类
9. Optional类改进，新增了ifPresentOrElse(), or(), stream()。
```java
public class OptionalTest {
    public static void main(String[] args) {
        System.out.println(Optional.empty().or(() -> Optional.of("or default")).get());
        Optional.of("hello").ifPresentOrElse(System.out::println, () -> System.out.println("empty"));
        Optional.empty().ifPresentOrElse(System.out::println, () -> System.out.println("empty"));


        // stream method can be used to convert Optional to Stream
        Optional.of("123").stream().forEach(System.out::println);
        Stream<String> stream = Stream.of(Optional.of("123"), Optional.of("456"), Optional.of("789")).flatMap(Optional::stream);
        System.out.println(stream.collect(Collectors.toList()));


        List<Optional<User>> optionalUserList = new ArrayList<>();
        optionalUserList.add(Optional.of(new User("jack", 18)));
        optionalUserList.add(Optional.empty());
        optionalUserList.add(Optional.of(new User("tom", 25)));

        List<Optional<User>> filteredUserList = optionalUserList.stream().flatMap(Optional::stream).filter(user -> user.age() > 20).map(Optional::of).collect(Collectors.toList());
        filteredUserList.forEach(user -> {if (user.isPresent()) {System.out.println("the eligible person is ：" + user.get().name() + ", he is " + user.get().age());}});
    }
}
```
10. try-with-resource的改进，可以对多个资源进行自动关闭，并会suppressed异常，并且可以从Throwable.getSuppressed()方法获取被阻止的异常信息
```java
public class TryWithResourceTest {
    public static void main(String[] args) {
        // it declared three resources, and they will be closed automatically
        try (
                FileReader fr = new FileReader("~/IdeaProjects/Java21Demo/src/main/resources/file1.txt");
                BufferedReader br = new BufferedReader(fr);
                FileWriter fw = new FileWriter("~/IdeaProjects/Java21Demo/src/main/resources/file2.txt")
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                fw.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
11. ***G1正式可以商用，但并不是默认回收器***
12. ***支持http2.0和WebSocket的API***
13. 改进了JVisualVM，JMC等jvm监控工具
14. 扩大了CDS archive的范围，除了jdk的类之外，应用的类也可以被提前读取的archive中。

# jdk10(2018.3)
1. ***新增var关键字，局部变量推断，可以直接使用var来声明变量***
```java
public class VarTest {
    public static void main(String[] args) {
        var user = new User("Jack", 18);
        System.out.println(user);
    }
}
```
2. ***G1变成多线程版本，提高性能***
3. Optional新增了orElseThrow()方法
```java
public class OptionalTest {
    public static void main(String[] args) {
        Optional.empty().orElseThrow();
    }
}
```

# jdk11(LTS，2018.9)
1. String中新增了strip, stripLeading, stripTrailing, lines, isBlank, repeat六个方法。
```java
public class StringTest {

    public static void main(String[] args) {
        String str = "Hello, ";
        System.out.println(str.repeat(3));

        System.out.println("\n".isBlank());

        String lines = """
                aaa
                bbb
                ccc
                """;
        System.out.println(lines.lines().collect(Collectors.toList()));

        String s = "   Hello, World!\n\n";
        System.out.println(s.strip());
        System.out.println(s.stripLeading());
        System.out.println(s.stripTrailing());
    }
}
```
2. HttpClient重写，支持http2.0，也支持WebSocket
```java

```
3. ***ZGC引入(实验版)***
4. Optional新增了isEmpty()方法
```java
public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optional = Optional.empty();
        if (optional.isEmpty()) {
            System.out.println("empty value");
        }
    }
}
```
5. Files新增readString，writeString两个方法，可以直接读取文件或写入文件。
```java
public class FilesTest {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = FilesTest.class.getClassLoader();
        Path path = Paths.get(classLoader.getResource("application.json").toURI());
        System.out.println(Files.readString(path));

        Path filePath = Paths.get("src/main/resources/application.json");
        System.out.println(Files.readString(filePath));

        // write content to new file
        String content = """
                {
                    "name": "jack",
                    "age": 18
                }
                """;
        String relativePath = "resources/output.json";
        Path targetFilePath = Paths.get(Objects.requireNonNull(FilesTest.class.getClassLoader().getResource("")).getPath(), relativePath);
        try {
            Files.createDirectories(targetFilePath.getParent());
            Files.writeString(targetFilePath, content, StandardCharsets.UTF_8, Files.exists(targetFilePath)? StandardOpenOption.TRUNCATE_EXISTING : StandardOpenOption.CREATE);
            System.out.println("内容已成功写入文件。");
        } catch (IOException e) {
            System.out.println("写入文件时出错：" + e.getMessage());
        }
    }
}
```
6. removal of JavaFX
7. ***G1成为默认回收器***

# jdk12(2019.3)
1. switch expressions(preview, finalized in java14), ***switch表达式增强，可以有返回值，在java14 finalized***
```java
public class SwitchExpressionTest {
    public static void main(String[] args) {
        char c = 'b';

        // don't input break keywork anymore, and can compare with multi values with case.
        switch(c) {
            case 'a' -> System.out.println("a");
            case 'b', 'c' -> System.out.println("b or c");
            default -> System.out.println("default");
        }

        // it can be braced by bracket if there are multi expressions after case
        String season = "spring";
        switch(season) {
            case "spring" -> {
                int count = 10;
                System.out.println("spring" + count);
            }

            case "summer" -> {
                int count = 20;
                System.out.println("summer" + count);
            }

            default -> {
                System.out.println("no count season");
            }
        }

        // it can be used as a return value
        int count = switch(season) {
            case "spring" -> 10;
            case "summer" -> 20;
            default -> 0;
        };
        System.out.println(count);
    }
}
```
2. 支持unicode11
3. ***引入Teeing Collector，可以用于流的并行处理。可以将流用于两个不同的收集器，最后再合并在一起。***
4. ***Shenandoah GC，新增的GC算法***
5. G1收集器的优化，将GC的垃圾分为强制部分和可选部分，强制部分会被回收，可选部分可能不会被回收，提高GC的效率
6. String新增方法：transform、indent、describeConstable、resolveConstantDesc
```java
public class StringTest {
    public static void main(String[] args) throws Exception {
        // indent method is used for indenting a fixed number of spaces
        String originalText = "line1\nline2\nline3";
        // 使用indent方法添加缩进，这里指定缩进4个空格
        String indentedText = originalText.indent(4);
        System.out.println(indentedText);

        String[] lines = {"line1", "line2", "line3"};
        String joinedLines = Stream.of(lines)
                .collect(StringBuilder::new, (sb, line) -> sb.append(line).append("\n"), StringBuilder::append)
                .toString();
        System.out.println("Before indent: \n" + joinedLines);
        String indentedJoinedLines = joinedLines.indent(2);
        System.out.println("After indent: \n" + indentedJoinedLines);


        // transform method is used for transforming a string according to a given format
        originalText = "Hello, World!";
        String transformedText = originalText.transform(String::toUpperCase);
        System.out.println("原始字符串: " + originalText);
        System.out.println("转换后的字符串: " + transformedText);

        Function<String, String> addPrefixFunction = s -> "Prefix: " + s;
        String anotherTransformedString = originalText.transform(addPrefixFunction);
        System.out.println("另一种转换后的字符串: " + anotherTransformedString);

        String str = "hello";
        Optional<?> optionalConstable = str.describeConstable();
        if (optionalConstable.isPresent()) {
            System.out.println("The constant value is: " + optionalConstable.get());
        }

        ConstantDesc constantDesc = (ConstantDesc) optionalConstable.get();
        Object resolvedValue = constantDesc.resolveConstantDesc(MethodHandles.lookup());
        System.out.println(resolvedValue);
    }
}
```
7. compact number formatting, 新增NumberFormat对复杂数字的格式化。一共有两种格式SHORT和LONG，其中英文SHORT就是k和M，LONG就是完整的单词，比如thousand, million. 但是对于中文short和long的格式都是一样的，就是用中文单位。
```java
public class NumberFormatTest {
    public static void main(String[] args) {
        NumberFormat numberFormat1 = NumberFormat.getCompactNumberInstance(Locale.CHINESE, Style.SHORT);
        System.out.println(numberFormat1.format(1000));
        System.out.println(numberFormat1.format(100000));
        System.out.println(numberFormat1.format(1000000));

        NumberFormat numberFormat4 = NumberFormat.getCompactNumberInstance(Locale.CHINESE, Style.LONG);
        System.out.println(numberFormat1.format(1000));
        System.out.println(numberFormat1.format(100000));
        System.out.println(numberFormat1.format(1000000));

        NumberFormat numberFormat2 = NumberFormat.getCompactNumberInstance(Locale.US, Style.SHORT);
        System.out.println(numberFormat2.format(1000));
        System.out.println(numberFormat2.format(100000));

        NumberFormat numberFormat3 = NumberFormat.getCompactNumberInstance(Locale.US, Style.LONG);
        System.out.println(numberFormat3.format(1000));
        System.out.println(numberFormat2.format(100000));
    }
}
```
# jdk13(2019.9)
1. ***switch表达式增加，可以使用yield关键字来返回结果，相当于return。如果没有结果则相当于break。***
```java
// we also can use traditional switch to return value, but we must use yield keyword
// and yield contains break.
int gender = 1;
String sex = switch(gender) {
    case 1:
        yield "male";
    case 2:
        yield "female";
    default:
        yield "unknown";
};

System.out.println(sex);
```
2. ***text block(preview)，在java15中finalized, 可以在文本前后使用三个双引号"""来表示文本块。比如一个json文本，中间就不用加换行符了，直接头和尾加上"""，中间正常换行就可以。并且该方式的json字符串可以直接被转换成对象。***
```java
public class TextBlockTest {
    private String testJson = """
            {
                "name": "Jack",
                "age": 18
            }
            """;
    public static void main(String[] args) throws Exception {
        System.out.println(new TextBlockTest().testJson);
        User user = new ObjectMapper().readValue(new TextBlockTest().testJson, User.class);
        System.out.println(user.toString());
    }
}
```

3. SocketAPI底层优化，引入了NIO
4. ZGC优化，增强 ZGC 释放未使用内存，将标记长时间空闲的堆内存空间返还给操作系统，保证堆大小不会小于配置的最小堆内存大小，如果堆最大和最小内存大小设置一样，则不会释放内存还给操作系统

# jdk14(2020.3)
1. pattern matching for instanceof(preview, finalized in java16), ***instanceof优化，可以直接赋值，if (a instanceof String b)，如果a是String类型，则直接将b赋值给a。在java16中最终finalized。***
```java
public class InstanceOfTest {
    public static void main(String[] args) {
        User user = new User("jack", 18);
        if (user instanceof Object aaa) {
            System.out.println(aaa);
        }
    }
}
```
2. ***add record keyword(preview, finalized in java16)，introduce the record type. It's used for creation of readonly class. It means the class doesn't have set methods and the value of variable won't be modified after object created***
```java
public class RecordTest {
    public static void main(String[] args) {
        User user = new User("jack", 18);
        System.out.println(user.name() + "," + user.age());
    }
}

record User(String name, int age) {
}
```
inner record class must be static, when we compiled the following codes, it will show us a compile error: variable out must be static. Because record Inner must be static by default. and non-static variable can be accessed in a static class.
***Note: In JDK17, inner Enum, inner Interface, inner Record will be static by default.***
```java
class Outer {
    int out;
    record Inner(String name) {
        
        public void test() {
            System.out.println(out);
        }
    }
}
```

if you want to define constructor of record class by yourself,
a. if the params are not the same with default constructor, it must invoke the default constructor directly or indirectly.
b. if the params are the same, you can use the following method, it will omit assignments of variable and parentheses after the method name.
```java
public class RecordConstructorTest {
    public static void main(String[] args) {
        Person person = new Person("jack", 12);
    }
}

record Person(String name, int age) {
    // define the constructor which has the same params, it doesn't need to write () behind the name
    public Person {

        // it will omit this.name = name and this.age = age, but actually it will do it
        if (age > 10) {
            System.out.println("age is too big");
        }
    }


    public Person(String name, int age, int gender) {
        // must invoke the default constructor directly or indirectly
        this(name, age);
        System.out.println("gender is " + gender);
    }

    public Person(String name, int age, int gender, String address) {
        // invoke the default constructor indirectly
        this(name, age, gender);
    }
}
```
3. 改进NPE异常的抛出信息，会指明是具体哪个变量是null，防止同一行代码中调用多个方法时不好排查。不用像之前那样自己去找哪个变量甚至是debug来找出哪个变量为null。
```java
public class NewNPETest {
    public static void main(String[] args) {
        User user = null;
        System.out.println(user.age());
    }
}
```
以上代码抛出的异常如下：其中会直接指出user变量为null。
```text
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "com.jack.newfeature.java14.User.age()" because "user" is null
	at com.jack.newfeature.java14.NewNPETest.main(NewNPETest.java:6)
```
4. ***Removal of CMS Garbage Collector***
5. switch expressions(finalized)

# jdk15(2020.9)
1. 引入EdDSA数字签名算法，具有更高的安全性和效率。
2. sealed class（preview, finalized in java17），使用sealed关键字可以规定的子类才可以继承抽象类，防止抽象类被滥用。sealed class可以是抽象类。如果有其他类继承，则会直接报编译错误。
```java
/**
 * 如果子类与父类是在同一个源文件中，可以是内部类，也可以不是，就可不用写permits关键字及后面的子类名.
 * 也就是说不写permits关键字，默认就只允许同一个源文件中的类来继承，外部的类是不允许继承的。
 */
sealed class Shape permits Circle {
}

/**
 * sealed class的子类必须是final, sealed, non-sealed
 */
final class Circle extends Shape {
}

final class Triangle extends Shape {
}
```
3. 隐藏类，隐藏类是在运行时动态创建并加载，主要是用于JDK内部的优化，这些类不会直接被开发人员使用，也无法找到对应的字节码，只能在运行时生成。
4. ***ZGC正式商用***
5. text block(finalized)
6. Hidden class for frameworks
7. 移除Nashorn JavaScript Engine.

# jdk16(2021.3)
1. ZGC性能优化，去掉ZGC线程堆栈处理从安全点到并发阶段
2. 弹性元空间能力
3. 提供用于打包独立Java应用程序的jpackage工具，可以将java应用打包成一个可安装的文件，不用本地再提前安装jdk了。
4. records(finalized)
5. Pattern Matching for instanceof (Finalized).
6. strong encapsulation of JDK internals by default. Most internal classes in the sun.* and com.sun.* packages are no longer accessible unless explicitly allowed using JVM flags.
```java
public class UnsafeDemo {
    public static void main(String[] args) throws Exception {
        // Accessing Unsafe
        Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);

        // Allocating memory directly
        long memoryAddress = unsafe.allocateMemory(8L);
        unsafe.putLong(memoryAddress, 42L);
        System.out.println("Value at memory address: " + unsafe.getLong(memoryAddress));
        unsafe.freeMemory(memoryAddress);
    }
}
```
上面的代码如果直接在jdk16中就会报错，但是在jdk21中，java官方又让内部的类可以运行了。所以这个特性只作为了解即可。
7. Vector API(incubator)，Vector API是java用来在CPU的架构上执行矢量计算的工具。它提供了一种简洁的编程模型，让开发者能够利用现代 CPU 中的单指令多数据（SIMD）指令集来加速计算。通过使用 Vector API，可以同时对多个数据元素进行相同的操作，减少循环开销，提高计算性能，特别适用于处理数组、矩阵等数据密集型的计算场景，如科学计算、图形处理、机器学习等领域中的向量和矩阵运算。


***jdk16相当于是把jdk14,15的很多特性正式引入，以前都是预览版本***

# jdk17(LTS，2021.9)
1. sealed class(finalized)
2. 恢复了始终严格模式（Always-Strict）的浮点语义，float更加精准了，但是依然不建议直接使用float进行精度计算。因为以前是在方法上面加strictfp关键字，来让浮点数的运算来严格按IEEE754的标准来运算。如果不加这个关键字，很可能因为不同平台的优化导致相同的浮点运算在不同的平台计算的结果会有细微的差别。现在恢复之后，就不用再加这个关键字了，只要是浮点运算就会都统一按照754的标准来计算。
3. 移除AOT 和 JIT 编译器的实验特性，移植到了graalvm当中。
4. Deprecation of the Applet API.
5. Removal of RMI Activation.
6. enhancement in switch expression, add pattern matching
```java
public class SwitchPatternMatchingTest {
    public static void main(String[] args) {
        Object obj = "123";
        switch (obj) {
            case Integer i -> System.out.println("Integer: " + i);
            case String s -> System.out.println("String: " + s);
            default -> System.out.println("Unknown");
        }
    }
}
```
# jdk18(2022.3)
1. UTF-8成为默认编码
2. 引入jwebserver，仅提供静态文件的最小网络服务器，不提供CGI或servlet功能。仅用于编码或测试。
```java
public class SimpleWebServerTest {
    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8000), 0);
        httpServer.createContext("/", new MyHttpHandler());
        httpServer.start();
        System.out.println("JDK 18简单Web服务器已启动，监听端口8000...");
    }
}

class MyHttpHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=utf-8");
        exchange.sendResponseHeaders(200, 0);
        OutputStream os = exchange.getResponseBody();
        String htmlResponse = """
                {
                    "name": "Jack",
                    "age": 18
                }    
                """;
        os.write(htmlResponse.getBytes(Charset.forName("utf-8")));
        os.close();
    }
}
```
3. Vector API enhancements
# JDK19(2022.9)
1. Virtual threads(Preview)
```java
public class VirtualThreadTest {
    public static void main(String[] args) {
        // Create a virtual thread
        Thread virtualThread = Thread.ofVirtual().start(() -> {
            System.out.println("Hello from virtual thread!");
        });

        try {
            virtualThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create multiple virtual threads
        for (int i = 0; i < 10; i++) {
            Thread.ofVirtual().start(() -> {
                System.out.println("Running virtual thread: " + Thread.currentThread());
            });
        }
    }
}
```
2. Structured concurrency (Incubator).
3. Foreign function and memory API (Preview).允许 Java 程序与本地代码（比如用 C、C++ 等语言编写的代码）进行交互，调用外部函数以及直接操作外部内存，
4. Improvements to the Vector API.
5. switch pattern matching (Second Preview).
6. support null-safe handling and guarded pattern(when clause) in switch
```java
public class SwitchNullWhenTest {
    public static void main(String[] args) {
        String str = "aaaa";
        switch (str) {
            case String i when i.length() > 3 -> System.out.println("the length is greater than 10");
            case "hello" -> System.out.println("hello");
            case "world" -> System.out.println("world");
            case null -> System.out.println("null");
            default -> System.out.println("default");
        }
    }
}
```
# JDK20(2023.3)
1. Enhanced Virtual Threads (2nd Preview).
2. Scoped values for thread-local-like data sharing.
3. Continuation of Foreign function/memory API (2nd Preview).
4. Pattern Matching for switch (Third Preview)

# JDK21(LTS, 2023.9)
1. Virtual Threads(Stable)
2. Sequenced collections API.
3. String Templates (Preview).
```java
public class StringTemplateTest {
    public static void main(String[] args) {
        String name = "Bob";
        int age = 25;
        Date now = new Date();
        String template = "姓名：%s, 年龄：%s, 当前时间：%s";
//        String result = template.replace("${name}", name).replace("${age}", String.valueOf(age)).replace("${now}", now.toString());
        String result = template.formatted(name, age, now);
        // if they're same between vars in string and real var, you can use the following syntax
//        String result2 = introduction.formatted(name, age, now);

        System.out.println(result);
    }
}
```
4. pattern matching in switch became a standard feature
5. Enhanced pattern matching for switch.


# Appendix
new feature link of Oracle offical website:

[Java 1.5-1.8](https://docs.oracle.com/javase/8/docs/technotes/guides/language/enhancements.html)

[Java 9](https://docs.oracle.com/javase/9/whatsnew/toc.htm#JSNEW-GUID-C23AFD78-C777-460B-8ACE-58BE5EA681F6)

[Java 10](https://docs.oracle.com/javase/10/whatsnew/whatsnew.html)

[Java 11](https://docs.oracle.com/en/java/javase/11/whatsnew/index.html)

[Java 12](https://docs.oracle.com/en/java/javase/12/whatsnew/index.html)

[Java 13](https://docs.oracle.com/en/java/javase/13/whatsnew/index.html)

[Java 14](https://docs.oracle.com/en/java/javase/14/whatsnew/index.html)

[Java 15](https://docs.oracle.com/en/java/javase/15/whatsnew/index.html)

[Java 16](https://docs.oracle.com/en/java/javase/16/whatsnew/index.html)

[Java 17](https://docs.oracle.com/en/java/javase/17/whatsnew/index.html)

[Java 18](https://docs.oracle.com/en/java/javase/18/whatsnew/index.html)

[Java 19](https://docs.oracle.com/en/java/javase/19/whatsnew/index.html)

[Java 20](https://docs.oracle.com/en/java/javase/20/whatsnew/index.html)

[Java 21](https://docs.oracle.com/en/java/javase/21/whatsnew/index.html)

[Java 22](https://docs.oracle.com/en/java/javase/22/whatsnew/index.html)

[Java 23](https://docs.oracle.com/en/java/javase/23/whatsnew/index.html)

[Java 24](https://openjdk.org/projects/jdk/24/) ，此为 Java 24 的 OpenJDK 项目页面，由于 Java 24 尚未正式发布，可通过该页面关注其特性开发进展.