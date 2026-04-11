package com.google.android.gms.internal.measurement;

import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class f1 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f2966u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f2967v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f2968w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ i1 f2969x;

    public f1(i1 i1Var, boolean z2) {
        this.f2969x = i1Var;
        i1Var.f3044b.getClass();
        this.f2966u = System.currentTimeMillis();
        i1Var.f3044b.getClass();
        this.f2967v = SystemClock.elapsedRealtime();
        this.f2968w = z2;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        i1 i1Var = this.f2969x;
        if (i1Var.f3048g) {
            b();
            return;
        }
        try {
            a();
        } catch (Exception e10) {
            i1Var.f(e10, false, this.f2968w);
            b();
        }
    }

    public void b() {
    }
}
