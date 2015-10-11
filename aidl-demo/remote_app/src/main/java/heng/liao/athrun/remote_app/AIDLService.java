package heng.liao.athrun.remote_app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.Random;

public class AIDLService extends Service {
    private IBinder mBinder = new AIDLStubImpl();
    private Random randomPro = new Random();
    public AIDLService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    /*相当于自定义的IBinder类*/
    class AIDLStubImpl extends IMyAidlInterface.Stub{

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public String getRuntimeString() throws RemoteException {
            /*返回需要的运行时东西*/
            return "返回需要的运行时东西"+randomPro.nextInt(100);
        }
    }

}
