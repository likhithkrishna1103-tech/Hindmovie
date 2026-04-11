package h4;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g0 implements Parcelable {
    public static final Parcelable.Creator<g0> CREATOR = new a9.b(24);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f5807u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final CharSequence f5808v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f5809w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Bundle f5810x;

    public g0(Parcel parcel) {
        String string = parcel.readString();
        string.getClass();
        this.f5807u = string;
        CharSequence charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        charSequence.getClass();
        this.f5808v = charSequence;
        this.f5809w = parcel.readInt();
        this.f5810x = parcel.readBundle(z.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "Action:mName='" + ((Object) this.f5808v) + ", mIcon=" + this.f5809w + ", mExtras=" + this.f5810x;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5807u);
        TextUtils.writeToParcel(this.f5808v, parcel, i);
        parcel.writeInt(this.f5809w);
        parcel.writeBundle(this.f5810x);
    }
}
