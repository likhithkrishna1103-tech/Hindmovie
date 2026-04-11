package a1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c implements Parcelable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Parcelable f112v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a f111w = new a();
    public static final Parcelable.Creator<c> CREATOR = new b(0);

    public c() {
        this.f112v = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f112v, i);
    }

    public c(Parcelable parcelable) {
        if (parcelable != null) {
            this.f112v = parcelable == f111w ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public c(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.f112v = parcelable == null ? f111w : parcelable;
    }
}
