package g2;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y1.v f4855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ta.l f4856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ta.l f4857d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ta.l f4858e;
    public ta.l f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ta.l f4859g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Looper f4860h;
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final v1.c f4861j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f4862k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f4863l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final r1 f4864m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final q1 f4865n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f4866o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f4867p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f4868q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final h f4869r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f4870s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final long f4871t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f4872u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f4873v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f4874w;

    public p(Context context) {
        c cVar = new c(context, 1);
        c cVar2 = new c(context, 2);
        c cVar3 = new c(context, 3);
        b2.i iVar = new b2.i(1);
        c cVar4 = new c(context, 4);
        context.getClass();
        this.f4854a = context;
        this.f4856c = cVar;
        this.f4857d = cVar2;
        this.f4858e = cVar3;
        this.f = iVar;
        this.f4859g = cVar4;
        int i = y1.a0.f14551a;
        Looper looperMyLooper = Looper.myLooper();
        this.f4860h = looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper;
        this.f4861j = v1.c.f12586h;
        this.f4862k = 1;
        this.f4863l = true;
        this.f4864m = r1.f4891c;
        this.f4866o = 5000L;
        this.f4867p = 15000L;
        this.f4868q = 3000L;
        this.f4865n = q1.f4886b;
        this.f4869r = new h(y1.a0.O(20L), y1.a0.O(500L));
        this.f4855b = y1.v.f14615a;
        this.f4870s = 500L;
        this.f4871t = 2000L;
        this.f4872u = true;
        this.f4874w = "";
        this.i = -1000;
        new f9.a0();
    }

    public final g0 a() {
        y1.d.g(!this.f4873v);
        this.f4873v = true;
        return new g0(this);
    }

    public final void b(l lVar) {
        y1.d.g(!this.f4873v);
        this.f4856c = new o(4, lVar);
    }
}
