package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class n6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f3119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f3120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m6 f3121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f3122d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f3123e;
    public static final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f3124g;

    /* JADX WARN: Removed duplicated region for block: B:11:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    static {
        /*
            Method dump skipped, instruction units count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.n6.<clinit>():void");
    }

    public static Object a(Class cls) {
        try {
            return f3119a.allocateInstance(cls);
        } catch (InstantiationException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public static void b(int i, long j5, Object obj) {
        f3121c.b(i, j5, obj);
    }

    public static void c(Object obj, long j5, Object obj2) {
        f3121c.f3101a.putObject(obj, j5, obj2);
    }

    public static int d(Class cls) {
        if (f3123e) {
            return f3121c.f3101a.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static Unsafe e() {
        try {
            return (Unsafe) AccessController.doPrivileged(new o6());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void f(Class cls) {
        if (f3123e) {
            f3121c.f3101a.arrayIndexScale(cls);
        }
    }

    public static void g(Object obj, long j5, byte b10) {
        long j8 = (-4) & j5;
        int iJ = f3121c.j(j8, obj);
        int i = ((~((int) j5)) & 3) << 3;
        b(((255 & b10) << i) | (iJ & (~(255 << i))), j8, obj);
    }

    public static void h(Object obj, long j5, byte b10) {
        long j8 = (-4) & j5;
        int i = (((int) j5) & 3) << 3;
        b(((255 & b10) << i) | (f3121c.j(j8, obj) & (~(255 << i))), j8, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean i(Class cls) {
        try {
            Class cls2 = f3120b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static Object j(long j5, Object obj) {
        return f3121c.f3101a.getObject(obj, j5);
    }

    public static Field k() {
        Field declaredField;
        Field declaredField2;
        try {
            declaredField = Buffer.class.getDeclaredField("effectiveDirectAddress");
        } catch (Throwable unused) {
            declaredField = null;
        }
        if (declaredField != null) {
            return declaredField;
        }
        try {
            declaredField2 = Buffer.class.getDeclaredField("address");
        } catch (Throwable unused2) {
            declaredField2 = null;
        }
        if (declaredField2 == null || declaredField2.getType() != Long.TYPE) {
            return null;
        }
        return declaredField2;
    }
}
