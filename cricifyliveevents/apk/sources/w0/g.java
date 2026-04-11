package w0;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.WeakHashMap;
import t0.d0;
import t0.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f13773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f13774b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l0.c f13775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l0.c f13776d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13777e;

    public g(ViewGroup viewGroup) {
        l0.c cVar = l0.c.f7601e;
        this.f13775c = cVar;
        this.f13776d = cVar;
        Drawable background = viewGroup.getBackground();
        this.f13777e = background instanceof ColorDrawable ? ((ColorDrawable) background).getColor() : 0;
        e eVar = new e(this, viewGroup.getContext(), viewGroup);
        this.f13773a = eVar;
        eVar.setWillNotDraw(true);
        kb.d dVar = new kb.d(18, this);
        WeakHashMap weakHashMap = m0.f11777a;
        d0.l(eVar, dVar);
        m0.p(eVar, new f(this));
        viewGroup.addView(eVar, 0);
    }
}
