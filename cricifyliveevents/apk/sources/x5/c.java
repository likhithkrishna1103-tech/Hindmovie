package x5;

import android.content.res.Configuration;
import android.os.Build;
import android.view.View;
import androidx.fragment.app.y;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c extends y {

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public boolean f14336s0 = false;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public boolean f14337t0 = false;

    public final boolean R() {
        boolean zIsInMultiWindowMode;
        try {
            boolean z10 = m().getConfiguration().orientation == 2;
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    zIsInMultiWindowMode = J().isInMultiWindowMode();
                } catch (Exception unused) {
                    zIsInMultiWindowMode = false;
                }
            } else {
                zIsInMultiWindowMode = false;
            }
            return z10 && !zIsInMultiWindowMode;
        } catch (IllegalStateException unused2) {
            return false;
        }
    }

    @Override // androidx.fragment.app.y, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        this.Z = true;
        if (R()) {
            if (this.f14337t0) {
                S(3);
                return;
            } else {
                S(this.f14336s0 ? 8 : 4);
                return;
            }
        }
        if (this.f14337t0) {
            S(1);
        } else {
            S(this.f14336s0 ? 4 : 2);
        }
    }

    public void T() {
    }

    @Override // androidx.fragment.app.y
    public void G(View view) {
    }

    public void S(int i) {
    }

    public void U(String str) {
    }
}
