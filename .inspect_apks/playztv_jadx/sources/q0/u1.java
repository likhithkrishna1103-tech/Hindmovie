package q0;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class u1 extends b8.h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WindowInsetsController f10501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f10502e;
    public final Window f;

    public u1(Window window, e eVar) {
        this.f10501d = window.getInsetsController();
        this.f10502e = eVar;
        this.f = window;
    }

    @Override // b8.h
    public final void B(boolean z2) {
        Window window = this.f;
        if (z2) {
            if (window != null) {
                H(16);
            }
            this.f10501d.setSystemBarsAppearance(16, 16);
        } else {
            if (window != null) {
                I(16);
            }
            this.f10501d.setSystemBarsAppearance(0, 16);
        }
    }

    @Override // b8.h
    public final void C(boolean z2) {
        Window window = this.f;
        if (z2) {
            if (window != null) {
                H(8192);
            }
            this.f10501d.setSystemBarsAppearance(8, 8);
        } else {
            if (window != null) {
                I(8192);
            }
            this.f10501d.setSystemBarsAppearance(0, 8);
        }
    }

    @Override // b8.h
    public void D() {
        Window window = this.f;
        if (window == null) {
            this.f10501d.setSystemBarsBehavior(2);
            return;
        }
        window.getDecorView().setTag(356039078, 2);
        I(2048);
        H(4096);
    }

    @Override // b8.h
    public final void E(int i) {
        if ((i & 8) != 0) {
            ((o4.c) this.f10502e.f10436v).D();
        }
        this.f10501d.show(i & (-9));
    }

    public final void H(int i) {
        View decorView = this.f.getDecorView();
        decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
    }

    public final void I(int i) {
        View decorView = this.f.getDecorView();
        decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
    }

    @Override // b8.h
    public final void q(int i) {
        if ((i & 8) != 0) {
            ((o4.c) this.f10502e.f10436v).z();
        }
        this.f10501d.hide(i & (-9));
    }
}
