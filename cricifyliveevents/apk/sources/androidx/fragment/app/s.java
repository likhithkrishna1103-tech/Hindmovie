package androidx.fragment.app;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s extends x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f1068a;

    public s(y yVar) {
        this.f1068a = yVar;
    }

    @Override // androidx.fragment.app.x
    public final void a() {
        y yVar = this.f1068a;
        yVar.f1115n0.d();
        androidx.lifecycle.i0.d(yVar);
        Bundle bundle = yVar.f1119w;
        yVar.f1115n0.e(bundle != null ? bundle.getBundle("registryState") : null);
    }
}
