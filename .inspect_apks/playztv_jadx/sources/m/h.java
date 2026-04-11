package m;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h extends BaseAdapter {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final k f8198u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f8199v = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f8200w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f8201x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final LayoutInflater f8202y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f8203z;

    public h(k kVar, LayoutInflater layoutInflater, boolean z2, int i) {
        this.f8201x = z2;
        this.f8202y = layoutInflater;
        this.f8198u = kVar;
        this.f8203z = i;
        a();
    }

    public final void a() {
        k kVar = this.f8198u;
        m mVar = kVar.f8224v;
        if (mVar != null) {
            kVar.i();
            ArrayList arrayList = kVar.f8212j;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((m) arrayList.get(i)) == mVar) {
                    this.f8199v = i;
                    return;
                }
            }
        }
        this.f8199v = -1;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final m getItem(int i) {
        ArrayList arrayListL;
        boolean z2 = this.f8201x;
        k kVar = this.f8198u;
        if (z2) {
            kVar.i();
            arrayListL = kVar.f8212j;
        } else {
            arrayListL = kVar.l();
        }
        int i10 = this.f8199v;
        if (i10 >= 0 && i >= i10) {
            i++;
        }
        return (m) arrayListL.get(i);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList arrayListL;
        boolean z2 = this.f8201x;
        k kVar = this.f8198u;
        if (z2) {
            kVar.i();
            arrayListL = kVar.f8212j;
        } else {
            arrayListL = kVar.l();
        }
        return this.f8199v < 0 ? arrayListL.size() : arrayListL.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean z2 = false;
        if (view == null) {
            view = this.f8202y.inflate(this.f8203z, viewGroup, false);
        }
        int i10 = getItem(i).f8231b;
        int i11 = i - 1;
        int i12 = i11 >= 0 ? getItem(i11).f8231b : i10;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f8198u.m() && i10 != i12) {
            z2 = true;
        }
        listMenuItemView.setGroupDividerEnabled(z2);
        x xVar = (x) view;
        if (this.f8200w) {
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
