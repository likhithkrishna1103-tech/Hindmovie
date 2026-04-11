package e7;

import android.os.Handler;
import android.os.Looper;
import android.view.accessibility.AccessibilityNodeInfo;
import p6.f;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static c f4585v;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Object f4586u;

    public /* synthetic */ c(Object obj) {
        this.f4586u = obj;
    }

    public static c a(int i, int i10, int i11, int i12, boolean z2, boolean z10) {
        return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i10, i11, i12, z2, z10));
    }

    public void b() {
        synchronized (this.f4586u) {
        }
    }

    @Override // md.a
    public Object get() {
        return this.f4586u;
    }

    public c() {
        this.f4586u = new Object();
        new Handler(Looper.getMainLooper(), new f(2, this));
    }
}
