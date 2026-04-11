package z0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends td.g implements ae.p {
    public int A;
    public /* synthetic */ Object B;
    public final /* synthetic */ List C;
    public final /* synthetic */ ArrayList D;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Iterator f14757y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Object f14758z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(List list, ArrayList arrayList, rd.c cVar) {
        super(2, cVar);
        this.C = list;
        this.D = arrayList;
    }

    @Override // ae.p
    public final Object i(Object obj, Object obj2) {
        return ((e) m(obj, (rd.c) obj2)).o(nd.k.f8990a);
    }

    @Override // td.a
    public final rd.c m(Object obj, rd.c cVar) {
        e eVar = new e(this.C, this.D, cVar);
        eVar.B = obj;
        return eVar;
    }

    @Override // td.a
    public final Object o(Object obj) throws Throwable {
        Iterator it;
        List list;
        int i = this.A;
        if (i == 0) {
            i5.a.Q(obj);
            obj = this.B;
            it = this.C.iterator();
            list = this.D;
        } else if (i == 1) {
            Object obj2 = this.f14758z;
            Iterator it2 = this.f14757y;
            List list2 = (List) this.B;
            i5.a.Q(obj);
            if (((Boolean) obj).booleanValue()) {
                list2.add(new d(1, null));
                this.B = list2;
                this.f14757y = it2;
                this.f14758z = null;
                this.A = 2;
                throw null;
            }
            obj = obj2;
            it = it2;
            list = list2;
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = this.f14757y;
            list = (List) this.B;
            i5.a.Q(obj);
        }
        if (!it.hasNext()) {
            return obj;
        }
        if (it.next() != null) {
            throw new ClassCastException();
        }
        this.B = list;
        this.f14757y = it;
        this.f14758z = obj;
        this.A = 1;
        throw null;
    }
}
