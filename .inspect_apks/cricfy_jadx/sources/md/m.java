package md;

import android.os.Parcel;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends g {
    public static final l CREATOR = new l();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final LinkedHashMap f8445x;

    public m(LinkedHashMap linkedHashMap) {
        super(linkedHashMap);
        this.f8445x = linkedHashMap;
    }

    @Override // md.g, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // md.g
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!m.class.equals(obj != null ? obj.getClass() : null) || !super.equals(obj)) {
            return false;
        }
        ge.i.c(obj, "null cannot be cast to non-null type com.tonyodev.fetch2core.MutableExtras");
        return ge.i.a(this.f8445x, ((m) obj).f8445x);
    }

    @Override // md.g
    public final int hashCode() {
        return this.f8445x.hashCode() + (this.f8433v.hashCode() * 31);
    }

    @Override // md.g
    public final String toString() {
        return a();
    }

    @Override // md.g, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ge.i.e(parcel, "dest");
        parcel.writeSerializable(new HashMap(this.f8445x));
    }
}
