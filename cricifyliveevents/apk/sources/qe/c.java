package qe;

import android.os.Handler;
import android.os.Looper;
import d1.a1;
import ge.i;
import java.util.concurrent.CancellationException;
import k8.j;
import pe.b0;
import pe.e;
import pe.e1;
import pe.f0;
import pe.h0;
import pe.k1;
import pe.s;
import pe.t;
import pe.v0;
import ue.n;
import vd.h;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends s implements b0 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Handler f10807x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f10808y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final c f10809z;

    public c(Handler handler, boolean z10) {
        this.f10807x = handler;
        this.f10808y = z10;
        this.f10809z = z10 ? this : new c(handler, true);
    }

    @Override // pe.b0
    public final h0 R(long j4, k1 k1Var, h hVar) {
        if (j4 > 4611686018427387903L) {
            j4 = 4611686018427387903L;
        }
        if (this.f10807x.postDelayed(k1Var, j4)) {
            return new a1(1, this, k1Var);
        }
        k0(hVar, k1Var);
        return e1.f10231v;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return cVar.f10807x == this.f10807x && cVar.f10808y == this.f10808y;
    }

    @Override // pe.b0
    public final void g0(long j4, pe.h hVar) {
        j jVar = new j(6, hVar, this);
        if (j4 > 4611686018427387903L) {
            j4 = 4611686018427387903L;
        }
        if (!this.f10807x.postDelayed(jVar, j4)) {
            k0(hVar.f10237z, jVar);
            return;
        }
        b6.c cVar = new b6.c(4, this, jVar);
        hVar.getClass();
        hVar.y(new e(1, cVar));
    }

    @Override // pe.s
    public final void h0(h hVar, Runnable runnable) {
        if (this.f10807x.post(runnable)) {
            return;
        }
        k0(hVar, runnable);
    }

    public final int hashCode() {
        return System.identityHashCode(this.f10807x) ^ (this.f10808y ? 1231 : 1237);
    }

    @Override // pe.s
    public final boolean i0(h hVar) {
        return (this.f10808y && i.a(Looper.myLooper(), this.f10807x.getLooper())) ? false : true;
    }

    public final void k0(h hVar, Runnable runnable) {
        CancellationException cancellationException = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        v0 v0Var = (v0) hVar.C(t.f10271w);
        if (v0Var != null) {
            v0Var.g(cancellationException);
        }
        we.e eVar = f0.f10232a;
        we.d.f14160x.h0(hVar, runnable);
    }

    @Override // pe.s
    public final String toString() {
        c cVar;
        String str;
        we.e eVar = f0.f10232a;
        c cVar2 = n.f12481a;
        if (this == cVar2) {
            str = "Dispatchers.Main";
        } else {
            try {
                cVar = cVar2.f10809z;
            } catch (UnsupportedOperationException unused) {
                cVar = null;
            }
            str = this == cVar ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.f10807x.toString();
        return this.f10808y ? l0.e.j(string, ".immediate") : string;
    }
}
