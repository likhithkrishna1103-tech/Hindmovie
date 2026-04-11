package q0;

import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class s1 extends b8.h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Window f10497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f10498e;

    public s1(Window window, e eVar) {
        this.f10497d = window;
        this.f10498e = eVar;
    }

    @Override // b8.h
    public final void C(boolean z2) {
        if (!z2) {
            I(8192);
            return;
        }
        Window window = this.f10497d;
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        H(8192);
    }

    @Override // b8.h
    public final void D() {
        this.f10497d.getDecorView().setTag(356039078, 2);
        I(2048);
        H(4096);
    }

    @Override // b8.h
    public final void E(int i) {
        for (int i10 = 1; i10 <= 512; i10 <<= 1) {
            if ((i & i10) != 0) {
                if (i10 == 1) {
                    I(4);
                    this.f10497d.clearFlags(1024);
                } else if (i10 == 2) {
                    I(2);
                } else if (i10 == 8) {
                    ((o4.c) this.f10498e.f10436v).D();
                }
            }
        }
    }

    public final void H(int i) {
        View decorView = this.f10497d.getDecorView();
        decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
    }

    public final void I(int i) {
        View decorView = this.f10497d.getDecorView();
        decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
    }

    @Override // b8.h
    public final void q(int i) {
        for (int i10 = 1; i10 <= 512; i10 <<= 1) {
            if ((i & i10) != 0) {
                if (i10 == 1) {
                    H(4);
                } else if (i10 == 2) {
                    H(2);
                } else if (i10 == 8) {
                    ((o4.c) this.f10498e.f10436v).z();
                }
            }
        }
    }
}
