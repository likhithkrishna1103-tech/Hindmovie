package p2;

import p1.q;
import v1.c0;
import w2.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l extends f {
    public final e D;
    public c E;
    public long F;
    public volatile boolean G;

    public l(v1.h hVar, v1.m mVar, q qVar, int i, Object obj, e eVar) {
        super(hVar, mVar, 2, qVar, i, obj, -9223372036854775807L, -9223372036854775807L);
        this.D = eVar;
    }

    @Override // s2.j
    public final void b() {
        if (this.F == 0) {
            this.D.a(this.E, -9223372036854775807L, -9223372036854775807L);
        }
        try {
            v1.m mVarC = this.f10144v.c(this.F);
            c0 c0Var = this.C;
            w2.l lVar = new w2.l(c0Var, mVarC.f, c0Var.h(mVarC));
            while (!this.G) {
                try {
                    int iL = this.D.f10137u.l(lVar, e.D);
                    boolean z2 = false;
                    s1.d.g(iL != 1);
                    if (iL == 0) {
                        z2 = true;
                    }
                    if (!z2) {
                        break;
                    }
                } finally {
                    this.F = lVar.f13653x - this.f10144v.f;
                    b0 b0Var = this.D.B;
                }
            }
        } finally {
            com.bumptech.glide.c.f(this.C);
        }
    }

    @Override // s2.j
    public final void c() {
        this.G = true;
    }
}
