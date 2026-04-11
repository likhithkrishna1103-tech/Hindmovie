package nc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.playz.tv.CustomLayoutManager;
import h4.z;
import java.util.ArrayList;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class p extends f {

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public z f8960t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public ic.g f8961u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public ArrayList f8962v0;

    @Override // androidx.fragment.app.v
    public final void D() {
        ((TextView) this.f8960t0.f5867v).setText("No favourite channel found!");
        this.f8929r0 = true;
        Executors.newSingleThreadExecutor().execute(new b(1, this));
    }

    @Override // nc.f
    public final void Q(int i) {
        RecyclerView recyclerView = (RecyclerView) this.f8960t0.f5868w;
        H();
        recyclerView.setLayoutManager(new CustomLayoutManager(i));
    }

    @Override // nc.f
    public final void S(String str) {
        if (this.f8962v0 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f8962v0;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            oc.c cVar = (oc.c) obj;
            String str2 = cVar.f9515a;
            if (str2 != null && str2.toLowerCase().contains(str.toLowerCase())) {
                arrayList.add(cVar);
            }
        }
        if (arrayList.isEmpty()) {
            ((RecyclerView) this.f8960t0.f5868w).setVisibility(8);
            ((TextView) this.f8960t0.f5867v).setVisibility(0);
        } else {
            ((RecyclerView) this.f8960t0.f5868w).setVisibility(0);
            ((TextView) this.f8960t0.f5867v).setVisibility(8);
            this.f8961u0.g(arrayList);
        }
    }

    @Override // androidx.fragment.app.v
    public final View w(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(gc.k.fragment_favourites, (ViewGroup) null, false);
        int i = gc.j.not_available;
        TextView textView = (TextView) z7.a.k(viewInflate, i);
        if (textView != null) {
            i = gc.j.recycler_view;
            RecyclerView recyclerView = (RecyclerView) z7.a.k(viewInflate, i);
            if (recyclerView != null) {
                RelativeLayout relativeLayout = (RelativeLayout) viewInflate;
                this.f8960t0 = new z(relativeLayout, textView, recyclerView);
                return relativeLayout;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
