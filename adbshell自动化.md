# adb shell自动化
##### 环境，版本，设置说明：
- 电脑：windows10 64位
- 真机：小米 
- 安卓版本： 9和7
- JDK：1.11.0.1和1.8
考虑到Android Studio很大，下载后也只使用的是安卓的SDK，所以直接下载安卓的SDK：https://dl.google.com/android/android-sdk_r24.4.1-windows.zip?utm_source=androiddevtools&utm_medium=website 位数64位
##### 准备：
1. 解压前面下载的android-sdk_r24.4.1-windows,放在D:\software\Android\目录下
2. 配置Java环境：系统配置的JAVA_HOME【因为之后要使用到Java，所以下载了11和8的，系统配置仍然是11】
![](https://github.com/tangwaikei/tangwaikei.github.io/blob/master/img/Java%E7%B3%BB%E7%BB%9F%E9%85%8D%E7%BD%AE.PNG)
3. 配置安卓环境：系统配置的ANDROID_HOME【我本地的在D:\software\Android\android-sdk_r24.4.1-windows\android-sdk-windows】
![](https://github.com/tangwaikei/tangwaikei.github.io/blob/master/img/android_home%E7%B3%BB%E7%BB%9F%E9%85%8D%E7%BD%AE.PNG)
4. 配置安卓SDK环境变量
![](https://github.com/tangwaikei/tangwaikei.github.io/blob/master/img/%E5%AE%89%E5%8D%93SDK%E7%8E%AF%E5%A2%83%E9%85%8D%E7%BD%AE.PNG)
5. 配置ANDROID_SWT
![](https://github.com/tangwaikei/tangwaikei.github.io/blob/master/img/Android_swt.PNG)
5. 双击D:\software\Android\android-sdk_r24.4.1-windows\android-sdk-windows下的SDK Manager.exe
刚打开的时候有闪退，或者报错，逐个解决。当时没有截图，但有参考的文章https://blog.csdn.net/fambit025/article/details/26984345 https://www.cnblogs.com/nebie/p/9145627.html
  - 当时Java的JDK是11，因为我开始设置的Java路径是错的：D:\Java\jdk-11.0.1\bin 
  - Java高版本不适合，用回8
  - find_java.exe 打开报错没关系，简单粗暴直接修改D:\software\Android\android-sdk_r24.4.1-windows\android-sdk-windows\tools\android.bat
  ```
  把set java_exe=
  call lib\find_java.bat
  改成
  set java_exe=D:\Java\jdk-1.8\bin\java.exe
  ```
  - 系统设置的java的版本是11，但android.bat用的是8，这没有冲突的，在android.bat指定Java版本即可
  - swt报错：网上说法一般是ANDROID_SWT没有在path设置变量
  - 解决完以上，一般可以打开SDK Manager.exe
  ![](https://github.com/tangwaikei/tangwaikei.github.io/blob/master/img/SDK%20manager.PNG)
##### SDK下载内容
![](https://github.com/tangwaikei/tangwaikei.github.io/blob/master/img/%E4%B8%8B%E8%BD%BD%E5%86%85%E5%AE%B91.PNG)
![](https://github.com/tangwaikei/tangwaikei.github.io/blob/master/img/%E4%B8%8B%E8%BD%BD%E5%86%85%E5%AE%B92.PNG)
![](https://github.com/tangwaikei/tangwaikei.github.io/blob/master/img/%E4%B8%8B%E8%BD%BD%E5%86%85%E5%AE%B93.PNG)
##### SDK 无法下载或者下载很慢
- 左上角Tools->Options: 记得勾选Force，下载的server填mirrors.neusoft.edu.cn，端口80
![](https://github.com/tangwaikei/tangwaikei.github.io/blob/master/img/options.PNG)
##### 打开uiautomatorviewer
- 双击 D:\software\Android\android-sdk_r24.4.1-windows\android-sdk-windows\tools\uiautomatorviewer.bat
- 发现报错 和android.bat一样
```
  把set java_exe=
  call lib\find_java.bat
  改成
  set java_exe=D:\Java\jdk-1.8\bin\java.exe
  ```
 - 闪退：用JDK 8 
 - 打开界面后dump发现会报错:Unexpected error while obtaining UI hierarchy
 ![](https://img2018.cnblogs.com/blog/1524273/201905/1524273-20190531135533363-1994563879.png)
 ###### 这个时候仍然用的是Android9的真机测试，所有APP只有微信可以成功，其他都会报错
 
