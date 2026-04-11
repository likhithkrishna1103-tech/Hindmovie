package androidx.navigation;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements Comparable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final l f1364v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Bundle f1365w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f1366x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f1367y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f1368z;

    public k(l lVar, Bundle bundle, boolean z10, boolean z11, int i) {
        this.f1364v = lVar;
        this.f1365w = bundle;
        this.f1366x = z10;
        this.f1367y = z11;
        this.f1368z = i;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(k kVar) {
        boolean z10 = this.f1366x;
        if (z10 && !kVar.f1366x) {
            return 1;
        }
        if (!z10 && kVar.f1366x) {
            return -1;
        }
        Bundle bundle = this.f1365w;
        if (bundle != null && kVar.f1365w == null) {
            return 1;
        }
        if (bundle == null && kVar.f1365w != null) {
            return -1;
        }
        if (bundle != null) {
            int size = bundle.size() - kVar.f1365w.size();
            if (size > 0) {
                return 1;
            }
            if (size < 0) {
                return -1;
            }
        }
        boolean z11 = this.f1367y;
        if (z11 && !kVar.f1367y) {
            return 1;
        }
        if (z11 || !kVar.f1367y) {
            return this.f1368z - kVar.f1368z;
        }
        return -1;
    }
}
