package b1;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.WeakHashMap;
import kf.i;
import t0.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends i {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ b f1632x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar) {
        super(18);
        this.f1632x = bVar;
    }

    @Override // kf.i
    public final u0.e E(int i) {
        return new u0.e(AccessibilityNodeInfo.obtain(this.f1632x.q(i).f12062a));
    }

    @Override // kf.i
    public final u0.e F(int i) {
        b bVar = this.f1632x;
        int i10 = i == 2 ? bVar.f1641k : bVar.f1642l;
        if (i10 == Integer.MIN_VALUE) {
            return null;
        }
        return E(i10);
    }

    @Override // kf.i
    public final boolean K(int i, int i10, Bundle bundle) {
        int i11;
        b bVar = this.f1632x;
        View view = bVar.i;
        if (i == -1) {
            WeakHashMap weakHashMap = m0.f11777a;
            return view.performAccessibilityAction(i10, bundle);
        }
        if (i10 == 1) {
            return bVar.v(i);
        }
        if (i10 == 2) {
            return bVar.j(i);
        }
        if (i10 != 64) {
            if (i10 != 128) {
                return bVar.r(i, i10);
            }
            if (bVar.f1641k != i) {
                return false;
            }
            bVar.f1641k = Integer.MIN_VALUE;
            view.invalidate();
            bVar.w(i, 65536);
            return true;
        }
        AccessibilityManager accessibilityManager = bVar.f1639h;
        if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled() || (i11 = bVar.f1641k) == i) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            bVar.f1641k = Integer.MIN_VALUE;
            view.invalidate();
            bVar.w(i11, 65536);
        }
        bVar.f1641k = i;
        view.invalidate();
        bVar.w(i, 32768);
        return true;
    }
}
