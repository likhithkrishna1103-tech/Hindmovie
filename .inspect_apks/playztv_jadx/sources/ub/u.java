package ub;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.util.Log;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v f12897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v f12898b;

    public u(v vVar, v vVar2) {
        this.f12898b = vVar;
        this.f12897a = vVar2;
    }

    public final void a() {
        if (Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3))) {
            Log.d("FirebaseMessaging", "Connectivity change received registered");
        }
        this.f12898b.f12900u.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // android.content.BroadcastReceiver
    public final synchronized void onReceive(Context context, Intent intent) {
        try {
            v vVar = this.f12897a;
            if (vVar == null) {
                return;
            }
            if (vVar.d()) {
                if (Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3))) {
                    Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                }
                v vVar2 = this.f12897a;
                vVar2.f12903x.f.schedule(vVar2, 0L, TimeUnit.SECONDS);
                context.unregisterReceiver(this);
                this.f12897a = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
