package e1;

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
import q0.o0;
import q4.n0;
import q4.y0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends q0.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f4276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f4277e;
    public final Object f;

    public b(y0 y0Var) {
        this.f4276d = 1;
        this.f = new WeakHashMap();
        this.f4277e = y0Var;
    }

    @Override // q0.b
    public final boolean a(View view, AccessibilityEvent accessibilityEvent) {
        int i = this.f4276d;
        View.AccessibilityDelegate accessibilityDelegate = this.f10418a;
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
                        WeakHashMap weakHashMap = o0.f10475a;
                        Gravity.getAbsoluteGravity(iJ, drawerLayout.getLayoutDirection());
                    }
                }
                break;
            default:
                q0.b bVar = (q0.b) ((WeakHashMap) obj).get(view);
                if (bVar == null) {
                }
                break;
        }
        return accessibilityDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // q0.b
    public o4.c b(View view) {
        switch (this.f4276d) {
            case 1:
                q0.b bVar = (q0.b) ((WeakHashMap) this.f).get(view);
                if (bVar == null) {
                }
                break;
        }
        return super.b(view);
    }

    @Override // q0.b
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f4276d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                super.c(view, accessibilityEvent);
                accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
                break;
            default:
                q0.b bVar = (q0.b) ((WeakHashMap) this.f).get(view);
                if (bVar == null) {
                    super.c(view, accessibilityEvent);
                } else {
                    bVar.c(view, accessibilityEvent);
                }
                break;
        }
    }

    @Override // q0.b
    public final void d(View view, r0.e eVar) {
        int i = this.f4276d;
        Object obj = this.f4277e;
        View.AccessibilityDelegate accessibilityDelegate = this.f10418a;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                AccessibilityNodeInfo accessibilityNodeInfo = eVar.f11226a;
                if (DrawerLayout.f1154c0) {
                    accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                } else {
                    AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
                    accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoObtain);
                    eVar.f11227b = -1;
                    accessibilityNodeInfo.setSource(view);
                    WeakHashMap weakHashMap = o0.f10475a;
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
                accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) r0.d.f11211e.f11221a);
                accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) r0.d.f.f11221a);
                break;
            default:
                AccessibilityNodeInfo accessibilityNodeInfo2 = eVar.f11226a;
                y0 y0Var = (y0) obj;
                RecyclerView recyclerView = y0Var.f10980d;
                RecyclerView recyclerView2 = y0Var.f10980d;
                if (recyclerView.O() || recyclerView2.getLayoutManager() == null) {
                    accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo2);
                } else {
                    recyclerView2.getLayoutManager().W(view, eVar);
                    q0.b bVar = (q0.b) ((WeakHashMap) this.f).get(view);
                    if (bVar != null) {
                        bVar.d(view, eVar);
                    } else {
                        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo2);
                    }
                }
                break;
        }
    }

    @Override // q0.b
    public void e(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f4276d) {
            case 1:
                q0.b bVar = (q0.b) ((WeakHashMap) this.f).get(view);
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

    @Override // q0.b
    public final boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f4276d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (DrawerLayout.f1154c0 || DrawerLayout.l(view)) {
                }
                break;
            default:
                q0.b bVar = (q0.b) ((WeakHashMap) this.f).get(viewGroup);
                if (bVar == null) {
                }
                break;
        }
        return this.f10418a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    @Override // q0.b
    public boolean g(View view, int i, Bundle bundle) {
        switch (this.f4276d) {
            case 1:
                y0 y0Var = (y0) this.f4277e;
                RecyclerView recyclerView = y0Var.f10980d;
                RecyclerView recyclerView2 = y0Var.f10980d;
                if (!recyclerView.O() && recyclerView2.getLayoutManager() != null) {
                    q0.b bVar = (q0.b) ((WeakHashMap) this.f).get(view);
                    if (bVar == null ? !super.g(view, i, bundle) : !bVar.g(view, i, bundle)) {
                        n0 n0Var = recyclerView2.getLayoutManager().f10818b.f1666w;
                    }
                }
                break;
        }
        return super.g(view, i, bundle);
    }

    @Override // q0.b
    public void h(View view, int i) {
        switch (this.f4276d) {
            case 1:
                q0.b bVar = (q0.b) ((WeakHashMap) this.f).get(view);
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

    @Override // q0.b
    public void i(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f4276d) {
            case 1:
                q0.b bVar = (q0.b) ((WeakHashMap) this.f).get(view);
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
        this.f4276d = 0;
        this.f = drawerLayout;
        this.f4277e = new Rect();
    }
}
