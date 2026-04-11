package c0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends ViewGroup.MarginLayoutParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f2209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2213e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f2214g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2215h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2216j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f2217k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f2218l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f2219m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f2220n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f2221o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Rect f2222p;

    public e() {
        super(-2, -2);
        this.f2210b = false;
        this.f2211c = 0;
        this.f2212d = 0;
        this.f2213e = -1;
        this.f = -1;
        this.f2214g = 0;
        this.f2215h = 0;
        this.f2222p = new Rect();
    }

    public final boolean a(int i) {
        if (i == 0) {
            return this.f2219m;
        }
        if (i != 1) {
            return false;
        }
        return this.f2220n;
    }

    public e(Context context, AttributeSet attributeSet) {
        b bVar;
        super(context, attributeSet);
        this.f2210b = false;
        this.f2211c = 0;
        this.f2212d = 0;
        this.f2213e = -1;
        this.f = -1;
        this.f2214g = 0;
        this.f2215h = 0;
        this.f2222p = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b0.c.CoordinatorLayout_Layout);
        this.f2211c = typedArrayObtainStyledAttributes.getInteger(b0.c.CoordinatorLayout_Layout_android_layout_gravity, 0);
        this.f = typedArrayObtainStyledAttributes.getResourceId(b0.c.CoordinatorLayout_Layout_layout_anchor, -1);
        this.f2212d = typedArrayObtainStyledAttributes.getInteger(b0.c.CoordinatorLayout_Layout_layout_anchorGravity, 0);
        this.f2213e = typedArrayObtainStyledAttributes.getInteger(b0.c.CoordinatorLayout_Layout_layout_keyline, -1);
        this.f2214g = typedArrayObtainStyledAttributes.getInt(b0.c.CoordinatorLayout_Layout_layout_insetEdge, 0);
        this.f2215h = typedArrayObtainStyledAttributes.getInt(b0.c.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(b0.c.CoordinatorLayout_Layout_layout_behavior);
        this.f2210b = zHasValue;
        if (zHasValue) {
            String string = typedArrayObtainStyledAttributes.getString(b0.c.CoordinatorLayout_Layout_layout_behavior);
            String str = CoordinatorLayout.N;
            if (TextUtils.isEmpty(string)) {
                bVar = null;
            } else {
                if (string.startsWith(".")) {
                    string = context.getPackageName() + string;
                } else if (string.indexOf(46) < 0) {
                    String str2 = CoordinatorLayout.N;
                    if (!TextUtils.isEmpty(str2)) {
                        string = str2 + '.' + string;
                    }
                }
                try {
                    ThreadLocal threadLocal = CoordinatorLayout.P;
                    Map map = (Map) threadLocal.get();
                    if (map == null) {
                        map = new HashMap();
                        threadLocal.set(map);
                    }
                    Constructor<?> constructor = (Constructor) map.get(string);
                    if (constructor == null) {
                        constructor = Class.forName(string, false, context.getClassLoader()).getConstructor(CoordinatorLayout.O);
                        constructor.setAccessible(true);
                        map.put(string, constructor);
                    }
                    bVar = (b) constructor.newInstance(context, attributeSet);
                } catch (Exception e10) {
                    throw new RuntimeException(l4.a.m("Could not inflate Behavior subclass ", string), e10);
                }
            }
            this.f2209a = bVar;
        }
        typedArrayObtainStyledAttributes.recycle();
        b bVar2 = this.f2209a;
        if (bVar2 != null) {
            bVar2.g(this);
        }
    }

    public e(e eVar) {
        super((ViewGroup.MarginLayoutParams) eVar);
        this.f2210b = false;
        this.f2211c = 0;
        this.f2212d = 0;
        this.f2213e = -1;
        this.f = -1;
        this.f2214g = 0;
        this.f2215h = 0;
        this.f2222p = new Rect();
    }

    public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f2210b = false;
        this.f2211c = 0;
        this.f2212d = 0;
        this.f2213e = -1;
        this.f = -1;
        this.f2214g = 0;
        this.f2215h = 0;
        this.f2222p = new Rect();
    }

    public e(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f2210b = false;
        this.f2211c = 0;
        this.f2212d = 0;
        this.f2213e = -1;
        this.f = -1;
        this.f2214g = 0;
        this.f2215h = 0;
        this.f2222p = new Rect();
    }
}
