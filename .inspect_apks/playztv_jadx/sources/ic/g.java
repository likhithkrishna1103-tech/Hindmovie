package ic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c2.w;
import com.google.android.material.card.MaterialCardView;
import com.playz.tv.app.ProApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import q4.x0;
import q4.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f6506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ProApplication f6507e = ProApplication.I;
    public final h.j f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList f6508g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public nc.c f6509h;
    public String i;

    public g(h.j jVar, ArrayList arrayList) {
        this.f = jVar;
        this.f6508g = new ArrayList(arrayList);
        this.f6506d = uc.b.f(jVar).getBoolean("is_tv", false);
    }

    @Override // q4.z
    public final int a() {
        return this.f6508g.size();
    }

    @Override // q4.z
    public final long b(int i) {
        return i;
    }

    @Override // q4.z
    public final void d(x0 x0Var, int i) {
        f fVar = (f) x0Var;
        final oc.c cVar = (oc.c) this.f6508g.get(i);
        TextView textView = fVar.f6504v;
        MaterialCardView materialCardView = fVar.f6503u;
        ImageView imageView = fVar.f6505w;
        textView.setText(cVar.f9515a);
        textView.setSelected(true);
        if (cVar.f9516b == null) {
            imageView.setImageResource(gc.i.icon);
        } else {
            h.j jVar = this.f;
            x6.f.c(jVar, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
            ((com.bumptech.glide.k) com.bumptech.glide.b.a(jVar).f2764y.c(jVar).r(cVar.f9516b).o(gc.i.icon)).D(imageView);
        }
        materialCardView.setOnClickListener(new d(this, 0, cVar));
        materialCardView.setOnLongClickListener(new View.OnLongClickListener() { // from class: ic.e
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                g gVar = this.f6501u;
                h.j jVar2 = gVar.f;
                String str = gVar.i;
                nc.c cVar2 = gVar.f6509h;
                Executors.newSingleThreadExecutor().execute(new w(jVar2, cVar, str, cVar2, 8));
                return true;
            }
        });
    }

    @Override // q4.z
    public final x0 e(ViewGroup viewGroup, int i) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(gc.k.item_channel, viewGroup, false);
        f fVar = new f(viewInflate);
        fVar.f6503u = (MaterialCardView) viewInflate.findViewById(gc.j.channel_card);
        fVar.f6504v = (TextView) viewInflate.findViewById(gc.j.channel_text_view);
        fVar.f6505w = (ImageView) viewInflate.findViewById(gc.j.channel_img);
        return fVar;
    }

    public final void g(List list) {
        this.f6508g = new ArrayList(list);
        this.f10982a.b();
    }

    @Override // q4.z
    public final int c(int i) {
        return i;
    }
}
