package d4;

import android.text.Layout;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3375e;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f3379k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f3380l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Layout.Alignment f3383o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Layout.Alignment f3384p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public b f3386r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f3388t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f3389u;
    public int f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3376g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3377h = -1;
    public int i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3378j = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3381m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3382n = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f3385q = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f3387s = Float.MAX_VALUE;

    public final void a(h hVar) {
        int i;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (hVar != null) {
            if (!this.f3373c && hVar.f3373c) {
                this.f3372b = hVar.f3372b;
                this.f3373c = true;
            }
            if (this.f3377h == -1) {
                this.f3377h = hVar.f3377h;
            }
            if (this.i == -1) {
                this.i = hVar.i;
            }
            if (this.f3371a == null && (str = hVar.f3371a) != null) {
                this.f3371a = str;
            }
            if (this.f == -1) {
                this.f = hVar.f;
            }
            if (this.f3376g == -1) {
                this.f3376g = hVar.f3376g;
            }
            if (this.f3382n == -1) {
                this.f3382n = hVar.f3382n;
            }
            if (this.f3383o == null && (alignment2 = hVar.f3383o) != null) {
                this.f3383o = alignment2;
            }
            if (this.f3384p == null && (alignment = hVar.f3384p) != null) {
                this.f3384p = alignment;
            }
            if (this.f3385q == -1) {
                this.f3385q = hVar.f3385q;
            }
            if (this.f3378j == -1) {
                this.f3378j = hVar.f3378j;
                this.f3379k = hVar.f3379k;
            }
            if (this.f3386r == null) {
                this.f3386r = hVar.f3386r;
            }
            if (this.f3387s == Float.MAX_VALUE) {
                this.f3387s = hVar.f3387s;
            }
            if (this.f3388t == null) {
                this.f3388t = hVar.f3388t;
            }
            if (this.f3389u == null) {
                this.f3389u = hVar.f3389u;
            }
            if (!this.f3375e && hVar.f3375e) {
                this.f3374d = hVar.f3374d;
                this.f3375e = true;
            }
            if (this.f3381m != -1 || (i = hVar.f3381m) == -1) {
                return;
            }
            this.f3381m = i;
        }
    }
}
