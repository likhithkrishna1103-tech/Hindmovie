package te;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pe.c1;
import pe.q;
import pe.t;
import pe.v0;
import qb.t1;
import rd.l;
import sd.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends xd.c implements se.d {
    public final int A;
    public vd.h B;
    public vd.c C;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final se.d f12025y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final vd.h f12026z;

    public g(se.d dVar, vd.h hVar) {
        super(f.f12024v, vd.i.f13722v);
        this.f12025y = dVar;
        this.f12026z = hVar;
        this.A = ((Number) hVar.J(0, new q(3))).intValue();
    }

    @Override // xd.a, xd.d
    public final xd.d d() {
        vd.c cVar = this.C;
        if (cVar instanceof xd.d) {
            return (xd.d) cVar;
        }
        return null;
    }

    @Override // se.d
    public final Object f(Object obj, vd.c cVar) {
        try {
            Object objQ = q(cVar, obj);
            return objQ == wd.a.f14143v ? objQ : l.f11003a;
        } catch (Throwable th) {
            this.B = new d(th, cVar.h());
            throw th;
        }
    }

    @Override // xd.c, vd.c
    public final vd.h h() {
        vd.h hVar = this.B;
        return hVar == null ? vd.i.f13722v : hVar;
    }

    @Override // xd.a
    public final StackTraceElement n() {
        return null;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        Throwable thA = rd.h.a(obj);
        if (thA != null) {
            this.B = new d(thA, h());
        }
        vd.c cVar = this.C;
        if (cVar != null) {
            cVar.i(obj);
        }
        return wd.a.f14143v;
    }

    public final Object q(vd.c cVar, Object obj) {
        List listX;
        Comparable comparable;
        String strSubstring;
        vd.h hVarH = cVar.h();
        v0 v0Var = (v0) hVarH.C(t.f10271w);
        if (v0Var != null && !v0Var.a()) {
            throw ((c1) v0Var).x();
        }
        vd.h hVar = this.B;
        if (hVar != hVarH) {
            if (hVar instanceof d) {
                String str = "\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((d) hVar).f12023w + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ";
                ge.i.e(str, "<this>");
                ne.c cVar2 = new ne.c(str);
                if (cVar2.hasNext()) {
                    Object next = cVar2.next();
                    if (cVar2.hasNext()) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(next);
                        while (cVar2.hasNext()) {
                            arrayList.add(cVar2.next());
                        }
                        listX = arrayList;
                    } else {
                        listX = n5.a.x(next);
                    }
                } else {
                    listX = p.f11669v;
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : listX) {
                    if (!ne.h.k0((String) obj2)) {
                        arrayList2.add(obj2);
                    }
                }
                ArrayList arrayList3 = new ArrayList(sd.l.f0(arrayList2, 10));
                int size = arrayList2.size();
                int i = 0;
                int i10 = 0;
                while (i10 < size) {
                    Object obj3 = arrayList2.get(i10);
                    i10++;
                    String str2 = (String) obj3;
                    int length = str2.length();
                    int length2 = 0;
                    while (true) {
                        if (length2 >= length) {
                            length2 = -1;
                            break;
                        }
                        if (!t1.k(str2.charAt(length2))) {
                            break;
                        }
                        length2++;
                    }
                    if (length2 == -1) {
                        length2 = str2.length();
                    }
                    arrayList3.add(Integer.valueOf(length2));
                }
                Iterator it = arrayList3.iterator();
                if (it.hasNext()) {
                    comparable = (Comparable) it.next();
                    while (it.hasNext()) {
                        Comparable comparable2 = (Comparable) it.next();
                        if (comparable.compareTo(comparable2) > 0) {
                            comparable = comparable2;
                        }
                    }
                } else {
                    comparable = null;
                }
                Integer num = (Integer) comparable;
                int iIntValue = num != null ? num.intValue() : 0;
                int length3 = str.length();
                listX.size();
                int iD0 = sd.k.d0(listX);
                ArrayList arrayList4 = new ArrayList();
                for (Object obj4 : listX) {
                    int i11 = i + 1;
                    if (i < 0) {
                        sd.k.e0();
                        throw null;
                    }
                    String str3 = (String) obj4;
                    if ((i == 0 || i == iD0) && ne.h.k0(str3)) {
                        strSubstring = null;
                    } else {
                        ge.i.e(str3, "<this>");
                        if (iIntValue < 0) {
                            throw new IllegalArgumentException(l0.e.h(iIntValue, "Requested character count ", " is less than zero.").toString());
                        }
                        int length4 = str3.length();
                        if (iIntValue <= length4) {
                            length4 = iIntValue;
                        }
                        strSubstring = str3.substring(length4);
                        ge.i.d(strSubstring, "substring(...)");
                    }
                    if (strSubstring != null) {
                        arrayList4.add(strSubstring);
                    }
                    i = i11;
                }
                StringBuilder sb = new StringBuilder(length3);
                sd.j.j0(arrayList4, sb, "\n", "", "", "...", null);
                throw new IllegalStateException(sb.toString().toString());
            }
            if (((Number) hVarH.J(0, new ne.p(1, this))).intValue() != this.A) {
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + this.f12026z + ",\n\t\tbut emission happened in " + hVarH + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
            }
            this.B = hVarH;
        }
        this.C = cVar;
        fe.q qVar = i.f12027a;
        se.d dVar = this.f12025y;
        ge.i.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        Object objG = qVar.g(dVar, obj, this);
        if (!ge.i.a(objG, wd.a.f14143v)) {
            this.C = null;
        }
        return objG;
    }
}
