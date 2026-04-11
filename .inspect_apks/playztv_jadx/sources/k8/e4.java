package k8;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e4 extends u7.a {
    public static final Parcelable.Creator<e4> CREATOR = new x(2);
    public final Double A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f7163u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f7164v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f7165w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Long f7166x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f7167y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f7168z;

    public e4(int i, String str, long j5, Long l10, Float f, String str2, String str3, Double d10) {
        this.f7163u = i;
        this.f7164v = str;
        this.f7165w = j5;
        this.f7166x = l10;
        if (i == 1) {
            this.A = f != null ? Double.valueOf(f.doubleValue()) : null;
        } else {
            this.A = d10;
        }
        this.f7167y = str2;
        this.f7168z = str3;
    }

    public final Object a() {
        Long l10 = this.f7166x;
        if (l10 != null) {
            return l10;
        }
        Double d10 = this.A;
        if (d10 != null) {
            return d10;
        }
        String str = this.f7167y;
        if (str != null) {
            return str;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = wa.t1.E(parcel, 20293);
        wa.t1.H(parcel, 1, 4);
        parcel.writeInt(this.f7163u);
        wa.t1.C(parcel, 2, this.f7164v);
        wa.t1.H(parcel, 3, 8);
        parcel.writeLong(this.f7165w);
        Long l10 = this.f7166x;
        if (l10 != null) {
            wa.t1.H(parcel, 4, 8);
            parcel.writeLong(l10.longValue());
        }
        wa.t1.C(parcel, 6, this.f7167y);
        wa.t1.C(parcel, 7, this.f7168z);
        Double d10 = this.A;
        if (d10 != null) {
            wa.t1.H(parcel, 8, 8);
            parcel.writeDouble(d10.doubleValue());
        }
        wa.t1.G(parcel, iE);
    }

    public e4(long j5, Object obj, String str, String str2) {
        t7.v.d(str);
        this.f7163u = 2;
        this.f7164v = str;
        this.f7165w = j5;
        this.f7168z = str2;
        if (obj == null) {
            this.f7166x = null;
            this.A = null;
            this.f7167y = null;
            return;
        }
        if (obj instanceof Long) {
            this.f7166x = (Long) obj;
            this.A = null;
            this.f7167y = null;
        } else if (obj instanceof String) {
            this.f7166x = null;
            this.A = null;
            this.f7167y = (String) obj;
        } else {
            if (obj instanceof Double) {
                this.f7166x = null;
                this.A = (Double) obj;
                this.f7167y = null;
                return;
            }
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    public e4(f4 f4Var) {
        this(f4Var.f7182d, f4Var.f7183e, f4Var.f7181c, f4Var.f7180b);
    }
}
