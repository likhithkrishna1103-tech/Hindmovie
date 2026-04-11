package j9;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k extends q0.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f6891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f6892e;
    public final /* synthetic */ l f;

    public k(l lVar, int i, boolean z2) {
        this.f = lVar;
        this.f6891d = i;
        this.f6892e = z2;
    }

    @Override // q0.b
    public final void d(View view, r0.e eVar) {
        this.f10418a.onInitializeAccessibilityNodeInfo(view, eVar.f11226a);
        t tVar = this.f.f6896g;
        int i = this.f6891d;
        int i10 = i;
        for (int i11 = 0; i11 < i; i11++) {
            if (tVar.f6905y.c(i11) == 2 || tVar.f6905y.c(i11) == 3) {
                i10--;
            }
        }
        eVar.j(e7.c.a(i10, 1, 1, 1, this.f6892e, view.isSelected()));
    }
}
