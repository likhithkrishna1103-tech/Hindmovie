package j4;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import c.z;
import ne.n;
import ub.o;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i implements OnBackAnimationCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f6794a;

    public i(h hVar) {
        this.f6794a = hVar;
    }

    public final void onBackCancelled() {
        h hVar = this.f6794a;
        o oVar = hVar.f6777a;
        if (oVar == null) {
            throw new IllegalStateException("This input is not added to any dispatcher.");
        }
        if (!hVar.f6778b) {
            oVar.j(hVar, null);
        }
        e eVar = (e) oVar.f12869w;
        eVar.getClass();
        if (hVar.equals(eVar.f6785h) && -1 == eVar.f6784g) {
            z zVarC = eVar.f;
            if (zVarC == null) {
                zVarC = eVar.c(-1);
            }
            eVar.f = null;
            eVar.f6784g = 0;
            eVar.f6785h = null;
            if (zVarC != null) {
                zVarC.f2206d.getClass();
            }
            n nVar = eVar.f6779a;
            nVar.getClass();
            nVar.f(null, f.f);
        }
        hVar.f6778b = false;
    }

    public final void onBackInvoked() {
        this.f6794a.a();
    }

    public final void onBackProgressed(BackEvent backEvent) {
        be.h.e(backEvent, "backEvent");
        b bVarA = t1.a(backEvent);
        h hVar = this.f6794a;
        o oVar = hVar.f6777a;
        if (oVar == null) {
            throw new IllegalStateException("This input is not added to any dispatcher.");
        }
        if (hVar.f6778b) {
            e eVar = (e) oVar.f12869w;
            eVar.getClass();
            if (hVar.equals(eVar.f6785h) && -1 == eVar.f6784g) {
                z zVarC = eVar.f;
                if (zVarC == null) {
                    zVarC = eVar.c(-1);
                }
                if (zVarC != null) {
                    zVarC.f2206d.getClass();
                }
                n nVar = eVar.f6779a;
                g gVar = new g(bVarA);
                nVar.getClass();
                nVar.f(null, gVar);
            }
        }
    }

    public final void onBackStarted(BackEvent backEvent) {
        be.h.e(backEvent, "backEvent");
        b bVarA = t1.a(backEvent);
        h hVar = this.f6794a;
        o oVar = hVar.f6777a;
        if (oVar == null) {
            throw new IllegalStateException("This input is not added to any dispatcher.");
        }
        if (hVar.f6778b) {
            return;
        }
        oVar.j(hVar, bVarA);
        hVar.f6778b = true;
    }
}
