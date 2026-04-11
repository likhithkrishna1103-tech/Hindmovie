package androidx.media3.exoplayer.hls;

import androidx.emoji2.text.v;
import b2.g;
import f9.a0;
import f9.z;
import i2.k;
import java.util.List;
import k4.r0;
import l2.n;
import l4.a;
import m2.c;
import m2.m;
import n2.s;
import s2.b0;
import v1.g0;
import x3.e;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class HlsMediaSource$Factory implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f1272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f1273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f1274c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final v f1278h = new v(29);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f9.b0 f1276e = new f9.b0(18);
    public final r0 f = n2.c.J;
    public final a0 i = new a0(28);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final z f1277g = new z(23);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f1280k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f1281l = -9223372036854775807L;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f1279j = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1275d = true;

    public HlsMediaSource$Factory(g gVar) {
        this.f1272a = new a(gVar);
    }

    @Override // s2.b0
    public final b0 a(boolean z10) {
        this.f1275d = z10;
        return this;
    }

    @Override // s2.b0
    public final b0 c(e eVar) {
        this.f1274c = eVar;
        return this;
    }

    @Override // s2.b0
    public final s2.a d(g0 g0Var) {
        g0Var.f12697b.getClass();
        if (this.f1273b == null) {
            c cVar = new c();
            cVar.f8048a = new e();
            this.f1273b = cVar;
        }
        e eVar = this.f1274c;
        if (eVar != null) {
            this.f1273b.f8048a = eVar;
        }
        c cVar2 = this.f1273b;
        cVar2.f8049b = this.f1275d;
        List list = g0Var.f12697b.f12609e;
        boolean zIsEmpty = list.isEmpty();
        s kVar = this.f1276e;
        if (!zIsEmpty) {
            kVar = new k(kVar, list);
        }
        n nVarD = this.f1278h.d(g0Var);
        this.f.getClass();
        a aVar = this.f1272a;
        a0 a0Var = this.i;
        return new m(g0Var, aVar, cVar2, this.f1277g, nVarD, a0Var, new n2.c(aVar, a0Var, kVar), this.f1281l, this.f1279j, this.f1280k);
    }

    @Override // s2.b0
    public final b0 b() {
        return this;
    }
}
