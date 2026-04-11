package id;

import android.os.Parcel;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n extends g {
    public static final m CREATOR = new m();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final LinkedHashMap f6590w;

    public n(LinkedHashMap linkedHashMap) {
        super(linkedHashMap);
        this.f6590w = linkedHashMap;
    }

    @Override // id.g, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // id.g
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!n.class.equals(obj != null ? obj.getClass() : null) || !super.equals(obj)) {
            return false;
        }
        be.h.c(obj, "null cannot be cast to non-null type com.tonyodev.fetch2core.MutableExtras");
        return be.h.a(this.f6590w, ((n) obj).f6590w);
    }

    @Override // id.g
    public final int hashCode() {
        return this.f6590w.hashCode() + (this.f6577u.hashCode() * 31);
    }

    @Override // id.g
    public final String toString() {
        return a();
    }

    @Override // id.g, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        be.h.e(parcel, "dest");
        parcel.writeSerializable(new HashMap(this.f6590w));
    }
}
