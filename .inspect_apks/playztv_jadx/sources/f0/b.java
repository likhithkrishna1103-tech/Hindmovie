package f0;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import c2.e;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static Intent a(Context context, e eVar, IntentFilter intentFilter) {
        return context.registerReceiver(eVar, intentFilter, null, null, 0);
    }

    public static Intent b(Context context, e eVar, IntentFilter intentFilter) {
        return context.registerReceiver(eVar, intentFilter, null, null, 2);
    }
}
