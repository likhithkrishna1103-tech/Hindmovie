package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u extends y {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Class f1398m;

    public u(Class cls) {
        super(true);
        if (!Parcelable.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException(cls + " does not implement Parcelable.");
        }
        try {
            this.f1398m = Class.forName("[L" + cls.getName() + ";");
        } catch (ClassNotFoundException e9) {
            throw new RuntimeException(e9);
        }
    }

    @Override // androidx.navigation.y
    public final Object a(String str, Bundle bundle) {
        return (Parcelable[]) bundle.get(str);
    }

    @Override // androidx.navigation.y
    public final String b() {
        return this.f1398m.getName();
    }

    @Override // androidx.navigation.y
    public final Object c(String str) {
        throw new UnsupportedOperationException("Arrays don't support default values.");
    }

    @Override // androidx.navigation.y
    public final void d(Bundle bundle, String str, Object obj) {
        Parcelable[] parcelableArr = (Parcelable[]) obj;
        this.f1398m.cast(parcelableArr);
        bundle.putParcelableArray(str, parcelableArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || u.class != obj.getClass()) {
            return false;
        }
        return this.f1398m.equals(((u) obj).f1398m);
    }

    public final int hashCode() {
        return this.f1398m.hashCode();
    }
}
