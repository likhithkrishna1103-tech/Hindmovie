package androidx.lifecycle;

import android.os.Bundle;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k0 implements x4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n.s f1471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f1473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final nd.i f1474d;

    public k0(n.s sVar, u0 u0Var) {
        be.h.e(sVar, "savedStateRegistry");
        this.f1471a = sVar;
        this.f1474d = new nd.i(new j0(0, u0Var));
    }

    @Override // x4.c
    public final Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1473c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : ((l0) this.f1474d.getValue()).f1476d.entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleA = ((h0) entry.getValue()).f1465e.a();
            if (!be.h.a(bundleA, Bundle.EMPTY)) {
                bundle.putBundle(str, bundleA);
            }
        }
        this.f1472b = false;
        return bundle;
    }

    public final void b() {
        if (this.f1472b) {
            return;
        }
        Bundle bundleC = this.f1471a.c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1473c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (bundleC != null) {
            bundle.putAll(bundleC);
        }
        this.f1473c = bundle;
        this.f1472b = true;
    }
}
