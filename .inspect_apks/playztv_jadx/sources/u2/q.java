package u2;

import aa.c1;
import aa.h0;
import aa.j0;
import android.content.Context;
import android.util.Pair;
import android.util.SparseArray;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f12632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseArray f12633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f12634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f12635e;
    public final s1.w f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CopyOnWriteArraySet f12636g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public q3.d f12637h = new q3.d();
    public s1.y i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Pair f12638j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f12639k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12640l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f12641m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f12642n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f12643o;

    public q(a2.m mVar) {
        this.f12631a = (Context) mVar.f318w;
        o oVar = (o) mVar.f320y;
        s1.d.h(oVar);
        this.f12632b = oVar;
        this.f12633c = new SparseArray();
        h0 h0Var = j0.f690v;
        c1 c1Var = c1.f650y;
        this.f12634d = mVar.f316u;
        s1.w wVar = (s1.w) mVar.f321z;
        this.f = wVar;
        this.f12635e = new c((v) mVar.f319x, wVar);
        this.f12636g = new CopyOnWriteArraySet();
        new p1.p().a();
        this.f12641m = -9223372036854775807L;
        this.f12643o = -1;
        this.f12640l = 0;
    }
}
