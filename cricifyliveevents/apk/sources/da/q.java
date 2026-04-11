package da;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.internal.NavigationMenuView;
import v4.y0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q extends y0 {
    public final /* synthetic */ t f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(t tVar, NavigationMenuView navigationMenuView) {
        super(navigationMenuView);
        this.f = tVar;
    }

    @Override // v4.y0, t0.b
    public final void d(View view, u0.e eVar) {
        super.d(view, eVar);
        t tVar = this.f.f3633z.f3624g;
        int i = 0;
        for (int i10 = 0; i10 < tVar.f3633z.f3622d.size(); i10++) {
            int iC = tVar.f3633z.c(i10);
            if (iC == 0 || iC == 1) {
                i++;
            }
        }
        eVar.f12062a.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(i, 1, false));
    }
}
