package myhump.io;

import android.graphics.drawable.Icon;
import android.os.Build;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.util.Random;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MyHump extends android.service.quicksettings.TileService {

    private final String TAG = TileService.class.getSimpleName();
    private Integer[] iconImageToggle = {
            R.drawable.ic_myhumpicon,
            R.drawable.ic_nohumpicon
            };
    private Integer TILE_STATE = 0;

    @Override
    public void onTileAdded(){
        Log.d(TAG, "onTileAdded");
    }

    @Override
    public void onTileRemoved(){
        Log.d(TAG, "onTileRemoved");
    }

    @Override
    public void onStartListening() {
        super.onStartListening();
        Log.d(TAG, "onStartListening");
    }

    @Override
    public void onStopListening(){
        super.onStopListening();
        Log.d(TAG, "onStopListening");
    }

    @Override
    public void onClick(){
        Log.d(TAG, "onClick current onslaught state" + Integer.toString(getQsTile().getState()));
        Icon icon;
//        Random r = new Random();

        if(TILE_STATE == 0) {
            icon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_nohumpicon);
            Log.d(TAG, "State Change [OFF] -> [ON]");
            Toast.makeText(this, "State Change [OFF] -> [ON]", Toast.LENGTH_SHORT).show();
            TILE_STATE = 1;
        }
        else{
            icon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_myhumpicon);
            Log.d(TAG, "State Change [ON] -> [OFF]");
            Toast.makeText(this, "State Change [ON] -> [OFF]", Toast.LENGTH_SHORT).show();
            TILE_STATE = 0;
        }
        getQsTile().setIcon(icon);
        getQsTile().updateTile();
    }
}
