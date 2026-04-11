package y0;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.chip.Chip;
import java.util.ArrayList;
import java.util.WeakHashMap;
import q0.o0;
import r0.e;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class b extends q0.b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Rect f14421n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ua.c f14422o = new ua.c();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final v8.c f14423p = new v8.c();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AccessibilityManager f14427h;
    public final Chip i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f14428j;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f14424d = new Rect();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f14425e = new Rect();
    public final Rect f = new Rect();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f14426g = new int[2];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f14429k = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f14430l = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f14431m = Integer.MIN_VALUE;

    public b(Chip chip) {
        this.i = chip;
        this.f14427h = (AccessibilityManager) chip.getContext().getSystemService("accessibility");
        chip.setFocusable(true);
        WeakHashMap weakHashMap = o0.f10475a;
        if (chip.getImportantForAccessibility() == 0) {
            chip.setImportantForAccessibility(1);
        }
    }

    @Override // q0.b
    public final o4.c b(View view) {
        if (this.f14428j == null) {
            this.f14428j = new a(this);
        }
        return this.f14428j;
    }

    @Override // q0.b
    public final void d(View view, e eVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = eVar.f11226a;
        this.f10418a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        Chip chip = ((b9.c) this).f1947q;
        b9.e eVar2 = chip.f3378y;
        accessibilityNodeInfo.setCheckable(eVar2 != null && eVar2.l0);
        accessibilityNodeInfo.setClickable(chip.isClickable());
        eVar.i(chip.getAccessibilityClassName());
        eVar.m(chip.getText());
    }

    public final boolean j(int i) {
        if (this.f14430l != i) {
            return false;
        }
        this.f14430l = Integer.MIN_VALUE;
        b9.c cVar = (b9.c) this;
        if (i == 1) {
            Chip chip = cVar.f1947q;
            chip.H = false;
            chip.refreshDrawableState();
        }
        q(i, 8);
        return true;
    }

    public final e k(int i) {
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
        e eVar = new e(accessibilityNodeInfoObtain);
        accessibilityNodeInfoObtain.setEnabled(true);
        accessibilityNodeInfoObtain.setFocusable(true);
        eVar.i("android.view.View");
        Rect rect = f14421n;
        accessibilityNodeInfoObtain.setBoundsInParent(rect);
        accessibilityNodeInfoObtain.setBoundsInScreen(rect);
        Chip chip = this.i;
        accessibilityNodeInfoObtain.setParent(chip);
        o(i, eVar);
        if (eVar.g() == null && accessibilityNodeInfoObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect2 = this.f14425e;
        eVar.f(rect2);
        if (rect2.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = accessibilityNodeInfoObtain.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((actions & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        accessibilityNodeInfoObtain.setPackageName(chip.getContext().getPackageName());
        eVar.f11227b = i;
        accessibilityNodeInfoObtain.setSource(chip, i);
        if (this.f14429k == i) {
            accessibilityNodeInfoObtain.setAccessibilityFocused(true);
            eVar.a(128);
        } else {
            accessibilityNodeInfoObtain.setAccessibilityFocused(false);
            eVar.a(64);
        }
        boolean z2 = this.f14430l == i;
        if (z2) {
            eVar.a(2);
        } else if (accessibilityNodeInfoObtain.isFocusable()) {
            eVar.a(1);
        }
        accessibilityNodeInfoObtain.setFocused(z2);
        int[] iArr = this.f14426g;
        chip.getLocationOnScreen(iArr);
        Rect rect3 = this.f14424d;
        accessibilityNodeInfoObtain.getBoundsInScreen(rect3);
        if (rect3.equals(rect)) {
            eVar.f(rect3);
            rect3.offset(iArr[0] - chip.getScrollX(), iArr[1] - chip.getScrollY());
        }
        Rect rect4 = this.f;
        if (chip.getLocalVisibleRect(rect4)) {
            rect4.offset(iArr[0] - chip.getScrollX(), iArr[1] - chip.getScrollY());
            if (rect3.intersect(rect4)) {
                accessibilityNodeInfoObtain.setBoundsInScreen(rect3);
                if (!rect3.isEmpty() && chip.getWindowVisibility() == 0) {
                    Object parent = chip.getParent();
                    while (true) {
                        if (parent instanceof View) {
                            View view = (View) parent;
                            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                                break;
                            }
                            parent = view.getParent();
                        } else if (parent != null) {
                            eVar.f11226a.setVisibleToUser(true);
                        }
                    }
                }
            }
        }
        return eVar;
    }

    public abstract void l(ArrayList arrayList);

    /* JADX WARN: Removed duplicated region for block: B:40:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m(int r19, android.graphics.Rect r20) {
        /*
            Method dump skipped, instruction units count: 488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.b.m(int, android.graphics.Rect):boolean");
    }

    public final e n(int i) {
        if (i != -1) {
            return k(i);
        }
        Chip chip = this.i;
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(chip);
        e eVar = new e(accessibilityNodeInfoObtain);
        WeakHashMap weakHashMap = o0.f10475a;
        chip.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
        ArrayList arrayList = new ArrayList();
        l(arrayList);
        if (accessibilityNodeInfoObtain.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            eVar.f11226a.addChild(chip, ((Integer) arrayList.get(i10)).intValue());
        }
        return eVar;
    }

    public abstract void o(int i, e eVar);

    public final boolean p(int i) {
        int i10;
        Chip chip = this.i;
        if ((!chip.isFocused() && !chip.requestFocus()) || (i10 = this.f14430l) == i) {
            return false;
        }
        if (i10 != Integer.MIN_VALUE) {
            j(i10);
        }
        if (i == Integer.MIN_VALUE) {
            return false;
        }
        this.f14430l = i;
        b9.c cVar = (b9.c) this;
        if (i == 1) {
            Chip chip2 = cVar.f1947q;
            chip2.H = true;
            chip2.refreshDrawableState();
        }
        q(i, 8);
        return true;
    }

    public final void q(int i, int i10) {
        View view;
        ViewParent parent;
        AccessibilityEvent accessibilityEventObtain;
        if (i == Integer.MIN_VALUE || !this.f14427h.isEnabled() || (parent = (view = this.i).getParent()) == null) {
            return;
        }
        if (i != -1) {
            accessibilityEventObtain = AccessibilityEvent.obtain(i10);
            e eVarN = n(i);
            accessibilityEventObtain.getText().add(eVarN.g());
            AccessibilityNodeInfo accessibilityNodeInfo = eVarN.f11226a;
            accessibilityEventObtain.setContentDescription(accessibilityNodeInfo.getContentDescription());
            accessibilityEventObtain.setScrollable(accessibilityNodeInfo.isScrollable());
            accessibilityEventObtain.setPassword(accessibilityNodeInfo.isPassword());
            accessibilityEventObtain.setEnabled(accessibilityNodeInfo.isEnabled());
            accessibilityEventObtain.setChecked(accessibilityNodeInfo.isChecked());
            if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
            accessibilityEventObtain.setClassName(accessibilityNodeInfo.getClassName());
            accessibilityEventObtain.setSource(view, i);
            accessibilityEventObtain.setPackageName(view.getContext().getPackageName());
        } else {
            accessibilityEventObtain = AccessibilityEvent.obtain(i10);
            view.onInitializeAccessibilityEvent(accessibilityEventObtain);
        }
        parent.requestSendAccessibilityEvent(view, accessibilityEventObtain);
    }
}
