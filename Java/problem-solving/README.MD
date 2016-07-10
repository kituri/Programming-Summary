问题以及解决
---
<h4>NO.1</h4>
- **问题描述：**home键或者其他方式程序进入后台后，一段时间回到前台界面显示信息出错
- **原因分析：**由于app进入后台时间太久没有唤起，被系统回收
- **问题解决：**在application类的onCreate方法里面对重新启动进行监听并重新启动进入后台时候的Activity

<h4>NO.2</h4>
- **问题描述：**postDelay+Dialog引起的窗体泄露
- **原因分析：**Android中消息队列postDelay+Dialog引起的窗体泄露的主要原因是，当床窗体压入栈或者finish掉后，Activity由于需要处理postDelay而不能及时销毁，因此造成了一个问题，当dialog触发show方法时，由于window和activity已经分开了，因此便会造成窗体泄露。
- **问题解决：**通过对Activity的状态进行监听确定是否显示dialog，见代码
```java
private boolean isActive = true;
public void onResume()
{
    super.onResume();
    isActive = true;
}
public void onPause()
{
    super.onPause();
    isActive = false;
}

public boolean activityIsActivity()
{
  return isActive;
}

public void showAlertDialog()
{
    if(activityIsActive())  //只有窗体处于活动状态时执行此程序
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("hello world")
               .setCancelable(false)
               .setMessage("Hello");
    	builder.create().show();
    }
}
```
