package d1;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q extends xd.h implements fe.p {
    public /* synthetic */ Object A;
    public final /* synthetic */ Object B;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f3293z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public q(fe.p pVar, vd.c cVar) {
        super(2, cVar);
        this.f3293z = 3;
        this.B = (xd.h) pVar;
    }

    @Override // fe.p
    public final Object j(Object obj, Object obj2) throws Throwable {
        switch (this.f3293z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((q) m((l1) obj, (vd.c) obj2)).o(rd.l.f11003a);
            case 1:
                return ((q) m((h1.b) obj, (vd.c) obj2)).o(rd.l.f11003a);
            case 2:
                ((q) m((pe.v) obj, (vd.c) obj2)).o(rd.l.f11003a);
                throw null;
            default:
                return ((q) m((pe.v) obj, (vd.c) obj2)).o(rd.l.f11003a);
        }
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [fe.p, xd.h] */
    @Override // xd.a
    public final vd.c m(Object obj, vd.c cVar) {
        switch (this.f3293z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                q qVar = new q((l1) this.B, cVar, 0);
                qVar.A = obj;
                return qVar;
            case 1:
                q qVar2 = new q((Set) this.B, cVar, 1);
                qVar2.A = obj;
                return qVar2;
            case 2:
                q qVar3 = new q((s4.d) this.B, cVar, 2);
                qVar3.A = obj;
                return qVar3;
            default:
                q qVar4 = new q((xd.h) this.B, cVar);
                qVar4.A = obj;
                return qVar4;
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [fe.p, xd.h] */
    @Override // xd.a
    public final Object o(Object obj) throws Throwable {
        int i = this.f3293z;
        boolean z10 = false;
        vd.c cVar = null;
        Object obj2 = this.B;
        boolean z11 = true;
        char c9 = 1;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                com.bumptech.glide.c.C(obj);
                l1 l1Var = (l1) this.A;
                if ((l1Var instanceof d) && l1Var.f3271a <= ((l1) obj2).f3271a) {
                    z10 = true;
                }
                return Boolean.valueOf(z10);
            case 1:
                com.bumptech.glide.c.C(obj);
                Set setKeySet = ((h1.b) this.A).a().keySet();
                ArrayList arrayList = new ArrayList(sd.l.f0(setKeySet, 10));
                Iterator it = setKeySet.iterator();
                while (it.hasNext()) {
                    arrayList.add(((h1.e) it.next()).f5477a);
                }
                Set set = (Set) obj2;
                if (set == g1.j.f4615a) {
                    z10 = true;
                } else if (set == null || !set.isEmpty()) {
                    Iterator it2 = set.iterator();
                    while (it2.hasNext()) {
                        if (!arrayList.contains((String) it2.next())) {
                            z10 = true;
                        }
                    }
                }
                return Boolean.valueOf(z10);
            case 2:
                com.bumptech.glide.c.C(obj);
                throw null;
            default:
                com.bumptech.glide.c.C(obj);
                vd.h hVarB = ((pe.v) this.A).b();
                vd.d dVar = vd.d.f13721v;
                vd.f fVarC = hVarB.C(dVar);
                ge.i.b(fVarC);
                vd.e eVar = (vd.e) fVarC;
                pe.n nVarA = pe.x.a();
                u uVar = new u(nVarA, (fe.p) obj2, (vd.c) null);
                vd.h hVarD = pe.x.d(vd.i.f13722v, eVar, true);
                we.e eVar2 = pe.f0.f10232a;
                if (hVarD != eVar2 && hVarD.C(dVar) == null) {
                    hVarD = hVarD.q(eVar2);
                }
                pe.a a0Var = new pe.a0(hVarD, z11, c9 == true ? 1 : 0);
                a0Var.f0(pe.w.f10278x, a0Var, uVar);
                while (!nVarA.L()) {
                    try {
                        return pe.x.o(eVar, new r4.a(nVarA, cVar, 3));
                    } catch (InterruptedException unused) {
                    }
                }
                return nVarA.y();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(Object obj, vd.c cVar, int i) {
        super(2, cVar);
        this.f3293z = i;
        this.B = obj;
    }
}
