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

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f5489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5490b;

    public f(Context context) {
        this(context, g.h(context, 0));
    }

    public f a(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        c cVar = this.f5489a;
        cVar.f5445g = charSequence;
        cVar.f5446h = onClickListener;
        return this;
    }

    public final g b() {
        g gVarCreate = create();
        gVarCreate.show();
        return gVarCreate;
    }

    public g create() {
        c cVar = this.f5489a;
        g gVar = new g(cVar.f5440a, this.f5490b);
        View view = cVar.f5444e;
        e eVar = gVar.A;
        if (view != null) {
            eVar.f5481w = view;
        } else {
            CharSequence charSequence = cVar.f5443d;
            if (charSequence != null) {
                eVar.f5464d = charSequence;
                TextView textView = eVar.f5479u;
                if (textView != null) {
                    textView.setText(charSequence);
                }
            }
            Drawable drawable = cVar.f5442c;
            if (drawable != null) {
                eVar.f5477s = drawable;
                ImageView imageView = eVar.f5478t;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    eVar.f5478t.setImageDrawable(drawable);
                }
            }
        }
        String str = cVar.f;
        if (str != null) {
            eVar.f5465e = str;
            TextView textView2 = eVar.f5480v;
            if (textView2 != null) {
                textView2.setText(str);
            }
        }
        CharSequence charSequence2 = cVar.f5445g;
        if (charSequence2 != null) {
            eVar.c(-1, charSequence2, cVar.f5446h);
        }
        CharSequence charSequence3 = cVar.i;
        if (charSequence3 != null) {
            eVar.c(-2, charSequence3, cVar.f5447j);
        }
        String str2 = cVar.f5448k;
        if (str2 != null) {
            eVar.c(-3, str2, cVar.f5449l);
        }
        if (cVar.f5453p != null) {
            AlertController$RecycleListView alertController$RecycleListView = (AlertController$RecycleListView) cVar.f5441b.inflate(eVar.A, (ViewGroup) null);
            int i = cVar.f5456s ? eVar.B : eVar.C;
            ListAdapter dVar = cVar.f5453p;
            if (dVar == null) {
                dVar = new d(cVar.f5440a, i, R.id.text1, null);
            }
            eVar.f5482x = dVar;
            eVar.f5483y = cVar.f5457t;
            if (cVar.f5454q != null) {
                alertController$RecycleListView.setOnItemClickListener(new b(cVar, eVar));
            }
            if (cVar.f5456s) {
                alertController$RecycleListView.setChoiceMode(1);
            }
            eVar.f = alertController$RecycleListView;
        }
        View view2 = cVar.f5455r;
        if (view2 != null) {
            eVar.f5466g = view2;
            eVar.f5467h = false;
        }
        gVar.setCancelable(cVar.f5450m);
        if (cVar.f5450m) {
            gVar.setCanceledOnTouchOutside(true);
        }
        gVar.setOnCancelListener(null);
        gVar.setOnDismissListener(cVar.f5451n);
        m.l lVar = cVar.f5452o;
        if (lVar != null) {
            gVar.setOnKeyListener(lVar);
        }
        return gVar;
    }

    public Context getContext() {
        return this.f5489a.f5440a;
    }

    public f setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
        c cVar = this.f5489a;
        cVar.i = cVar.f5440a.getText(i);
        cVar.f5447j = onClickListener;
        return this;
    }

    public f setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
        c cVar = this.f5489a;
        cVar.f5445g = cVar.f5440a.getText(i);
        cVar.f5446h = onClickListener;
        return this;
    }

    public f setTitle(CharSequence charSequence) {
        this.f5489a.f5443d = charSequence;
        return this;
    }

    public f setView(View view) {
        this.f5489a.f5455r = view;
        return this;
    }

    public f(Context context, int i) {
        this.f5489a = new c(new ContextThemeWrapper(context, g.h(context, i)));
        this.f5490b = i;
    }
}
