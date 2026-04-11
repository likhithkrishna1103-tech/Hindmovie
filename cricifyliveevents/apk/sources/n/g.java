package n;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import androidx.appcompat.view.menu.ExpandedMenuView;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements w, AdapterView.OnItemClickListener {
    public v A;
    public f B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Context f8508v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public LayoutInflater f8509w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public k f8510x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ExpandedMenuView f8511y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f8512z;

    public g(Context context, int i) {
        this.f8512z = i;
        this.f8508v = context;
        this.f8509w = LayoutInflater.from(context);
    }

    @Override // n.w
    public final void b(Parcelable parcelable) {
        SparseArray<Parcelable> sparseParcelableArray = ((Bundle) parcelable).getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f8511y.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // n.w
    public final void c(k kVar, boolean z10) {
        v vVar = this.A;
        if (vVar != null) {
            vVar.c(kVar, z10);
        }
    }

    @Override // n.w
    public final void e() {
        f fVar = this.B;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // n.w
    public final boolean g(m mVar) {
        return false;
    }

    @Override // n.w
    public final int getId() {
        return 0;
    }

    @Override // n.w
    public final void h(Context context, k kVar) {
        if (this.f8508v != null) {
            this.f8508v = context;
            if (this.f8509w == null) {
                this.f8509w = LayoutInflater.from(context);
            }
        }
        this.f8510x = kVar;
        f fVar = this.B;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // n.w
    public final boolean i(c0 c0Var) {
        boolean zHasVisibleItems = c0Var.hasVisibleItems();
        Context context = c0Var.f8519a;
        if (!zHasVisibleItems) {
            return false;
        }
        l lVar = new l();
        lVar.f8541v = c0Var;
        h.g gVar = new h.g(context);
        g gVar2 = new g(gVar.getContext(), g.g.abc_list_menu_item_layout);
        lVar.f8543x = gVar2;
        gVar2.A = lVar;
        c0Var.b(gVar2, context);
        g gVar3 = lVar.f8543x;
        if (gVar3.B == null) {
            gVar3.B = new f(gVar3);
        }
        f fVar = gVar3.B;
        h.c cVar = gVar.f5346a;
        cVar.f5303p = fVar;
        cVar.f5304q = lVar;
        View view = c0Var.f8531o;
        if (view != null) {
            cVar.f5294e = view;
        } else {
            cVar.f5292c = c0Var.f8530n;
            gVar.setTitle(c0Var.f8529m);
        }
        cVar.f5302o = lVar;
        h.h hVarCreate = gVar.create();
        lVar.f8542w = hVarCreate;
        hVarCreate.setOnDismissListener(lVar);
        WindowManager.LayoutParams attributes = lVar.f8542w.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        lVar.f8542w.show();
        v vVar = this.A;
        if (vVar == null) {
            return true;
        }
        vVar.n(c0Var);
        return true;
    }

    @Override // n.w
    public final boolean j() {
        return false;
    }

    @Override // n.w
    public final Parcelable k() {
        if (this.f8511y == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f8511y;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        return bundle;
    }

    @Override // n.w
    public final void l(v vVar) {
        throw null;
    }

    @Override // n.w
    public final boolean m(m mVar) {
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j4) {
        this.f8510x.q(this.B.getItem(i), this, 0);
    }
}
