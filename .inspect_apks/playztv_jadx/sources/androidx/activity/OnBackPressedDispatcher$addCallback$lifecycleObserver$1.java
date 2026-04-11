package androidx.activity;

import androidx.lifecycle.m;
import androidx.lifecycle.q;
import androidx.lifecycle.s;
import androidx.lifecycle.u;
import c.c0;
import c.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class OnBackPressedDispatcher$addCallback$lifecycleObserver$1 implements q, AutoCloseable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ z f854u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ u f855v;

    public OnBackPressedDispatcher$addCallback$lifecycleObserver$1(z zVar, c0 c0Var, u uVar) {
        this.f854u = zVar;
        this.f855v = uVar;
    }

    @Override // androidx.lifecycle.q
    public final void a(s sVar, m mVar) {
        m mVar2 = m.ON_START;
        z zVar = this.f854u;
        if (mVar == mVar2) {
            zVar.c(true);
        } else if (mVar == m.ON_STOP) {
            zVar.c(false);
        }
        if (mVar == m.ON_DESTROY) {
            zVar.a();
            this.f855v.f(this);
        }
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.f855v.f(this);
    }
}
