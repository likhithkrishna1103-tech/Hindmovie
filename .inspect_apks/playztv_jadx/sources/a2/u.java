package a2;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s1.w f422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z9.l f423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public z9.l f424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public z9.l f425e;
    public z9.l f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public z9.l f426g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Looper f427h;
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p1.d f428j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f429k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f430l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d2 f431m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c2 f432n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f433o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f434p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f435q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final j f436r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f437s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final long f438t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f439u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f440v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f441w;

    public u(Context context) {
        e eVar = new e(context, 1);
        e eVar2 = new e(context, 2);
        e eVar3 = new e(context, 3);
        t tVar = new t(0);
        e eVar4 = new e(context, 4);
        context.getClass();
        this.f421a = context;
        this.f423c = eVar;
        this.f424d = eVar2;
        this.f425e = eVar3;
        this.f = tVar;
        this.f426g = eVar4;
        int i = s1.b0.f11647a;
        Looper looperMyLooper = Looper.myLooper();
        this.f427h = looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper;
        this.f428j = p1.d.f9682h;
        this.f429k = 1;
        this.f430l = true;
        this.f431m = d2.f186c;
        this.f433o = 5000L;
        this.f434p = 15000L;
        this.f435q = 3000L;
        this.f432n = c2.f181b;
        this.f436r = new j(s1.b0.O(20L), s1.b0.O(500L));
        this.f422b = s1.w.f11715a;
        this.f437s = 500L;
        this.f438t = 2000L;
        this.f439u = true;
        this.f441w = "";
        this.i = -1000;
        new pa.b();
    }

    public final o0 a() {
        s1.d.g(!this.f440v);
        this.f440v = true;
        return new o0(this);
    }

    public final void b(n nVar) {
        s1.d.g(!this.f440v);
        this.f423c = new r(4, nVar);
    }
}
