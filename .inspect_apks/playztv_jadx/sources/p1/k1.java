package p1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class k1 {
    public boolean A;
    public boolean B;
    public boolean C;
    public HashMap D;
    public HashSet E;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9871e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f9872g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f9873h;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public aa.j0 f9877m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public aa.j0 f9878n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f9879o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public aa.j0 f9880p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f9881q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f9882r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f9883s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public aa.j0 f9884t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public j1 f9885u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public aa.j0 f9886v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f9887w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f9888x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f9889y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f9890z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9867a = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9868b = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9869c = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9870d = Integer.MAX_VALUE;
    public int i = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f9874j = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f9875k = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f9876l = true;

    public k1() {
        aa.h0 h0Var = aa.j0.f690v;
        aa.c1 c1Var = aa.c1.f650y;
        this.f9877m = c1Var;
        this.f9878n = c1Var;
        this.f9879o = 0;
        this.f9880p = c1Var;
        this.f9881q = 0;
        this.f9882r = Integer.MAX_VALUE;
        this.f9883s = Integer.MAX_VALUE;
        this.f9884t = c1Var;
        this.f9885u = j1.f9860d;
        this.f9886v = c1Var;
        this.f9887w = 0;
        this.f9888x = true;
        this.f9889y = 0;
        this.f9890z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = new HashMap();
        this.E = new HashSet();
    }

    public static aa.c1 f(String[] strArr) {
        aa.g0 g0VarN = aa.j0.n();
        for (String str : strArr) {
            str.getClass();
            g0VarN.a(s1.b0.P(str));
        }
        return g0VarN.g();
    }

    public void a(h1 h1Var) {
        this.D.put(h1Var.f9783a, h1Var);
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
            if (((h1) it.next()).f9783a.f9764c == i) {
                it.remove();
            }
        }
        return this;
    }

    public final void e(l1 l1Var) {
        this.f9867a = l1Var.f9911a;
        this.f9868b = l1Var.f9912b;
        this.f9869c = l1Var.f9913c;
        this.f9870d = l1Var.f9914d;
        this.f9871e = l1Var.f9915e;
        this.f = l1Var.f;
        this.f9872g = l1Var.f9916g;
        this.f9873h = l1Var.f9917h;
        this.i = l1Var.i;
        this.f9874j = l1Var.f9918j;
        this.f9875k = l1Var.f9919k;
        this.f9876l = l1Var.f9920l;
        this.f9877m = l1Var.f9921m;
        this.f9878n = l1Var.f9922n;
        this.f9879o = l1Var.f9923o;
        this.f9880p = l1Var.f9924p;
        this.f9881q = l1Var.f9925q;
        this.f9882r = l1Var.f9926r;
        this.f9883s = l1Var.f9927s;
        this.f9884t = l1Var.f9928t;
        this.f9885u = l1Var.f9929u;
        this.f9886v = l1Var.f9930v;
        this.f9887w = l1Var.f9931w;
        this.f9888x = l1Var.f9932x;
        this.f9889y = l1Var.f9933y;
        this.f9890z = l1Var.f9934z;
        this.A = l1Var.A;
        this.B = l1Var.B;
        this.C = l1Var.C;
        this.E = new HashSet(l1Var.E);
        this.D = new HashMap(l1Var.D);
    }

    public k1 g() {
        this.f9889y = -3;
        return this;
    }

    public k1 h(h1 h1Var) {
        g1 g1Var = h1Var.f9783a;
        d(g1Var.f9764c);
        this.D.put(g1Var, h1Var);
        return this;
    }

    public k1 i(int i, boolean z2) {
        if (z2) {
            this.E.add(Integer.valueOf(i));
            return this;
        }
        this.E.remove(Integer.valueOf(i));
        return this;
    }
}
