## git
### git fork代码之后如何贡献
#### 提交代码到仓库
1. 复制ssh的地址
2. 在本地选中一个仓库，git clone ssh的地址
3. clone完之后,需要添加与原始库的关联
打开.git下的config文件，修改 url,比如我fork的是ssh地址是git@github.com:A/Hogwarts_Online2.git,
改成将你的 github 的帐号名， 替换掉你fork的人的账户名，再在ssh的地址之前加上ssh://
```
url = ssh://git@github.com/tangwaikei/Hogwarts_Online2.git
```
4. 提交本地的修改
```
git add 2.txt
git commit -m 'commit'
```
5. 推送到fork的项目
```
git push origin master
```
![](https://github.com/tangwaikei/tangwaikei.github.io/blob/master/img/git-push.PNG)
6. 总结:其实可以clone自己项目的地址，比如git@github.com/tangwaikei/Hogwarts_Online2.git 这样可以不用修改config
直接在本地仓库修改，提交之后推送到远端
![](https://github.com/tangwaikei/tangwaikei.github.io/blob/master/img/%E5%8F%A6%E4%B8%80%E7%A7%8D%E6%96%B9%E6%B3%95.PNG)
#### 发起pr,等待合并
1. 打开自己的Hogwarts_Online2项目下,发起pull request,通知项目人接收
![](https://github.com/tangwaikei/tangwaikei.github.io/blob/master/img/pr.png)
2. 写明修改的主题，提交之后等待合并
#### 同步fork的代码到本地
1. ```git pull origin master```
git pull = git fetch + git merge 
### git工作原理
#### 把数据看作是对小型文件系统的一组快照
- 每次提交更新，或在 Git 中保存项目状态时，它主要对当时的全部文件制作一个快照并保存这个快照的索引
- 文件不修改时，git不会再重新储存文件，只保留一个链接指向之前存储的文件
#### git几乎所有的操作都是本地执行
- git绝大多数操作都只需要访问本地文件和资源
- git所有的操作都是添加，即使删除文件，在git看来也是一种添加
#### git工作区域
- 本地工作目录
- 临时仓库是一个文件，保存了下次将提交的文件列表信息，一般在 Git 仓库目录中。 有时候也被称作‘索引’：将文件的快照放入暂存区域
- git仓库
![](https://progit.bootcss.com/images/areas.png)
git add 是跟踪文件，将文件放进快照流里
```
$ git status
On branch master
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

    new file:   README
```
只要在 Changes to be committed 这行下面的，就说明是已暂存状态
### git命令行
#### 初始化仓库
1. git clone
- git 支持 https://, git://, ssh传输协议, 比如user@server:path/to/repo.git
2. git init , git add 2.txt, git commit -m '2.txt'
#### 查看差异
- git diff 查看工作目录和暂存区域快照之间的差异，也就是修改后还没有暂存的变化。只看到未暂存的改动，不是自上次以来所有的改动
- git diff --cached 查看已经暂存但没有提交的快照

#### 别名
- git config --global alias.st status: git st = git status
- git config --global alias.c-box checkout new-box: git c-box = git checkout new-box

