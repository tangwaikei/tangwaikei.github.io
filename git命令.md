## git命令
### git fork代码之后如何贡献
1. 复制ssh的地址
2. 在本地选中一个仓库，git clone ssh的地址
3. clone完之后，打开.git下的config文件，修改 url,比如我fork的是ssh地址是git@github.com:A/Hogwarts_Online2.git,
改成将你的 github 的帐号名， 替换掉你fork的人的账户名，再在ssh的地址之前加上ssh://
```
url = ssh://git@github.com/tangwaikei/Hogwarts_Online2.git
```
4. git push origin 
![](https://github.com/tangwaikei/tangwaikei.github.io/blob/master/img/git-push.PNG)
