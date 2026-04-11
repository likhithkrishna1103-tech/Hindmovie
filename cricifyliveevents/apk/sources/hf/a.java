package hf;

import android.graphics.Rect;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import ge.q;
import java.util.ArrayList;
import java.util.List;
import me.ibrahimsn.lib.SmoothBottomBar;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends b1.b {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final SmoothBottomBar f5956q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List f5957r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final h f5958s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(SmoothBottomBar smoothBottomBar, List list, h hVar) {
        super(smoothBottomBar);
        ge.i.e(list, "bottomBarItems");
        this.f5956q = smoothBottomBar;
        this.f5957r = list;
        this.f5958s = hVar;
    }

    @Override // b1.b
    public final int n(float f, float f10) {
        return (int) (f / (this.f5956q.getWidth() / this.f5957r.size()));
    }

    @Override // b1.b
    public final void o(ArrayList arrayList) {
        int size = this.f5957r.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(Integer.valueOf(i));
        }
    }

    @Override // b1.b
    public final boolean r(int i, int i10) {
        if (i10 != 16) {
            return false;
        }
        this.f5958s.a(Integer.valueOf(i));
        return true;
    }

    @Override // b1.b
    public final void t(int i, u0.e eVar) {
        eVar.i(q.a(b.class).c());
        List list = this.f5957r;
        String str = ((b) list.get(i)).f5960b;
        AccessibilityNodeInfo accessibilityNodeInfo = eVar.f12062a;
        accessibilityNodeInfo.setContentDescription(str);
        accessibilityNodeInfo.setClickable(true);
        accessibilityNodeInfo.setFocusable(true);
        if (Build.VERSION.SDK_INT >= 28) {
            accessibilityNodeInfo.setScreenReaderFocusable(true);
        } else {
            eVar.h(1, true);
        }
        eVar.b(u0.c.f12047g);
        SmoothBottomBar smoothBottomBar = this.f5956q;
        accessibilityNodeInfo.setSelected(smoothBottomBar.getItemActiveIndex() == i);
        Rect rect = new Rect();
        int width = smoothBottomBar.getWidth() / list.size();
        int i10 = i * width;
        rect.left = i10;
        rect.top = 0;
        rect.right = i10 + width;
        rect.bottom = smoothBottomBar.getHeight();
        accessibilityNodeInfo.setBoundsInParent(rect);
    }
}
