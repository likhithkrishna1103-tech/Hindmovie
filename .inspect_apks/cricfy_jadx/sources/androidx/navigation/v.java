package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v extends y {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Class f1399m;

    public v(Class cls) {
        super(true);
        if (Parcelable.class.isAssignableFrom(cls) || Serializable.class.isAssignableFrom(cls)) {
            this.f1399m = cls;
            return;
        }
        throw new IllegalArgumentException(cls + " does not implement Parcelable or Serializable.");
    }

    @Override // androidx.navigation.y
    public final Object a(String str, Bundle bundle) {
        return bundle.get(str);
    }

    @Override // androidx.navigation.y
    public final String b() {
        return this.f1399m.getName();
    }

    @Override // androidx.navigation.y
    public final Object c(String str) {
        throw new UnsupportedOperationException("Parcelables don't support default values.");
    }

    @Override // androidx.navigation.y
    public final void d(Bundle bundle, String str, Object obj) {
        this.f1399m.cast(obj);
        if (obj == null || (obj instanceof Parcelable)) {
            bundle.putParcelable(str, (Parcelable) obj);
        } else if (obj instanceof Serializable) {
            bundle.putSerializable(str, (Serializable) obj);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || v.class != obj.getClass()) {
            return false;
        }
        return this.f1399m.equals(((v) obj).f1399m);
    }

    public final int hashCode() {
        return this.f1399m.hashCode();
    }
}
