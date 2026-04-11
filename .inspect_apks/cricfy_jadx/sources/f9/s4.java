package f9;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s4 extends p8.a {
    public static final Parcelable.Creator<s4> CREATOR = new android.support.v4.media.a(25);
    public final String A;
    public final Double B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f4403v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f4404w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f4405x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Long f4406y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f4407z;

    public s4(int i, String str, long j4, Long l10, Float f, String str2, String str3, Double d10) {
        this.f4403v = i;
        this.f4404w = str;
        this.f4405x = j4;
        this.f4406y = l10;
        this.B = i == 1 ? f != null ? Double.valueOf(f.doubleValue()) : null : d10;
        this.f4407z = str2;
        this.A = str3;
    }

    public final Object a() {
        Long l10 = this.f4406y;
        if (l10 != null) {
            return l10;
        }
        Double d10 = this.B;
        if (d10 != null) {
            return d10;
        }
        String str = this.f4407z;
        if (str != null) {
            return str;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        android.support.v4.media.a.b(this, parcel);
    }

    public s4(long j4, Object obj, String str, String str2) {
        o8.u.d(str);
        this.f4403v = 2;
        this.f4404w = str;
        this.f4405x = j4;
        this.A = str2;
        if (obj == null) {
            this.f4406y = null;
            this.B = null;
            this.f4407z = null;
            return;
        }
        if (obj instanceof Long) {
            this.f4406y = (Long) obj;
            this.B = null;
            this.f4407z = null;
        } else if (obj instanceof String) {
            this.f4406y = null;
            this.B = null;
            this.f4407z = (String) obj;
        } else {
            if (obj instanceof Double) {
                this.f4406y = null;
                this.B = (Double) obj;
                this.f4407z = null;
                return;
            }
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    public s4(t4 t4Var) {
        this(t4Var.f4424d, t4Var.f4425e, t4Var.f4423c, t4Var.f4422b);
    }
}
