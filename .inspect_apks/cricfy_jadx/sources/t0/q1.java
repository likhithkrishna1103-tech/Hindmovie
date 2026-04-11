package t0;

import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class q1 extends ab.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Window f11796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l4.a f11797c;

    public q1(Window window, l4.a aVar) {
        this.f11796b = window;
        this.f11797c = aVar;
    }

    @Override // ab.b
    public final void A(boolean z10) {
        if (!z10) {
            G(8192);
            return;
        }
        Window window = this.f11796b;
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        F(8192);
    }

    @Override // ab.b
    public final void C() {
        this.f11796b.getDecorView().setTag(356039078, 2);
        G(2048);
        F(4096);
    }

    @Override // ab.b
    public final void D(int i) {
        for (int i10 = 1; i10 <= 512; i10 <<= 1) {
            if ((i & i10) != 0) {
                if (i10 == 1) {
                    G(4);
                    this.f11796b.clearFlags(1024);
                } else if (i10 == 2) {
                    G(2);
                } else if (i10 == 8) {
                    ((kf.i) this.f11797c.f7697v).N();
                }
            }
        }
    }

    public final void F(int i) {
        View decorView = this.f11796b.getDecorView();
        decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
    }

    public final void G(int i) {
        View decorView = this.f11796b.getDecorView();
        decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
    }

    @Override // ab.b
    public final void p(int i) {
        for (int i10 = 1; i10 <= 512; i10 <<= 1) {
            if ((i & i10) != 0) {
                if (i10 == 1) {
                    F(4);
                } else if (i10 == 2) {
                    F(2);
                } else if (i10 == 8) {
                    ((kf.i) this.f11797c.f7697v).G();
                }
            }
        }
    }
}
