package a2;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y1 extends o2.s {
    public final /* synthetic */ int f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f515g;

    public y1(p1.f1 f1Var, p1.g0 g0Var) {
        super(f1Var);
        this.f515g = g0Var;
    }

    @Override // o2.s, p1.f1
    public p1.c1 f(int i, p1.c1 c1Var, boolean z2) {
        switch (this.f) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                p1.f1 f1Var = this.f9206e;
                p1.c1 c1VarF = f1Var.f(i, c1Var, z2);
                if (f1Var.m(c1VarF.f9678c, (p1.e1) this.f515g, 0L).a()) {
                    c1VarF.h(c1Var.f9676a, c1Var.f9677b, c1Var.f9678c, c1Var.f9679d, c1Var.f9680e, p1.b.f9644c, true);
                } else {
                    c1VarF.f = true;
                }
                return c1VarF;
            default:
                return super.f(i, c1Var, z2);
        }
    }

    @Override // o2.s, p1.f1
    public p1.e1 m(int i, p1.e1 e1Var, long j5) {
        switch (this.f) {
            case 1:
                super.m(i, e1Var, j5);
                p1.g0 g0Var = (p1.g0) this.f515g;
                e1Var.f9715c = g0Var;
                p1.c0 c0Var = g0Var.f9757b;
                e1Var.getClass();
                return e1Var;
            default:
                return super.m(i, e1Var, j5);
        }
    }

    public y1(p1.f1 f1Var) {
        super(f1Var);
        this.f515g = new p1.e1();
    }
}
