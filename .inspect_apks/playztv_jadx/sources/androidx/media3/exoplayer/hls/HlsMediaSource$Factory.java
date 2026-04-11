package androidx.media3.exoplayer.hls;

import a7.b;
import f2.n;
import g2.l;
import g4.s0;
import h2.s;
import h4.z;
import java.util.List;
import k8.a0;
import k8.b0;
import o2.a;
import o2.c0;
import p1.g0;
import q9.e;
import v1.g;
import wb.c;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class HlsMediaSource$Factory implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f1574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g2.c f1575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b0 f1576c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f1580h = new b(18);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f1578e = new e(13);
    public final s0 f = h2.c.I;
    public final a0 i = new a0(25);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final k8.c0 f1579g = new k8.c0(19);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f1582k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f1583l = -9223372036854775807L;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f1581j = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1577d = true;

    public HlsMediaSource$Factory(g gVar) {
        this.f1574a = new c(13, gVar);
    }

    @Override // o2.c0
    public final c0 a(boolean z2) {
        this.f1577d = z2;
        return this;
    }

    @Override // o2.c0
    public final a c(g0 g0Var) {
        g0Var.f9757b.getClass();
        if (this.f1575b == null) {
            g2.c cVar = new g2.c();
            cVar.f4855a = new b0(27);
            this.f1575b = cVar;
        }
        b0 b0Var = this.f1576c;
        if (b0Var != null) {
            this.f1575b.f4855a = b0Var;
        }
        g2.c cVar2 = this.f1575b;
        cVar2.f4856b = this.f1577d;
        List list = g0Var.f9757b.f9669e;
        boolean zIsEmpty = list.isEmpty();
        s zVar = this.f1578e;
        if (!zIsEmpty) {
            zVar = new z(zVar, 18, list);
        }
        n nVarB = this.f1580h.b(g0Var);
        this.f.getClass();
        c cVar3 = this.f1574a;
        a0 a0Var = this.i;
        return new l(g0Var, cVar3, cVar2, this.f1579g, nVarB, a0Var, new h2.c(cVar3, a0Var, zVar), this.f1583l, this.f1581j, this.f1582k);
    }

    @Override // o2.c0
    public final c0 d(b0 b0Var) {
        this.f1576c = b0Var;
        return this;
    }

    @Override // o2.c0
    public final c0 b() {
        return this;
    }
}
