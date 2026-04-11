package j1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends a1.c {
    public static final Parcelable.Creator<e> CREATOR = new a1.b(5);
    public int A;
    public int B;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f6507x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f6508y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f6509z;

    public e(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f6507x = 0;
        this.f6507x = parcel.readInt();
        this.f6508y = parcel.readInt();
        this.f6509z = parcel.readInt();
        this.A = parcel.readInt();
        this.B = parcel.readInt();
    }

    @Override // a1.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f6507x);
        parcel.writeInt(this.f6508y);
        parcel.writeInt(this.f6509z);
        parcel.writeInt(this.A);
        parcel.writeInt(this.B);
    }
}
