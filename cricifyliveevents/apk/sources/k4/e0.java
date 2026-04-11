package k4;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e0 implements k0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f6947v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ l0 f6948w;

    public /* synthetic */ e0(l0 l0Var, int i) {
        this.f6947v = i;
        this.f6948w = l0Var;
    }

    @Override // k4.k0
    public final void d(s sVar) {
        int i = this.f6947v;
        l0 l0Var = this.f6948w;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                b0 b0Var = l0Var.f7060g;
                if (b0Var.f6924t.a0() != null) {
                    f9.b0 b0Var2 = b0Var.f6911e;
                    b0Var.s(sVar);
                    b0Var2.getClass();
                    w1.d.l(new o1(-6));
                    break;
                }
                break;
            case 1:
                l0Var.f7060g.f6924t.R0();
                break;
            case 2:
                l0Var.f7060g.f6924t.S();
                break;
            case 3:
                l0Var.f7060g.f6924t.M0();
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                l0Var.f7060g.f6924t.K0();
                break;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                l0Var.f7060g.f6924t.b();
                break;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                l0Var.f7060g.f6924t.stop();
                break;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                b0 b0Var3 = l0Var.f7060g;
                h1 h1Var = b0Var3.f6924t;
                if (!y1.a0.Y(h1Var, b0Var3.f6920p)) {
                    if (h1Var != null && h1Var.Z(1)) {
                        h1Var.c();
                        break;
                    }
                } else {
                    y1.a0.F(h1Var);
                    break;
                }
                break;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                l0Var.f7060g.f6924t.J0();
                break;
            case 9:
                l0Var.f7060g.f6924t.D();
                break;
            case 10:
                l0Var.f7060g.g(sVar, true);
                break;
            default:
                h1 h1Var2 = l0Var.f7060g.f6924t;
                int i10 = y1.a0.f14551a;
                if (h1Var2 != null && h1Var2.Z(1)) {
                    h1Var2.c();
                    break;
                }
                break;
        }
    }

    public /* synthetic */ e0(l0 l0Var, v1.x0 x0Var) {
        this.f6947v = 0;
        this.f6948w = l0Var;
    }
}
