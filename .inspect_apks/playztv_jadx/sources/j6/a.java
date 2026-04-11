package j6;

import c6.h;
import c6.i;
import com.bumptech.glide.load.data.l;
import i6.o;
import i6.p;
import i6.q;
import i6.r;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f6795b = h.a(2500, "com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wb.c f6796a;

    public a(wb.c cVar) {
        this.f6796a = cVar;
    }

    @Override // i6.r
    public final q a(Object obj, int i, int i10, i iVar) {
        i6.h hVar = (i6.h) obj;
        wb.c cVar = this.f6796a;
        if (cVar != null) {
            o oVar = (o) cVar.f14088v;
            p pVarA = p.a(hVar);
            Object objA = oVar.a(pVarA);
            ArrayDeque arrayDeque = p.f6418b;
            synchronized (arrayDeque) {
                arrayDeque.offer(pVarA);
            }
            i6.h hVar2 = (i6.h) objA;
            if (hVar2 == null) {
                oVar.d(p.a(hVar), hVar);
            } else {
                hVar = hVar2;
            }
        }
        return new q(hVar, new l(hVar, ((Integer) iVar.c(f6795b)).intValue()));
    }

    @Override // i6.r
    public final /* bridge */ /* synthetic */ boolean b(Object obj) {
        return true;
    }
}
