package heng.liao.athrun.aidldemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import heng.liao.athrun.remote_app.IMyAidlInterface;

public class MainActivity extends Activity {
    private TextView aidl_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aidl_test = (TextView) findViewById(R.id.aidl_test);
        aidl_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testAIDL();
            }
        });
    }

    private void testAIDL() {
        /*创建 ServiceConnection*/
        ServiceConnection mServiceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                IMyAidlInterface iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
                String result = "result";
                try {
                    result = iMyAidlInterface.getRuntimeString();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    result = "failed";
                }
                aidl_test.setText(result);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
        Intent  intent = new Intent("heng.liao.athrun.remote_app.AIDLService");
        /*android 5.0以上必须显式指定*/
        intent.setPackage("heng.liao.athrun.remote_app");
        bindService(intent,mServiceConnection, Context.BIND_AUTO_CREATE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
