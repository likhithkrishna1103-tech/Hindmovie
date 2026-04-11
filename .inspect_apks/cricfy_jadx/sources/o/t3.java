package o;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t3 implements xc.b {
    public final Object A;
    public Object B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f9367v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f9368w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f9369x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Object f9370y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Object f9371z;

    public t3() {
        this.f9367v = new AtomicBoolean();
        this.f9368w = null;
        this.f9369x = new HashMap(16, 1.0f);
        this.f9370y = new HashMap(16, 1.0f);
        this.f9371z = new HashMap(16, 1.0f);
        this.A = new HashMap(16, 1.0f);
        this.B = null;
    }

    @Override // qd.a
    public Object get() {
        return new vc.a1((yc.j) ((qd.a) this.f9367v).get(), (vc.r0) ((qd.a) this.f9368w).get(), (vc.n0) ((qd.a) this.f9369x).get(), (vc.e1) ((qd.a) this.f9370y).get(), (d1.i) ((qd.a) this.f9371z).get(), (vc.c0) ((xc.c) this.A).get(), (vd.h) ((qd.a) this.B).get());
    }

    public t3(xc.c cVar, xc.c cVar2, xc.c cVar3, xc.c cVar4, xc.c cVar5, xc.c cVar6, ma.e eVar) {
        this.f9367v = cVar;
        this.f9368w = cVar2;
        this.f9369x = cVar3;
        this.f9370y = cVar4;
        this.f9371z = cVar5;
        this.A = cVar6;
        this.B = eVar;
    }

    public t3(ScrollView scrollView, LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView2, TextView textView3, TextView textView4) {
        this.f9367v = linearLayout;
        this.f9369x = textView;
        this.f9368w = linearLayout2;
        this.f9370y = linearLayout3;
        this.f9371z = textView2;
        this.A = textView3;
        this.B = textView4;
    }

    public t3(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f9370y = layoutParams;
        this.f9371z = new Rect();
        this.A = new int[2];
        this.B = new int[2];
        this.f9367v = context;
        View viewInflate = LayoutInflater.from(context).inflate(g.g.abc_tooltip, (ViewGroup) null);
        this.f9368w = viewInflate;
        this.f9369x = (TextView) viewInflate.findViewById(g.f.message);
        layoutParams.setTitle(t3.class.getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = g.i.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    public t3(cd.c cVar, md.j jVar, dd.g gVar, id.a aVar, androidx.emoji2.text.v vVar, Handler handler, l4.c0 c0Var, d8.j jVar2) {
        ge.i.e(handler, "uiHandler");
        this.f9367v = cVar;
        this.f9368w = jVar;
        this.f9369x = gVar;
        this.f9370y = handler;
        this.f9371z = jVar2;
        id.a aVar2 = new id.a(gVar);
        i2.x xVar = new i2.x(cVar.f2155a, 1);
        this.A = xVar;
        fd.a aVar3 = new fd.a(cVar.f2156b, cVar.f2158d, xVar, aVar2, c0Var, jVar2, cVar.f2159e, cVar.f, vVar);
        id.d dVar = new id.d(jVar, aVar, aVar3, xVar, cVar.f2158d, jVar2, cVar.f2160g);
        aVar3.G = dVar;
        cd.g gVar2 = cVar.f2157c;
        ge.i.e(gVar2, "<set-?>");
        dVar.D = gVar2;
        this.B = new hd.a(gVar, aVar3, dVar, cVar.f2158d, cVar.f2156b, cVar.f2159e, jVar2, handler, cVar.f, vVar, cVar.f2160g);
        p6.d dVar2 = new p6.d(23, this);
        synchronized (gVar.f3687w) {
            gVar.f3686v.f3685z = dVar2;
        }
    }
}
