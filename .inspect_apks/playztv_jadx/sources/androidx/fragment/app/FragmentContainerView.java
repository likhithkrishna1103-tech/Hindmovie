package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import java.util.ArrayList;
import q0.r1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ArrayList f1221u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f1222v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View.OnApplyWindowInsetsListener f1223w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f1224x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        String str;
        super(context, attributeSet, 0);
        be.h.e(context, "context");
        this.f1221u = new ArrayList();
        this.f1222v = new ArrayList();
        this.f1224x = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            int[] iArr = i1.c.FragmentContainerView;
            be.h.d(iArr, "FragmentContainerView");
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
            if (classAttribute == null) {
                classAttribute = typedArrayObtainStyledAttributes.getString(i1.c.FragmentContainerView_android_name);
                str = "android:name";
            } else {
                str = "class";
            }
            typedArrayObtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + '\"');
        }
    }

    public final void a(View view) {
        if (this.f1222v.contains(view)) {
            this.f1221u.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        be.h.e(view, "child");
        Object tag = view.getTag(i1.b.fragment_container_view_tag);
        if ((tag instanceof v ? (v) tag : null) != null) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        r1 r1VarI;
        be.h.e(windowInsets, "insets");
        r1 r1VarH = r1.h(null, windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f1223w;
        if (onApplyWindowInsetsListener != null) {
            be.h.b(onApplyWindowInsetsListener);
            WindowInsets windowInsetsOnApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets);
            be.h.d(windowInsetsOnApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            r1VarI = r1.h(null, windowInsetsOnApplyWindowInsets);
        } else {
            r1VarI = q0.o0.i(this, r1VarH);
        }
        be.h.d(r1VarI, "if (applyWindowInsetsLis…, insetsCompat)\n        }");
        if (!r1VarI.f10492a.n()) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                q0.o0.b(getChildAt(i), r1VarI);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        be.h.e(canvas, "canvas");
        if (this.f1224x) {
            ArrayList arrayList = this.f1221u;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                super.drawChild(canvas, (View) obj, getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j5) {
        be.h.e(canvas, "canvas");
        be.h.e(view, "child");
        if (this.f1224x) {
            ArrayList arrayList = this.f1221u;
            if (!arrayList.isEmpty() && arrayList.contains(view)) {
                return false;
            }
        }
        return super.drawChild(canvas, view, j5);
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        be.h.e(view, "view");
        this.f1222v.remove(view);
        if (this.f1221u.remove(view)) {
            this.f1224x = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends v> F getFragment() {
        h.j jVar;
        v vVar;
        n0 n0VarO;
        View view = this;
        while (true) {
            jVar = null;
            if (view == null) {
                vVar = null;
                break;
            }
            Object tag = view.getTag(i1.b.fragment_container_view_tag);
            vVar = tag instanceof v ? (v) tag : null;
            if (vVar != null) {
                break;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        if (vVar == null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
                if (context instanceof h.j) {
                    jVar = (h.j) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (jVar == null) {
                throw new IllegalStateException("View " + this + " is not within a subclass of FragmentActivity.");
            }
            n0VarO = jVar.o();
        } else {
            if (!vVar.p()) {
                throw new IllegalStateException("The Fragment " + vVar + " that owns View " + this + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
            }
            n0VarO = vVar.i();
        }
        return (F) n0VarO.A(getId());
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        be.h.e(windowInsets, "insets");
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                super.removeAllViewsInLayout();
                return;
            } else {
                View childAt = getChildAt(childCount);
                be.h.d(childAt, "view");
                a(childAt);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        be.h.e(view, "view");
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i) {
        View childAt = getChildAt(i);
        be.h.d(childAt, "view");
        a(childAt);
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        be.h.e(view, "view");
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int i, int i10) {
        int i11 = i + i10;
        for (int i12 = i; i12 < i11; i12++) {
            View childAt = getChildAt(i12);
            be.h.d(childAt, "view");
            a(childAt);
        }
        super.removeViews(i, i10);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int i, int i10) {
        int i11 = i + i10;
        for (int i12 = i; i12 < i11; i12++) {
            View childAt = getChildAt(i12);
            be.h.d(childAt, "view");
            a(childAt);
        }
        super.removeViewsInLayout(i, i10);
    }

    public final void setDrawDisappearingViewsLast(boolean z2) {
        this.f1224x = z2;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        be.h.e(onApplyWindowInsetsListener, "listener");
        this.f1223w = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        be.h.e(view, "view");
        if (view.getParent() == this) {
            this.f1222v.add(view);
        }
        super.startViewTransition(view);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet, n0 n0Var) {
        View view;
        super(context, attributeSet);
        be.h.e(context, "context");
        be.h.e(attributeSet, "attrs");
        this.f1221u = new ArrayList();
        this.f1222v = new ArrayList();
        this.f1224x = true;
        String classAttribute = attributeSet.getClassAttribute();
        int[] iArr = i1.c.FragmentContainerView;
        be.h.d(iArr, "FragmentContainerView");
        int i = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        classAttribute = classAttribute == null ? typedArrayObtainStyledAttributes.getString(i1.c.FragmentContainerView_android_name) : classAttribute;
        String string = typedArrayObtainStyledAttributes.getString(i1.c.FragmentContainerView_android_tag);
        typedArrayObtainStyledAttributes.recycle();
        int id2 = getId();
        v vVarA = n0Var.A(id2);
        if (classAttribute != null && vVarA == null) {
            if (id2 == -1) {
                throw new IllegalStateException(e6.j.n("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? " with tag ".concat(string) : ""));
            }
            h0 h0VarD = n0Var.D();
            context.getClassLoader();
            v vVarA2 = h0VarD.a(classAttribute);
            be.h.d(vVarA2, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            vVarA2.Y = true;
            z zVar = vVarA2.N;
            if ((zVar == null ? null : zVar.f1422u) != null) {
                vVarA2.Y = true;
            }
            a aVar = new a(n0Var);
            aVar.f1238p = true;
            vVarA2.Z = this;
            aVar.e(getId(), vVarA2, string, 1);
            if (!aVar.f1230g) {
                aVar.f1231h = false;
                aVar.f1239q.y(aVar, true);
            } else {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
        }
        ArrayList arrayListT = n0Var.f1312c.t();
        int size = arrayListT.size();
        while (i < size) {
            Object obj = arrayListT.get(i);
            i++;
            u0 u0Var = (u0) obj;
            v vVar = u0Var.f1374c;
            if (vVar.R == getId() && (view = vVar.f1378a0) != null && view.getParent() == null) {
                vVar.Z = this;
                u0Var.b();
            }
        }
    }
}
