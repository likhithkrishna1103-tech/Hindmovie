package com.bumptech.glide.manager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements o {
    public static final Executor B = AsyncTask.SERIAL_EXECUTOR;
    public final r A = new r(0, this);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Context f2283v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final n f2284w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final l8.i f2285x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile boolean f2286y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile boolean f2287z;

    public t(Context context, l8.i iVar, n nVar) {
        this.f2283v = context.getApplicationContext();
        this.f2285x = iVar;
        this.f2284w = nVar;
    }

    @Override // com.bumptech.glide.manager.o
    public final void a() {
        B.execute(new s(this, 1));
    }

    @Override // com.bumptech.glide.manager.o
    public final boolean b() {
        B.execute(new s(this, 0));
        return true;
    }

    public final boolean c() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f2285x.get()).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e9) {
            if (!Log.isLoggable("ConnectivityMonitor", 5)) {
                return true;
            }
            Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e9);
            return true;
        }
    }
}
