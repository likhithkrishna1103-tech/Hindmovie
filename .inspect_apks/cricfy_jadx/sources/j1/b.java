package j1;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.recyclerview.widget.RecyclerView;
import java.util.WeakHashMap;
import kf.i;
import t0.m0;
import v4.n0;
import v4.y0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends t0.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f6501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f6502e;
    public final Object f;

    public b(y0 y0Var) {
        this.f6501d = 1;
        this.f = new WeakHashMap();
        this.f6502e = y0Var;
    }

    @Override // t0.b
    public final boolean a(View view, AccessibilityEvent accessibilityEvent) {
        int i = this.f6501d;
        View.AccessibilityDelegate accessibilityDelegate = this.f11731a;
        Object obj = this.f;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                DrawerLayout drawerLayout = (DrawerLayout) obj;
                if (accessibilityEvent.getEventType() == 32) {
                    accessibilityEvent.getText();
                    View viewG = drawerLayout.g();
                    if (viewG != null) {
                        int iJ = drawerLayout.j(viewG);
                        drawerLayout.getClass();
                        WeakHashMap weakHashMap = m0.f11777a;
                        Gravity.getAbsoluteGravity(iJ, drawerLayout.getLayoutDirection());
                    }
                }
                break;
            default:
                t0.b bVar = (t0.b) ((WeakHashMap) obj).get(view);
                if (bVar == null) {
                }
                break;
        }
        return accessibilityDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // t0.b
    public i b(View view) {
        switch (this.f6501d) {
            case 1:
                t0.b bVar = (t0.b) ((WeakHashMap) this.f).get(view);
                if (bVar == null) {
                }
                break;
        }
        return super.b(view);
    }

    @Override // t0.b
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f6501d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                super.c(view, accessibilityEvent);
                accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
                break;
            default:
                t0.b bVar = (t0.b) ((WeakHashMap) this.f).get(view);
                if (bVar == null) {
                    super.c(view, accessibilityEvent);
                } else {
                    bVar.c(view, accessibilityEvent);
                }
                break;
        }
    }

    @Override // t0.b
    public final void d(View view, u0.e eVar) {
        int i = this.f6501d;
        Object obj = this.f6502e;
        View.AccessibilityDelegate accessibilityDelegate = this.f11731a;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                AccessibilityNodeInfo accessibilityNodeInfo = eVar.f12062a;
                if (DrawerLayout.f823d0) {
                    accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                } else {
                    AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
                    accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoObtain);
                    eVar.f12063b = -1;
                    accessibilityNodeInfo.setSource(view);
                    WeakHashMap weakHashMap = m0.f11777a;
                    Object parentForAccessibility = view.getParentForAccessibility();
                    if (parentForAccessibility instanceof View) {
                        accessibilityNodeInfo.setParent((View) parentForAccessibility);
                    }
                    Rect rect = (Rect) obj;
                    accessibilityNodeInfoObtain.getBoundsInScreen(rect);
                    accessibilityNodeInfo.setBoundsInScreen(rect);
                    accessibilityNodeInfo.setVisibleToUser(accessibilityNodeInfoObtain.isVisibleToUser());
                    accessibilityNodeInfo.setPackageName(accessibilityNodeInfoObtain.getPackageName());
                    eVar.i(accessibilityNodeInfoObtain.getClassName());
                    accessibilityNodeInfo.setContentDescription(accessibilityNodeInfoObtain.getContentDescription());
                    accessibilityNodeInfo.setEnabled(accessibilityNodeInfoObtain.isEnabled());
                    accessibilityNodeInfo.setFocused(accessibilityNodeInfoObtain.isFocused());
                    accessibilityNodeInfo.setAccessibilityFocused(accessibilityNodeInfoObtain.isAccessibilityFocused());
                    accessibilityNodeInfo.setSelected(accessibilityNodeInfoObtain.isSelected());
                    eVar.a(accessibilityNodeInfoObtain.getActions());
                    ViewGroup viewGroup = (ViewGroup) view;
                    int childCount = viewGroup.getChildCount();
                    for (int i10 = 0; i10 < childCount; i10++) {
                        View childAt = viewGroup.getChildAt(i10);
                        if (DrawerLayout.l(childAt)) {
                            accessibilityNodeInfo.addChild(childAt);
                        }
                    }
                }
                eVar.i("androidx.drawerlayout.widget.DrawerLayout");
                accessibilityNodeInfo.setFocusable(false);
                accessibilityNodeInfo.setFocused(false);
                accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) u0.c.f12046e.f12056a);
                accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) u0.c.f.f12056a);
                break;
            default:
                AccessibilityNodeInfo accessibilityNodeInfo2 = eVar.f12062a;
                y0 y0Var = (y0) obj;
                RecyclerView recyclerView = y0Var.f13405d;
                RecyclerView recyclerView2 = y0Var.f13405d;
                if (recyclerView.O() || recyclerView2.getLayoutManager() == null) {
                    accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo2);
                } else {
                    recyclerView2.getLayoutManager().W(view, eVar);
                    t0.b bVar = (t0.b) ((WeakHashMap) this.f).get(view);
                    if (bVar != null) {
                        bVar.d(view, eVar);
                    } else {
                        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo2);
                    }
                }
                break;
        }
    }

    @Override // t0.b
    public void e(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f6501d) {
            case 1:
                t0.b bVar = (t0.b) ((WeakHashMap) this.f).get(view);
                if (bVar == null) {
                    super.e(view, accessibilityEvent);
                } else {
                    bVar.e(view, accessibilityEvent);
                }
                break;
            default:
                super.e(view, accessibilityEvent);
                break;
        }
    }

    @Override // t0.b
    public final boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f6501d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (DrawerLayout.f823d0 || DrawerLayout.l(view)) {
                }
                break;
            default:
                t0.b bVar = (t0.b) ((WeakHashMap) this.f).get(viewGroup);
                if (bVar == null) {
                }
                break;
        }
        return this.f11731a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    @Override // t0.b
    public boolean g(View view, int i, Bundle bundle) {
        switch (this.f6501d) {
            case 1:
                y0 y0Var = (y0) this.f6502e;
                RecyclerView recyclerView = y0Var.f13405d;
                RecyclerView recyclerView2 = y0Var.f13405d;
                if (!recyclerView.O() && recyclerView2.getLayoutManager() != null) {
                    t0.b bVar = (t0.b) ((WeakHashMap) this.f).get(view);
                    if (bVar == null ? !super.g(view, i, bundle) : !bVar.g(view, i, bundle)) {
                        n0 n0Var = recyclerView2.getLayoutManager().f13248b.f1451x;
                    }
                }
                break;
        }
        return super.g(view, i, bundle);
    }

    @Override // t0.b
    public void h(View view, int i) {
        switch (this.f6501d) {
            case 1:
                t0.b bVar = (t0.b) ((WeakHashMap) this.f).get(view);
                if (bVar == null) {
                    super.h(view, i);
                } else {
                    bVar.h(view, i);
                }
                break;
            default:
                super.h(view, i);
                break;
        }
    }

    @Override // t0.b
    public void i(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f6501d) {
            case 1:
                t0.b bVar = (t0.b) ((WeakHashMap) this.f).get(view);
                if (bVar == null) {
                    super.i(view, accessibilityEvent);
                } else {
                    bVar.i(view, accessibilityEvent);
                }
                break;
            default:
                super.i(view, accessibilityEvent);
                break;
        }
    }

    public b(DrawerLayout drawerLayout) {
        this.f6501d = 0;
        this.f = drawerLayout;
        this.f6502e = new Rect();
    }
}
