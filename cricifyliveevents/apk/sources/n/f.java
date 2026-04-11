package n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends BaseAdapter {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f8506v = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ g f8507w;

    public f(g gVar) {
        this.f8507w = gVar;
        a();
    }

    public final void a() {
        k kVar = this.f8507w.f8510x;
        m mVar = kVar.f8538v;
        if (mVar != null) {
            kVar.i();
            ArrayList arrayList = kVar.f8526j;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((m) arrayList.get(i)) == mVar) {
                    this.f8506v = i;
                    return;
                }
            }
        }
        this.f8506v = -1;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final m getItem(int i) {
        g gVar = this.f8507w;
        k kVar = gVar.f8510x;
        kVar.i();
        ArrayList arrayList = kVar.f8526j;
        gVar.getClass();
        int i10 = this.f8506v;
        if (i10 >= 0 && i >= i10) {
            i++;
        }
        return (m) arrayList.get(i);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        g gVar = this.f8507w;
        k kVar = gVar.f8510x;
        kVar.i();
        int size = kVar.f8526j.size();
        gVar.getClass();
        return this.f8506v < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            g gVar = this.f8507w;
            view = gVar.f8509w.inflate(gVar.f8512z, viewGroup, false);
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
