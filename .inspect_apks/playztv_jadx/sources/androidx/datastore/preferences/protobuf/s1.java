package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f1125a = Logger.getLogger(s1.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Unsafe f1126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Class f1127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r1 f1128d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f1129e;
    public static final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f1130g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f1131h;

    /* JADX WARN: Removed duplicated region for block: B:69:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x026a  */
    static {
        /*
            Method dump skipped, instruction units count: 623
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.s1.<clinit>():void");
    }

    public static Object a(Class cls) {
        try {
            return f1126b.allocateInstance(cls);
        } catch (InstantiationException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public static int b(Class cls) {
        if (f) {
            return f1128d.a(cls);
        }
        return -1;
    }

    public static void c(Class cls) {
        if (f) {
            f1128d.b(cls);
        }
    }

    public static Field d() {
        Field declaredField;
        Field declaredField2;
        if (c.a()) {
            try {
                declaredField2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
            } catch (Throwable unused) {
                declaredField2 = null;
            }
            if (declaredField2 != null) {
                return declaredField2;
            }
        }
        try {
            declaredField = Buffer.class.getDeclaredField("address");
        } catch (Throwable unused2) {
            declaredField = null;
        }
        if (declaredField == null || declaredField.getType() != Long.TYPE) {
            return null;
        }
        return declaredField;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean e(Class cls) {
        if (!c.a()) {
            return false;
        }
        try {
            Class cls2 = f1127c;
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

    public static byte f(long j5, byte[] bArr) {
        return f1128d.d(f1130g + j5, bArr);
    }

    public static byte g(long j5, Object obj) {
        return (byte) ((f1128d.g((-4) & j5, obj) >>> ((int) (((~j5) & 3) << 3))) & 255);
    }

    public static byte h(long j5, Object obj) {
        return (byte) ((f1128d.g((-4) & j5, obj) >>> ((int) ((j5 & 3) << 3))) & 255);
    }

    public static Unsafe i() {
        try {
            return (Unsafe) AccessController.doPrivileged(new o1());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void j(byte[] bArr, long j5, byte b10) {
        f1128d.l(bArr, f1130g + j5, b10);
    }

    public static void k(Object obj, long j5, byte b10) {
        long j8 = (-4) & j5;
        int iG = f1128d.g(j8, obj);
        int i = ((~((int) j5)) & 3) << 3;
        m(((255 & b10) << i) | (iG & (~(255 << i))), j8, obj);
    }

    public static void l(Object obj, long j5, byte b10) {
        long j8 = (-4) & j5;
        int i = (((int) j5) & 3) << 3;
        m(((255 & b10) << i) | (f1128d.g(j8, obj) & (~(255 << i))), j8, obj);
    }

    public static void m(int i, long j5, Object obj) {
        f1128d.o(i, j5, obj);
    }

    public static void n(Object obj, long j5, long j8) {
        f1128d.p(obj, j5, j8);
    }

    public static void o(Object obj, long j5, Object obj2) {
        f1128d.q(obj, j5, obj2);
    }
}
