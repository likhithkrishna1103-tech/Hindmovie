package k8;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q1 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7380u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public /* synthetic */ o1 f7381v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public /* synthetic */ a4 f7382w;

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7380u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                o1 o1Var = this.f7381v;
                a4 a4Var = this.f7382w;
                x3 x3Var = o1Var.f7348d;
                x3Var.d0();
                x3Var.X(a4Var);
                break;
            case 1:
                o1 o1Var2 = this.f7381v;
                a4 a4Var2 = this.f7382w;
                x3 x3Var2 = o1Var2.f7348d;
                x3Var2.d0();
                x3Var2.W(a4Var2);
                break;
            case 2:
                o1 o1Var3 = this.f7381v;
                o1Var3.f7348d.d0();
                o1Var3.f7348d.R(this.f7382w);
                break;
            case 3:
                x3 x3Var3 = this.f7381v.f7348d;
                x3Var3.d0();
                a4 a4Var3 = this.f7382w;
                x3Var3.x().p1();
                x3Var3.e0();
                t7.v.d(a4Var3.f7076u);
                x3Var3.j(a4Var3);
                break;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                x3 x3Var4 = this.f7381v.f7348d;
                x3Var4.d0();
                a4 a4Var4 = this.f7382w;
                x3Var4.x().p1();
                x3Var4.e0();
                t7.v.h(a4Var4);
                String str = a4Var4.f7076u;
                t7.v.d(str);
                if (x3Var4.S().A1(null, w.f7470c1)) {
                    int i = 0;
                    if (x3Var4.S().A1(null, w.f7491k0)) {
                        x3Var4.y0().getClass();
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        int iU1 = x3Var4.S().u1(null, w.V);
                        x3Var4.S();
                        long jLongValue = jCurrentTimeMillis - ((Long) w.f7474e.a(null)).longValue();
                        while (i < iU1 && x3Var4.C(null, jLongValue)) {
                            i++;
                        }
                    } else {
                        x3Var4.S();
                        long jIntValue = ((Integer) w.f7493l.a(null)).intValue();
                        while (i < jIntValue && x3Var4.C(str, 0L)) {
                            i++;
                        }
                    }
                    if (x3Var4.S().A1(null, w.l0)) {
                        x3Var4.F();
                    }
                    break;
                }
                break;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                x3 x3Var5 = this.f7381v.f7348d;
                x3Var5.d0();
                a4 a4Var5 = this.f7382w;
                x3Var5.x().p1();
                x3Var5.e0();
                t7.v.d(a4Var5.f7076u);
                x3Var5.X(a4Var5);
                x3Var5.W(a4Var5);
                break;
            default:
                o1 o1Var4 = this.f7381v;
                o1Var4.f7348d.d0();
                o1Var4.f7348d.U(this.f7382w);
                break;
        }
    }

    public /* synthetic */ q1(o1 o1Var, a4 a4Var, int i) {
        this.f7380u = i;
        this.f7382w = a4Var;
        this.f7381v = o1Var;
    }
}
