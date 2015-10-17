内存优化
---

**参考博文**

1. http://blog.csdn.net/innost/article/details/9008691
2. http://www.trinea.cn/android/performance/
3. http://hukai.me/android-performance-patterns/

**主要工具**

1. Eclipse插件 MAT memory analyser tool
2. LeakCanary

**[常见内存问题](http://blog.csdn.net/gemmem/article/details/13017999)** 

**MAT使用教程**

http://inter12.iteye.com/blog/1407492  
http://www.importnew.com/2433.html  

**其他**

[Shallow heap & Retained heap 区别](http://bjyzxxds.iteye.com/blog/1532937 )  
list objects -- with outgoing references : 查看这个对象持有的外部对象引用。  
list objects -- with incoming references : 查看这个对象被哪些外部对象引用。  
static对象不会被gc回收