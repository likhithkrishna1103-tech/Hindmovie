package f9;

import android.os.Bundle;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y extends d0 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final v.e f4491x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final v.e f4492y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f4493z;

    public y(r1 r1Var) {
        super(r1Var);
        this.f4492y = new v.e(0);
        this.f4491x = new v.e(0);
    }

    public final void n1(String str, long j4) {
        r1 r1Var = (r1) this.f307w;
        if (str == null || str.length() == 0) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.B.a("Ad unit id must be a non-empty string");
        } else {
            p1 p1Var = r1Var.B;
            r1.g(p1Var);
            p1Var.v1(new a(this, str, j4, 0));
        }
    }

    public final void o1(String str, long j4) {
        r1 r1Var = (r1) this.f307w;
        if (str == null || str.length() == 0) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.B.a("Ad unit id must be a non-empty string");
        } else {
            p1 p1Var = r1Var.B;
            r1.g(p1Var);
            p1Var.v1(new a(this, str, j4, 1));
        }
    }

    public final void p1(long j4) {
        j3 j3Var = ((r1) this.f307w).G;
        r1.f(j3Var);
        f3 f3VarS1 = j3Var.s1(false);
        v.e eVar = this.f4491x;
        for (String str : (v.b) eVar.keySet()) {
            r1(str, j4 - ((Long) eVar.get(str)).longValue(), f3VarS1);
        }
        if (!eVar.isEmpty()) {
            q1(j4 - this.f4493z, f3VarS1);
        }
        s1(j4);
    }

    public final void q1(long j4, f3 f3Var) {
        r1 r1Var = (r1) this.f307w;
        if (f3Var == null) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.J.a("Not logging ad exposure. No active activity");
        } else if (j4 < 1000) {
            w0 w0Var2 = r1Var.A;
            r1.g(w0Var2);
            w0Var2.J.b(Long.valueOf(j4), "Not logging ad exposure. Less than 1000 ms. exposure");
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j4);
            u4.e2(f3Var, bundle, true);
            x2 x2Var = r1Var.H;
            r1.f(x2Var);
            x2Var.t1("am", "_xa", bundle);
        }
    }

    public final void r1(String str, long j4, f3 f3Var) {
        r1 r1Var = (r1) this.f307w;
        if (f3Var == null) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.J.a("Not logging ad unit exposure. No active activity");
        } else {
            if (j4 < 1000) {
                w0 w0Var2 = r1Var.A;
                r1.g(w0Var2);
                w0Var2.J.b(Long.valueOf(j4), "Not logging ad unit exposure. Less than 1000 ms. exposure");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j4);
            u4.e2(f3Var, bundle, true);
            x2 x2Var = r1Var.H;
            r1.f(x2Var);
            x2Var.t1("am", "_xu", bundle);
        }
    }

    public final void s1(long j4) {
        v.e eVar = this.f4491x;
        Iterator it = ((v.b) eVar.keySet()).iterator();
        while (it.hasNext()) {
            eVar.put((String) it.next(), Long.valueOf(j4));
        }
        if (eVar.isEmpty()) {
            return;
        }
        this.f4493z = j4;
    }
}
