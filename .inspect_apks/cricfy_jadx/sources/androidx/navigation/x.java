package androidx.navigation;

import android.os.Bundle;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class x extends y {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Class f1401m;

    public x(Class cls) {
        super(true);
        if (!Serializable.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException(cls + " does not implement Serializable.");
        }
        if (!cls.isEnum()) {
            this.f1401m = cls;
            return;
        }
        throw new IllegalArgumentException(cls + " is an Enum. You should use EnumType instead.");
    }

    @Override // androidx.navigation.y
    public final Object a(String str, Bundle bundle) {
        return (Serializable) bundle.get(str);
    }

    @Override // androidx.navigation.y
    public String b() {
        return this.f1401m.getName();
    }

    @Override // androidx.navigation.y
    public final void d(Bundle bundle, String str, Object obj) {
        Serializable serializable = (Serializable) obj;
        this.f1401m.cast(serializable);
        bundle.putSerializable(str, serializable);
    }

    @Override // androidx.navigation.y
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Serializable c(String str) {
        throw new UnsupportedOperationException("Serializables don't support default values.");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x) {
            return this.f1401m.equals(((x) obj).f1401m);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1401m.hashCode();
    }

    public x(int i, Class cls) {
        super(false);
        if (Serializable.class.isAssignableFrom(cls)) {
            this.f1401m = cls;
            return;
        }
        throw new IllegalArgumentException(cls + " does not implement Serializable.");
    }
}
