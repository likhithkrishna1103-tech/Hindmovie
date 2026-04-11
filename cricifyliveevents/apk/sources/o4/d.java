package o4;

import androidx.fragment.app.f1;
import c.b0;
import c.f0;
import nc.p;
import se.x;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f9488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9489b;

    public final void a() {
        p pVar = this.f9488a;
        if (pVar == null) {
            throw new IllegalStateException("This input is not added to any dispatcher.");
        }
        if (!this.f9489b) {
            pVar.f(this, null);
        }
        e eVar = (e) pVar.f9070b;
        f1 f1Var = (f1) pVar.f9069a;
        eVar.getClass();
        if (equals(eVar.f9496h) && -1 == eVar.f9495g) {
            b0 b0VarC = eVar.f;
            if (b0VarC == null) {
                b0VarC = eVar.c(-1);
            }
            eVar.f = null;
            eVar.f9495g = 0;
            eVar.f9496h = null;
            if (b0VarC == null) {
                ((f0) f1Var.f986w).f1951a.run();
            } else {
                b0VarC.f1934d.a();
            }
            x xVar = eVar.f9490a;
            xVar.getClass();
            xVar.e(null, f.f9502a);
        }
        this.f9489b = false;
    }

    public void b(boolean z10) {
    }
}
