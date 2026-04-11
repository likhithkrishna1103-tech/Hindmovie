package r0;

import android.R;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import q0.x;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f11211e = new d(1);
    public static final d f = new d(2);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f11212g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f11213h;
    public static final d i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final d f11214j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final d f11215k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final d f11216l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final d f11217m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final d f11218n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final d f11219o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final d f11220p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f11221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class f11223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o f11224d;

    static {
        new d(4);
        new d(8);
        f11212g = new d(16);
        new d(32);
        new d(64);
        new d(128);
        new d(256, h.class);
        new d(512, h.class);
        new d(1024, i.class);
        new d(2048, i.class);
        f11213h = new d(4096);
        i = new d(8192);
        new d(16384);
        new d(32768);
        new d(65536);
        new d(131072, m.class);
        f11214j = new d(262144);
        f11215k = new d(524288);
        f11216l = new d(1048576);
        new d(2097152, n.class);
        int i10 = Build.VERSION.SDK_INT;
        new d(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
        f11217m = new d(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, k.class);
        f11218n = new d(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
        new d(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
        f11219o = new d(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
        new d(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
        new d(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
        new d(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
        new d(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
        new d(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
        new d(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
        new d(i10 >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, R.id.accessibilityActionSetProgress, null, null, l.class);
        new d(i10 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, j.class);
        new d(i10 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
        new d(i10 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
        new d(i10 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
        new d(i10 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
        new d(i10 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
        new d(i10 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null, null);
        new d(i10 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null, null);
        new d(i10 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
        f11220p = new d(i10 >= 34 ? x.a() : null, R.id.accessibilityActionScrollInDirection, null, null, null);
    }

    public d(int i10) {
        this(null, i10, null, null, null);
    }

    public final int a() {
        return ((AccessibilityNodeInfo.AccessibilityAction) this.f11221a).getId();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof d)) {
            return false;
        }
        Object obj2 = ((d) obj).f11221a;
        Object obj3 = this.f11221a;
        return obj3 == null ? obj2 == null : obj3.equals(obj2);
    }

    public final int hashCode() {
        Object obj = this.f11221a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("AccessibilityActionCompat: ");
        String strD = e.d(this.f11222b);
        if (strD.equals("ACTION_UNKNOWN")) {
            Object obj = this.f11221a;
            if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                strD = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
            }
        }
        sb2.append(strD);
        return sb2.toString();
    }

    public d(int i10, Class cls) {
        this(null, i10, null, null, cls);
    }

    public d(Object obj, int i10, String str, o oVar, Class cls) {
        this.f11222b = i10;
        this.f11224d = oVar;
        if (obj == null) {
            this.f11221a = new AccessibilityNodeInfo.AccessibilityAction(i10, str);
        } else {
            this.f11221a = obj;
        }
        this.f11223c = cls;
    }
}
