P42
1.根据请求的url获取你的servlet path ，并根据这个path 解析出一个名字
2.解析我们加载的配置文件 appContext，从配置文件里读取beans 到我们的map容器中
3.根据那个名字，去map里找那个能够处理的那个controller，然后调用相应方法