package t0;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class s1 extends ab.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WindowInsetsController f11804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l4.a f11805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Window f11806d;

    public s1(Window window, l4.a aVar) {
        this.f11804b = window.getInsetsController();
        this.f11805c = aVar;
        this.f11806d = window;
    }

    @Override // ab.b
    public final void A(boolean z10) {
        Window window = this.f11806d;
        if (z10) {
            if (window != null) {
                F(8192);
            }
            this.f11804b.setSystemBarsAppearance(8, 8);
        } else {
            if (window != null) {
                G(8192);
            }
            this.f11804b.setSystemBarsAppearance(0, 8);
        }
    }

    @Override // ab.b
    public void C() {
        Window window = this.f11806d;
        if (window == null) {
            this.f11804b.setSystemBarsBehavior(2);
            return;
        }
        window.getDecorView().setTag(356039078, 2);
        G(2048);
        F(4096);
    }

    @Override // ab.b
    public final void D(int i) {
        if ((i & 8) != 0) {
            ((kf.i) this.f11805c.f7697v).N();
        }
        this.f11804b.show(i & (-9));
    }

    public final void F(int i) {
        View decorView = this.f11806d.getDecorView();
        decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
    }

    public final void G(int i) {
        View decorView = this.f11806d.getDecorView();
        decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
    }

    @Override // ab.b
    public final void p(int i) {
        if ((i & 8) != 0) {
            ((kf.i) this.f11805c.f7697v).G();
        }
        this.f11804b.hide(i & (-9));
    }

    @Override // ab.b
    public final void z(boolean z10) {
        Window window = this.f11806d;
        if (z10) {
            if (window != null) {
                F(16);
            }
            this.f11804b.setSystemBarsAppearance(16, 16);
        } else {
            if (window != null) {
                G(16);
            }
            this.f11804b.setSystemBarsAppearance(0, 16);
        }
    }
}
