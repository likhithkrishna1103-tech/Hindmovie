package s5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import app.cricfy.tv.app.ProApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import v4.x0;
import v4.z;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f11481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ProApplication f11482e = ProApplication.K;
    public final h.j f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList f11483g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public kb.d f11484h;
    public String i;

    public e(h.j jVar, ArrayList arrayList) {
        this.f = jVar;
        this.f11483g = new ArrayList(arrayList);
        this.f11481d = com.bumptech.glide.d.t(jVar).getBoolean("is_tv", false);
    }

    @Override // v4.z
    public final int a() {
        return this.f11483g.size();
    }

    @Override // v4.z
    public final long b(int i) {
        return i;
    }

    @Override // v4.z
    public final void e(x0 x0Var, int i) {
        d dVar = (d) x0Var;
        ImageView imageView = dVar.f11479v;
        final y5.c cVar = (y5.c) this.f11483g.get(i);
        if (cVar.f14914b == null) {
            imageView.setImageResource(q5.j.icon);
        } else {
            h.j jVar = this.f;
            s7.f.c(jVar, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
            ((com.bumptech.glide.n) com.bumptech.glide.b.a(jVar).f2197z.c(jVar).q(cVar.f14914b).o(q5.j.icon)).B(imageView);
        }
        View view = dVar.f11478u;
        view.setOnClickListener(new b(0, this, cVar));
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: s5.c
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                e eVar = this.f11476v;
                h.j jVar2 = eVar.f;
                String str = eVar.i;
                kb.d dVar2 = eVar.f11484h;
                Executors.newSingleThreadExecutor().execute(new c8.a(jVar2, cVar, str, dVar2, 9));
                return true;
            }
        });
        view.setOnFocusChangeListener(new pa.a(2, dVar));
    }

    @Override // v4.z
    public final x0 f(ViewGroup viewGroup, int i) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(q5.l.item_channel, viewGroup, false);
        d dVar = new d(viewInflate);
        dVar.f11478u = viewInflate;
        dVar.f11479v = (ImageView) viewInflate.findViewById(q5.k.channel_img);
        dVar.f11480w = viewInflate.findViewById(q5.k.focused_view);
        return dVar;
    }

    public final void h(List list) {
        this.f11483g = new ArrayList(list);
        d();
    }

    @Override // v4.z
    public final int c(int i) {
        return i;
    }
}
