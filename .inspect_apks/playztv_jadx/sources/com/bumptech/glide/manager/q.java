package com.bumptech.glide.manager;

import android.content.IntentFilter;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f2851u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ r f2852v;

    public /* synthetic */ q(r rVar, int i) {
        this.f2851u = i;
        this.f2852v = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2851u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                r rVar = this.f2852v;
                rVar.f2856x = rVar.c();
                try {
                    r rVar2 = this.f2852v;
                    rVar2.f2853u.registerReceiver(rVar2.f2858z, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    this.f2852v.f2857y = true;
                } catch (SecurityException e10) {
                    if (Log.isLoggable("ConnectivityMonitor", 5)) {
                        Log.w("ConnectivityMonitor", "Failed to register", e10);
                    }
                    this.f2852v.f2857y = false;
                    return;
                }
                break;
            case 1:
                if (this.f2852v.f2857y) {
                    this.f2852v.f2857y = false;
                    r rVar3 = this.f2852v;
                    rVar3.f2853u.unregisterReceiver(rVar3.f2858z);
                    break;
                }
                break;
            default:
                boolean z2 = this.f2852v.f2856x;
                r rVar4 = this.f2852v;
                rVar4.f2856x = rVar4.c();
                if (z2 != this.f2852v.f2856x) {
                    if (Log.isLoggable("ConnectivityMonitor", 3)) {
                        Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + this.f2852v.f2856x);
                    }
                    r rVar5 = this.f2852v;
                    x6.m.f().post(new o(rVar5, rVar5.f2856x, 1));
                }
                break;
        }
    }
}
