package l4;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7760c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h.d f7762e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f7758a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f7759b = new t(this);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference f7761d = new WeakReference(null);

    public final void C(w wVar, Handler handler) {
        synchronized (this.f7758a) {
            try {
                this.f7761d = new WeakReference(wVar);
                h.d dVar = this.f7762e;
                if (dVar != null) {
                    dVar.removeCallbacksAndMessages(null);
                }
                this.f7762e = new h.d(this, handler.getLooper(), 4);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(w wVar, Handler handler) {
        if (this.f7760c) {
            this.f7760c = false;
            handler.removeMessages(1);
            k0 k0Var = wVar.f7770g;
            long j4 = k0Var == null ? 0L : k0Var.f7735z;
            boolean z10 = k0Var != null && k0Var.f7731v == 3;
            boolean z11 = (516 & j4) != 0;
            boolean z12 = (j4 & 514) != 0;
            if (z10 && z12) {
                h();
            } else {
                if (z10 || !z11) {
                    return;
                }
                i();
            }
        }
    }

    public boolean g(Intent intent) {
        w wVar;
        h.d dVar;
        KeyEvent keyEvent;
        if (Build.VERSION.SDK_INT < 27) {
            synchronized (this.f7758a) {
                wVar = (w) this.f7761d.get();
                dVar = this.f7762e;
            }
            if (wVar != null && dVar != null && (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) != null && keyEvent.getAction() == 0) {
                e0 e0VarC = wVar.c();
                int keyCode = keyEvent.getKeyCode();
                if (keyCode != 79 && keyCode != 85) {
                    a(wVar, dVar);
                    return false;
                }
                if (keyEvent.getRepeatCount() != 0) {
                    a(wVar, dVar);
                    return true;
                }
                if (!this.f7760c) {
                    this.f7760c = true;
                    dVar.sendMessageDelayed(dVar.obtainMessage(1, e0VarC), ViewConfiguration.getDoubleTapTimeout());
                    return true;
                }
                dVar.removeMessages(1);
                this.f7760c = false;
                k0 k0Var = wVar.f7770g;
                if (((k0Var == null ? 0L : k0Var.f7735z) & 32) != 0) {
                    y();
                }
                return true;
            }
        }
        return false;
    }

    public void B() {
    }

    public void f() {
    }

    public void h() {
    }

    public void i() {
    }

    public void m() {
    }

    public void r() {
    }

    public void y() {
    }

    public void z() {
    }

    public void A(long j4) {
    }

    public void b(o oVar) {
    }

    public void q(o oVar) {
    }

    public void s(long j4) {
    }

    public void t(float f) {
    }

    public void u(l0 l0Var) {
    }

    public void v(l0 l0Var) {
    }

    public void w(int i) {
    }

    public void x(int i) {
    }

    public void c(o oVar, int i) {
    }

    public void e(String str, Bundle bundle) {
    }

    public void j(String str, Bundle bundle) {
    }

    public void k(String str, Bundle bundle) {
    }

    public void l(Uri uri, Bundle bundle) {
    }

    public void n(String str, Bundle bundle) {
    }

    public void o(String str, Bundle bundle) {
    }

    public void p(Uri uri, Bundle bundle) {
    }

    public void d(String str, Bundle bundle, ResultReceiver resultReceiver) {
    }
}
