package g2;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f4932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f4933e;
    public final String f;

    public r(int i, int i10, String str, String str2, String str3, String str4) {
        this.f4929a = i;
        this.f4930b = i10;
        this.f4931c = str;
        this.f4932d = str2;
        this.f4933e = str3;
        this.f = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && r.class == obj.getClass()) {
            r rVar = (r) obj;
            if (this.f4929a == rVar.f4929a && this.f4930b == rVar.f4930b && TextUtils.equals(this.f4931c, rVar.f4931c) && TextUtils.equals(this.f4932d, rVar.f4932d) && TextUtils.equals(this.f4933e, rVar.f4933e) && TextUtils.equals(this.f, rVar.f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = ((this.f4929a * 31) + this.f4930b) * 31;
        String str = this.f4931c;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f4932d;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f4933e;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }
}
