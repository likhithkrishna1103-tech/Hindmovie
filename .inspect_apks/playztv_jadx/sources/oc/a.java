package oc;

import android.os.Parcel;
import android.os.Parcelable;
import k8.x;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new x(8);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f9505u = "https://t.me/playztv";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f9506v = "Notice text will be show here.";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f9507w = "https://playztv.online/";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f9508x = "https://playztv.online/";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f9509y = "PlayZ Tv, we are still working on it to provide more better result.";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f9510z = "https://t.me/playztv";
    public String A = "";
    public String B = "";
    public String C = "no";
    public String D = "no";
    public String E = "no";
    public String F = "no";
    public String G = "test@gmail.com";
    public String H = "no";
    public int I = 1;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9505u);
        parcel.writeString(this.f9506v);
        parcel.writeString(this.f9507w);
        parcel.writeString(this.f9508x);
        parcel.writeString(this.f9509y);
        parcel.writeString(this.f9510z);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeString(this.E);
        parcel.writeString(this.F);
        parcel.writeString(this.G);
        parcel.writeString(this.H);
        parcel.writeInt(this.I);
    }
}
