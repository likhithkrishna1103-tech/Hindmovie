package g2;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v1.p f4685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v1.p f4686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f4688e;

    public g(String str, v1.p pVar, v1.p pVar2, int i, int i10) {
        y1.d.b(i == 0 || i10 == 0);
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        this.f4684a = str;
        pVar.getClass();
        this.f4685b = pVar;
        pVar2.getClass();
        this.f4686c = pVar2;
        this.f4687d = i;
        this.f4688e = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && g.class == obj.getClass()) {
            g gVar = (g) obj;
            if (this.f4687d == gVar.f4687d && this.f4688e == gVar.f4688e && this.f4684a.equals(gVar.f4684a) && this.f4685b.equals(gVar.f4685b) && this.f4686c.equals(gVar.f4686c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f4686c.hashCode() + ((this.f4685b.hashCode() + l0.e.e((((527 + this.f4687d) * 31) + this.f4688e) * 31, 31, this.f4684a)) * 31);
    }
}
