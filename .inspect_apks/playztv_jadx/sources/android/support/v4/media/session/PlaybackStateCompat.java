package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a(4);
    public final CharSequence A;
    public final long B;
    public final ArrayList C;
    public final long D;
    public final Bundle E;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f840u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f841v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f842w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float f843x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long f844y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f845z;

    /* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new c();

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final String f846u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final CharSequence f847v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final int f848w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final Bundle f849x;

        public CustomAction(Parcel parcel) {
            this.f846u = parcel.readString();
            this.f847v = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f848w = parcel.readInt();
            this.f849x = parcel.readBundle(b.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "Action:mName='" + ((Object) this.f847v) + ", mIcon=" + this.f848w + ", mExtras=" + this.f849x;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f846u);
            TextUtils.writeToParcel(this.f847v, parcel, i);
            parcel.writeInt(this.f848w);
            parcel.writeBundle(this.f849x);
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f840u = parcel.readInt();
        this.f841v = parcel.readLong();
        this.f843x = parcel.readFloat();
        this.B = parcel.readLong();
        this.f842w = parcel.readLong();
        this.f844y = parcel.readLong();
        this.A = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.C = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.D = parcel.readLong();
        this.E = parcel.readBundle(b.class.getClassLoader());
        this.f845z = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("PlaybackState {state=");
        sb2.append(this.f840u);
        sb2.append(", position=");
        sb2.append(this.f841v);
        sb2.append(", buffered position=");
        sb2.append(this.f842w);
        sb2.append(", speed=");
        sb2.append(this.f843x);
        sb2.append(", updated=");
        sb2.append(this.B);
        sb2.append(", actions=");
        sb2.append(this.f844y);
        sb2.append(", error code=");
        sb2.append(this.f845z);
        sb2.append(", error message=");
        sb2.append(this.A);
        sb2.append(", custom actions=");
        sb2.append(this.C);
        sb2.append(", active item id=");
        return l4.a.n(sb2, this.D, "}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f840u);
        parcel.writeLong(this.f841v);
        parcel.writeFloat(this.f843x);
        parcel.writeLong(this.B);
        parcel.writeLong(this.f842w);
        parcel.writeLong(this.f844y);
        TextUtils.writeToParcel(this.A, parcel, i);
        parcel.writeTypedList(this.C);
        parcel.writeLong(this.D);
        parcel.writeBundle(this.E);
        parcel.writeInt(this.f845z);
    }
}
