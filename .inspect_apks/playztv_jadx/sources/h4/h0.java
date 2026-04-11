package h4;

import aa.c1;
import aa.j0;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.AbstractCollection;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h0 implements Parcelable {
    public static final Parcelable.Creator<h0> CREATOR = new a9.b(23);
    public final CharSequence A;
    public final long B;
    public final AbstractCollection C;
    public final long D;
    public final Bundle E;
    public PlaybackState F;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f5811u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f5812v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f5813w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float f5814x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long f5815y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f5816z;

    public h0(int i, long j5, long j8, float f, long j10, int i10, CharSequence charSequence, long j11, ArrayList arrayList, long j12, Bundle bundle) {
        this.f5811u = i;
        this.f5812v = j5;
        this.f5813w = j8;
        this.f5814x = f;
        this.f5815y = j10;
        this.f5816z = i10;
        this.A = charSequence;
        this.B = j11;
        this.C = new ArrayList(arrayList);
        this.D = j12;
        this.E = bundle;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("PlaybackState {state=");
        sb2.append(this.f5811u);
        sb2.append(", position=");
        sb2.append(this.f5812v);
        sb2.append(", buffered position=");
        sb2.append(this.f5813w);
        sb2.append(", speed=");
        sb2.append(this.f5814x);
        sb2.append(", updated=");
        sb2.append(this.B);
        sb2.append(", actions=");
        sb2.append(this.f5815y);
        sb2.append(", error code=");
        sb2.append(this.f5816z);
        sb2.append(", error message=");
        sb2.append(this.A);
        sb2.append(", custom actions=");
        sb2.append(this.C);
        sb2.append(", active item id=");
        return l4.a.n(sb2, this.D, "}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5811u);
        parcel.writeLong(this.f5812v);
        parcel.writeFloat(this.f5814x);
        parcel.writeLong(this.B);
        parcel.writeLong(this.f5813w);
        parcel.writeLong(this.f5815y);
        TextUtils.writeToParcel(this.A, parcel, i);
        parcel.writeTypedList(this.C);
        parcel.writeLong(this.D);
        parcel.writeBundle(this.E);
        parcel.writeInt(this.f5816z);
    }

    public h0(Parcel parcel) {
        this.f5811u = parcel.readInt();
        this.f5812v = parcel.readLong();
        this.f5814x = parcel.readFloat();
        this.B = parcel.readLong();
        this.f5813w = parcel.readLong();
        this.f5815y = parcel.readLong();
        this.A = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        AbstractCollection abstractCollectionCreateTypedArrayList = parcel.createTypedArrayList(g0.CREATOR);
        if (abstractCollectionCreateTypedArrayList == null) {
            aa.h0 h0Var = j0.f690v;
            abstractCollectionCreateTypedArrayList = c1.f650y;
        }
        this.C = abstractCollectionCreateTypedArrayList;
        this.D = parcel.readLong();
        this.E = parcel.readBundle(z.class.getClassLoader());
        this.f5816z = parcel.readInt();
    }
}
