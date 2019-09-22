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
#### 初始化仓库 init clone
1. git clone
  - git 支持 https://, git://, ssh传输协议, 比如user@server:path/to/repo.git
2. git init , git add 2.txt, git commit -m '2.txt'
#### 建立仓库
```
git clone ssh地址
cd tangwaikei
touch README.md
git add README.md
git commit -m "add README"
git push -u origin master

Push an existing folder
cd existing_folder
git init
git remote add origin ssh地址
git add .
git commit -m "Initial commit"
git push -u origin master

Push an existing Git repository
cd existing_repo
git remote rename origin old-origin
git remote add origin ssh地址
git push -u origin --all
git push -u origin --tags
```
#### 查看差异 diff
- git diff 查看工作目录和暂存区域快照之间的差异，也就是修改后还没有暂存的变化。只看到未暂存的改动，不是自上次以来所有的改动
- git diff --cached 查看已经暂存但没有提交的快照
- vimdiff 交互式
#### 提交 commit
- 提交时未暂存的仍然保持已修改状态，可下次提交时纳入版本管理
- git commit -a 将已经跟踪过的文件（这个文件是已经存在的文件即可）暂存起来一并提交
#### 删除文件 rm
1. 工作目录删除 rm xxx 
2. git rm xxx 已经提交到仓库
```
$ git st
On branch master
Your branch is ahead of 'origin/master' by 1 commit.
  (use "git push" to publish your local commits)
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)
        deleted:    3.txt
```
#### 撤销
- git commit --amend 提交完之后漏掉添加几个文件，或者需要重写提交信息，将暂存区的重新提交【前提：提交完之后立马执行该命令】
- 取消暂存的文件 git reset HEAD <file>
- 撤销对文件的修改 git checkout -- <file> 对file的任何修改都会消失
- 已经提交的文件可以恢复，但未提交的文件丢失后可能找不回
  
#### 查看提交历史 log
- 上面的原理提到git绝大多数操作都只需要访问本地文件和资源，所以git log 不需要访问外网
- git log -p -2 查看最近2次提交的内容差异
- git log --stat 查看每次提交的简略统计信息
- 其他的提交记录建议用GUI图形工具
#### 查看远程仓库 git remote -v
```
origin	https://github.com/schacon/ticgit (fetch)
origin	https://github.com/schacon/ticgit (push)
```
git remote show origin 查看远程仓库的信息  
当你想分享你的项目时，必须将其推送到上游。 这个命令很简单：git push [remote-name] [branch-name]
#### 别名 alias 
- git config --global alias.st status: git st = git status
- git config --global alias.c-box checkout new-box: git c-box = git checkout new-box
- 执行外部命令，而不是一个 Git 子命令。 如果是那样的话，可以在命令前面加入 ! 符号
#### 推送到远程仓库 push
在当前分支git push --set-upstream origin branch
执行完之后可以直接 git push 默认推送到origin/branch上
### 分支
#### 分支原理：暂存会将文件计算校验和，将当前版本的文件快照保存在git仓库 
- git commit时，Git 会先计算每一个子目录（本例中只有项目根目录）的校验和，然后在 Git 仓库中这些校验和保存为树对象。 随后，Git 便会创建一个提交对象，它除了包含上面提到的那些信息外，还包含指向这个树对象（项目根目录）的指针 
- Git 仓库中有五个对象：三个 blob 对象（保存着文件快照）、一个树对象（记录着目录结构和 blob 对象索引）以及一个提交对象（包含着指向前述树对象的指针和所有提交信息）
![](https://progit.bootcss.com/images/commit-and-tree.png)
#### 分支新建与合并  
##### HEAD  
- HEAD 指向当前所在的本地分支  
- HEAD随着提交自动向前移动
![](https://progit.bootcss.com/images/checkout-master.png)
##### 快进fast-forward
- 由于当前 master 分支所指向的提交是你当前提交（有关 hotfix 的提交）的直接上游，所以 Git 只是简单的将指针向前移动。 换句话说，当你试图合并两个分支时，如果顺着一个分支走下去能够到达另一个分支，那么 Git 在合并两者的时候，只会简单的将指针向前推进（指针右移），因为这种情况下的合并操作没有需要解决的分歧
![](https://progit.bootcss.com/images/advance-testing.png)  
##### 命令行  
- git checkout -b new_branch 创建new_branch新分支，并切换到new_brach
- git branch -d new_branch 删除new_branch分支【此时不在new_branch分支上】  
- git add 在解决冲突之后要暂存，标记冲突已解决
- git branch --merged 查看哪些分支已经合并到当前分支
- git branch --no-merged 查看所有包含未合并工作的分支 
- git merge --abort 放弃合并
- git log --graph --all --decorate=short 查看
##### 本地生成远程分支[操作前远程分支不存在]
```
git checkout -b new-branch origin/branch
git push origin branch
git branch --set-upstream-to=origin/branch
git pull origin branch
```
##### 本地创建远程分支[操作前远程分支已存在]
```
git checkout -b branch origin/branch
```
##### 删除本地分支
```
git checkout master
git branch -d branch
```
##### 拉取更新远程分支
git pull origin
git checkout 到本地没有的分支，可以直接push 到非保护分支
#### 分支开发工作流  
##### 长期分支的开发周期
- 稳定分支的指针总是在提交历史中落后一大截，而前沿分支的指针往往比较靠前  
- 想象成流水线（work silos）可能更好理解一点，那些经过测试考验的提交会被遴选到更加稳定的流水线上去
- 使你的分支具有不同级别的稳定性；当它们具有一定程度的稳定性后，再把它们合并入具有更高级别稳定性的分支中  
##### 特性分支
- 短期分支，它被用来实现单一特性或其相关工作   
- 一旦处理完毕【提交了一些更新，并且在它们合并入主干分支】，就会删除，使你快速并且完整地进行上下文切换 
##### 分布式Git
#### 远程分支
##### 添加远程仓库
- git remote add 命令添加一个新的远程仓库引用到当前的项目  
- git fetch teamone 来抓取远程仓库 teamone 有而本地没有的数据。 因为那台服务器上现有的数据是 origin 服务器上的一个子集，所以 Git 并不会抓取数据而是会设置远程跟踪分支 teamone/master 指向 teamone 的 master 分支  
![](https://progit.bootcss.com/images/remote-branches-5.png)
- git fetch origin 在本地生成一个远程分支 origin/serverfix，指向服务器的 serverfix 分支的引用
  抓取到新的远程跟踪分支时，本地不会自动生成一份可编辑的副本（拷贝）。 换一句话说，这种情况下，不会有一个新的 serverfix 分支 - 只有一个不可以修改的 origin/serverfix 指针
- git checkout -b branch remote/branch 建立branch并切换到该分支上
##### 跟踪远程分支
- 将远程分支拉取到本地的新分支：git checkout -b 本地分支 远程分支/分支名 git checkout -b box origin/box
- 远程分支 checkout 出来的本地分支，称为 跟踪分支 (tracking branch)。跟踪分支是一种和某个远程分支有直接联系的本地分支。在跟踪分支里输入 git push，Git 会自行推断应该向哪个服务器的哪个分支推送数据。同样，在这些分支里运行 git pull 会获取所有远程索引，并把它们的数据都合并到本地分支中来。
### 变基
### 标签
#### 呃  
