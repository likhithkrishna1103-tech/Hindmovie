package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements c5.b {
    @Override // c5.b
    public final List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // c5.b
    public final Object b(Context context) {
        u uVar = new u(new wb.c(context));
        uVar.f1174a = 1;
        if (m.f1181k == null) {
            synchronized (m.f1180j) {
                try {
                    if (m.f1181k == null) {
                        m.f1181k = new m(uVar);
                    }
                } finally {
                }
            }
        }
        c(context);
        return Boolean.TRUE;
    }

    public final void c(Context context) {
        Object objB;
        c5.a aVarC = c5.a.c(context);
        aVarC.getClass();
        synchronized (c5.a.f2506e) {
            try {
                objB = aVarC.f2507a.get(ProcessLifecycleInitializer.class);
                if (objB == null) {
                    objB = aVarC.b(ProcessLifecycleInitializer.class, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        final androidx.lifecycle.u uVarF = ((androidx.lifecycle.s) objB).f();
        uVarF.a(new androidx.lifecycle.e(this) { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.e
            public final void d() {
                (Build.VERSION.SDK_INT >= 28 ? c.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new o(0), 500L);
                uVarF.f(this);
            }
        });
    }
}
