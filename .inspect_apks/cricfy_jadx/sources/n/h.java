package n;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends BaseAdapter {
    public final int A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final k f8513v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f8514w = -1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f8515x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f8516y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final LayoutInflater f8517z;

    public h(k kVar, LayoutInflater layoutInflater, boolean z10, int i) {
        this.f8516y = z10;
        this.f8517z = layoutInflater;
        this.f8513v = kVar;
        this.A = i;
        a();
    }

    public final void a() {
        k kVar = this.f8513v;
        m mVar = kVar.f8538v;
        if (mVar != null) {
            kVar.i();
            ArrayList arrayList = kVar.f8526j;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((m) arrayList.get(i)) == mVar) {
                    this.f8514w = i;
                    return;
                }
            }
        }
        this.f8514w = -1;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final m getItem(int i) {
        ArrayList arrayListL;
        boolean z10 = this.f8516y;
        k kVar = this.f8513v;
        if (z10) {
            kVar.i();
            arrayListL = kVar.f8526j;
        } else {
            arrayListL = kVar.l();
        }
        int i10 = this.f8514w;
        if (i10 >= 0 && i >= i10) {
            i++;
        }
        return (m) arrayListL.get(i);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList arrayListL;
        boolean z10 = this.f8516y;
        k kVar = this.f8513v;
        if (z10) {
            kVar.i();
            arrayListL = kVar.f8526j;
        } else {
            arrayListL = kVar.l();
        }
        return this.f8514w < 0 ? arrayListL.size() : arrayListL.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean z10 = false;
        if (view == null) {
            view = this.f8517z.inflate(this.A, viewGroup, false);
        }
        int i10 = getItem(i).f8545b;
        int i11 = i - 1;
        int i12 = i11 >= 0 ? getItem(i11).f8545b : i10;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f8513v.m() && i10 != i12) {
            z10 = true;
        }
        listMenuItemView.setGroupDividerEnabled(z10);
        x xVar = (x) view;
        if (this.f8515x) {
            listMenuItemView.setForceShowIcon(true);
        }
        xVar.a(getItem(i));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
