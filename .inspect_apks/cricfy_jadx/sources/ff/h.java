package ff;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import rf.c0;
import rf.p;
import rf.q;
import rf.y;
import sd.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements fe.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4581v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f4582w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f4583x;

    public /* synthetic */ h(int i, Object obj, Object obj2) {
        this.f4581v = i;
        this.f4582w = obj;
        this.f4583x = obj2;
    }

    private final Object c() {
        long jA;
        int i;
        y[] yVarArr;
        p pVar = (p) this.f4582w;
        c0 c0Var = (c0) this.f4583x;
        ge.p pVar2 = new ge.p();
        q qVar = pVar.f11102w;
        synchronized (qVar.R) {
            synchronized (qVar) {
                try {
                    c0 c0Var2 = qVar.M;
                    c0 c0Var3 = new c0();
                    c0Var3.b(c0Var2);
                    c0Var3.b(c0Var);
                    pVar2.f5254v = c0Var3;
                    jA = ((long) c0Var3.a()) - ((long) c0Var2.a());
                    yVarArr = (jA == 0 || qVar.f11104w.isEmpty()) ? null : (y[]) qVar.f11104w.values().toArray(new y[0]);
                    c0 c0Var4 = (c0) pVar2.f5254v;
                    ge.i.e(c0Var4, "<set-?>");
                    qVar.M = c0Var4;
                    nf.c.c(qVar.E, qVar.f11105x + " onSettings", new h(5, qVar, pVar2));
                } catch (Throwable th) {
                    throw th;
                }
            }
            try {
                qVar.R.a((c0) pVar2.f5254v);
            } catch (IOException e9) {
                rf.b bVar = rf.b.f11050y;
                qVar.a(bVar, bVar, e9);
            }
        }
        if (yVarArr != null) {
            for (y yVar : yVarArr) {
                synchronized (yVar) {
                    yVar.f11138z += jA;
                    if (jA > 0) {
                        yVar.notifyAll();
                    }
                }
            }
        }
        return rd.l.f11003a;
    }

    @Override // fe.a
    public final Object b() {
        String[] strArrNames;
        switch (this.f4581v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                bf.d dVar = (bf.d) this.f4582w;
                ef.b bVar = (ef.b) this.f4583x;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                bVar.f3893a.getClass();
                i.e(dVar, bVar);
                int iD = dVar.d();
                for (int i = 0; i < iD; i++) {
                    List listI = dVar.i(i);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : listI) {
                        if (obj instanceof ef.d) {
                            arrayList.add(obj);
                        }
                    }
                    ef.d dVar2 = (ef.d) (arrayList.size() == 1 ? arrayList.get(0) : null);
                    if (dVar2 != null && (strArrNames = dVar2.names()) != null) {
                        for (String str : strArrNames) {
                            String str2 = ge.i.a(dVar.c(), bf.e.f1913e) ? "enum value" : "property";
                            if (linkedHashMap.containsKey(str)) {
                                String str3 = "The suggested name '" + str + "' for " + str2 + ' ' + dVar.e(i) + " is already one of the names for " + str2 + ' ' + dVar.e(((Number) s.z(linkedHashMap, str)).intValue()) + " in " + dVar;
                                ge.i.e(str3, "message");
                                throw new g(str3);
                            }
                            linkedHashMap.put(str, Integer.valueOf(i));
                        }
                    }
                }
                return linkedHashMap.isEmpty() ? sd.q.f11670v : linkedHashMap;
            case 1:
                hd.e eVar = (hd.e) this.f4582w;
                z5.b bVar2 = (z5.b) this.f4583x;
                hd.a aVar = (hd.a) eVar.f5927c;
                aVar.getClass();
                synchronized (aVar.D) {
                    aVar.D.add(bVar2);
                }
                aVar.f5916z.a(aVar.C, bVar2);
                aVar.f5915y.b("Added listener " + bVar2);
                break;
            case 2:
                id.d dVar3 = (id.d) this.f4582w;
                String str4 = (String) this.f4583x;
                if (!dVar3.F && !dVar3.E && "LibGlobalFetchLib".equals(str4)) {
                    dVar3.q();
                }
                return rd.l.f11003a;
            case 3:
                q qVar = (q) this.f4582w;
                y yVar = (y) this.f4583x;
                try {
                    qVar.f11103v.c(yVar);
                    break;
                } catch (IOException e9) {
                    uf.f fVar = uf.f.f12506a;
                    uf.f.f12506a.j("Http2Connection.Listener failure for " + qVar.f11105x, 4, e9);
                    try {
                        yVar.c(rf.b.f11050y, e9);
                        break;
                    } catch (IOException unused) {
                    }
                }
                return rd.l.f11003a;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return c();
            default:
                q qVar2 = (q) this.f4582w;
                qVar2.f11103v.b(qVar2, (c0) ((ge.p) this.f4583x).f5254v);
                break;
        }
        return rd.l.f11003a;
    }
}
