package kf;

import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z implements Closeable {
    public final p A;
    public final b0 B;
    public final ag.v C;
    public final z D;
    public final z E;
    public final z F;
    public final long G;
    public final long H;
    public final com.bumptech.glide.l I;
    public final e0 J;
    public final boolean K;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final c2.o f7594v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final v f7595w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f7596x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f7597y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final n f7598z;

    public z(c2.o oVar, v vVar, String str, int i, n nVar, p pVar, b0 b0Var, ag.v vVar2, z zVar, z zVar2, z zVar3, long j4, long j7, com.bumptech.glide.l lVar, e0 e0Var) {
        ge.i.e(oVar, "request");
        ge.i.e(vVar, "protocol");
        ge.i.e(str, "message");
        ge.i.e(b0Var, "body");
        ge.i.e(e0Var, "trailersSource");
        this.f7594v = oVar;
        this.f7595w = vVar;
        this.f7596x = str;
        this.f7597y = i;
        this.f7598z = nVar;
        this.A = pVar;
        this.B = b0Var;
        this.C = vVar2;
        this.D = zVar;
        this.E = zVar2;
        this.F = zVar3;
        this.G = j4;
        this.H = j7;
        this.I = lVar;
        this.J = e0Var;
        boolean z10 = false;
        if (200 <= i && i < 300) {
            z10 = true;
        }
        this.K = z10;
    }

    public final y a() {
        y yVar = new y();
        yVar.f7583c = -1;
        yVar.f7586g = b0.f7439v;
        yVar.f7593o = e0.f7460a;
        yVar.f7581a = this.f7594v;
        yVar.f7582b = this.f7595w;
        yVar.f7583c = this.f7597y;
        yVar.f7584d = this.f7596x;
        yVar.f7585e = this.f7598z;
        yVar.f = this.A.c();
        yVar.f7586g = this.B;
        yVar.f7587h = this.C;
        yVar.i = this.D;
        yVar.f7588j = this.E;
        yVar.f7589k = this.F;
        yVar.f7590l = this.G;
        yVar.f7591m = this.H;
        yVar.f7592n = this.I;
        yVar.f7593o = this.J;
        return yVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.B.close();
    }

    public final String toString() {
        return "Response{protocol=" + this.f7595w + ", code=" + this.f7597y + ", message=" + this.f7596x + ", url=" + ((q) this.f7594v.f2035b) + '}';
    }
}
