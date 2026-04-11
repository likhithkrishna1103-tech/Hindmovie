package n;

import android.content.Context;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h3 implements m.w {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public m.k f8396u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public m.m f8397v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Toolbar f8398w;

    public h3(Toolbar toolbar) {
        this.f8398w = toolbar;
    }

    @Override // m.w
    public final void f(boolean z2) {
        if (this.f8397v != null) {
            m.k kVar = this.f8396u;
            if (kVar != null) {
                int size = kVar.f.size();
                for (int i = 0; i < size; i++) {
                    if (this.f8396u.getItem(i) == this.f8397v) {
                        return;
                    }
                }
            }
            m(this.f8397v);
        }
    }

    @Override // m.w
    public final boolean g(m.m mVar) {
        Toolbar toolbar = this.f8398w;
        toolbar.c();
        ViewParent parent = toolbar.B.getParent();
        if (parent != toolbar) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(toolbar.B);
            }
            toolbar.addView(toolbar.B);
        }
        View actionView = mVar.getActionView();
        toolbar.C = actionView;
        this.f8397v = mVar;
        ViewParent parent2 = actionView.getParent();
        if (parent2 != toolbar) {
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(toolbar.C);
            }
            i3 i3VarH = Toolbar.h();
            i3VarH.f8411a = (toolbar.H & 112) | 8388611;
            i3VarH.f8412b = 2;
            toolbar.C.setLayoutParams(i3VarH);
            toolbar.addView(toolbar.C);
        }
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (((i3) childAt.getLayoutParams()).f8412b != 2 && childAt != toolbar.f942u) {
                toolbar.removeViewAt(childCount);
                toolbar.f927b0.add(childAt);
            }
        }
        toolbar.requestLayout();
        mVar.C = true;
        mVar.f8241n.p(false);
        KeyEvent.Callback callback = toolbar.C;
        if (callback instanceof l.b) {
            ((l.b) callback).onActionViewExpanded();
        }
        toolbar.w();
        return true;
    }

    @Override // m.w
    public final int getId() {
        return 0;
    }

    @Override // m.w
    public final void h(Context context, m.k kVar) {
        m.m mVar;
        m.k kVar2 = this.f8396u;
        if (kVar2 != null && (mVar = this.f8397v) != null) {
            kVar2.d(mVar);
        }
        this.f8396u = kVar;
    }

    @Override // m.w
    public final boolean i() {
        return false;
    }

    @Override // m.w
    public final Parcelable j() {
        return null;
    }

    @Override // m.w
    public final boolean k(m.c0 c0Var) {
        return false;
    }

    @Override // m.w
    public final boolean m(m.m mVar) {
        Toolbar toolbar = this.f8398w;
        KeyEvent.Callback callback = toolbar.C;
        if (callback instanceof l.b) {
            ((l.b) callback).onActionViewCollapsed();
        }
        toolbar.removeView(toolbar.C);
        toolbar.removeView(toolbar.B);
        toolbar.C = null;
        ArrayList arrayList = toolbar.f927b0;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            toolbar.addView((View) arrayList.get(size));
        }
        arrayList.clear();
        this.f8397v = null;
        toolbar.requestLayout();
        mVar.C = false;
        mVar.f8241n.p(false);
        toolbar.w();
        return true;
    }

    @Override // m.w
    public final void b(Parcelable parcelable) {
    }

    @Override // m.w
    public final void c(m.k kVar, boolean z2) {
    }
}
