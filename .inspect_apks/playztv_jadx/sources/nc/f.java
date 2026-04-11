package nc;

import android.content.res.Configuration;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class f extends androidx.fragment.app.v {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public boolean f8929r0 = false;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public boolean f8930s0 = false;

    public final boolean P() {
        boolean zIsInMultiWindowMode;
        try {
            boolean z2 = m().getConfiguration().orientation == 2;
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    zIsInMultiWindowMode = G().isInMultiWindowMode();
                } catch (Exception unused) {
                    zIsInMultiWindowMode = false;
                }
            } else {
                zIsInMultiWindowMode = false;
            }
            return z2 && !zIsInMultiWindowMode;
        } catch (IllegalStateException unused2) {
            return false;
        }
    }

    @Override // androidx.fragment.app.v, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        this.Y = true;
        if (P()) {
            if (this.f8930s0) {
                Q(3);
                return;
            } else {
                Q(this.f8929r0 ? 5 : 6);
                return;
            }
        }
        if (this.f8930s0) {
            Q(1);
        } else {
            Q(3);
        }
    }

    public void R() {
    }

    public void Q(int i) {
    }

    public void S(String str) {
    }
}
