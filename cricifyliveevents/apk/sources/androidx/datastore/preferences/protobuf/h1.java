package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g1 f718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f720e;
    public static final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f721g;

    static {
        Unsafe unsafeI = i();
        f716a = unsafeI;
        f717b = c.f686a;
        boolean zH = h(Long.TYPE);
        boolean zH2 = h(Integer.TYPE);
        g1 f1Var = null;
        if (unsafeI != null) {
            if (!c.a()) {
                f1Var = new f1(unsafeI);
            } else if (zH) {
                f1Var = new e1(unsafeI, 1);
            } else if (zH2) {
                f1Var = new e1(unsafeI, 0);
            }
        }
        f718c = f1Var;
        f719d = f1Var == null ? false : f1Var.r();
        f720e = f1Var == null ? false : f1Var.q();
        f = e(byte[].class);
        e(boolean[].class);
        f(boolean[].class);
        e(int[].class);
        f(int[].class);
        e(long[].class);
        f(long[].class);
        e(float[].class);
        f(float[].class);
        e(double[].class);
        f(double[].class);
        e(Object[].class);
        f(Object[].class);
        Field fieldG = g();
        if (fieldG != null && f1Var != null) {
            f1Var.i(fieldG);
        }
        f721g = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static void a(Throwable th) {
        Logger.getLogger(h1.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static boolean b(long j4, Object obj) {
        return ((byte) ((f718c.f((-4) & j4, obj) >>> ((int) (((~j4) & 3) << 3))) & 255)) != 0;
    }

    public static boolean c(long j4, Object obj) {
        return ((byte) ((f718c.f((-4) & j4, obj) >>> ((int) ((j4 & 3) << 3))) & 255)) != 0;
    }

    public static Object d(Class cls) {
        try {
            return f716a.allocateInstance(cls);
        } catch (InstantiationException e9) {
            throw new IllegalStateException(e9);
        }
    }

    public static int e(Class cls) {
        if (f720e) {
            return f718c.a(cls);
        }
        return -1;
    }

    public static void f(Class cls) {
        if (f720e) {
            f718c.b(cls);
        }
    }

    public static Field g() {
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
    public static boolean h(Class cls) {
        if (!c.a()) {
            return false;
        }
        try {
            Class cls2 = f717b;
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

    public static Unsafe i() {
        try {
            return (Unsafe) AccessController.doPrivileged(new d1());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void j(byte[] bArr, long j4, byte b8) {
        f718c.k(bArr, f + j4, b8);
    }

    public static void k(Object obj, long j4, byte b8) {
        long j7 = (-4) & j4;
        int iF = f718c.f(j7, obj);
        int i = ((~((int) j4)) & 3) << 3;
        m(j7, obj, ((255 & b8) << i) | (iF & (~(255 << i))));
    }

    public static void l(Object obj, long j4, byte b8) {
        long j7 = (-4) & j4;
        int i = (((int) j4) & 3) << 3;
        m(j7, obj, ((255 & b8) << i) | (f718c.f(j7, obj) & (~(255 << i))));
    }

    public static void m(long j4, Object obj, int i) {
        f718c.n(j4, obj, i);
    }

    public static void n(Object obj, long j4, long j7) {
        f718c.o(obj, j4, j7);
    }

    public static void o(Object obj, long j4, Object obj2) {
        f718c.p(obj, j4, obj2);
    }
}
