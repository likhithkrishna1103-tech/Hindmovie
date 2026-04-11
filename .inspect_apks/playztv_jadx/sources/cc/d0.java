package cc;

import androidx.media3.decoder.DecoderInputBuffer;
import ke.d1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d0 extends td.g implements ae.p {
    public final /* synthetic */ Object A;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ int f2620y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public /* synthetic */ Object f2621z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d0(ae.p pVar, rd.c cVar) {
        super(2, cVar);
        this.f2620y = 1;
        this.A = (td.g) pVar;
    }

    @Override // ae.p
    public final Object i(Object obj, Object obj2) throws Throwable {
        switch (this.f2620y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                d0 d0Var = (d0) m((c1.b) obj, (rd.c) obj2);
                nd.k kVar = nd.k.f8990a;
                d0Var.o(kVar);
                return kVar;
            case 1:
                return ((d0) m((ke.u) obj, (rd.c) obj2)).o(nd.k.f8990a);
            case 2:
                return ((d0) m((t4.j) obj, (rd.c) obj2)).o(nd.k.f8990a);
            default:
                return ((d0) m((z0.b0) obj, (rd.c) obj2)).o(nd.k.f8990a);
        }
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [ae.p, td.g] */
    @Override // td.a
    public final rd.c m(Object obj, rd.c cVar) {
        switch (this.f2620y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                d0 d0Var = new d0((String) this.A, cVar, 0);
                d0Var.f2621z = obj;
                return d0Var;
            case 1:
                d0 d0Var2 = new d0((ae.p) this.A, cVar);
                d0Var2.f2621z = obj;
                return d0Var2;
            case 2:
                d0 d0Var3 = new d0(cVar, (ae.l) this.A);
                d0Var3.f2621z = obj;
                return d0Var3;
            default:
                d0 d0Var4 = new d0((z0.b0) this.A, cVar, 3);
                d0Var4.f2621z = obj;
                return d0Var4;
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [ae.p, td.g] */
    @Override // td.a
    public final Object o(Object obj) throws Throwable {
        int i = this.f2620y;
        char c9 = 1;
        char c10 = 1;
        Object obj2 = this.A;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                i5.a.Q(obj);
                c1.b bVar = (c1.b) this.f2621z;
                bVar.getClass();
                c1.d dVar = z.f2727a;
                be.h.e(dVar, "key");
                bVar.b(dVar, (String) obj2);
                return nd.k.f8990a;
            case 1:
                i5.a.Q(obj);
                rd.h hVarB = ((ke.u) this.f2621z).b();
                rd.d dVar2 = rd.d.f11571u;
                rd.f fVarV = hVarB.v(dVar2);
                be.h.b(fVarV);
                rd.e eVar = (rd.e) fVarV;
                ke.m mVar = new ke.m(true);
                rd.c cVar = null;
                mVar.C(null);
                l lVar = new l(mVar, (ae.p) obj2, (rd.c) null);
                rd.h hVarC = ke.x.c(rd.i.f11572u, eVar, true);
                re.e eVar2 = ke.f0.f7690a;
                if (hVarC != eVar2 && hVarC.v(dVar2) == null) {
                    hVarC = hVarC.K(eVar2);
                }
                ke.a a0Var = new ke.a0(hVarC, c10 == true ? 1 : 0, c9 == true ? 1 : 0);
                a0Var.X(ke.v.f7737v, a0Var, lVar);
                while (d1.f7686u.get(mVar) instanceof ke.s0) {
                    try {
                        return ke.x.m(eVar, new w(mVar, cVar, 4));
                    } catch (InterruptedException unused) {
                    }
                }
                return mVar.t();
            case 2:
                i5.a.Q(obj);
                t4.j jVar = (t4.j) this.f2621z;
                be.h.c(jVar, "null cannot be cast to non-null type androidx.room.coroutines.RawConnectionAccessor");
                return ((ae.l) obj2).a(jVar.c());
            default:
                i5.a.Q(obj);
                z0.b0 b0Var = (z0.b0) obj2;
                return Boolean.valueOf(((b0Var instanceof z0.b) || (b0Var instanceof z0.g) || ((z0.b0) this.f2621z) != b0Var) ? false : true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d0(Object obj, rd.c cVar, int i) {
        super(2, cVar);
        this.f2620y = i;
        this.A = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(rd.c cVar, ae.l lVar) {
        super(2, cVar);
        this.f2620y = 2;
        this.A = lVar;
    }
}
