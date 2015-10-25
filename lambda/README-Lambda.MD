#Lambda
---
<h3>Outline</h3>

* [Lambda定义和结构](#1)
* [java.util.function（java8功能性接口）](#2)
* [java.util.stream（java8流式接口）](#3)

---


<h3 id="1">一、Lambda定义和结构</h3>
#####Lambda表达式的定义：

	Java8引入Lambda表达式的目的是简化内部类的使用，其实质仍然是一个函数或者接口的实现。
	虽然称作Lambda表达式，但是不同于一般的可计算的表达式，Lambda表达式是一个接口（函数）的实现，也可以理解成匿名类的缩写。

*注：对于一个接口如果有多个未实现的方法，则不能使用Lambda表达式，可以有default和static方法方法*

#####基本结构：
    ( 形式参数 ) -> { 方法实现 }
形式参数的参数类型可以省去，编译器可以自动判断
e.g.
```java
Collections.sort(list, (x, y) -> y - x)
```
上面代码中的Lambda表达式：(x, y) -> y - x 实现的就是 java.util.Comparator 接口的
```int compare(T o1, T o2);```方法，虽然代码中没有显式指明，但是编译器会自动根据语法规则判断，并在编译成字节码时应用这些规则。


#####基本概念

函数式接口。

	如果一个接口定义个唯一一个抽象方法，那么这个接口就成为函数式接口，只有函数式接口才能使用Lambda表达式进行简化。

方法引用

```
1. ClassName:: MethodName 
2. InstanceName:MethodName
3. ClassName::new
```

接口默认方法，在实现接口时就不需要实现Default方法
```java
public interface IDefaultMethod {
    String getString();
    default int getInt(){
        return 1024;
    }
}
```

**编译器自动推导类型**
1. 接口类型
2. 方法参数类型
3. 方法返回值类型

如果不能推导出来那就需要开发者显示指出



<h3 id="2">二、java.util.function（java8功能性接口）</h3>
java.util.function是java8中提供便于Lambda编程的接口，包内全部为接口
[<h3>api文档</h3>](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html)

![](20151024082354783.png)

主要分为
1. Consumer（泛型输入，无输出）
2. Function（泛型输入，泛型输出）
3. Predicate（泛型输入，Boolean输出）
3. Supplier(无输入，泛型输出)
4. UnaryOperator(一元操作，输入一个T，返回一个T，因为继承Function)
5. BinaryOperator(二元操作，输入两个T，返回一个T，因为继承BiFunction)

<h3 id="3">三、java.util.stream</h3>

	流是一种基于集合这种数据源产生的，可以在其上处理一系列操作的对象。



扩展阅读

http://lucida.me/blog/java-8-lambdas-insideout-language-features/

http://www.oschina.net/translate/everything-about-java-8
