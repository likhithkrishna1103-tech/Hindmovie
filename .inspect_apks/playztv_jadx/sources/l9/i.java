package l9;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.MenuItem;
import g5.t;
import j9.v;
import m.c0;
import m.w;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i implements w {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public v8.b f8050u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f8051v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f8052w;

    @Override // m.w
    public final void b(Parcelable parcelable) {
        if (parcelable instanceof h) {
            v8.b bVar = this.f8050u;
            h hVar = (h) parcelable;
            int i = hVar.f8048u;
            int size = bVar.f8041b0.f.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    break;
                }
                MenuItem item = bVar.f8041b0.getItem(i10);
                if (i == item.getItemId()) {
                    bVar.A = i;
                    bVar.B = i10;
                    item.setChecked(true);
                    break;
                }
                i10++;
            }
            Context context = this.f8050u.getContext();
            v vVar = hVar.f8049v;
            SparseArray sparseArray = new SparseArray(vVar.size());
            for (int i11 = 0; i11 < vVar.size(); i11++) {
                int iKeyAt = vVar.keyAt(i11);
                s8.b bVar2 = (s8.b) vVar.valueAt(i11);
                sparseArray.put(iKeyAt, bVar2 != null ? new s8.a(context, bVar2) : null);
            }
            v8.b bVar3 = this.f8050u;
            SparseArray sparseArray2 = bVar3.M;
            for (int i12 = 0; i12 < sparseArray.size(); i12++) {
                int iKeyAt2 = sparseArray.keyAt(i12);
                if (sparseArray2.indexOfKey(iKeyAt2) < 0) {
                    sparseArray2.append(iKeyAt2, (s8.a) sparseArray.get(iKeyAt2));
                }
            }
            e[] eVarArr = bVar3.f8047z;
            if (eVarArr != null) {
                for (e eVar : eVarArr) {
                    s8.a aVar = (s8.a) sparseArray2.get(eVar.getId());
                    if (aVar != null) {
                        eVar.setBadge(aVar);
                    }
                }
            }
        }
    }

    @Override // m.w
    public final void f(boolean z2) {
        g5.a aVar;
        if (this.f8051v) {
            return;
        }
        if (z2) {
            this.f8050u.a();
            return;
        }
        v8.b bVar = this.f8050u;
        m.k kVar = bVar.f8041b0;
        if (kVar == null || bVar.f8047z == null) {
            return;
        }
        int size = kVar.f.size();
        if (size != bVar.f8047z.length) {
            bVar.a();
            return;
        }
        int i = bVar.A;
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = bVar.f8041b0.getItem(i10);
            if (item.isChecked()) {
                bVar.A = item.getItemId();
                bVar.B = i10;
            }
        }
        if (i != bVar.A && (aVar = bVar.f8042u) != null) {
            t.a(bVar, aVar);
        }
        int i11 = bVar.f8046y;
        boolean z10 = i11 != -1 ? i11 == 0 : bVar.f8041b0.l().size() > 3;
        for (int i12 = 0; i12 < size; i12++) {
            bVar.f8040a0.f8051v = true;
            bVar.f8047z[i12].setLabelVisibilityMode(bVar.f8046y);
            bVar.f8047z[i12].setShifting(z10);
            bVar.f8047z[i12].a((m.m) bVar.f8041b0.getItem(i12));
            bVar.f8040a0.f8051v = false;
        }
    }

    @Override // m.w
    public final boolean g(m.m mVar) {
        return false;
    }

    @Override // m.w
    public final int getId() {
        return this.f8052w;
    }

    @Override // m.w
    public final void h(Context context, m.k kVar) {
        this.f8050u.f8041b0 = kVar;
    }

    @Override // m.w
    public final boolean i() {
        return false;
    }

    @Override // m.w
    public final Parcelable j() {
        h hVar = new h();
        hVar.f8048u = this.f8050u.getSelectedItemId();
        SparseArray<s8.a> badgeDrawables = this.f8050u.getBadgeDrawables();
        v vVar = new v();
        for (int i = 0; i < badgeDrawables.size(); i++) {
            int iKeyAt = badgeDrawables.keyAt(i);
            s8.a aVarValueAt = badgeDrawables.valueAt(i);
            vVar.put(iKeyAt, aVarValueAt != null ? aVarValueAt.f11916y.f11924a : null);
        }
        hVar.f8049v = vVar;
        return hVar;
    }

    @Override // m.w
    public final boolean k(c0 c0Var) {
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
