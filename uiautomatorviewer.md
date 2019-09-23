# uiautomatorviewer 安装教程
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
  if not defined java_exe goto :EOF
  改成
  set java_exe=D:\Java\jdk-1.8\bin\java.exe
  ```
  - 系统设置的java的版本是11，但android.bat用的是8，这没有冲突的，在android.bat指定Java版本即可
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
  if not defined java_exe goto :EOF
  改成
  set java_exe=D:\Java\jdk-1.8\bin\java.exe
  ```
 - 闪退：用JDK 8 
 - 无法初始化主类【swt报错】：网上说法一般是ANDROID_SWT没有在path设置变量,参考文章：https://blog.csdn.net/kally001/article/details/81111285
 ![](https://github.com/tangwaikei/tangwaikei.github.io/blob/master/img/%E6%97%A0%E6%B3%95%E5%88%9D%E5%A7%8B%E5%8C%96%E4%B8%BB%E7%B1%BB.PNG)
 - 打开界面后dump发现会报错:Unexpected error while obtaining UI hierarchy
 ![](https://img2018.cnblogs.com/blog/1524273/201905/1524273-20190531135533363-1994563879.png)
 ##### 这个时候仍然用的是Android9的真机测试，所有APP只有微信可以成功，其他都会报错。尝试了很多方法，还是只有微信可以
 ##### 死马当活马医
 - 网上搜了很多之后，这句话是在dumpWindowHierarchy函数里抛出的，于是将D:\software\Android\android-sdk_r24.4.1-windows\android-sdk-windows\tools\lib的uiautomatorviewer.jar反编译之后研究了一下
 ```
  public void  [More ...] dumpWindowHierarchy(String fileName) {
        AccessibilityNodeInfo root = getAutomatorBridge().getQueryController().getAccessibilityRootNode();
        if(root != null) {
            AccessibilityNodeInfoDumper.dumpWindowToFile(
                    root, new File(new File(Environment.getDataDirectory(),
                            "local/tmp"), fileName));
        }
    }
 ```
 - uiautomatorview工作原理是：先用Uidevice 获取截图，然后用dumpWindowHierarchy来dump解析成xml
 - 错误的原因：官网默认的地址是/data/local/tmp但又增加了local/tmp/的目录，也就是/data/local/tmp/local/tmp/ 
 - 详细的研究参考文章：https://blog.csdn.net/itfootball/article/details/22683999
 ##### 解决方法：https://github.com/yaming116/uiautomatorview
 1. 下载修复了路径bug的新uiautomatorviewer.jar来替换旧的，建议旧的jar包做个备份,地址${ANDROID_HOME}/tools/lib下的uiautomatorviewer.jar
 2. 将LvmamaXmlKit.jar push 到手机的/data/local/tmp/
 ```
 adb push D:\jar\LvmamaXmlKit.jar /data/local/tmp/
 ```
 3. 重新打开uiautomatorviewer.bat,时间久耐心要等待加载
 ![](https://github.com/tangwaikei/tangwaikei.github.io/blob/master/img/uiautomatorviewer.PNG)
 4. 可以打开任何的APP并且解析xml了
 ## 安装appium
 #### 安装appium服务端
 https://bitbucket.org/appium/appium.app/downloads/ 下载最新的AppiumForWindows_1_4_16_1.zip
 #### 配置系统变量路径
 ![](https://github.com/tangwaikei/tangwaikei.github.io/blob/master/img/%E7%B3%BB%E7%BB%9F%E5%8F%98%E9%87%8F.PNG)
 #### 启动appium
 ![](https://github.com/tangwaikei/tangwaikei.github.io/blob/master/img/%E5%90%AF%E5%8A%A8appium.PNG)
 #### 检查appium所需的环境是否OK:appium-doctor
 ![](https://github.com/tangwaikei/tangwaikei.github.io/blob/master/img/doctor.PNG)
 #### 安装appium 客户端
 appium client是对webdriver原生api的一些扩展和封装，用于抓取app上的定位信息
 ![](https://github.com/tangwaikei/tangwaikei.github.io/blob/master/img/client.PNG)
 https://juejin.im/post/5c25c6b5f265da612c5df54c
