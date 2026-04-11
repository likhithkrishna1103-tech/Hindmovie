package g4;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e0 implements l0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f4994u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ m0 f4995v;

    public /* synthetic */ e0(m0 m0Var, int i) {
        this.f4994u = i;
        this.f4995v = m0Var;
    }

    @Override // g4.l0
    public final void d(s sVar) {
        int i = this.f4994u;
        m0 m0Var = this.f4995v;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                b0 b0Var = m0Var.f5115g;
                if (b0Var.f4973t.g() != null) {
                    q9.e eVar = b0Var.f4960e;
                    b0Var.s(sVar);
                    eVar.getClass();
                    b8.h.r(new q1(-6));
                    break;
                }
                break;
            case 1:
                m0Var.f5115g.f4973t.R0();
                break;
            case 2:
                m0Var.f5115g.f4973t.V();
                break;
            case 3:
                m0Var.f5115g.f4973t.M0();
                break;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                m0Var.f5115g.f4973t.K0();
                break;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                m0Var.f5115g.f4973t.d();
                break;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                m0Var.f5115g.f4973t.stop();
                break;
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                b0 b0Var2 = m0Var.f5115g;
                j1 j1Var = b0Var2.f4973t;
                if (!s1.b0.Y(j1Var, b0Var2.f4969p)) {
                    if (j1Var != null && j1Var.e0(1)) {
                        j1Var.f();
                        break;
                    }
                } else {
                    s1.b0.F(j1Var);
                    break;
                }
                break;
            case 8:
                m0Var.f5115g.f4973t.J0();
                break;
            case 9:
                m0Var.f5115g.f4973t.H();
                break;
            case 10:
                m0Var.f5115g.g(sVar, true);
                break;
            default:
                j1 j1Var2 = m0Var.f5115g.f4973t;
                int i10 = s1.b0.f11647a;
                if (j1Var2 != null && j1Var2.e0(1)) {
                    j1Var2.f();
                    break;
                }
                break;
        }
    }

    public /* synthetic */ e0(m0 m0Var, p1.x0 x0Var) {
        this.f4994u = 0;
        this.f4995v = m0Var;
    }
}
