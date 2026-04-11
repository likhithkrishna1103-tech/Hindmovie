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
import t0.p1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f904v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList f905w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View.OnApplyWindowInsetsListener f906x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f907y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context) {
        super(context);
        ge.i.e(context, "context");
        this.f904v = new ArrayList();
        this.f905w = new ArrayList();
        this.f907y = true;
    }

    public final void a(View view) {
        if (this.f905w.contains(view)) {
            this.f904v.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        ge.i.e(view, "child");
        Object tag = view.getTag(o1.b.fragment_container_view_tag);
        if ((tag instanceof y ? (y) tag : null) != null) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        p1 p1VarI;
        ge.i.e(windowInsets, "insets");
        p1 p1VarH = p1.h(null, windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f906x;
        if (onApplyWindowInsetsListener != null) {
            ge.i.b(onApplyWindowInsetsListener);
            WindowInsets windowInsetsOnApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets);
            ge.i.d(windowInsetsOnApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            p1VarI = p1.h(null, windowInsetsOnApplyWindowInsets);
        } else {
            p1VarI = t0.m0.i(this, p1VarH);
        }
        ge.i.d(p1VarI, "if (applyWindowInsetsLis…, insetsCompat)\n        }");
        if (!p1VarI.f11791a.n()) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                t0.m0.b(getChildAt(i), p1VarI);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        ge.i.e(canvas, "canvas");
        if (this.f907y) {
            ArrayList arrayList = this.f904v;
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
    public final boolean drawChild(Canvas canvas, View view, long j4) {
        ge.i.e(canvas, "canvas");
        ge.i.e(view, "child");
        if (this.f907y) {
            ArrayList arrayList = this.f904v;
            if (!arrayList.isEmpty() && arrayList.contains(view)) {
                return false;
            }
        }
        return super.drawChild(canvas, view, j4);
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        ge.i.e(view, "view");
        this.f905w.remove(view);
        if (this.f904v.remove(view)) {
            this.f907y = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends y> F getFragment() {
        h.j jVar;
        y yVar;
        r0 r0VarO;
        View view = this;
        while (true) {
            jVar = null;
            if (view == null) {
                yVar = null;
                break;
            }
            Object tag = view.getTag(o1.b.fragment_container_view_tag);
            yVar = tag instanceof y ? (y) tag : null;
            if (yVar != null) {
                break;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        if (yVar == null) {
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
            r0VarO = jVar.o();
        } else {
            if (!yVar.p()) {
                throw new IllegalStateException("The Fragment " + yVar + " that owns View " + this + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
            }
            r0VarO = yVar.i();
        }
        return (F) r0VarO.D(getId());
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        ge.i.e(windowInsets, "insets");
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
                ge.i.d(childAt, "view");
                a(childAt);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        ge.i.e(view, "view");
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i) {
        View childAt = getChildAt(i);
        ge.i.d(childAt, "view");
        a(childAt);
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        ge.i.e(view, "view");
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int i, int i10) {
        int i11 = i + i10;
        for (int i12 = i; i12 < i11; i12++) {
            View childAt = getChildAt(i12);
            ge.i.d(childAt, "view");
            a(childAt);
        }
        super.removeViews(i, i10);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int i, int i10) {
        int i11 = i + i10;
        for (int i12 = i; i12 < i11; i12++) {
            View childAt = getChildAt(i12);
            ge.i.d(childAt, "view");
            a(childAt);
        }
        super.removeViewsInLayout(i, i10);
    }

    public final void setDrawDisappearingViewsLast(boolean z10) {
        this.f907y = z10;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        ge.i.e(onApplyWindowInsetsListener, "listener");
        this.f906x = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        ge.i.e(view, "view");
        if (view.getParent() == this) {
            this.f905w.add(view);
        }
        super.startViewTransition(view);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        String str;
        super(context, attributeSet, 0);
        ge.i.e(context, "context");
        this.f904v = new ArrayList();
        this.f905w = new ArrayList();
        this.f907y = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            int[] iArr = o1.c.FragmentContainerView;
            ge.i.d(iArr, "FragmentContainerView");
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
            if (classAttribute == null) {
                classAttribute = typedArrayObtainStyledAttributes.getString(o1.c.FragmentContainerView_android_name);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet, r0 r0Var) {
        View view;
        super(context, attributeSet);
        ge.i.e(context, "context");
        ge.i.e(attributeSet, "attrs");
        this.f904v = new ArrayList();
        this.f905w = new ArrayList();
        this.f907y = true;
        String classAttribute = attributeSet.getClassAttribute();
        int[] iArr = o1.c.FragmentContainerView;
        ge.i.d(iArr, "FragmentContainerView");
        int i = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        classAttribute = classAttribute == null ? typedArrayObtainStyledAttributes.getString(o1.c.FragmentContainerView_android_name) : classAttribute;
        String string = typedArrayObtainStyledAttributes.getString(o1.c.FragmentContainerView_android_tag);
        typedArrayObtainStyledAttributes.recycle();
        int id2 = getId();
        y yVarD = r0Var.D(id2);
        if (classAttribute != null && yVarD == null) {
            if (id2 == -1) {
                throw new IllegalStateException(l0.e.k("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? " with tag ".concat(string) : ""));
            }
            k0 k0VarG = r0Var.G();
            context.getClassLoader();
            y yVarA = k0VarG.a(classAttribute);
            ge.i.d(yVarA, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            yVarA.B(context, attributeSet, null);
            a aVar = new a(r0Var);
            aVar.f924p = true;
            yVarA.f1102a0 = this;
            aVar.f(getId(), yVarA, string, 1);
            if (!aVar.f916g) {
                aVar.f917h = false;
                aVar.f925q.B(aVar, true);
            } else {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
        }
        ArrayList arrayListM = r0Var.f1046c.m();
        int size = arrayListM.size();
        while (i < size) {
            Object obj = arrayListM.get(i);
            i++;
            z0 z0Var = (z0) obj;
            y yVar = z0Var.f1129c;
            if (yVar.S == getId() && (view = yVar.f1103b0) != null && view.getParent() == null) {
                yVar.f1102a0 = this;
                z0Var.b();
            }
        }
    }
}
