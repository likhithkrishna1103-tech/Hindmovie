package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f1 extends g1 {
    @Override // androidx.datastore.preferences.protobuf.g1
    public final boolean c(long j4, Object obj) {
        return this.f708a.getBoolean(obj, j4);
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final double d(long j4, Object obj) {
        return this.f708a.getDouble(obj, j4);
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final float e(long j4, Object obj) {
        return this.f708a.getFloat(obj, j4);
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final void j(Object obj, long j4, boolean z10) {
        this.f708a.putBoolean(obj, j4, z10);
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final void k(Object obj, long j4, byte b8) {
        this.f708a.putByte(obj, j4, b8);
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final void l(Object obj, long j4, double d10) {
        this.f708a.putDouble(obj, j4, d10);
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final void m(Object obj, long j4, float f) {
        this.f708a.putFloat(obj, j4, f);
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final boolean q() {
        if (!super.q()) {
            return false;
        }
        try {
            Class<?> cls = this.f708a.getClass();
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, cls2);
            cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, cls2);
            cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
            cls.getMethod("getDouble", Object.class, cls2);
            cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
            return true;
        } catch (Throwable th) {
            h1.a(th);
            return false;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final boolean r() {
        Unsafe unsafe = this.f708a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getLong", Object.class, cls2);
                if (h1.g() != null) {
                    try {
                        Class<?> cls3 = this.f708a.getClass();
                        cls3.getMethod("getByte", cls2);
                        cls3.getMethod("putByte", cls2, Byte.TYPE);
                        cls3.getMethod("getInt", cls2);
                        cls3.getMethod("putInt", cls2, Integer.TYPE);
                        cls3.getMethod("getLong", cls2);
                        cls3.getMethod("putLong", cls2, cls2);
                        cls3.getMethod("copyMemory", cls2, cls2, cls2);
                        cls3.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                        return true;
                    } catch (Throwable th) {
                        h1.a(th);
                        return false;
                    }
                }
            } catch (Throwable th2) {
                h1.a(th2);
            }
        }
        return false;
    }
}
