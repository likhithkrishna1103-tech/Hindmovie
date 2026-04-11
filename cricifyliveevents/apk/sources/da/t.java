package da;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.internal.NavigationMenuView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements n.w {
    public LayoutInflater A;
    public ColorStateList C;
    public ColorStateList F;
    public ColorStateList G;
    public Drawable H;
    public RippleDrawable I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public boolean R;
    public int T;
    public int U;
    public int V;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public NavigationMenuView f3629v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public LinearLayout f3630w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public n.k f3631x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f3632y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public l f3633z;
    public int B = 0;
    public int D = 0;
    public boolean E = true;
    public boolean S = true;
    public int W = -1;
    public final com.google.android.material.datepicker.l X = new com.google.android.material.datepicker.l(1, this);

    public final void a() {
        l lVar = this.f3633z;
        if (lVar != null) {
            ArrayList arrayList = lVar.f3622d;
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i) instanceof o) {
                    lVar.f13407a.c(i, 1);
                }
            }
        }
    }

    @Override // n.w
    public final void b(Parcelable parcelable) {
        n.m mVar;
        View actionView;
        v vVar;
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f3629v.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                l lVar = this.f3633z;
                ArrayList arrayList = lVar.f3622d;
                int i = bundle2.getInt("android:menu:checked", 0);
                if (i != 0) {
                    lVar.f = true;
                    int size = arrayList.size();
                    int i10 = 0;
                    while (true) {
                        if (i10 >= size) {
                            break;
                        }
                        n nVar = (n) arrayList.get(i10);
                        if (nVar instanceof p) {
                            n.m mVar2 = ((p) nVar).f3627a;
                            if (mVar2.f8544a == i) {
                                lVar.i(mVar2);
                                break;
                            }
                        }
                        i10++;
                    }
                    lVar.f = false;
                    lVar.h();
                }
                SparseArray sparseParcelableArray2 = bundle2.getSparseParcelableArray("android:menu:action_views");
                if (sparseParcelableArray2 != null) {
                    int size2 = arrayList.size();
                    for (int i11 = 0; i11 < size2; i11++) {
                        n nVar2 = (n) arrayList.get(i11);
                        if ((nVar2 instanceof p) && (actionView = (mVar = ((p) nVar2).f3627a).getActionView()) != null && (vVar = (v) sparseParcelableArray2.get(mVar.f8544a)) != null) {
                            actionView.restoreHierarchyState(vVar);
                        }
                    }
                }
            }
            SparseArray<Parcelable> sparseParcelableArray3 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray3 != null) {
                this.f3630w.restoreHierarchyState(sparseParcelableArray3);
            }
        }
    }

    public final void d() {
        l lVar = this.f3633z;
        if (lVar != null) {
            ArrayList arrayList = lVar.f3622d;
            for (int i = 0; i < arrayList.size(); i++) {
                if ((arrayList.get(i) instanceof p) && lVar.c(i) == 1) {
                    lVar.f13407a.c(i, 1);
                }
            }
        }
    }

    @Override // n.w
    public final void e() {
        l lVar = this.f3633z;
        if (lVar != null) {
            ArrayList arrayList = lVar.f3622d;
            int size = arrayList.size();
            lVar.h();
            lVar.d();
            if (size == arrayList.size()) {
                lVar.f13407a.c(0, arrayList.size());
            }
        }
    }

    public final void f() {
        l lVar = this.f3633z;
        if (lVar != null) {
            ArrayList arrayList = lVar.f3622d;
            for (int i = 0; i < arrayList.size(); i++) {
                if ((arrayList.get(i) instanceof p) && lVar.c(i) == 0) {
                    lVar.f13407a.c(i, 1);
                }
            }
        }
    }

    @Override // n.w
    public final boolean g(n.m mVar) {
        return false;
    }

    @Override // n.w
    public final int getId() {
        return this.f3632y;
    }

    @Override // n.w
    public final void h(Context context, n.k kVar) {
        this.A = LayoutInflater.from(context);
        this.f3631x = kVar;
        this.V = context.getResources().getDimensionPixelOffset(k9.d.design_navigation_separator_vertical_padding);
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
        Bundle bundle = new Bundle();
        if (this.f3629v != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f3629v.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        l lVar = this.f3633z;
        if (lVar != null) {
            ArrayList arrayList = lVar.f3622d;
            Bundle bundle2 = new Bundle();
            n.m mVar = lVar.f3623e;
            if (mVar != null) {
                bundle2.putInt("android:menu:checked", mVar.f8544a);
            }
            SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                n nVar = (n) arrayList.get(i);
                if (nVar instanceof p) {
                    n.m mVar2 = ((p) nVar).f3627a;
                    View actionView = mVar2 != null ? mVar2.getActionView() : null;
                    if (actionView != null) {
                        v vVar = new v();
                        actionView.saveHierarchyState(vVar);
                        sparseArray2.put(mVar2.f8544a, vVar);
                    }
                }
            }
            bundle2.putSparseParcelableArray("android:menu:action_views", sparseArray2);
            bundle.putBundle("android:menu:adapter", bundle2);
        }
        if (this.f3630w != null) {
            SparseArray<Parcelable> sparseArray3 = new SparseArray<>();
            this.f3630w.saveHierarchyState(sparseArray3);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray3);
        }
        return bundle;
    }

    @Override // n.w
    public final boolean m(n.m mVar) {
        return false;
    }

    @Override // n.w
    public final void c(n.k kVar, boolean z10) {
    }
}
