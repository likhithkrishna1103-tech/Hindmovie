package com.google.android.gms.internal.measurement;

import android.os.SystemClock;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g1 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f2453v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f2454w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f2455x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ k1 f2456y;

    public g1(k1 k1Var, boolean z10) {
        Objects.requireNonNull(k1Var);
        this.f2456y = k1Var;
        this.f2453v = System.currentTimeMillis();
        this.f2454w = SystemClock.elapsedRealtime();
        this.f2455x = z10;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        k1 k1Var = this.f2456y;
        if (k1Var.f2507e) {
            b();
            return;
        }
        try {
            a();
        } catch (Exception e9) {
            k1Var.d(e9, false, this.f2455x);
            b();
        }
    }

    public void b() {
    }
}
