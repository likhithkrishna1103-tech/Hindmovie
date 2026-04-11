package t2;

import a3.c0;
import b2.f0;
import b2.o;
import nb.w;
import v1.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends e {
    public final d E;
    public w F;
    public long G;
    public volatile boolean H;

    public j(b2.h hVar, o oVar, p pVar, int i, Object obj, d dVar) {
        super(hVar, oVar, 2, pVar, i, obj, -9223372036854775807L, -9223372036854775807L);
        this.E = dVar;
    }

    @Override // w2.k
    public final void a() {
        if (this.G == 0) {
            this.E.a(this.F, -9223372036854775807L, -9223372036854775807L);
        }
        try {
            o oVarC = this.f11849w.c(this.G);
            f0 f0Var = this.D;
            a3.l lVar = new a3.l(f0Var, oVarC.f, f0Var.B(oVarC));
            while (!this.H) {
                try {
                    int i = this.E.f11843v.i(lVar, d.E);
                    boolean z10 = false;
                    y1.d.g(i != 1);
                    if (i == 0) {
                        z10 = true;
                    }
                    if (!z10) {
                        break;
                    }
                } finally {
                    this.G = lVar.f215y - this.f11849w.f;
                    c0 c0Var = this.E.C;
                }
            }
        } finally {
            u8.a.g(this.D);
        }
    }

    @Override // w2.k
    public final void d() {
        this.H = true;
    }
}
