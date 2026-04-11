package androidx.navigation;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new android.support.v4.media.a(9);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final UUID f1349v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f1350w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Bundle f1351x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Bundle f1352y;

    public g(f fVar) {
        this.f1349v = fVar.A;
        this.f1350w = fVar.f1331w.f1371x;
        this.f1351x = fVar.f1332x;
        Bundle bundle = new Bundle();
        this.f1352y = bundle;
        fVar.f1334z.f(bundle);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1349v.toString());
        parcel.writeInt(this.f1350w);
        parcel.writeBundle(this.f1351x);
        parcel.writeBundle(this.f1352y);
    }

    public g(Parcel parcel) {
        this.f1349v = UUID.fromString(parcel.readString());
        this.f1350w = parcel.readInt();
        this.f1351x = parcel.readBundle(g.class.getClassLoader());
        this.f1352y = parcel.readBundle(g.class.getClassLoader());
    }
}
