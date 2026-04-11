package da;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends t0.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f3620d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f3621e;
    public final /* synthetic */ l f;

    public k(l lVar, int i, boolean z10) {
        this.f = lVar;
        this.f3620d = i;
        this.f3621e = z10;
    }

    @Override // t0.b
    public final void d(View view, u0.e eVar) {
        this.f11731a.onInitializeAccessibilityNodeInfo(view, eVar.f12062a);
        t tVar = this.f.f3624g;
        int i = this.f3620d;
        int i10 = i;
        for (int i11 = 0; i11 < i; i11++) {
            if (tVar.f3633z.c(i11) == 2 || tVar.f3633z.c(i11) == 3) {
                i10--;
            }
        }
        eVar.j(u0.d.a(i10, 1, 1, 1, this.f3621e, view.isSelected()));
    }
}
