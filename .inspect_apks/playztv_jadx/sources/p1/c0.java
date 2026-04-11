package p1;

import android.net.Uri;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {
    public static final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f9658j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f9659k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f9660l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f9661m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f9662n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f9663o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f9664p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f9665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a0 f9667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u f9668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f9669e;
    public final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final aa.j0 f9670g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f9671h;

    static {
        int i10 = s1.b0.f11647a;
        i = Integer.toString(0, 36);
        f9658j = Integer.toString(1, 36);
        f9659k = Integer.toString(2, 36);
        f9660l = Integer.toString(3, 36);
        f9661m = Integer.toString(4, 36);
        f9662n = Integer.toString(5, 36);
        f9663o = Integer.toString(6, 36);
        f9664p = Integer.toString(7, 36);
    }

    public c0(Uri uri, String str, a0 a0Var, u uVar, List list, String str2, aa.j0 j0Var, long j5) {
        this.f9665a = uri;
        this.f9666b = m0.p(str);
        this.f9667c = a0Var;
        this.f9668d = uVar;
        this.f9669e = list;
        this.f = str2;
        this.f9670g = j0Var;
        aa.g0 g0VarN = aa.j0.n();
        for (int i10 = 0; i10 < j0Var.size(); i10++) {
            f0 f0Var = (f0) j0Var.get(i10);
            na.a aVar = new na.a();
            aVar.f8876d = f0Var.f9735a;
            aVar.f8873a = f0Var.f9736b;
            aVar.f8877e = f0Var.f9737c;
            aVar.f8874b = f0Var.f9738d;
            aVar.f8875c = f0Var.f9739e;
            aVar.f = f0Var.f;
            aVar.f8878g = f0Var.f9740g;
            g0VarN.a(new e0(aVar));
        }
        g0VarN.g();
        this.f9671h = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return this.f9665a.equals(c0Var.f9665a) && Objects.equals(this.f9666b, c0Var.f9666b) && Objects.equals(this.f9667c, c0Var.f9667c) && Objects.equals(this.f9668d, c0Var.f9668d) && this.f9669e.equals(c0Var.f9669e) && Objects.equals(this.f, c0Var.f) && this.f9670g.equals(c0Var.f9670g) && this.f9671h == c0Var.f9671h;
    }

    public final int hashCode() {
        int iHashCode = this.f9665a.hashCode() * 31;
        String str = this.f9666b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        a0 a0Var = this.f9667c;
        int iHashCode3 = (iHashCode2 + (a0Var == null ? 0 : a0Var.hashCode())) * 31;
        u uVar = this.f9668d;
        int iHashCode4 = (this.f9669e.hashCode() + ((iHashCode3 + (uVar == null ? 0 : uVar.hashCode())) * 31)) * 31;
        String str2 = this.f;
        return (int) ((((long) ((this.f9670g.hashCode() + ((iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31)) * 31)) * 31) + this.f9671h);
    }
}
