package androidx.navigation;

import android.os.Bundle;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w extends y {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Class f1400m;

    public w(Class cls) {
        super(true);
        if (!Serializable.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException(cls + " does not implement Serializable.");
        }
        try {
            this.f1400m = Class.forName("[L" + cls.getName() + ";");
        } catch (ClassNotFoundException e9) {
            throw new RuntimeException(e9);
        }
    }

    @Override // androidx.navigation.y
    public final Object a(String str, Bundle bundle) {
        return (Serializable[]) bundle.get(str);
    }

    @Override // androidx.navigation.y
    public final String b() {
        return this.f1400m.getName();
    }

    @Override // androidx.navigation.y
    public final Object c(String str) {
        throw new UnsupportedOperationException("Arrays don't support default values.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Serializable, java.io.Serializable[], java.lang.Object] */
    @Override // androidx.navigation.y
    public final void d(Bundle bundle, String str, Object obj) {
        ?? r42 = (Serializable[]) obj;
        this.f1400m.cast(r42);
        bundle.putSerializable(str, r42);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || w.class != obj.getClass()) {
            return false;
        }
        return this.f1400m.equals(((w) obj).f1400m);
    }

    public final int hashCode() {
        return this.f1400m.hashCode();
    }
}
