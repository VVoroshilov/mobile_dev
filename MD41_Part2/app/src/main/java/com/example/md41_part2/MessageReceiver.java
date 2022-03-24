package com.example.md41_part2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MessageReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Вам посылка из другой активности: " +
                        intent.getStringExtra("com.example.md41_part2.broadcast.Message"),
                Toast.LENGTH_LONG).show();
    }

}