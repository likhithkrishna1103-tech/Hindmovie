package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class m6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Unsafe f3101a;

    public m6(Unsafe unsafe) {
        this.f3101a = unsafe;
    }

    public abstract double a(long j5, Object obj);

    public final void b(int i, long j5, Object obj) {
        this.f3101a.putInt(obj, j5, i);
    }

    public abstract void c(Object obj, long j5, byte b10);

    public abstract void d(Object obj, long j5, double d10);

    public abstract void e(Object obj, long j5, float f);

    public final void f(Object obj, long j5, long j8) {
        this.f3101a.putLong(obj, j5, j8);
    }

    public abstract void g(Object obj, long j5, boolean z2);

    public abstract float h(long j5, Object obj);

    public abstract boolean i(long j5, Object obj);

    public final int j(long j5, Object obj) {
        return this.f3101a.getInt(obj, j5);
    }

    public final long k(long j5, Object obj) {
        return this.f3101a.getLong(obj, j5);
    }
}
