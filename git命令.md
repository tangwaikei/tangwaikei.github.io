## git命令
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
git commit -a -m 'commit'
```
5. 推送到fork的项目
```
git push origin master
```
![](https://github.com/tangwaikei/tangwaikei.github.io/blob/master/img/git-push.PNG)
#### 发起pr,等待合并
1. 打开自己的Hogwarts_Online2项目下,发起pull request,通知项目人接收
![](https://github.com/tangwaikei/tangwaikei.github.io/blob/master/img/pr.png)
2. 写明修改的主题，提交之后等待合并
#### 同步fork的代码到本地
1.```git pull ```
