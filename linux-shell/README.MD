Linux终端命令
---

包管理工具

1. yum
2. apt-get（Advanced Package Tool）
3. wget
4. rpm（Redhat Package Manager）

远程文件传输sftp

`vsftpd` can support FTPS if configured, but `sftp` runs over ssh.
		
####使用ssh支持的sftp传输文件

1.连接远程ftp服务器
`sftp root@202.206.64.33`

2.拉取远程文件到本地
`sftp> get /var/www/fuyatao/index.php  /home/fuyatao/`
这条语句将从远程主机的  /var/www/fuyatao/目录下将 index.php 下载到本地  /home/fuyatao/目录下。

3.上传本地文件到远程
`sftp> put /home/fuyatao/downloads/Linuxgl.pdf /var/www/fuyatao/`
这条语句将把本地 /home/fuyatao/downloads/目录下的 linuxgl.pdf文件上传至远程主机。

`rename baidu.html index.html * ` 将baidu.html 重命名为index.html

[查找相关命令](http://www.ruanyifeng.com/blog/2009/10/5_ways_to_search_for_files_using_the_terminal.html)  
1. find
2. locate
3. whereis
4. which
5. type


