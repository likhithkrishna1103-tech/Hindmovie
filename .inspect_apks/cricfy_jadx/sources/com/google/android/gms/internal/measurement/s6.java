package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class s6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f2614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f2615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r6 f2616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f2617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f2618e;
    public static final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f2619g;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0044  */
    static {
        /*
            Method dump skipped, instruction units count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.s6.<clinit>():void");
    }

    public static void a(Class cls) {
        if (f2618e) {
            f2616c.f2585a.arrayIndexScale(cls);
        }
    }

    public static Field b() {
        Field declaredField;
        Field declaredField2;
        int i = w4.f2707a;
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

    public static void c(Object obj, long j4, byte b8) {
        Unsafe unsafe = f2616c.f2585a;
        long j7 = (-4) & j4;
        int i = unsafe.getInt(obj, j7);
        int i10 = ((~((int) j4)) & 3) << 3;
        unsafe.putInt(obj, j7, ((255 & b8) << i10) | (i & (~(255 << i10))));
    }

    public static void d(Object obj, long j4, byte b8) {
        Unsafe unsafe = f2616c.f2585a;
        long j7 = (-4) & j4;
        int i = (((int) j4) & 3) << 3;
        unsafe.putInt(obj, j7, ((255 & b8) << i) | (unsafe.getInt(obj, j7) & (~(255 << i))));
    }

    public static Object e(Class cls) {
        try {
            return f2614a.allocateInstance(cls);
        } catch (InstantiationException e9) {
            throw new IllegalStateException(e9);
        }
    }

    public static int f(long j4, Object obj) {
        return f2616c.f2585a.getInt(obj, j4);
    }

    public static void g(long j4, Object obj, int i) {
        f2616c.f2585a.putInt(obj, j4, i);
    }

    public static long h(long j4, Object obj) {
        return f2616c.f2585a.getLong(obj, j4);
    }

    public static void i(Object obj, long j4, long j7) {
        f2616c.f2585a.putLong(obj, j4, j7);
    }

    public static Object j(long j4, Object obj) {
        return f2616c.f2585a.getObject(obj, j4);
    }

    public static void k(Object obj, long j4, Object obj2) {
        f2616c.f2585a.putObject(obj, j4, obj2);
    }

    public static Unsafe l() {
        try {
            return (Unsafe) AccessController.doPrivileged(new o6());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean m(Class cls) {
        int i = w4.f2707a;
        try {
            Class cls2 = f2615b;
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

    public static /* synthetic */ boolean n(long j4, Object obj) {
        return ((byte) ((f2616c.f2585a.getInt(obj, (-4) & j4) >>> ((int) (((~j4) & 3) << 3))) & 255)) != 0;
    }

    public static /* synthetic */ boolean o(long j4, Object obj) {
        return ((byte) ((f2616c.f2585a.getInt(obj, (-4) & j4) >>> ((int) ((j4 & 3) << 3))) & 255)) != 0;
    }

    public static int p(Class cls) {
        if (f2618e) {
            return f2616c.f2585a.arrayBaseOffset(cls);
        }
        return -1;
    }
}
