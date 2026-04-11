package oe;

import ie.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ke.d1;
import ke.p;
import ke.s;
import ke.v0;
import nd.k;
import od.j;
import od.q;
import rd.i;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends td.c implements ne.c {
    public rd.h A;
    public rd.c B;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ne.c f9582x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final rd.h f9583y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f9584z;

    public f(ne.c cVar, rd.h hVar) {
        super(e.f9581u, i.f11572u);
        this.f9582x = cVar;
        this.f9583y = hVar;
        this.f9584z = ((Number) hVar.d(0, new p(3))).intValue();
    }

    @Override // td.a, td.d
    public final td.d c() {
        rd.c cVar = this.B;
        if (cVar instanceof td.d) {
            return (td.d) cVar;
        }
        return null;
    }

    @Override // td.c, rd.c
    public final rd.h f() {
        rd.h hVar = this.A;
        return hVar == null ? i.f11572u : hVar;
    }

    @Override // ne.c
    public final Object j(Object obj, rd.c cVar) {
        try {
            Object objQ = q(cVar, obj);
            return objQ == sd.a.f11942u ? objQ : k.f8990a;
        } catch (Throwable th) {
            this.A = new d(th, cVar.f());
            throw th;
        }
    }

    @Override // td.a
    public final StackTraceElement n() {
        return null;
    }

    @Override // td.a
    public final Object o(Object obj) {
        Throwable thA = nd.h.a(obj);
        if (thA != null) {
            this.A = new d(thA, f());
        }
        rd.c cVar = this.B;
        if (cVar != null) {
            cVar.g(obj);
        }
        return sd.a.f11942u;
    }

    public final Object q(rd.c cVar, Object obj) {
        List listG;
        Comparable comparable;
        String strSubstring;
        rd.h hVarF = cVar.f();
        v0 v0Var = (v0) hVarF.v(s.f7730v);
        if (v0Var != null && !v0Var.a()) {
            throw ((d1) v0Var).s();
        }
        rd.h hVar = this.A;
        if (hVar != hVarF) {
            int i = 0;
            if (hVar instanceof d) {
                String str = "\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((d) hVar).f9580v + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ";
                be.h.e(str, "<this>");
                ie.c cVar2 = new ie.c(str);
                if (cVar2.hasNext()) {
                    Object next = cVar2.next();
                    if (cVar2.hasNext()) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(next);
                        while (cVar2.hasNext()) {
                            arrayList.add(cVar2.next());
                        }
                        listG = arrayList;
                    } else {
                        listG = android.support.v4.media.session.b.G(next);
                    }
                } else {
                    listG = q.f9570u;
                }
                List list = listG;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : list) {
                    if (!ie.e.U((String) obj2)) {
                        arrayList2.add(obj2);
                    }
                }
                ArrayList arrayList3 = new ArrayList(od.k.U(arrayList2));
                int size = arrayList2.size();
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
                        if (!cf.d.r(str2.charAt(length2))) {
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
                listG.size();
                int iR = j.R(listG);
                ArrayList arrayList4 = new ArrayList();
                for (Object obj4 : list) {
                    int i11 = i + 1;
                    if (i < 0) {
                        throw new ArithmeticException("Index overflow has happened.");
                    }
                    String str3 = (String) obj4;
                    if ((i == 0 || i == iR) && ie.e.U(str3)) {
                        strSubstring = null;
                    } else {
                        be.h.e(str3, "<this>");
                        if (iIntValue < 0) {
                            throw new IllegalArgumentException(e6.j.j(iIntValue, "Requested character count ", " is less than zero.").toString());
                        }
                        int length4 = str3.length();
                        if (iIntValue <= length4) {
                            length4 = iIntValue;
                        }
                        strSubstring = str3.substring(length4);
                        be.h.d(strSubstring, "substring(...)");
                    }
                    if (strSubstring != null) {
                        arrayList4.add(strSubstring);
                    }
                    i = i11;
                }
                StringBuilder sb2 = new StringBuilder(length3);
                od.i.Z(arrayList4, sb2, "\n", "", "", "...", null);
                throw new IllegalStateException(sb2.toString().toString());
            }
            if (((Number) hVarF.d(0, new o(1, this))).intValue() != this.f9584z) {
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + this.f9583y + ",\n\t\tbut emission happened in " + hVarF + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
            }
            this.A = hVarF;
        }
        this.B = cVar;
        ae.q qVar = h.f9585a;
        ne.c cVar3 = this.f9582x;
        be.h.c(cVar3, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        Object objH = qVar.h(cVar3, obj, this);
        if (!be.h.a(objH, sd.a.f11942u)) {
            this.B = null;
        }
        return objH;
    }
}
