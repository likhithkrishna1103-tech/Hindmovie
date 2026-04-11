package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Unsafe f708a;

    public g1(Unsafe unsafe) {
        this.f708a = unsafe;
    }

    public final int a(Class cls) {
        return this.f708a.arrayBaseOffset(cls);
    }

    public final int b(Class cls) {
        return this.f708a.arrayIndexScale(cls);
    }

    public abstract boolean c(long j4, Object obj);

    public abstract double d(long j4, Object obj);

    public abstract float e(long j4, Object obj);

    public final int f(long j4, Object obj) {
        return this.f708a.getInt(obj, j4);
    }

    public final long g(long j4, Object obj) {
        return this.f708a.getLong(obj, j4);
    }

    public final Object h(long j4, Object obj) {
        return this.f708a.getObject(obj, j4);
    }

    public final long i(Field field) {
        return this.f708a.objectFieldOffset(field);
    }

    public abstract void j(Object obj, long j4, boolean z10);

    public abstract void k(Object obj, long j4, byte b8);

    public abstract void l(Object obj, long j4, double d10);

    public abstract void m(Object obj, long j4, float f);

    public final void n(long j4, Object obj, int i) {
        this.f708a.putInt(obj, j4, i);
    }

    public final void o(Object obj, long j4, long j7) {
        this.f708a.putLong(obj, j4, j7);
    }

    public final void p(Object obj, long j4, Object obj2) {
        this.f708a.putObject(obj, j4, obj2);
    }

    public boolean q() {
        Unsafe unsafe = this.f708a;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getInt", Object.class, cls2);
            cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
            cls.getMethod("getLong", Object.class, cls2);
            cls.getMethod("putLong", Object.class, cls2, cls2);
            cls.getMethod("getObject", Object.class, cls2);
            cls.getMethod("putObject", Object.class, cls2, Object.class);
            return true;
        } catch (Throwable th) {
            h1.a(th);
            return false;
        }
    }

    public abstract boolean r();
}
