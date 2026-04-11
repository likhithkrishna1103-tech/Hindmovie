package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s0 implements Parcelable {
    public static final Parcelable.Creator<s0> CREATOR = new android.support.v4.media.a(7);
    public ArrayList A;
    public ArrayList B;
    public ArrayList C;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ArrayList f1069v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ArrayList f1070w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public b[] f1071x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f1072y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f1073z;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.f1069v);
        parcel.writeStringList(this.f1070w);
        parcel.writeTypedArray(this.f1071x, i);
        parcel.writeInt(this.f1072y);
        parcel.writeString(this.f1073z);
        parcel.writeStringList(this.A);
        parcel.writeTypedList(this.B);
        parcel.writeTypedList(this.C);
    }
}
