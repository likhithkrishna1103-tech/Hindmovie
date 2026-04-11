package l4;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j0 implements Parcelable {
    public static final Parcelable.Creator<j0> CREATOR = new p(6);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f7726v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final CharSequence f7727w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f7728x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Bundle f7729y;

    public j0(Parcel parcel) {
        String string = parcel.readString();
        string.getClass();
        this.f7726v = string;
        CharSequence charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        charSequence.getClass();
        this.f7727w = charSequence;
        this.f7728x = parcel.readInt();
        this.f7729y = parcel.readBundle(c0.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "Action:mName='" + ((Object) this.f7727w) + ", mIcon=" + this.f7728x + ", mExtras=" + this.f7729y;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7726v);
        TextUtils.writeToParcel(this.f7727w, parcel, i);
        parcel.writeInt(this.f7728x);
        parcel.writeBundle(this.f7729y);
    }
}
