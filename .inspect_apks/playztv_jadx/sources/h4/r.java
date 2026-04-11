package h4;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import cc.q0;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5842c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public q0 f5844e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5840a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f5841b = new q(this);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference f5843d = new WeakReference(null);

    public final void C(t tVar, Handler handler) {
        synchronized (this.f5840a) {
            try {
                this.f5843d = new WeakReference(tVar);
                q0 q0Var = this.f5844e;
                if (q0Var != null) {
                    q0Var.removeCallbacksAndMessages(null);
                }
                this.f5844e = new q0(this, handler.getLooper(), 5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(t tVar, Handler handler) {
        if (this.f5842c) {
            this.f5842c = false;
            handler.removeMessages(1);
            h0 h0Var = tVar.f5852g;
            long j5 = h0Var == null ? 0L : h0Var.f5815y;
            boolean z2 = h0Var != null && h0Var.f5811u == 3;
            boolean z10 = (516 & j5) != 0;
            boolean z11 = (j5 & 514) != 0;
            if (z2 && z11) {
                h();
            } else {
                if (z2 || !z10) {
                    return;
                }
                i();
            }
        }
    }

    public boolean g(Intent intent) {
        t tVar;
        q0 q0Var;
        KeyEvent keyEvent;
        if (Build.VERSION.SDK_INT < 27) {
            synchronized (this.f5840a) {
                tVar = (t) this.f5843d.get();
                q0Var = this.f5844e;
            }
            if (tVar != null && q0Var != null && (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) != null && keyEvent.getAction() == 0) {
                b0 b0VarC = tVar.c();
                int keyCode = keyEvent.getKeyCode();
                if (keyCode != 79 && keyCode != 85) {
                    a(tVar, q0Var);
                    return false;
                }
                if (keyEvent.getRepeatCount() != 0) {
                    a(tVar, q0Var);
                    return true;
                }
                if (!this.f5842c) {
                    this.f5842c = true;
                    q0Var.sendMessageDelayed(q0Var.obtainMessage(1, b0VarC), ViewConfiguration.getDoubleTapTimeout());
                    return true;
                }
                q0Var.removeMessages(1);
                this.f5842c = false;
                h0 h0Var = tVar.f5852g;
                if (((h0Var == null ? 0L : h0Var.f5815y) & 32) != 0) {
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

    public void A(long j5) {
    }

    public void b(n nVar) {
    }

    public void q(n nVar) {
    }

    public void s(long j5) {
    }

    public void t(float f) {
    }

    public void u(i0 i0Var) {
    }

    public void v(i0 i0Var) {
    }

    public void w(int i) {
    }

    public void x(int i) {
    }

    public void c(n nVar, int i) {
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
