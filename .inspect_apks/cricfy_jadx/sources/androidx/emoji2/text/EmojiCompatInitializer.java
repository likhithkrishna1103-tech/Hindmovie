package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements h5.b {
    @Override // h5.b
    public final List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // h5.b
    public final Object b(Context context) {
        p pVar = new p();
        pVar.f877a = context.getApplicationContext();
        y yVar = new y(pVar);
        yVar.f856a = 1;
        if (m.f863k == null) {
            synchronized (m.f862j) {
                try {
                    if (m.f863k == null) {
                        m.f863k = new m(yVar);
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
        h5.a aVarC = h5.a.c(context);
        aVarC.getClass();
        synchronized (h5.a.f5841e) {
            try {
                objB = aVarC.f5842a.get(ProcessLifecycleInitializer.class);
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
            public final void g() {
                (Build.VERSION.SDK_INT >= 28 ? c.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new q(0), 500L);
                uVarF.f(this);
            }
        });
    }
}
