package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class r6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Unsafe f2585a;

    public r6(Unsafe unsafe) {
        this.f2585a = unsafe;
    }

    public abstract void a(Object obj, long j4, byte b8);

    public abstract boolean b(long j4, Object obj);

    public abstract void c(Object obj, long j4, boolean z10);

    public abstract float d(long j4, Object obj);

    public abstract void e(Object obj, long j4, float f);

    public abstract double f(long j4, Object obj);

    public abstract void g(Object obj, long j4, double d10);
}
