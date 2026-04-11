package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a(4);
    public final int A;
    public final CharSequence B;
    public final long C;
    public final ArrayList D;
    public final long E;
    public final Bundle F;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f497v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f498w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f499x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final float f500y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final long f501z;

    /* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new c();

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final String f502v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final CharSequence f503w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final int f504x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final Bundle f505y;

        public CustomAction(Parcel parcel) {
            this.f502v = parcel.readString();
            this.f503w = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f504x = parcel.readInt();
            this.f505y = parcel.readBundle(b.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "Action:mName='" + ((Object) this.f503w) + ", mIcon=" + this.f504x + ", mExtras=" + this.f505y;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f502v);
            TextUtils.writeToParcel(this.f503w, parcel, i);
            parcel.writeInt(this.f504x);
            parcel.writeBundle(this.f505y);
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f497v = parcel.readInt();
        this.f498w = parcel.readLong();
        this.f500y = parcel.readFloat();
        this.C = parcel.readLong();
        this.f499x = parcel.readLong();
        this.f501z = parcel.readLong();
        this.B = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.D = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.E = parcel.readLong();
        this.F = parcel.readBundle(b.class.getClassLoader());
        this.A = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PlaybackState {state=");
        sb.append(this.f497v);
        sb.append(", position=");
        sb.append(this.f498w);
        sb.append(", buffered position=");
        sb.append(this.f499x);
        sb.append(", speed=");
        sb.append(this.f500y);
        sb.append(", updated=");
        sb.append(this.C);
        sb.append(", actions=");
        sb.append(this.f501z);
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
        parcel.writeInt(this.f497v);
        parcel.writeLong(this.f498w);
        parcel.writeFloat(this.f500y);
        parcel.writeLong(this.C);
        parcel.writeLong(this.f499x);
        parcel.writeLong(this.f501z);
        TextUtils.writeToParcel(this.B, parcel, i);
        parcel.writeTypedList(this.D);
        parcel.writeLong(this.E);
        parcel.writeBundle(this.F);
        parcel.writeInt(this.A);
    }
}
