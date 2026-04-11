package m;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import androidx.appcompat.view.menu.ExpandedMenuView;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g implements w, AdapterView.OnItemClickListener {
    public f A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Context f8192u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public LayoutInflater f8193v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public k f8194w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ExpandedMenuView f8195x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f8196y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public v f8197z;

    public g(Context context, int i) {
        this.f8196y = i;
        this.f8192u = context;
        this.f8193v = LayoutInflater.from(context);
    }

    @Override // m.w
    public final void b(Parcelable parcelable) {
        SparseArray<Parcelable> sparseParcelableArray = ((Bundle) parcelable).getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f8195x.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // m.w
    public final void c(k kVar, boolean z2) {
        v vVar = this.f8197z;
        if (vVar != null) {
            vVar.c(kVar, z2);
        }
    }

    @Override // m.w
    public final void f(boolean z2) {
        f fVar = this.A;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // m.w
    public final boolean g(m mVar) {
        return false;
    }

    @Override // m.w
    public final int getId() {
        return 0;
    }

    @Override // m.w
    public final void h(Context context, k kVar) {
        if (this.f8192u != null) {
            this.f8192u = context;
            if (this.f8193v == null) {
                this.f8193v = LayoutInflater.from(context);
            }
        }
        this.f8194w = kVar;
        f fVar = this.A;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // m.w
    public final boolean i() {
        return false;
    }

    @Override // m.w
    public final Parcelable j() {
        if (this.f8195x == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f8195x;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        return bundle;
    }

    @Override // m.w
    public final boolean k(c0 c0Var) {
        boolean zHasVisibleItems = c0Var.hasVisibleItems();
        Context context = c0Var.f8205a;
        if (!zHasVisibleItems) {
            return false;
        }
        l lVar = new l();
        lVar.f8227u = c0Var;
        h.f fVar = new h.f(context);
        g gVar = new g(fVar.getContext(), g.g.abc_list_menu_item_layout);
        lVar.f8229w = gVar;
        gVar.f8197z = lVar;
        c0Var.b(gVar, context);
        g gVar2 = lVar.f8229w;
        if (gVar2.A == null) {
            gVar2.A = new f(gVar2);
        }
        f fVar2 = gVar2.A;
        h.c cVar = fVar.f5489a;
        cVar.f5453p = fVar2;
        cVar.f5454q = lVar;
        View view = c0Var.f8217o;
        if (view != null) {
            cVar.f5444e = view;
        } else {
            cVar.f5442c = c0Var.f8216n;
            fVar.setTitle(c0Var.f8215m);
        }
        cVar.f5452o = lVar;
        h.g gVarCreate = fVar.create();
        lVar.f8228v = gVarCreate;
        gVarCreate.setOnDismissListener(lVar);
        WindowManager.LayoutParams attributes = lVar.f8228v.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        lVar.f8228v.show();
        v vVar = this.f8197z;
        if (vVar == null) {
            return true;
        }
        vVar.x(c0Var);
        return true;
    }

    @Override // m.w
    public final void l(v vVar) {
        throw null;
    }

    @Override // m.w
    public final boolean m(m mVar) {
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j5) {
        this.f8194w.q(this.A.getItem(i), this, 0);
    }
}
