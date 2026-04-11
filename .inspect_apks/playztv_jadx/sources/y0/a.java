package y0;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.chip.Chip;
import java.util.WeakHashMap;
import q0.o0;
import r0.e;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends o4.c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ b f14420v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar) {
        super(8);
        this.f14420v = bVar;
    }

    @Override // o4.c
    public final boolean B(int i, int i10, Bundle bundle) {
        int i11;
        b bVar = this.f14420v;
        Chip chip = bVar.i;
        if (i == -1) {
            WeakHashMap weakHashMap = o0.f10475a;
            return chip.performAccessibilityAction(i10, bundle);
        }
        if (i10 == 1) {
            return bVar.p(i);
        }
        if (i10 == 2) {
            return bVar.j(i);
        }
        boolean z2 = false;
        if (i10 == 64) {
            AccessibilityManager accessibilityManager = bVar.f14427h;
            if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled() || (i11 = bVar.f14429k) == i) {
                return false;
            }
            if (i11 != Integer.MIN_VALUE) {
                bVar.f14429k = Integer.MIN_VALUE;
                chip.invalidate();
                bVar.q(i11, 65536);
            }
            bVar.f14429k = i;
            chip.invalidate();
            bVar.q(i, 32768);
            return true;
        }
        if (i10 == 128) {
            if (bVar.f14429k != i) {
                return false;
            }
            bVar.f14429k = Integer.MIN_VALUE;
            chip.invalidate();
            bVar.q(i, 65536);
            return true;
        }
        Chip chip2 = ((b9.c) bVar).f1947q;
        if (i10 == 16) {
            if (i == 0) {
                return chip2.performClick();
            }
            if (i == 1) {
                chip2.playSoundEffect(0);
                View.OnClickListener onClickListener = chip2.B;
                if (onClickListener != null) {
                    onClickListener.onClick(chip2);
                    z2 = true;
                }
                if (chip2.N) {
                    chip2.M.q(1, 1);
                }
            }
        }
        return z2;
    }

    @Override // o4.c
    public final e w(int i) {
        return new e(AccessibilityNodeInfo.obtain(this.f14420v.n(i).f11226a));
    }

    @Override // o4.c
    public final e y(int i) {
        b bVar = this.f14420v;
        int i10 = i == 2 ? bVar.f14429k : bVar.f14430l;
        if (i10 == Integer.MIN_VALUE) {
            return null;
        }
        return w(i10);
    }
}
