package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new android.support.v4.media.a(5);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f949v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList f950w;

    public c(Parcel parcel) {
        this.f949v = parcel.createStringArrayList();
        this.f950w = parcel.createTypedArrayList(b.CREATOR);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.f949v);
        parcel.writeTypedList(this.f950w);
    }
}
