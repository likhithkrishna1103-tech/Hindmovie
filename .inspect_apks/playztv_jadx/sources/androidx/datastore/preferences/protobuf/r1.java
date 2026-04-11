package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Unsafe f1110a;

    public r1(Unsafe unsafe) {
        this.f1110a = unsafe;
    }

    public final int a(Class cls) {
        return this.f1110a.arrayBaseOffset(cls);
    }

    public final int b(Class cls) {
        return this.f1110a.arrayIndexScale(cls);
    }

    public abstract boolean c(long j5, Object obj);

    public abstract byte d(long j5, Object obj);

    public abstract double e(long j5, Object obj);

    public abstract float f(long j5, Object obj);

    public final int g(long j5, Object obj) {
        return this.f1110a.getInt(obj, j5);
    }

    public final long h(long j5, Object obj) {
        return this.f1110a.getLong(obj, j5);
    }

    public final Object i(long j5, Object obj) {
        return this.f1110a.getObject(obj, j5);
    }

    public final long j(Field field) {
        return this.f1110a.objectFieldOffset(field);
    }

    public abstract void k(Object obj, long j5, boolean z2);

    public abstract void l(Object obj, long j5, byte b10);

    public abstract void m(Object obj, long j5, double d10);

    public abstract void n(Object obj, long j5, float f);

    public final void o(int i, long j5, Object obj) {
        this.f1110a.putInt(obj, j5, i);
    }

    public final void p(Object obj, long j5, long j8) {
        this.f1110a.putLong(obj, j5, j8);
    }

    public final void q(Object obj, long j5, Object obj2) {
        this.f1110a.putObject(obj, j5, obj2);
    }
}
