package c;

import android.window.OnBackInvokedDispatcher;
import androidx.activity.OnBackPressedDispatcher$addCallback$lifecycleObserver$1;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f2156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ub.o f2157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b0 f2158c;

    public c0(Runnable runnable) {
        this.f2156a = runnable;
        ub.o oVar = new ub.o(new a2.f0(11, this));
        this.f2157b = oVar;
        b0 b0Var = new b0(this);
        this.f2158c = b0Var;
        oVar.d(b0Var);
    }

    public final void a(androidx.fragment.app.f0 f0Var, androidx.lifecycle.s sVar) {
        be.h.e(f0Var, "onBackPressedCallback");
        androidx.lifecycle.u uVarF = sVar.f();
        if (uVarF.f1504c == androidx.lifecycle.n.f1482u) {
            return;
        }
        z zVar = new z(f0Var, new a0(f0Var, sVar));
        f0Var.f1273a.add(zVar);
        zVar.c(false);
        ub.o oVar = this.f2157b;
        oVar.getClass();
        if (((LinkedHashSet) oVar.f12870x).add(zVar)) {
            j4.e eVar = (j4.e) oVar.f12869w;
            eVar.getClass();
            if (zVar.f2205c != null) {
                throw new IllegalArgumentException(("Handler '" + zVar + "' is already registered with a dispatcher").toString());
            }
            eVar.f6783e.addFirst(zVar);
            zVar.f2205c = oVar;
            eVar.b();
        }
        OnBackPressedDispatcher$addCallback$lifecycleObserver$1 onBackPressedDispatcher$addCallback$lifecycleObserver$1 = new OnBackPressedDispatcher$addCallback$lifecycleObserver$1(zVar, this, uVarF);
        uVarF.a(onBackPressedDispatcher$addCallback$lifecycleObserver$1);
        f0Var.f1275c.add(onBackPressedDispatcher$addCallback$lifecycleObserver$1);
    }

    public final void b(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        j4.h hVar = new j4.h(onBackInvokedDispatcher, 0);
        ub.o oVar = this.f2157b;
        oVar.e(hVar, 1);
        oVar.e(new j4.h(onBackInvokedDispatcher, 1000000), 0);
    }
}
