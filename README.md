# GlowCare

基于Macaca-Java版的UI自动化实现



## 安装Macaca环境

1. Node.js

2. Xcode v8.3 or higher is required.
  usbmuxd is needed in order to testing real iOS device via USB.
  $ brew install usbmuxd

  ios-webkit-debug-proxy is needed in order to testing WebViews.
  $ brew install ios-webkit-debug-proxy

3. Android
  Install the latest JDK
  Install the Android SDK
  Set the ANDROID_HOME environment variable to your ~/.bashrc, ~/.bash_profile, ~/.zshrc or whatever your shell uses

4. Prepare application
  iOS: An valid iOS application package suffixed with .app.
  Android: An valid Android application package suffixed with .apk.
  Desktop: All web application could be run with initial url.

5. Macaca Cli
  $ npm i -g macaca-cli

6. Macaca Application (Choose you need)

  $ npm i macaca-ios -g

  $ npm i macaca-android -g

  $ npm i macaca-chrome -g

#### verify environment
$ macaca doctor



## 使用步骤

### 1. 下载源码

```
$ git clone 
```

### 2. 更新依赖

```
$ cd autoui
$ make install
```

如果下载依赖过程中报错，可能是由于mvn -s命令没有生效导致的，建议将根目录下settings.xml中的依赖配置到本地Maven目录下的settings.xml中。

### 如何修改目标平台 ios/android/PC

```
//package com.glow.common;
// Config.java
// 目标平台- ios android PC
   public static final String PLATFORM = "ios"; 
```
### 3. 启动server

```
$ macaca server --verbose
```

注意启动server时不能加代理，因为server在本机启动需要连接localhost,加代理会导致无法建立连接。

### 4. 执行测试用例

新建窗口 
```
$ mvn test 
```




