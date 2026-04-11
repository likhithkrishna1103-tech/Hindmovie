package com.bumptech.glide.manager;

import android.content.IntentFilter;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f2281v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ t f2282w;

    public /* synthetic */ s(t tVar, int i) {
        this.f2281v = i;
        this.f2282w = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2281v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                t tVar = this.f2282w;
                tVar.f2286y = tVar.c();
                try {
                    t tVar2 = this.f2282w;
                    tVar2.f2283v.registerReceiver(tVar2.A, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    this.f2282w.f2287z = true;
                } catch (SecurityException e9) {
                    if (Log.isLoggable("ConnectivityMonitor", 5)) {
                        Log.w("ConnectivityMonitor", "Failed to register", e9);
                    }
                    this.f2282w.f2287z = false;
                    return;
                }
                break;
            case 1:
                if (this.f2282w.f2287z) {
                    this.f2282w.f2287z = false;
                    t tVar3 = this.f2282w;
                    tVar3.f2283v.unregisterReceiver(tVar3.A);
                    break;
                }
                break;
            default:
                boolean z10 = this.f2282w.f2286y;
                t tVar4 = this.f2282w;
                tVar4.f2286y = tVar4.c();
                if (z10 != this.f2282w.f2286y) {
                    if (Log.isLoggable("ConnectivityMonitor", 3)) {
                        Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + this.f2282w.f2286y);
                    }
                    t tVar5 = this.f2282w;
                    s7.m.f().post(new p(tVar5, tVar5.f2286y, 1));
                }
                break;
        }
    }
}
