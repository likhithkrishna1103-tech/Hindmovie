package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements c5.b {
    @Override // c5.b
    public final List a() {
        return od.q.f9570u;
    }

    @Override // c5.b
    public final Object b(Context context) {
        be.h.e(context, "context");
        c5.a aVarC = c5.a.c(context);
        be.h.d(aVarC, "getInstance(context)");
        if (!aVarC.f2508b.contains(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
        }
        if (!p.f1493a.getAndSet(true)) {
            Context applicationContext = context.getApplicationContext();
            be.h.c(applicationContext, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext).registerActivityLifecycleCallbacks(new o());
        }
        c0 c0Var = c0.C;
        c0Var.getClass();
        c0Var.f1453y = new Handler();
        c0Var.f1454z.d(m.ON_CREATE);
        Context applicationContext2 = context.getApplicationContext();
        be.h.c(applicationContext2, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext2).registerActivityLifecycleCallbacks(new b0(c0Var));
        return c0Var;
    }
}
