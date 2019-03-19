# Function Notes

### BaseErrorType.java

用于标记错误码

```java
//业务相关
FUNCTION_FAILED( 3001, "其他异常--" ),
ELEMENT_NOT_FOUND(3004, "未找到控件"),
PAGE_NOT_LOAD(3006,"页面未加载"),
//平台相关
INSTALL_FAIL(1011, "安装失败");
```

### BaseMacacaClient.java

自定义的MacacaClient基类，用于在MacacaClient基础上封装自己的处理

```java
    // 定义平台类型枚举
     public enum PlatformType
  
  	// 定义手势
     public enum GesturePinchType
  
     /**
      * 查找控件，当同样的控件有多个时，返回第一个
      * @param bean
      * @throws Exception
      */
     public Element findElement(CommonUIBean bean) throws Exception
  
     /**
      * 根据索引获取控件，当同样的控件可能存在多个时，查询返回的是一个数组，此时通过传入目标控件的索引获取指定控件
      * @param bean 要查找的控件
      * @param index 目标控件index
      * @throws Exception
      */
     public Element findElementByIndex(CommonUIBean bean ,int index) throws Exception
  
     /**
      * 当一类控件存在多个时，返回共有多少个该控件
      * @param bean 要查找的控件
      * @return 控件数组个数
      * @throws Exception
      */
     public int  countOfElment(CommonUIBean bean) throws Exception
  
     /**
      * 循环查找某个element，直到查找完毕
      * @param bean
      * @return
      * @throws Exception
      */
     public Element waitForElement(CommonUIBean bean) throws Exception
  
     /**
      * 循环查找某个element,直到查找完毕，适用于当前控件存在多个时，按照索引查找
      * @param bean  要查找的控件
      * @param index 目标控件index
      * @throws Exception
      */
     public Element waitForElement(CommonUIBean bean,int index) throws Exception
     
     /**
      * 判断某个控件是否存在
      * @param bean
      * @return
      */
     public boolean isElementExist(CommonUIBean bean)
  
     /**
      * 判断某个控件是否存在
      * @param bean
      * @return
      */
     public boolean isElementExist(CommonUIBean bean,int index)
  
     /**
      * 是否存在目标控件，如果当前没有该控件，在给定时间内循环查询，查询间隔以及时长通过setWaitElementTimeInterval,setWaitElementTimeout可设置
      * @param bean
      * @return
      */
     public boolean isElementExistAfterWaiting(CommonUIBean bean)
     
     /**
      * 是否存在目标控件，如果当前没有该控件，在给定时间内循环查询，查询间隔以及时长通过setWaitElementTimeInterval,setWaitElementTimeout可设置
      * @param bean
      * @return
      */
     public boolean isElementExistAfterWaiting(CommonUIBean bean, int index)
  
     /**
      * 自定义返回事件，对于iOS,通过右滑手势实现，对于Android，需要另外处理
      * @throws Exception
      */
     public void customBack() throws Exception
  
     /**
      * 点击某一个控件，执行操作为 查找控件-点击控件
      * @param bean 要点击的控件
      */
     public void onclickBean(CommonUIBean bean)
  
     /**
      * 点击某一个控件，执行操作为 查找控件-点击控件
      * @param bean 目标控件
      * @param index 目标控件索引
      */
     public void onclickBeanAtIndex(CommonUIBean bean, int index)
     
     /**
      * 实现简单的输入
      * @param bean 要输入文本的控件
      * @param input 要输入的关键字
      */
      public void  inputBean(CommonUIBean bean,String input)
  
      /**
       * 清除指定控件文案
       * @param bean 要清除文案的控件
       */
      public void clearText(CommonUIBean bean)
  
      /**
       * 获取控件文案
       * @param bean 目标控件
       * @return
       */
      public String getText(CommonUIBean bean)
  
      /**
       * 获取控件属性
       * @param bean 目标控件
       * @param name 要获取的属性名字
       * Support: Android iOS Web(WebView). iOS支持: 'isVisible', 'label', 'value', Android支持: 'selected', 'description', 'text'
       * @return
       */
      public Object getProperty(CommonUIBean bean,String name)
  
      /**
       * 获取控件rect
       * @param bean 目标控件
       * @return jsonObject eg: {x:100,y:100,width：100,height:100}
       */
      public Object getRect(CommonUIBean bean)
  
      /**
       * 控件是否展示
       * @param bean 目标控件
       * @return true-展示  false-未展示
       */
      public boolean isDisplayed(CommonUIBean bean)
  
      /**
          * 滑动当前页面到指定控件
          * Support: Android iOS Web(WebView)
          * @param wayToFind
          *           目标控件查找方式
          * @param value
          *           目标控件查找值
          * @return
          *           true:找到控件，并完成滑动
          *            false:控件不存在，滑到底部依然没有查到
          */
         public boolean scrollToElement (GetElementWay wayToFind, String value)
  
     /**
      * 滑动到最底部
      */
     public void scrollToBottom () 
     
     /**
      * 滑动到最顶部
      */
     public void scrollToTop () 
     
     /**
      * 滑动到最底部或最顶部
      * @param isToBottom
      *          是否滑动到最底部，true：滑动到最底部，false：滑动到最顶部
      */
     public void scrollToBottomOrTop (boolean isToBottom)
  
     // App操作相关
     /**
      * Support : Android only
      * 启动app- 需在server启动后调用，如server未启动，需要通过BaseUtils.startApp(deviceId, packageName, activityName)调用
      * Support : Android Only
      */
     public void startApp()
     
     /**
      * Support : Android Only
      * 清理app,回到初始状态 -需在server启动后调用，如server未启动，需要通过BaseUtils.clearApp(deviceId, packageName)调用
      */
     public void clearApp()
     
     /**
      * Support : Android Only
      * 杀死app -需在server启动后调用，如server未启动，需要通过BaseUtils.forceStopApp(deviceId, packageName)调用
      */
     public void forceStopApp() 
  
     /**
      * 从native切换到webview
      * @return
      * @throws Exception
      */
     public void switchFromNativeToWebView() 
  
     /**
      * 从webview切换到native
      * @return
      * @throws Exception
      */
     public  void switchFromeWebviewToNative() throws Exception
  
      /**
       * 获取文件md5
       * @param file
       * @return
       */
     public static String getFileMD5(File file)
```

### CommonUIBean.java

```java
		/**
    * 当PC 安卓 ios两个平台对应同一控件的获取方式不一致时使用本构造函数
    * @param androidBy 获取安卓对应控件的方式
    * @param androidValue 获取安卓对应控件的值
    * @param iosBy 获取ios对应控件的方式
    * @param iosValue 获取ios对应控件的值
    * @param destopBy 获取PC对应控件的方式
    * @param destopValue 获取PC对应控件的值
    * @param elementDesc 控件描述文案
    */
   public CommonUIBean(GetElementWay destopBy,String destopValue,GetElementWay androidBy,String androidValue,GetElementWay iosBy,String iosValue,String elementDesc)
     
   /**
    * 构造函数，用于ios&android两个平台获取UI一致的情况
    * @param commonBy 统一获取控件方式
    * @param commonValue 统一获取控件值
    * @param elementDesc 控件描述文案
    */
   public CommonUIBean(GetElementWay commonBy,String commonValue,String elementDesc)
```

### ResultGenerator

```java
   /**
    * 清除log数据,包含result.log & custom.log
    */
   public static void clearOldData()

   /**
    * 成功时记录，desc是预留参数，目前随便填什么都可以
    *
    * @param action, 当前操作
    * @param desc， 描述，预留字段，可以设为空字符串
    */
   public static void success(String action, String desc)
     
   /**
    * 页面加载成功日志记录
    * @param page 当前page对象
    */
   public static void loadPageSucc(BasePage page)

   /**
    * 页面加载失败时生成日志记录
    * @param page
    */
   public static void loadPageFail(BasePage page) 
     
   /**
    * 控件查找失败时生成日志记录
    * @param elementDesc 控件描述-方便可读性
    */
   public static void findElementFail(CommonUIBean targetElement)

   /**
    * 进入catch Exception方法时触发日志记录
    */
   public static void catchedException(Exception e) 
     
   /**
    *
    * @param action
    * @param desc 错误描述
    * @param type 错误类型, 必须选择一个错误类型
    */
   public static void fail(String action,  String desc, BaseErrorType type)

   /**
    * 自定义日志输出
    * @param action
    * @param desc
    */
   public static void customLog(String action,String desc)
     
   /**
    * 获取现在时间
    * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
    */
   public static String getStringDate()
```

### BaseUtils.java

```java
    /**
     * 执行系统命令
     *
     * @param cmd
     * @return
     */
    public static List<String> exec2(String cmd)
      
    /**
     * 安装app
     * Support: Android ios
     * 注：ios设备使用该方法时需提前在本机安装命令行工具ideviceinstaller，安装方法：brew install ideviceinstaller
     * @param deviceType 设备类型 ios,android
     * @param deviceId 设备id,当存在多个设备时需指定设备id,如果只有一台设备，可以不必指定,ios:udid
     * @param packagePath 安装包路径 Android：.apk，ios：.ipa
     */
    public static void deviceInstaller
    
    /**
     * 启动app
     * Support: Android ios
     * 注：ios设备使用该方法时需提前在本机安装命令行工具libimobiledevice，安装方法：前往https://github.com/libimobiledevice/libimobiledevice 将项目下载到本地，按照README进行配置、编译安装即可
     * @param deviceType 设备类型 ios,android
     * @param deviceId 设备id,当存在多个设备时需指定设备id,如果只有一台设备，可以不必指定,ios:udid
     * @param packageName for Android，要启动app的packageName,与initDriver时设置的desiredCapabilities一致
     * @param activityName for Android，要启动app的activityName,与initDriver时设置的desiredCapabilities一致
     * @param bundleId for ios，要启动app的bundleId
     */
    public static void launchApp(String deviceType,String deviceId,String packageName,String activityName,String bundleId ) throws InterruptedException

    /**
     * 安装app
     * Support: Android Only
     * @param deviceId 设备id,当存在多个设备时需指定设备id,如果只有一台设备，可以不必指定
     * @param apkPath 安装包路径
     */
    public static void installApp (String deviceId,String apkPath)
      
    /**
     * 启动app
     * Support: Android only
     * @param deviceId 设备id,当存在多个设备时需指定设备id,如果只有一台设备，可以不必指定
     * @param packageName 要启动app的packageName,与initDriver时设置的desiredCapabilities一致
     * @param activityName 要启动app的activityName,与initDriver时设置的desiredCapabilities一致
     */
    public static void startApp(String deviceId,String packageName,String activityName) 

    /**
     * 清理app
     * Support: Android only
     * @param deviceId 设备id,当存在多个设备时需指定设备id,如果只有一台设备，可以不必指定
     * @param packageName 要启动app的packageName,与initDriver时设置的desiredCapabilities一致
     */
    public static void clearApp(String deviceId,String packageName)

    /**
     * 杀死app
     * Support: Android only
     * @param deviceId 设备id,当存在多个设备时需指定设备id,如果只有一台设备，可以不必指定
     * @param packageName 要启动app的packageName,与initDriver时设置的desiredCapabilities一致
     */
    public static void forceStopApp(String deviceId,String packageName)

    /**
     * 获取文件md5
     * @param file
     * @return
     */
    public static String getFileMD5(File file)
      
    public static  boolean isStringNotNull(String str) 
```