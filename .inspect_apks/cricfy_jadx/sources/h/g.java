package h;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f5346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5347b;

    public g(Context context) {
        this(context, h.h(context, 0));
    }

    public g a(String str) {
        this.f5346a.f = str;
        return this;
    }

    public g b(String str) {
        c cVar = this.f5346a;
        cVar.i = str;
        cVar.f5297j = null;
        return this;
    }

    public g c(String str, DialogInterface.OnClickListener onClickListener) {
        c cVar = this.f5346a;
        cVar.f5295g = str;
        cVar.f5296h = onClickListener;
        return this;
    }

    public h create() {
        c cVar = this.f5346a;
        h hVar = new h(cVar.f5290a, this.f5347b);
        View view = cVar.f5294e;
        f fVar = hVar.B;
        if (view != null) {
            fVar.f5342w = view;
        } else {
            CharSequence charSequence = cVar.f5293d;
            if (charSequence != null) {
                fVar.f5325d = charSequence;
                TextView textView = fVar.f5340u;
                if (textView != null) {
                    textView.setText(charSequence);
                }
            }
            Drawable drawable = cVar.f5292c;
            if (drawable != null) {
                fVar.f5338s = drawable;
                ImageView imageView = fVar.f5339t;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    fVar.f5339t.setImageDrawable(drawable);
                }
            }
        }
        String str = cVar.f;
        if (str != null) {
            fVar.f5326e = str;
            TextView textView2 = fVar.f5341v;
            if (textView2 != null) {
                textView2.setText(str);
            }
        }
        CharSequence charSequence2 = cVar.f5295g;
        if (charSequence2 != null) {
            fVar.c(-1, charSequence2, cVar.f5296h);
        }
        CharSequence charSequence3 = cVar.i;
        if (charSequence3 != null) {
            fVar.c(-2, charSequence3, cVar.f5297j);
        }
        String str2 = cVar.f5298k;
        if (str2 != null) {
            fVar.c(-3, str2, cVar.f5299l);
        }
        if (cVar.f5303p != null) {
            AlertController$RecycleListView alertController$RecycleListView = (AlertController$RecycleListView) cVar.f5291b.inflate(fVar.A, (ViewGroup) null);
            int i = cVar.f5306s ? fVar.B : fVar.C;
            ListAdapter eVar = cVar.f5303p;
            if (eVar == null) {
                eVar = new e(cVar.f5290a, i, R.id.text1, null);
            }
            fVar.f5343x = eVar;
            fVar.f5344y = cVar.f5307t;
            if (cVar.f5304q != null) {
                alertController$RecycleListView.setOnItemClickListener(new b(cVar, fVar));
            }
            if (cVar.f5306s) {
                alertController$RecycleListView.setChoiceMode(1);
            }
            fVar.f = alertController$RecycleListView;
        }
        View view2 = cVar.f5305r;
        if (view2 != null) {
            fVar.f5327g = view2;
            fVar.f5328h = false;
        }
        hVar.setCancelable(cVar.f5300m);
        if (cVar.f5300m) {
            hVar.setCanceledOnTouchOutside(true);
        }
        hVar.setOnCancelListener(null);
        hVar.setOnDismissListener(cVar.f5301n);
        n.l lVar = cVar.f5302o;
        if (lVar != null) {
            hVar.setOnKeyListener(lVar);
        }
        return hVar;
    }

    public final h d() {
        h hVarCreate = create();
        hVarCreate.show();
        return hVarCreate;
    }

    public Context getContext() {
        return this.f5346a.f5290a;
    }

    public g setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
        c cVar = this.f5346a;
        cVar.i = cVar.f5290a.getText(i);
        cVar.f5297j = onClickListener;
        return this;
    }

    public g setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
        c cVar = this.f5346a;
        cVar.f5295g = cVar.f5290a.getText(i);
        cVar.f5296h = onClickListener;
        return this;
    }

    public g setTitle(CharSequence charSequence) {
        this.f5346a.f5293d = charSequence;
        return this;
    }

    public g setView(View view) {
        this.f5346a.f5305r = view;
        return this;
    }

    public g(Context context, int i) {
        this.f5346a = new c(new ContextThemeWrapper(context, h.h(context, i)));
        this.f5347b = i;
    }
}
