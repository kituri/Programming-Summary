Linux基础与终端命令
---
关于Linux常用目录：

1. http://www.ruanyifeng.com/blog/2012/02/a_history_of_unix_directory_structure.html
2. https://en.wikipedia.org/wiki/Filesystem_Hierarchy_Standard
3. http://cnbin.github.io/blog/2015/06/05/mac-os-x-de-xi-tong-mu-lu-jie-gou/

关于 - & -- 的区别

http://serverfault.com/questions/387935/whats-the-difference-betwen-the-single-dash-and-double-dash-flags-on-shell-comm

###查看进程占用端口的方式
1. lsof(list open files)	
2. ps


以查看1099端口为例：

```
lsof -i :1099
ps -ef | grep 1099
```
终止相关进程

```
sudo kill -9 PID
```


####包管理工具

1. yum
2. apt-get（Advanced Package Tool）
3. rpm（Redhat Package Manager）



		
####使用ssh支持的sftp传输文件到服务器

`vsftpd` can support FTPS if configured, but `sftp` runs over ssh.

1.连接远程ftp服务器
`sftp root@202.206.64.33`

2.拉取远程文件到本地
`sftp> get /var/www/fuyatao/index.php  /home/fuyatao/`
这条语句将从远程主机的  /var/www/fuyatao/目录下将 index.php 下载到本地  /home/fuyatao/目录下。

3.上传本地文件到远程
`sftp> put /home/fuyatao/downloads/Linuxgl.pdf /var/www/fuyatao/`
这条语句将把本地 /home/fuyatao/downloads/目录下的 linuxgl.pdf文件上传至远程主机。


####常用命令

`ipconfig getifaddr en0`  获取WIFI局域网IP地址 

`wget&&curl 下载`

`grep 文本搜索工具`  


`rename baidu.html index.html * ` 将baidu.html 重命名为index.html

[查找相关命令](http://www.ruanyifeng.com/blog/2009/10/5_ways_to_search_for_files_using_the_terminal.html)

[find和grep的区别:](http://www.cnblogs.com/xudong-bupt/archive/2013/03/23/2976793.html)

find查找的文件的属性，grep查找的是文件的内容

`find . -name "*Dao*" -exec rm -rf {} \; 查找当前目录所有文件名包含Dao的文件并将他们删除`
`ps -ef | grep nginx 查找和nginx有关系的进程列表`

`|` :管道命令，将上个命令的输出作为下个命令的输入
 
1. find
2. locate
3. whereis
4. which
5. type

####用户和权限管理

1. **用户和用户组**

	用户和用户组的关系可以是1.一对一 2.一对多 3.多对多 4.多对一
	
2. **权限管理**

	一个文档的所有者只能有一个用户
	
3. **chmod&chown命令**

		chown更改文档的属主，指定 有且只有一个用户。
		chomod更改文件的权限，包括user（属主），group（与属主同一个用户组），		everyone（其他用户）对文件的rwx权限，7表示全部权限开通
		
####后台运行程序
```nohup 'command line' &```



