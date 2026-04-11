package i0;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bumptech.glide.manager.r;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static Intent a(Context context, r rVar, IntentFilter intentFilter) {
        return context.registerReceiver(rVar, intentFilter, null, null, 0);
    }

    public static Intent b(Context context, r rVar, IntentFilter intentFilter) {
        return context.registerReceiver(rVar, intentFilter, null, null, 2);
    }
}
