AIDL
===
>全称 Android Interface Definition Language<br/>
>>是一种Android内部进程间通信的机制

	只有你允许客户端从不同的应用程序为了进程间的通信而去访问你的service，以及想在你的service处理多线程时才建议使用AIDL。


	

项目包含两个部分   
1. ```app``` 客服端，请求aidl服务<br/>
2. ```remote-app``` 服务端，提供客服端调用的接口服务