package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements h5.b {
    @Override // h5.b
    public final List a() {
        return sd.p.f11669v;
    }

    @Override // h5.b
    public final Object b(Context context) {
        ge.i.e(context, "context");
        h5.a aVarC = h5.a.c(context);
        ge.i.d(aVarC, "getInstance(context)");
        if (!aVarC.f5843b.contains(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
        }
        if (!p.f1189a.getAndSet(true)) {
            Context applicationContext = context.getApplicationContext();
            ge.i.c(applicationContext, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext).registerActivityLifecycleCallbacks(new o());
        }
        c0 c0Var = c0.D;
        c0Var.getClass();
        c0Var.f1151z = new Handler();
        c0Var.A.d(m.ON_CREATE);
        Context applicationContext2 = context.getApplicationContext();
        ge.i.c(applicationContext2, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext2).registerActivityLifecycleCallbacks(new b0(c0Var));
        return c0Var;
    }
}
