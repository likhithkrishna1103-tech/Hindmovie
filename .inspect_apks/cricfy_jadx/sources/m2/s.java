package m2;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f8137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f8138e;
    public final String f;

    public s(int i, int i10, String str, String str2, String str3, String str4) {
        this.f8134a = i;
        this.f8135b = i10;
        this.f8136c = str;
        this.f8137d = str2;
        this.f8138e = str3;
        this.f = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && s.class == obj.getClass()) {
            s sVar = (s) obj;
            if (this.f8134a == sVar.f8134a && this.f8135b == sVar.f8135b && TextUtils.equals(this.f8136c, sVar.f8136c) && TextUtils.equals(this.f8137d, sVar.f8137d) && TextUtils.equals(this.f8138e, sVar.f8138e) && TextUtils.equals(this.f, sVar.f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = ((this.f8134a * 31) + this.f8135b) * 31;
        String str = this.f8136c;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f8137d;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f8138e;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }
}
