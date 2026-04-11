package v1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class k1 {
    public boolean A;
    public boolean B;
    public boolean C;
    public HashMap D;
    public HashSet E;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12804e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12805g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12806h;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ua.i0 f12810m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ua.i0 f12811n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f12812o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ua.i0 f12813p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f12814q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f12815r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f12816s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ua.i0 f12817t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public j1 f12818u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ua.i0 f12819v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f12820w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f12821x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f12822y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f12823z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12800a = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12801b = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12802c = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12803d = Integer.MAX_VALUE;
    public int i = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f12807j = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f12808k = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f12809l = true;

    public k1() {
        ua.g0 g0Var = ua.i0.f12341w;
        ua.z0 z0Var = ua.z0.f12413z;
        this.f12810m = z0Var;
        this.f12811n = z0Var;
        this.f12812o = 0;
        this.f12813p = z0Var;
        this.f12814q = 0;
        this.f12815r = Integer.MAX_VALUE;
        this.f12816s = Integer.MAX_VALUE;
        this.f12817t = z0Var;
        this.f12818u = j1.f12789d;
        this.f12819v = z0Var;
        this.f12820w = 0;
        this.f12821x = true;
        this.f12822y = 0;
        this.f12823z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = new HashMap();
        this.E = new HashSet();
    }

    public static ua.z0 f(String[] strArr) {
        ua.f0 f0VarJ = ua.i0.j();
        for (String str : strArr) {
            str.getClass();
            f0VarJ.a(y1.a0.P(str));
        }
        return f0VarJ.g();
    }

    public void a(h1 h1Var) {
        this.D.put(h1Var.f12711a, h1Var);
    }

    public l1 b() {
        return new l1(this);
    }

    public k1 c() {
        this.D.clear();
        return this;
    }

    public k1 d(int i) {
        Iterator it = this.D.values().iterator();
        while (it.hasNext()) {
            if (((h1) it.next()).f12711a.f12704c == i) {
                it.remove();
            }
        }
        return this;
    }

    public final void e(l1 l1Var) {
        this.f12800a = l1Var.f12844a;
        this.f12801b = l1Var.f12845b;
        this.f12802c = l1Var.f12846c;
        this.f12803d = l1Var.f12847d;
        this.f12804e = l1Var.f12848e;
        this.f = l1Var.f;
        this.f12805g = l1Var.f12849g;
        this.f12806h = l1Var.f12850h;
        this.i = l1Var.i;
        this.f12807j = l1Var.f12851j;
        this.f12808k = l1Var.f12852k;
        this.f12809l = l1Var.f12853l;
        this.f12810m = l1Var.f12854m;
        this.f12811n = l1Var.f12855n;
        this.f12812o = l1Var.f12856o;
        this.f12813p = l1Var.f12857p;
        this.f12814q = l1Var.f12858q;
        this.f12815r = l1Var.f12859r;
        this.f12816s = l1Var.f12860s;
        this.f12817t = l1Var.f12861t;
        this.f12818u = l1Var.f12862u;
        this.f12819v = l1Var.f12863v;
        this.f12820w = l1Var.f12864w;
        this.f12821x = l1Var.f12865x;
        this.f12822y = l1Var.f12866y;
        this.f12823z = l1Var.f12867z;
        this.A = l1Var.A;
        this.B = l1Var.B;
        this.C = l1Var.C;
        this.E = new HashSet(l1Var.E);
        this.D = new HashMap(l1Var.D);
    }

    public k1 g() {
        this.f12822y = -3;
        return this;
    }

    public k1 h(h1 h1Var) {
        g1 g1Var = h1Var.f12711a;
        d(g1Var.f12704c);
        this.D.put(g1Var, h1Var);
        return this;
    }

    public k1 i(int i, boolean z10) {
        if (z10) {
            this.E.add(Integer.valueOf(i));
            return this;
        }
        this.E.remove(Integer.valueOf(i));
        return this;
    }
}
