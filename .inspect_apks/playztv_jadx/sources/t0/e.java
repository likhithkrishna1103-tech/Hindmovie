package t0;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends View {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f11985u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ g f11986v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(g gVar, Context context, ViewGroup viewGroup) {
        super(context);
        this.f11986v = gVar;
        this.f11985u = viewGroup;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        Drawable background = this.f11985u.getBackground();
        int color = background instanceof ColorDrawable ? ((ColorDrawable) background).getColor() : 0;
        g gVar = this.f11986v;
        if (gVar.f11993e != color) {
            gVar.f11993e = color;
            for (int size = gVar.f11990b.size() - 1; size >= 0; size--) {
                ((c) gVar.f11990b.get(size)).b(color);
            }
        }
    }
}
