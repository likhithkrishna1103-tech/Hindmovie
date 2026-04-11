package e7;

import com.bumptech.glide.load.data.k;
import d7.j;
import d7.q;
import d7.r;
import d7.s;
import d7.t;
import java.util.ArrayDeque;
import x6.g;
import x6.h;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f3814b = g.a(2500, "com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pc.c f3815a;

    public a(pc.c cVar) {
        this.f3815a = cVar;
    }

    @Override // d7.t
    public final s a(Object obj, int i, int i10, h hVar) {
        j jVar = (j) obj;
        pc.c cVar = this.f3815a;
        if (cVar != null) {
            q qVar = (q) cVar.f10180v;
            r rVarA = r.a(jVar);
            Object objA = qVar.a(rVarA);
            ArrayDeque arrayDeque = r.f3505b;
            synchronized (arrayDeque) {
                arrayDeque.offer(rVarA);
            }
            j jVar2 = (j) objA;
            if (jVar2 == null) {
                qVar.d(r.a(jVar), jVar);
            } else {
                jVar = jVar2;
            }
        }
        return new s(jVar, new k(jVar, ((Integer) hVar.c(f3814b)).intValue()));
    }

    @Override // d7.t
    public final /* bridge */ /* synthetic */ boolean b(Object obj) {
        return true;
    }
}
