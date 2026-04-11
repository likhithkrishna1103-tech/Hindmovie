package androidx.activity;

import androidx.lifecycle.m;
import androidx.lifecycle.q;
import androidx.lifecycle.s;
import androidx.lifecycle.u;
import c.b0;
import c.f0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class OnBackPressedDispatcher$addCallback$lifecycleObserver$1 implements q, AutoCloseable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ b0 f514v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ u f515w;

    public OnBackPressedDispatcher$addCallback$lifecycleObserver$1(b0 b0Var, f0 f0Var, u uVar) {
        this.f514v = b0Var;
        this.f515w = uVar;
    }

    @Override // androidx.lifecycle.q
    public final void a(s sVar, m mVar) {
        m mVar2 = m.ON_START;
        b0 b0Var = this.f514v;
        if (mVar == mVar2) {
            b0Var.c(true);
        } else if (mVar == m.ON_STOP) {
            b0Var.c(false);
        }
        if (mVar == m.ON_DESTROY) {
            b0Var.a();
            this.f515w.f(this);
        }
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.f515w.f(this);
    }
}
