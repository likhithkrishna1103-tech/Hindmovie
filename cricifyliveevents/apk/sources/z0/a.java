package z0;

import android.view.View;
import ge.i;
import java.util.ArrayList;
import me.f;
import sd.k;
import t0.p0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f15058a = c.pooling_container_listener_holder_tag;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f15059b = c.is_pooling_container_tag;

    public static final void a(View view) {
        i.e(view, "<this>");
        f fVar = new f();
        p0 p0Var = new p0(view, fVar);
        p0Var.f11788y = fVar;
        fVar.f8465y = p0Var;
        while (fVar.hasNext()) {
            View view2 = (View) fVar.next();
            int i = f15058a;
            b bVar = (b) view2.getTag(i);
            if (bVar == null) {
                bVar = new b();
                view2.setTag(i, bVar);
            }
            ArrayList arrayList = bVar.f15060a;
            int iD0 = k.d0(arrayList);
            if (-1 < iD0) {
                throw q4.a.k(iD0, arrayList);
            }
        }
    }
}
