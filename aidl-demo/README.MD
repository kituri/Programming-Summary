AIDL
===
>全称 Android Interface Definition Language<br/>
>>是一种Android内部进程间通信的机制

	只有你允许客户端从不同的应用程序为了进程间的通信而去访问你的service，以及想在你的service处理多线程时才建议使用AIDL。


	

<h3>项目包含两个部分</h3>   
1. `app` 客服端，请求aidl服务<br/>
2. `remote-app` 服务端，提供客服端调用的接口服务


<h3>使用流程</h3>  
1. 在服务端声明一个aidl接口，build后产生java文件，里面包含有IBinder的子类和proxy类,同时创建service类用于响应客户端的AIDL请求<br/>
2. 客服端将服务端的AIDL接口拷贝过去，然后build也会产生一个java文件，在代码中通过`ServiceConnection`类连接远程服务并在其方法中获得AIDL接口对象就可以调用自己定义的方法了 