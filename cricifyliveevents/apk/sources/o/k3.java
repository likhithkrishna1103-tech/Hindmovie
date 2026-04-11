package o;

import android.content.Context;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k3 implements n.w {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public n.k f9256v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public n.m f9257w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Toolbar f9258x;

    public k3(Toolbar toolbar) {
        this.f9258x = toolbar;
    }

    @Override // n.w
    public final void e() {
        if (this.f9257w != null) {
            n.k kVar = this.f9256v;
            if (kVar != null) {
                int size = kVar.f.size();
                for (int i = 0; i < size; i++) {
                    if (this.f9256v.getItem(i) == this.f9257w) {
                        return;
                    }
                }
            }
            m(this.f9257w);
        }
    }

    @Override // n.w
    public final boolean g(n.m mVar) {
        Toolbar toolbar = this.f9258x;
        toolbar.c();
        ViewParent parent = toolbar.C.getParent();
        if (parent != toolbar) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(toolbar.C);
            }
            toolbar.addView(toolbar.C);
        }
        View actionView = mVar.getActionView();
        toolbar.D = actionView;
        this.f9257w = mVar;
        ViewParent parent2 = actionView.getParent();
        if (parent2 != toolbar) {
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(toolbar.D);
            }
            l3 l3VarH = Toolbar.h();
            l3VarH.f9267a = (toolbar.I & 112) | 8388611;
            l3VarH.f9268b = 2;
            toolbar.D.setLayoutParams(l3VarH);
            toolbar.addView(toolbar.D);
        }
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (((l3) childAt.getLayoutParams()).f9268b != 2 && childAt != toolbar.f619v) {
                toolbar.removeViewAt(childCount);
                toolbar.f604c0.add(childAt);
            }
        }
        toolbar.requestLayout();
        mVar.C = true;
        mVar.f8555n.p(false);
        KeyEvent.Callback callback = toolbar.D;
        if (callback instanceof m.b) {
            ((m.b) callback).onActionViewExpanded();
        }
        toolbar.v();
        return true;
    }

    @Override // n.w
    public final int getId() {
        return 0;
    }

    @Override // n.w
    public final void h(Context context, n.k kVar) {
        n.m mVar;
        n.k kVar2 = this.f9256v;
        if (kVar2 != null && (mVar = this.f9257w) != null) {
            kVar2.d(mVar);
        }
        this.f9256v = kVar;
    }

    @Override // n.w
    public final boolean i(n.c0 c0Var) {
        return false;
    }

    @Override // n.w
    public final boolean j() {
        return false;
    }

    @Override // n.w
    public final Parcelable k() {
        return null;
    }

    @Override // n.w
    public final boolean m(n.m mVar) {
        Toolbar toolbar = this.f9258x;
        KeyEvent.Callback callback = toolbar.D;
        if (callback instanceof m.b) {
            ((m.b) callback).onActionViewCollapsed();
        }
        toolbar.removeView(toolbar.D);
        toolbar.removeView(toolbar.C);
        toolbar.D = null;
        ArrayList arrayList = toolbar.f604c0;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            toolbar.addView((View) arrayList.get(size));
        }
        arrayList.clear();
        this.f9257w = null;
        toolbar.requestLayout();
        mVar.C = false;
        mVar.f8555n.p(false);
        toolbar.v();
        return true;
    }

    @Override // n.w
    public final void b(Parcelable parcelable) {
    }

    @Override // n.w
    public final void c(n.k kVar, boolean z10) {
    }
}
