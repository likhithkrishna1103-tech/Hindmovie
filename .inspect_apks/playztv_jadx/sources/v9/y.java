package v9;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y extends x0.b {
    public static final Parcelable.Creator<y> CREATOR = new c0.g(12);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CharSequence f13427w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f13428x;

    public y(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f13427w = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f13428x = parcel.readInt() == 1;
    }

    public final String toString() {
        return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f13427w) + "}";
    }

    @Override // x0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        TextUtils.writeToParcel(this.f13427w, parcel, i);
        parcel.writeInt(this.f13428x ? 1 : 0);
    }
}
