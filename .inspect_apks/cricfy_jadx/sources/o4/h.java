package o4;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OnBackInvokedDispatcher f9504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9505d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OnBackInvokedCallback f9506e;
    public boolean f;

    public h(OnBackInvokedDispatcher onBackInvokedDispatcher, int i) {
        this.f9504c = onBackInvokedDispatcher;
        this.f9505d = i;
        this.f9506e = Build.VERSION.SDK_INT == 33 ? new ea.c(3, this) : new i(this);
    }

    @Override // o4.d
    public final void b(boolean z10) {
        if (z10 && !this.f) {
            this.f9504c.registerOnBackInvokedCallback(this.f9505d, this.f9506e);
            this.f = true;
        } else {
            if (z10 || !this.f) {
                return;
            }
            this.f9504c.unregisterOnBackInvokedCallback(this.f9506e);
            this.f = false;
        }
    }
}
