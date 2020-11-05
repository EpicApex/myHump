package myhump.io;

import android.graphics.drawable.Icon;
import android.os.Build;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import android.util.Log;

import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MyHump extends android.service.quicksettings.TileService {

    public static final String TAG = TileService.class.getSimpleName();
    private final int STATE_ON = 1;
    private final int STATE_OFF = 0;
    private int toggle = STATE_OFF;

    @Override
    public void onTileAdded(){
        Log.d(TAG, "onTileAdded");
    }

    @Override
    public void onStartListening() {
        Tile tile = getQsTile();
        Log.d(TAG, "onStartListening" + tile.getLabel() );
    }

    @Override
    public void onClick(){
        Log.d(TAG, "onClick current onslaught state" + Integer.toString(getQsTile().getState()));
        Icon icon;
        if(toggle == STATE_ON){
            Log.d(TAG, "onClick current onslaught state" + toggle);
            toggle = STATE_OFF;
            icon = Icon.createWithResource(getApplicationContext(), R.drawable.myhumpicon);
            Log.d(TAG, "onClick current onslaught state" + toggle);
        } else {
            Log.d(TAG, "onClick current onslaught state" + toggle);
            toggle = STATE_ON;
            icon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_myhumpicon_opac40);
            Log.d(TAG, "onClick current onslaught state" + toggle);
        }
        getQsTile().setIcon(icon);
        getQsTile().updateTile();
    }
}
