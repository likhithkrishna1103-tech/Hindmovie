package i4;

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

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n extends q4.z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f6236d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f6237e;
    public final Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f6238g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f6239h;

    public n(Context context, ArrayList arrayList, nc.n nVar) {
        this.f6237e = context;
        this.f6238g = new ArrayList(arrayList);
        this.f = nVar;
    }

    @Override // q4.z
    public final int a() {
        switch (this.f6236d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((String[]) this.f6237e).length;
            default:
                return ((ArrayList) this.f6238g).size();
        }
    }

    @Override // q4.z
    public final long b(int i) {
        switch (this.f6236d) {
        }
        return i;
    }

    @Override // q4.z
    public int c(int i) {
        switch (this.f6236d) {
            case 1:
                return i;
            default:
                return super.c(i);
        }
    }

    @Override // q4.z
    public final void d(q4.x0 x0Var, int i) {
        switch (this.f6236d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                m mVar = (m) x0Var;
                View view = mVar.f10962a;
                if (g(i)) {
                    view.setLayoutParams(new q4.i0(-1, -2));
                } else {
                    view.setLayoutParams(new q4.i0(0, 0));
                }
                TextView textView = mVar.f6232u;
                ImageView imageView = mVar.f6234w;
                TextView textView2 = mVar.f6233v;
                textView.setText(((String[]) this.f6237e)[i]);
                String str = ((String[]) this.f)[i];
                if (str == null) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(str);
                }
                Drawable drawable = ((Drawable[]) this.f6238g)[i];
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                } else {
                    imageView.setVisibility(8);
                }
                break;
            default:
                ic.l lVar = (ic.l) x0Var;
                TextView textView3 = lVar.f6530w;
                MaterialCardView materialCardView = lVar.f6528u;
                Context context = (Context) this.f6237e;
                if (((ic.l) this.f6239h) == null && i == 0) {
                    materialCardView.setStrokeColor(context.getColor(gc.h.app_color));
                    this.f6239h = lVar;
                }
                oc.d dVar = (oc.d) ((ArrayList) this.f6238g).get(i);
                ImageView imageView2 = lVar.f6529v;
                textView3.setText(dVar.f9521a);
                textView3.setSelected(true);
                lVar.f6531x.setText(String.valueOf(dVar.f9523c));
                if (dVar.f9521a.equalsIgnoreCase("All")) {
                    imageView2.setImageResource(gc.i.ic_all);
                } else {
                    x6.f.c(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
                    ((com.bumptech.glide.k) com.bumptech.glide.b.a(context).f2764y.b(context).r(dVar.f9522b).o(gc.i.icon)).D(imageView2);
                }
                materialCardView.setOnClickListener(new ic.a(this, lVar, dVar, 1));
                break;
        }
    }

    @Override // q4.z
    public final q4.x0 e(ViewGroup viewGroup, int i) {
        switch (this.f6236d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                s sVar = (s) this.f6239h;
                return new m(sVar, LayoutInflater.from(sVar.getContext()).inflate(j0.exo_styled_settings_list_item, viewGroup, false));
            default:
                View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(gc.k.item_event_home, viewGroup, false);
                ic.l lVar = new ic.l(viewInflate);
                lVar.f6528u = (MaterialCardView) viewInflate.findViewById(gc.j.card);
                lVar.f6529v = (ImageView) viewInflate.findViewById(gc.j.image);
                lVar.f6530w = (TextView) viewInflate.findViewById(gc.j.txtSportName);
                lVar.f6531x = (TextView) viewInflate.findViewById(gc.j.txtEventCount);
                return lVar;
        }
    }

    public boolean g(int i) {
        s sVar = (s) this.f6239h;
        p1.w0 w0Var = sVar.B0;
        if (w0Var == null) {
            return false;
        }
        if (i == 0) {
            return w0Var.e0(13);
        }
        if (i != 1) {
            return true;
        }
        return w0Var.e0(30) && sVar.B0.e0(29);
    }

    public n(s sVar, String[] strArr, Drawable[] drawableArr) {
        this.f6239h = sVar;
        this.f6237e = strArr;
        this.f = new String[strArr.length];
        this.f6238g = drawableArr;
    }
}
