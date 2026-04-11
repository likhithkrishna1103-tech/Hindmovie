package m4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.card.MaterialCardView;
import java.util.ArrayList;
import v4.x0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends v4.z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f8183d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f8184e;
    public final Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f8185g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f8186h;

    public l(Context context, ArrayList arrayList, x5.j jVar) {
        this.f8184e = context;
        this.f8185g = new ArrayList(arrayList);
        this.f = jVar;
    }

    @Override // v4.z
    public final int a() {
        switch (this.f8183d) {
        }
        return ((ArrayList) this.f8185g).size();
    }

    @Override // v4.z
    public final long b(int i) {
        switch (this.f8183d) {
        }
        return i;
    }

    @Override // v4.z
    public int c(int i) {
        switch (this.f8183d) {
            case 1:
            case 2:
                return i;
            default:
                return super.c(i);
        }
    }

    @Override // v4.z
    public final void e(x0 x0Var, int i) {
        switch (this.f8183d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                k kVar = (k) x0Var;
                View view = kVar.f13387a;
                if (h(i)) {
                    view.setLayoutParams(new v4.i0(-1, -2));
                } else {
                    view.setLayoutParams(new v4.i0(0, 0));
                }
                TextView textView = kVar.f8179u;
                ImageView imageView = kVar.f8181w;
                TextView textView2 = kVar.f8180v;
                textView.setText(((String[]) this.f8184e)[i]);
                String str = ((String[]) this.f)[i];
                if (str == null) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(str);
                }
                Drawable drawable = ((Drawable[]) this.f8185g)[i];
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                } else {
                    imageView.setVisibility(8);
                }
                break;
            case 1:
                s5.a aVar = (s5.a) x0Var;
                y5.b bVar = (y5.b) ((ArrayList) this.f8185g).get(i);
                String str2 = bVar.f14909a;
                TextView textView3 = aVar.f11471v;
                textView3.setText(str2);
                textView3.setSelected(true);
                ((com.bumptech.glide.n) com.bumptech.glide.b.d((Context) this.f8184e).q(bVar.f14910b).o(q5.j.icon)).B(aVar.f11472w);
                aVar.f11470u.setOnClickListener(new d6.b(this, bVar, str2, 1));
                break;
            default:
                s5.j jVar = (s5.j) x0Var;
                MaterialCardView materialCardView = jVar.f11503u;
                if (((s5.j) this.f8186h) == null && i == 0) {
                    materialCardView.setSelected(true);
                    this.f8186h = jVar;
                }
                y5.d dVar = (y5.d) ((ArrayList) this.f8185g).get(i);
                TextView textView4 = jVar.f11505w;
                ImageView imageView2 = jVar.f11504v;
                textView4.setText(String.valueOf(dVar.f14920c));
                if (dVar.f14918a.equalsIgnoreCase("All")) {
                    imageView2.setImageResource(q5.j.ic_all);
                } else {
                    ((com.bumptech.glide.n) com.bumptech.glide.b.d((Context) this.f8184e).q(dVar.f14919b).o(q5.j.icon)).B(imageView2);
                }
                materialCardView.setOnClickListener(new d6.b(this, jVar, dVar, 2));
                break;
        }
    }

    @Override // v4.z
    public final x0 f(ViewGroup viewGroup, int i) {
        switch (this.f8183d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                q qVar = (q) this.f8186h;
                return new k(qVar, LayoutInflater.from(qVar.getContext()).inflate(h0.exo_styled_settings_list_item, viewGroup, false));
            case 1:
                View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(q5.l.item_category, viewGroup, false);
                s5.a aVar = new s5.a(viewInflate);
                aVar.f11470u = (MaterialCardView) viewInflate.findViewById(q5.k.category_card);
                aVar.f11471v = (TextView) viewInflate.findViewById(q5.k.cat_name);
                aVar.f11472w = (ImageView) viewInflate.findViewById(q5.k.cat_image);
                return aVar;
            default:
                View viewInflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(q5.l.item_event_home, viewGroup, false);
                s5.j jVar = new s5.j(viewInflate2);
                jVar.f11503u = (MaterialCardView) viewInflate2.findViewById(q5.k.card);
                jVar.f11504v = (ImageView) viewInflate2.findViewById(q5.k.event_cat_image);
                jVar.f11505w = (TextView) viewInflate2.findViewById(q5.k.cat_item_count);
                return jVar;
        }
    }

    public boolean h(int i) {
        q qVar = (q) this.f8186h;
        v1.w0 w0Var = qVar.C0;
        if (w0Var == null) {
            return false;
        }
        if (i == 0) {
            return w0Var.Z(13);
        }
        if (i != 1) {
            return true;
        }
        return w0Var.Z(30) && qVar.C0.Z(29);
    }

    public l(Context context, x5.d dVar, ArrayList arrayList) {
        this.f8184e = context;
        this.f = dVar;
        this.f8185g = new ArrayList(arrayList);
    }

    public l(q qVar, String[] strArr, Drawable[] drawableArr) {
        this.f8186h = qVar;
        this.f8184e = strArr;
        this.f = new String[strArr.length];
        this.f8185g = drawableArr;
    }
}
