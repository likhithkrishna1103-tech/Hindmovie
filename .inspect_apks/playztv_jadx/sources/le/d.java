package le;

import android.os.Handler;
import android.os.Looper;
import e6.j;
import java.util.concurrent.CancellationException;
import ke.b0;
import ke.d1;
import ke.f0;
import ke.f1;
import ke.h0;
import ke.l1;
import ke.r;
import ke.s;
import ke.v0;
import pe.n;
import rd.h;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends r implements b0 {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Handler f8159w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f8160x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final d f8161y;

    public d(Handler handler, boolean z2) {
        this.f8159w = handler;
        this.f8160x = z2;
        this.f8161y = z2 ? this : new d(handler, true);
    }

    @Override // ke.b0
    public final h0 S(long j5, final l1 l1Var, h hVar) {
        if (j5 > 4611686018427387903L) {
            j5 = 4611686018427387903L;
        }
        if (this.f8159w.postDelayed(l1Var, j5)) {
            return new h0() { // from class: le.c
                @Override // ke.h0
                public final void b() {
                    this.f8157u.f8159w.removeCallbacks(l1Var);
                }
            };
        }
        k0(hVar, l1Var);
        return f1.f7691u;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return dVar.f8159w == this.f8159w && dVar.f8160x == this.f8160x;
    }

    @Override // ke.r
    public final void h0(h hVar, Runnable runnable) {
        if (this.f8159w.post(runnable)) {
            return;
        }
        k0(hVar, runnable);
    }

    public final int hashCode() {
        return System.identityHashCode(this.f8159w) ^ (this.f8160x ? 1231 : 1237);
    }

    @Override // ke.r
    public final boolean i0(h hVar) {
        return (this.f8160x && be.h.a(Looper.myLooper(), this.f8159w.getLooper())) ? false : true;
    }

    public final void k0(h hVar, Runnable runnable) {
        CancellationException cancellationException = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        v0 v0Var = (v0) hVar.v(s.f7730v);
        if (v0Var != null) {
            ((d1) v0Var).j(cancellationException);
        }
        re.e eVar = f0.f7690a;
        re.d.f11591w.h0(hVar, runnable);
    }

    @Override // ke.r
    public final String toString() {
        d dVar;
        String str;
        re.e eVar = f0.f7690a;
        d dVar2 = n.f10395a;
        if (this == dVar2) {
            str = "Dispatchers.Main";
        } else {
            try {
                dVar = dVar2.f8161y;
            } catch (UnsupportedOperationException unused) {
                dVar = null;
            }
            str = this == dVar ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.f8159w.toString();
        return this.f8160x ? j.m(string, ".immediate") : string;
    }
}
