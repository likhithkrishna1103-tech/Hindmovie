package f0;

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

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends ViewGroup.MarginLayoutParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f3897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3901e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f3902g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3903h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3904j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f3905k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f3906l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f3907m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f3908n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f3909o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Rect f3910p;

    public e() {
        super(-2, -2);
        this.f3898b = false;
        this.f3899c = 0;
        this.f3900d = 0;
        this.f3901e = -1;
        this.f = -1;
        this.f3902g = 0;
        this.f3903h = 0;
        this.f3910p = new Rect();
    }

    public final boolean a(int i) {
        if (i == 0) {
            return this.f3907m;
        }
        if (i != 1) {
            return false;
        }
        return this.f3908n;
    }

    public e(Context context, AttributeSet attributeSet) {
        b bVar;
        super(context, attributeSet);
        this.f3898b = false;
        this.f3899c = 0;
        this.f3900d = 0;
        this.f3901e = -1;
        this.f = -1;
        this.f3902g = 0;
        this.f3903h = 0;
        this.f3910p = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e0.c.CoordinatorLayout_Layout);
        this.f3899c = typedArrayObtainStyledAttributes.getInteger(e0.c.CoordinatorLayout_Layout_android_layout_gravity, 0);
        this.f = typedArrayObtainStyledAttributes.getResourceId(e0.c.CoordinatorLayout_Layout_layout_anchor, -1);
        this.f3900d = typedArrayObtainStyledAttributes.getInteger(e0.c.CoordinatorLayout_Layout_layout_anchorGravity, 0);
        this.f3901e = typedArrayObtainStyledAttributes.getInteger(e0.c.CoordinatorLayout_Layout_layout_keyline, -1);
        this.f3902g = typedArrayObtainStyledAttributes.getInt(e0.c.CoordinatorLayout_Layout_layout_insetEdge, 0);
        this.f3903h = typedArrayObtainStyledAttributes.getInt(e0.c.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(e0.c.CoordinatorLayout_Layout_layout_behavior);
        this.f3898b = zHasValue;
        if (zHasValue) {
            String string = typedArrayObtainStyledAttributes.getString(e0.c.CoordinatorLayout_Layout_layout_behavior);
            String str = CoordinatorLayout.O;
            if (TextUtils.isEmpty(string)) {
                bVar = null;
            } else {
                if (string.startsWith(".")) {
                    string = context.getPackageName() + string;
                } else if (string.indexOf(46) < 0) {
                    String str2 = CoordinatorLayout.O;
                    if (!TextUtils.isEmpty(str2)) {
                        string = str2 + '.' + string;
                    }
                }
                try {
                    ThreadLocal threadLocal = CoordinatorLayout.Q;
                    Map map = (Map) threadLocal.get();
                    if (map == null) {
                        map = new HashMap();
                        threadLocal.set(map);
                    }
                    Constructor<?> constructor = (Constructor) map.get(string);
                    if (constructor == null) {
                        constructor = Class.forName(string, false, context.getClassLoader()).getConstructor(CoordinatorLayout.P);
                        constructor.setAccessible(true);
                        map.put(string, constructor);
                    }
                    bVar = (b) constructor.newInstance(context, attributeSet);
                } catch (Exception e9) {
                    throw new RuntimeException(q4.a.n("Could not inflate Behavior subclass ", string), e9);
                }
            }
            this.f3897a = bVar;
        }
        typedArrayObtainStyledAttributes.recycle();
        b bVar2 = this.f3897a;
        if (bVar2 != null) {
            bVar2.g(this);
        }
    }

    public e(e eVar) {
        super((ViewGroup.MarginLayoutParams) eVar);
        this.f3898b = false;
        this.f3899c = 0;
        this.f3900d = 0;
        this.f3901e = -1;
        this.f = -1;
        this.f3902g = 0;
        this.f3903h = 0;
        this.f3910p = new Rect();
    }

    public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f3898b = false;
        this.f3899c = 0;
        this.f3900d = 0;
        this.f3901e = -1;
        this.f = -1;
        this.f3902g = 0;
        this.f3903h = 0;
        this.f3910p = new Rect();
    }

    public e(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f3898b = false;
        this.f3899c = 0;
        this.f3900d = 0;
        this.f3901e = -1;
        this.f = -1;
        this.f3902g = 0;
        this.f3903h = 0;
        this.f3910p = new Rect();
    }
}
