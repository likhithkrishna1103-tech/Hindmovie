package u0;

import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements z7.b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f12060v;

    public /* synthetic */ d(Object obj) {
        this.f12060v = obj;
    }

    public static d a(int i, int i10, int i11, int i12, boolean z10, boolean z11) {
        return new d(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i10, i11, i12, z10, z11));
    }

    @Override // qd.a
    public Object get() {
        return this.f12060v;
    }
}
