package m;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends BaseAdapter {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f8190u = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ g f8191v;

    public f(g gVar) {
        this.f8191v = gVar;
        a();
    }

    public final void a() {
        k kVar = this.f8191v.f8194w;
        m mVar = kVar.f8224v;
        if (mVar != null) {
            kVar.i();
            ArrayList arrayList = kVar.f8212j;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((m) arrayList.get(i)) == mVar) {
                    this.f8190u = i;
                    return;
                }
            }
        }
        this.f8190u = -1;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final m getItem(int i) {
        g gVar = this.f8191v;
        k kVar = gVar.f8194w;
        kVar.i();
        ArrayList arrayList = kVar.f8212j;
        gVar.getClass();
        int i10 = this.f8190u;
        if (i10 >= 0 && i >= i10) {
            i++;
        }
        return (m) arrayList.get(i);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        g gVar = this.f8191v;
        k kVar = gVar.f8194w;
        kVar.i();
        int size = kVar.f8212j.size();
        gVar.getClass();
        return this.f8190u < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            g gVar = this.f8191v;
            view = gVar.f8193v.inflate(gVar.f8196y, viewGroup, false);
        }
        ((x) view).a(getItem(i));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
