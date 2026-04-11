package w0;

import android.view.View;
import be.h;
import he.f;
import java.util.ArrayList;
import od.j;
import q0.r0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f13504a = c.pooling_container_listener_holder_tag;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f13505b = c.is_pooling_container_tag;

    public static final void a(View view) {
        h.e(view, "<this>");
        f fVar = new f();
        r0 r0Var = new r0(view, fVar);
        r0Var.f10489x = fVar;
        fVar.f6088x = r0Var;
        while (fVar.hasNext()) {
            View view2 = (View) fVar.next();
            int i = f13504a;
            b bVar = (b) view2.getTag(i);
            if (bVar == null) {
                bVar = new b();
                view2.setTag(i, bVar);
            }
            ArrayList arrayList = bVar.f13506a;
            int iR = j.R(arrayList);
            if (-1 < iR) {
                arrayList.get(iR).getClass();
                throw new ClassCastException();
            }
        }
    }
}
