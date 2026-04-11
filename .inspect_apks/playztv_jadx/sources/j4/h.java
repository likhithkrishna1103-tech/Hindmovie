package j4;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import h.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OnBackInvokedDispatcher f6791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6792d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OnBackInvokedCallback f6793e;
    public boolean f;

    public h(OnBackInvokedDispatcher onBackInvokedDispatcher, int i) {
        this.f6791c = onBackInvokedDispatcher;
        this.f6792d = i;
        this.f6793e = Build.VERSION.SDK_INT == 33 ? new v(1, this) : new i(this);
    }

    @Override // j4.d
    public final void b(boolean z2) {
        if (z2 && !this.f) {
            this.f6791c.registerOnBackInvokedCallback(this.f6792d, this.f6793e);
            this.f = true;
        } else {
            if (z2 || !this.f) {
                return;
            }
            this.f6791c.unregisterOnBackInvokedCallback(this.f6793e);
            this.f = false;
        }
    }
}
