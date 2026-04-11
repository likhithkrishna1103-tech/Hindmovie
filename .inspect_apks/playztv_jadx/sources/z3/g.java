package z3;

import android.text.Layout;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f14848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f14852e;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f14856k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f14857l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Layout.Alignment f14860o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Layout.Alignment f14861p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public b f14863r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f14865t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f14866u;
    public int f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14853g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14854h = -1;
    public int i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14855j = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f14858m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f14859n = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f14862q = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f14864s = Float.MAX_VALUE;

    public final void a(g gVar) {
        int i;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (gVar != null) {
            if (!this.f14850c && gVar.f14850c) {
                this.f14849b = gVar.f14849b;
                this.f14850c = true;
            }
            if (this.f14854h == -1) {
                this.f14854h = gVar.f14854h;
            }
            if (this.i == -1) {
                this.i = gVar.i;
            }
            if (this.f14848a == null && (str = gVar.f14848a) != null) {
                this.f14848a = str;
            }
            if (this.f == -1) {
                this.f = gVar.f;
            }
            if (this.f14853g == -1) {
                this.f14853g = gVar.f14853g;
            }
            if (this.f14859n == -1) {
                this.f14859n = gVar.f14859n;
            }
            if (this.f14860o == null && (alignment2 = gVar.f14860o) != null) {
                this.f14860o = alignment2;
            }
            if (this.f14861p == null && (alignment = gVar.f14861p) != null) {
                this.f14861p = alignment;
            }
            if (this.f14862q == -1) {
                this.f14862q = gVar.f14862q;
            }
            if (this.f14855j == -1) {
                this.f14855j = gVar.f14855j;
                this.f14856k = gVar.f14856k;
            }
            if (this.f14863r == null) {
                this.f14863r = gVar.f14863r;
            }
            if (this.f14864s == Float.MAX_VALUE) {
                this.f14864s = gVar.f14864s;
            }
            if (this.f14865t == null) {
                this.f14865t = gVar.f14865t;
            }
            if (this.f14866u == null) {
                this.f14866u = gVar.f14866u;
            }
            if (!this.f14852e && gVar.f14852e) {
                this.f14851d = gVar.f14851d;
                this.f14852e = true;
            }
            if (this.f14858m != -1 || (i = gVar.f14858m) == -1) {
                return;
            }
            this.f14858m = i;
        }
    }
}
