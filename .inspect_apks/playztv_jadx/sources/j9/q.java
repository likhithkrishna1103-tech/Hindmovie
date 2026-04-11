package j9;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.internal.NavigationMenuView;
import q4.y0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q extends y0 {
    public final /* synthetic */ t f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(t tVar, NavigationMenuView navigationMenuView) {
        super(navigationMenuView);
        this.f = tVar;
    }

    @Override // q4.y0, q0.b
    public final void d(View view, r0.e eVar) {
        super.d(view, eVar);
        t tVar = this.f.f6905y.f6896g;
        int i = 0;
        for (int i10 = 0; i10 < tVar.f6905y.f6894d.size(); i10++) {
            int iC = tVar.f6905y.c(i10);
            if (iC == 0 || iC == 1) {
                i++;
            }
        }
        eVar.f11226a.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(i, 1, false));
    }
}
