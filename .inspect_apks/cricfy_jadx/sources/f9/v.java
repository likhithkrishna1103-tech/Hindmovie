package f9;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v extends p8.a {
    public static final Parcelable.Creator<v> CREATOR = new android.support.v4.media.a(20);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f4441v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final u f4442w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f4443x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long f4444y;

    public v(v vVar, long j4) {
        o8.u.g(vVar);
        this.f4441v = vVar.f4441v;
        this.f4442w = vVar.f4442w;
        this.f4443x = vVar.f4443x;
        this.f4444y = j4;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f4442w);
        String str = this.f4443x;
        int length = String.valueOf(str).length();
        String str2 = this.f4441v;
        StringBuilder sb = new StringBuilder(length + 13 + String.valueOf(str2).length() + 8 + strValueOf.length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        return q4.a.q(sb, ",params=", strValueOf);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        android.support.v4.media.a.a(this, parcel, i);
    }

    public v(String str, u uVar, String str2, long j4) {
        this.f4441v = str;
        this.f4442w = uVar;
        this.f4443x = str2;
        this.f4444y = j4;
    }
}
