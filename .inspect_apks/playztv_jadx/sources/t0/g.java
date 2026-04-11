package t0;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.WeakHashMap;
import q0.f0;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f11989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f11990b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i0.d f11991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i0.d f11992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11993e;

    public g(ViewGroup viewGroup) {
        i0.d dVar = i0.d.f6160e;
        this.f11991c = dVar;
        this.f11992d = dVar;
        Drawable background = viewGroup.getBackground();
        this.f11993e = background instanceof ColorDrawable ? ((ColorDrawable) background).getColor() : 0;
        e eVar = new e(this, viewGroup.getContext(), viewGroup);
        this.f11989a = eVar;
        eVar.setWillNotDraw(true);
        nc.c cVar = new nc.c(8, this);
        WeakHashMap weakHashMap = o0.f10475a;
        f0.l(eVar, cVar);
        o0.q(eVar, new f(this));
        viewGroup.addView(eVar, 0);
    }
}
