package w0;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends View {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f13769v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ g f13770w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(g gVar, Context context, ViewGroup viewGroup) {
        super(context);
        this.f13770w = gVar;
        this.f13769v = viewGroup;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        Drawable background = this.f13769v.getBackground();
        int color = background instanceof ColorDrawable ? ((ColorDrawable) background).getColor() : 0;
        g gVar = this.f13770w;
        if (gVar.f13777e != color) {
            gVar.f13777e = color;
            for (int size = gVar.f13774b.size() - 1; size >= 0; size--) {
                ((c) gVar.f13774b.get(size)).b(color);
            }
        }
    }
}
