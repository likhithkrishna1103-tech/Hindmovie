package ic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.card.MaterialCardView;
import java.util.ArrayList;
import q4.x0;
import q4.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f6494d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final nc.g f6495e;
    public ArrayList f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public nc.m f6496g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f6497h;

    public c(Context context, nc.g gVar, ArrayList arrayList, boolean z2) {
        this.f6494d = context;
        this.f6495e = gVar;
        this.f = new ArrayList(arrayList);
        this.f6497h = z2;
    }

    @Override // q4.z
    public final int a() {
        return this.f.size();
    }

    @Override // q4.z
    public final long b(int i) {
        return i;
    }

    @Override // q4.z
    public final void d(x0 x0Var, int i) {
        b bVar = (b) x0Var;
        oc.b bVar2 = (oc.b) this.f.get(i);
        String str = bVar2.f9511a;
        TextView textView = bVar.f6492v;
        textView.setText(str);
        textView.setSelected(true);
        Context context = this.f6494d;
        x6.f.c(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        ((com.bumptech.glide.k) com.bumptech.glide.b.a(context).f2764y.b(context).r(bVar2.f9512b).o(gc.i.icon)).D(bVar.f6493w);
        bVar.f6491u.setOnClickListener(new a(this, bVar2, str, 0));
    }

    @Override // q4.z
    public final x0 e(ViewGroup viewGroup, int i) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(gc.k.item_category, viewGroup, false);
        b bVar = new b(viewInflate);
        bVar.f6491u = (MaterialCardView) viewInflate.findViewById(gc.j.category_card);
        bVar.f6492v = (TextView) viewInflate.findViewById(gc.j.category_text_view);
        bVar.f6493w = (ImageView) viewInflate.findViewById(gc.j.category_img);
        return bVar;
    }

    @Override // q4.z
    public final int c(int i) {
        return i;
    }
}
