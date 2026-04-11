package l4;

import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.AbstractCollection;
import java.util.ArrayList;
import ua.z0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k0 implements Parcelable {
    public static final Parcelable.Creator<k0> CREATOR = new p(5);
    public final int A;
    public final CharSequence B;
    public final long C;
    public final AbstractCollection D;
    public final long E;
    public final Bundle F;
    public PlaybackState G;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f7731v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f7732w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f7733x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final float f7734y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final long f7735z;

    public k0(int i, long j4, long j7, float f, long j10, int i10, CharSequence charSequence, long j11, ArrayList arrayList, long j12, Bundle bundle) {
        this.f7731v = i;
        this.f7732w = j4;
        this.f7733x = j7;
        this.f7734y = f;
        this.f7735z = j10;
        this.A = i10;
        this.B = charSequence;
        this.C = j11;
        this.D = new ArrayList(arrayList);
        this.E = j12;
        this.F = bundle;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PlaybackState {state=");
        sb.append(this.f7731v);
        sb.append(", position=");
        sb.append(this.f7732w);
        sb.append(", buffered position=");
        sb.append(this.f7733x);
        sb.append(", speed=");
        sb.append(this.f7734y);
        sb.append(", updated=");
        sb.append(this.C);
        sb.append(", actions=");
        sb.append(this.f7735z);
        sb.append(", error code=");
        sb.append(this.A);
        sb.append(", error message=");
        sb.append(this.B);
        sb.append(", custom actions=");
        sb.append(this.D);
        sb.append(", active item id=");
        return q4.a.p(sb, this.E, "}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7731v);
        parcel.writeLong(this.f7732w);
        parcel.writeFloat(this.f7734y);
        parcel.writeLong(this.C);
        parcel.writeLong(this.f7733x);
        parcel.writeLong(this.f7735z);
        TextUtils.writeToParcel(this.B, parcel, i);
        parcel.writeTypedList(this.D);
        parcel.writeLong(this.E);
        parcel.writeBundle(this.F);
        parcel.writeInt(this.A);
    }

    public k0(Parcel parcel) {
        this.f7731v = parcel.readInt();
        this.f7732w = parcel.readLong();
        this.f7734y = parcel.readFloat();
        this.C = parcel.readLong();
        this.f7733x = parcel.readLong();
        this.f7735z = parcel.readLong();
        this.B = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        AbstractCollection abstractCollectionCreateTypedArrayList = parcel.createTypedArrayList(j0.CREATOR);
        if (abstractCollectionCreateTypedArrayList == null) {
            ua.g0 g0Var = ua.i0.f12341w;
            abstractCollectionCreateTypedArrayList = z0.f12413z;
        }
        this.D = abstractCollectionCreateTypedArrayList;
        this.E = parcel.readLong();
        this.F = parcel.readBundle(c0.class.getClassLoader());
        this.A = parcel.readInt();
    }
}
