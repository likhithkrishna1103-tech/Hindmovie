package o4;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import c.b0;
import nc.p;
import se.x;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements OnBackAnimationCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f9507a;

    public i(h hVar) {
        this.f9507a = hVar;
    }

    public final void onBackCancelled() {
        h hVar = this.f9507a;
        p pVar = hVar.f9488a;
        if (pVar == null) {
            throw new IllegalStateException("This input is not added to any dispatcher.");
        }
        if (!hVar.f9489b) {
            pVar.f(hVar, null);
        }
        e eVar = (e) pVar.f9070b;
        eVar.getClass();
        if (hVar.equals(eVar.f9496h) && -1 == eVar.f9495g) {
            b0 b0VarC = eVar.f;
            if (b0VarC == null) {
                b0VarC = eVar.c(-1);
            }
            eVar.f = null;
            eVar.f9495g = 0;
            eVar.f9496h = null;
            if (b0VarC != null) {
                b0VarC.f1934d.getClass();
            }
            x xVar = eVar.f9490a;
            xVar.getClass();
            xVar.e(null, f.f9502a);
        }
        hVar.f9489b = false;
    }

    public final void onBackInvoked() {
        this.f9507a.a();
    }

    public final void onBackProgressed(BackEvent backEvent) {
        ge.i.e(backEvent, "backEvent");
        b bVarB = ab.b.b(backEvent);
        h hVar = this.f9507a;
        p pVar = hVar.f9488a;
        if (pVar == null) {
            throw new IllegalStateException("This input is not added to any dispatcher.");
        }
        if (hVar.f9489b) {
            e eVar = (e) pVar.f9070b;
            eVar.getClass();
            if (hVar.equals(eVar.f9496h) && -1 == eVar.f9495g) {
                b0 b0VarC = eVar.f;
                if (b0VarC == null) {
                    b0VarC = eVar.c(-1);
                }
                if (b0VarC != null) {
                    b0VarC.f1934d.getClass();
                }
                x xVar = eVar.f9490a;
                g gVar = new g(bVarB);
                xVar.getClass();
                xVar.e(null, gVar);
            }
        }
    }

    public final void onBackStarted(BackEvent backEvent) {
        ge.i.e(backEvent, "backEvent");
        b bVarB = ab.b.b(backEvent);
        h hVar = this.f9507a;
        p pVar = hVar.f9488a;
        if (pVar == null) {
            throw new IllegalStateException("This input is not added to any dispatcher.");
        }
        if (hVar.f9489b) {
            return;
        }
        pVar.f(hVar, bVarB);
        hVar.f9489b = true;
    }
}
