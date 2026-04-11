package c;

import android.window.OnBackInvokedDispatcher;
import androidx.activity.OnBackPressedDispatcher$addCallback$lifecycleObserver$1;
import androidx.fragment.app.i0;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f1951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rd.j f1952b = new rd.j(new d0(0, this));

    public f0(Runnable runnable) {
        this.f1951a = runnable;
    }

    public final void a(i0 i0Var, androidx.lifecycle.s sVar) {
        ge.i.e(sVar, "owner");
        ge.i.e(i0Var, "onBackPressedCallback");
        androidx.lifecycle.u uVarF = sVar.f();
        if (uVarF.f1200c == androidx.lifecycle.n.f1179v) {
            return;
        }
        b0 b0Var = new b0(i0Var, new c0(i0Var, sVar));
        i0Var.f997a.add(b0Var);
        b0Var.c(false);
        nc.p pVar = b().f1947c;
        pVar.getClass();
        if (((LinkedHashSet) pVar.f9071c).add(b0Var)) {
            o4.e eVar = (o4.e) pVar.f9070b;
            eVar.getClass();
            if (b0Var.f1933c != null) {
                throw new IllegalArgumentException(("Handler '" + b0Var + "' is already registered with a dispatcher").toString());
            }
            eVar.f9494e.addFirst(b0Var);
            b0Var.f1933c = pVar;
            eVar.b();
        }
        OnBackPressedDispatcher$addCallback$lifecycleObserver$1 onBackPressedDispatcher$addCallback$lifecycleObserver$1 = new OnBackPressedDispatcher$addCallback$lifecycleObserver$1(b0Var, this, uVarF);
        uVarF.a(onBackPressedDispatcher$addCallback$lifecycleObserver$1);
        i0Var.f999c.add(onBackPressedDispatcher$addCallback$lifecycleObserver$1);
    }

    public final e0 b() {
        return (e0) this.f1952b.getValue();
    }

    public final void c(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        b().f1947c.c(new o4.h(onBackInvokedDispatcher, 0), 1);
        b().f1947c.c(new o4.h(onBackInvokedDispatcher, 1000000), 0);
    }
}
