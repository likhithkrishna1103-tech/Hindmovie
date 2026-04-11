package pa;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends a1.c {
    public static final Parcelable.Creator<b0> CREATOR = new a1.b(11);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CharSequence f10051x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f10052y;

    public b0(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f10051x = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f10052y = parcel.readInt() == 1;
    }

    public final String toString() {
        return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f10051x) + "}";
    }

    @Override // a1.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        TextUtils.writeToParcel(this.f10051x, parcel, i);
        parcel.writeInt(this.f10052y ? 1 : 0);
    }
}
