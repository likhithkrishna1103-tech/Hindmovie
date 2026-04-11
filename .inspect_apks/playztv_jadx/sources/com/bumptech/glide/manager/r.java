package com.bumptech.glide.manager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r implements n {
    public static final Executor A = AsyncTask.SERIAL_EXECUTOR;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Context f2853u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final m f2854v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final q7.h f2855w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile boolean f2856x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile boolean f2857y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final c2.e f2858z = new c2.e(1, this);

    public r(Context context, q7.h hVar, m mVar) {
        this.f2853u = context.getApplicationContext();
        this.f2855w = hVar;
        this.f2854v = mVar;
    }

    @Override // com.bumptech.glide.manager.n
    public final void a() {
        A.execute(new q(this, 1));
    }

    @Override // com.bumptech.glide.manager.n
    public final boolean b() {
        A.execute(new q(this, 0));
        return true;
    }

    public final boolean c() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f2855w.get()).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e10) {
            if (!Log.isLoggable("ConnectivityMonitor", 5)) {
                return true;
            }
            Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e10);
            return true;
        }
    }
}
