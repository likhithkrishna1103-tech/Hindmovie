package androidx.lifecycle;

import android.os.Bundle;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k0 implements b5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b5.e f1168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f1170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final rd.j f1171d;

    public k0(b5.e eVar, u0 u0Var) {
        ge.i.e(eVar, "savedStateRegistry");
        this.f1168a = eVar;
        this.f1171d = new rd.j(new j0(0, u0Var));
    }

    @Override // b5.d
    public final Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1170c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : ((l0) this.f1171d.getValue()).f1173d.entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleA = ((h0) entry.getValue()).f1162e.a();
            if (!ge.i.a(bundleA, Bundle.EMPTY)) {
                bundle.putBundle(str, bundleA);
            }
        }
        this.f1169b = false;
        return bundle;
    }

    public final void b() {
        if (this.f1169b) {
            return;
        }
        Bundle bundleC = this.f1168a.c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1170c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (bundleC != null) {
            bundle.putAll(bundleC);
        }
        this.f1170c = bundle;
        this.f1169b = true;
    }
}
