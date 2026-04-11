package v1;

import android.net.Uri;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {
    public static final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f12598j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f12599k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f12600l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f12601m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f12602n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f12603o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f12604p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f12605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f12607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t f12608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f12609e;
    public final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ua.i0 f12610g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f12611h;

    static {
        int i10 = y1.a0.f14551a;
        i = Integer.toString(0, 36);
        f12598j = Integer.toString(1, 36);
        f12599k = Integer.toString(2, 36);
        f12600l = Integer.toString(3, 36);
        f12601m = Integer.toString(4, 36);
        f12602n = Integer.toString(5, 36);
        f12603o = Integer.toString(6, 36);
        f12604p = Integer.toString(7, 36);
    }

    public c0(Uri uri, String str, z zVar, t tVar, List list, String str2, ua.i0 i0Var, long j4) {
        this.f12605a = uri;
        this.f12606b = m0.p(str);
        this.f12607c = zVar;
        this.f12608d = tVar;
        this.f12609e = list;
        this.f = str2;
        this.f12610g = i0Var;
        ua.f0 f0VarJ = ua.i0.j();
        for (int i10 = 0; i10 < i0Var.size(); i10++) {
            f0 f0Var = (f0) i0Var.get(i10);
            hb.a aVar = new hb.a();
            aVar.f5873d = f0Var.f12668a;
            aVar.f5870a = f0Var.f12669b;
            aVar.f5874e = f0Var.f12670c;
            aVar.f5871b = f0Var.f12671d;
            aVar.f5872c = f0Var.f12672e;
            aVar.f = f0Var.f;
            aVar.f5875g = f0Var.f12673g;
            f0VarJ.a(new e0(aVar));
        }
        f0VarJ.g();
        this.f12611h = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return this.f12605a.equals(c0Var.f12605a) && Objects.equals(this.f12606b, c0Var.f12606b) && Objects.equals(this.f12607c, c0Var.f12607c) && Objects.equals(this.f12608d, c0Var.f12608d) && this.f12609e.equals(c0Var.f12609e) && Objects.equals(this.f, c0Var.f) && this.f12610g.equals(c0Var.f12610g) && this.f12611h == c0Var.f12611h;
    }

    public final int hashCode() {
        int iHashCode = this.f12605a.hashCode() * 31;
        String str = this.f12606b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        z zVar = this.f12607c;
        int iHashCode3 = (iHashCode2 + (zVar == null ? 0 : zVar.hashCode())) * 31;
        t tVar = this.f12608d;
        int iHashCode4 = (this.f12609e.hashCode() + ((iHashCode3 + (tVar == null ? 0 : tVar.hashCode())) * 31)) * 31;
        String str2 = this.f;
        return (int) ((((long) ((this.f12610g.hashCode() + ((iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31)) * 31)) * 31) + this.f12611h);
    }
}
