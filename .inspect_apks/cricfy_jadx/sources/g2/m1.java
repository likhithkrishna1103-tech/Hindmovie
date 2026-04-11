package g2;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m1 extends s2.r {
    public final /* synthetic */ int f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f4807g;

    public m1(v1.f1 f1Var, v1.g0 g0Var) {
        super(f1Var);
        this.f4807g = g0Var;
    }

    @Override // s2.r, v1.f1
    public v1.c1 f(int i, v1.c1 c1Var, boolean z10) {
        switch (this.f) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                v1.f1 f1Var = this.f11299e;
                v1.c1 c1VarF = f1Var.f(i, c1Var, z10);
                if (f1Var.m(c1VarF.f12618c, (v1.e1) this.f4807g, 0L).a()) {
                    c1VarF.h(c1Var.f12616a, c1Var.f12617b, c1Var.f12618c, c1Var.f12619d, c1Var.f12620e, v1.b.f12580c, true);
                } else {
                    c1VarF.f = true;
                }
                return c1VarF;
            default:
                return super.f(i, c1Var, z10);
        }
    }

    @Override // s2.r, v1.f1
    public v1.e1 m(int i, v1.e1 e1Var, long j4) {
        switch (this.f) {
            case 1:
                super.m(i, e1Var, j4);
                v1.g0 g0Var = (v1.g0) this.f4807g;
                e1Var.f12645c = g0Var;
                v1.c0 c0Var = g0Var.f12697b;
                e1Var.getClass();
                return e1Var;
            default:
                return super.m(i, e1Var, j4);
        }
    }

    public m1(v1.f1 f1Var) {
        super(f1Var);
        this.f4807g = new v1.e1();
    }
}
