package j9;

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

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t implements m.w {
    public ColorStateList B;
    public ColorStateList E;
    public ColorStateList F;
    public Drawable G;
    public RippleDrawable H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public boolean Q;
    public int S;
    public int T;
    public int U;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public NavigationMenuView f6901u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public LinearLayout f6902v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public m.k f6903w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f6904x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public l f6905y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public LayoutInflater f6906z;
    public int A = 0;
    public int C = 0;
    public boolean D = true;
    public boolean R = true;
    public int V = -1;
    public final com.google.android.material.datepicker.l W = new com.google.android.material.datepicker.l(4, this);

    @Override // m.w
    public final void b(Parcelable parcelable) {
        m.m mVar;
        View actionView;
        v vVar;
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f6901u.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                l lVar = this.f6905y;
                ArrayList arrayList = lVar.f6894d;
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
                            m.m mVar2 = ((p) nVar).f6899a;
                            if (mVar2.f8230a == i) {
                                lVar.h(mVar2);
                                break;
                            }
                        }
                        i10++;
                    }
                    lVar.f = false;
                    lVar.g();
                }
                SparseArray sparseParcelableArray2 = bundle2.getSparseParcelableArray("android:menu:action_views");
                if (sparseParcelableArray2 != null) {
                    int size2 = arrayList.size();
                    for (int i11 = 0; i11 < size2; i11++) {
                        n nVar2 = (n) arrayList.get(i11);
                        if ((nVar2 instanceof p) && (actionView = (mVar = ((p) nVar2).f6899a).getActionView()) != null && (vVar = (v) sparseParcelableArray2.get(mVar.f8230a)) != null) {
                            actionView.restoreHierarchyState(vVar);
                        }
                    }
                }
            }
            SparseArray<Parcelable> sparseParcelableArray3 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray3 != null) {
                this.f6902v.restoreHierarchyState(sparseParcelableArray3);
            }
        }
    }

    @Override // m.w
    public final void f(boolean z2) {
        l lVar = this.f6905y;
        if (lVar != null) {
            lVar.g();
            lVar.f10982a.b();
        }
    }

    @Override // m.w
    public final boolean g(m.m mVar) {
        return false;
    }

    @Override // m.w
    public final int getId() {
        return this.f6904x;
    }

    @Override // m.w
    public final void h(Context context, m.k kVar) {
        this.f6906z = LayoutInflater.from(context);
        this.f6903w = kVar;
        this.U = context.getResources().getDimensionPixelOffset(p8.d.design_navigation_separator_vertical_padding);
    }

    @Override // m.w
    public final boolean i() {
        return false;
    }

    @Override // m.w
    public final Parcelable j() {
        Bundle bundle = new Bundle();
        if (this.f6901u != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f6901u.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        l lVar = this.f6905y;
        if (lVar != null) {
            ArrayList arrayList = lVar.f6894d;
            Bundle bundle2 = new Bundle();
            m.m mVar = lVar.f6895e;
            if (mVar != null) {
                bundle2.putInt("android:menu:checked", mVar.f8230a);
            }
            SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                n nVar = (n) arrayList.get(i);
                if (nVar instanceof p) {
                    m.m mVar2 = ((p) nVar).f6899a;
                    View actionView = mVar2 != null ? mVar2.getActionView() : null;
                    if (actionView != null) {
                        v vVar = new v();
                        actionView.saveHierarchyState(vVar);
                        sparseArray2.put(mVar2.f8230a, vVar);
                    }
                }
            }
            bundle2.putSparseParcelableArray("android:menu:action_views", sparseArray2);
            bundle.putBundle("android:menu:adapter", bundle2);
        }
        if (this.f6902v != null) {
            SparseArray<Parcelable> sparseArray3 = new SparseArray<>();
            this.f6902v.saveHierarchyState(sparseArray3);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray3);
        }
        return bundle;
    }

    @Override // m.w
    public final boolean k(m.c0 c0Var) {
        return false;
    }

    @Override // m.w
    public final boolean m(m.m mVar) {
        return false;
    }

    @Override // m.w
    public final void c(m.k kVar, boolean z2) {
    }
}
