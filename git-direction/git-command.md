git常用命令
---
>主要介绍常用的一些git命令

**基础命令**

```
git add 命令（多功能命令，根据目标文件的状态不同，此命令的效果也不同：可以用它开始跟踪新文件，或者把已跟踪的文件放到暂存区，还能用于合并时把有冲突的文件标记为已解决状态等）  
git status 命令，用来查看发生变动的文件。
```

**分支管理**
```
git branch --track experimental origin/experimental 拉取并追踪分支  
git branch -d <branch_name>  删除本地分支  
git push origin --delete branch_3.0_liaoheng  删除远程分支
git branch -vv 查看本地分支和远程分支的跟踪关联关系 
git checkout -b myfeature 以当前分支为基础创建新分支
git branch --set-upstream-to=origin/branch_3.0_liaoheng branch_3.0_liaoheng  将本地分支与远程分支关联
```

**切换git源：**
```
git remote remove origin
git remote add origin  https://xxxx.git  将本地库添加到远程
git push -u origin --all # pushes up the repo and its refs for the first time  上传所有文件
git push -u origin --tags # pushes up any tags
```

**标签管理**
```
git tag -a v1.1.4 -m "tagging version 1.1.4" #打标签
git tag #列出标签
git push --tags  推送所有本地标签到远程仓库
git push 仓库名 标签名  eg. git push origin v1.0       推送本地标签到远程仓库
git push origin --delete tag <tagname> 删除远程tag
git tag -d v1.1.4  删除本地仓库标签
```

**恢复commit**

http://zhyq0826.iteye.com/blog/1671638

reset: 直接回退，将repository的版本进行回退，工作区的状态会根据参数不同有不同的结果

revert：以新提交覆盖旧的提交达到回退的目的，如果修改已经不是最新的commit，则只能使用git revert。

git ls-files --stage 显示index文件（.git目录下） 内容，即暂存区信息