package he;

import androidx.media3.decoder.DecoderInputBuffer;
import k8.b0;
import r4.p;
import r4.t;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements ae.l {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6089u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f6090v;

    public /* synthetic */ i(int i, Object obj) {
        this.f6089u = i;
        this.f6090v = obj;
    }

    @Override // ae.l
    public final Object a(Object obj) throws Exception {
        switch (this.f6089u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a5.c cVar = (a5.c) this.f6090v;
                be.h.e(obj, "it");
                return cVar.b();
            case 1:
                return obj == ((od.c) this.f6090v) ? "(this Collection)" : String.valueOf(obj);
            case 2:
                p pVar = (p) this.f6090v;
                z4.a aVar = (z4.a) obj;
                be.h.e(aVar, "db");
                pVar.f11473g = aVar;
                return nd.k.f8990a;
            case 3:
                t tVar = (t) this.f6090v;
                r4.a aVar2 = (r4.a) obj;
                be.h.e(aVar2, "config");
                return tVar.e(aVar2);
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                rc.c cVar2 = (rc.c) this.f6090v;
                y4.a aVar3 = (y4.a) obj;
                be.h.e(aVar3, "connection");
                y4.c cVarE0 = aVar3.e0("INSERT OR REPLACE INTO `fav_channels` (`id`,`name`,`image`,`link`,`playlist`) VALUES (nullif(?, 0),?,?,?,?)");
                try {
                    b0.h(cVarE0, cVar2);
                    cVarE0.W();
                    cf.d.g(cVarE0, null);
                    return null;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        cf.d.g(cVarE0, th);
                        throw th2;
                    }
                }
            default:
                ((se.c) this.f6090v).a(null);
                return nd.k.f8990a;
        }
    }

    public /* synthetic */ i(rc.b bVar, rc.c cVar) {
        this.f6089u = 4;
        this.f6090v = cVar;
    }

    public /* synthetic */ i(se.c cVar, se.b bVar) {
        this.f6089u = 5;
        this.f6090v = cVar;
    }
}
