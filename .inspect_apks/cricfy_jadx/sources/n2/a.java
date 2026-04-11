package n2;

import android.net.Uri;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.List;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements t {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ c f8631v;

    public a(c cVar) {
        this.f8631v = cVar;
    }

    @Override // n2.t
    public final void b() {
        this.f8631v.f8641z.remove(this);
    }

    @Override // n2.t
    public final boolean c(Uri uri, ag.o oVar, boolean z10) {
        b bVar;
        c cVar = this.f8631v;
        HashMap map = cVar.f8640y;
        if (cVar.G == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            o oVar2 = cVar.E;
            int i = a0.f14551a;
            List list = oVar2.f8717e;
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                b bVar2 = (b) map.get(((n) list.get(i11)).f8710a);
                if (bVar2 != null && jElapsedRealtime < bVar2.C) {
                    i10++;
                }
            }
            w2.h hVar = new w2.h(1, 0, cVar.E.f8717e.size(), i10);
            cVar.f8639x.getClass();
            i4.e eVarK = f9.a0.k(hVar, oVar);
            if (eVarK != null && eVarK.f6206a == 2 && (bVar = (b) map.get(uri)) != null) {
                b.a(bVar, eVarK.f6207b);
            }
        }
        return false;
    }
}
