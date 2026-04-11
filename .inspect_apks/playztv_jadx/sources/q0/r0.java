package q0;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r0 extends td.a implements ae.p, be.f {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f10487v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f10488w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public /* synthetic */ Object f10489x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ View f10490y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r0(View view, rd.c cVar) {
        super(cVar);
        this.f10490y = view;
        if (cVar != null && cVar.f() != rd.i.f11572u) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
        this.f10487v = 2;
    }

    @Override // be.f
    public final int d() {
        return this.f10487v;
    }

    @Override // rd.c
    public final rd.h f() {
        return rd.i.f11572u;
    }

    @Override // ae.p
    public final Object i(Object obj, Object obj2) {
        return ((r0) m((he.f) obj, (rd.c) obj2)).o(nd.k.f8990a);
    }

    @Override // td.a
    public final rd.c m(Object obj, rd.c cVar) {
        r0 r0Var = new r0(this.f10490y, cVar);
        r0Var.f10489x = obj;
        return r0Var;
    }

    @Override // td.a
    public final Object o(Object obj) throws Throwable {
        Object obj2;
        int i = this.f10488w;
        View view = this.f10490y;
        sd.a aVar = sd.a.f11942u;
        if (i == 0) {
            i5.a.Q(obj);
            he.f fVar = (he.f) this.f10489x;
            this.f10489x = fVar;
            this.f10488w = 1;
            fVar.f6086v = view;
            fVar.f6085u = 3;
            fVar.f6088x = this;
            return aVar;
        }
        nd.k kVar = nd.k.f8990a;
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i5.a.Q(obj);
            return kVar;
        }
        he.f fVar2 = (he.f) this.f10489x;
        i5.a.Q(obj);
        if (view instanceof ViewGroup) {
            this.f10489x = null;
            this.f10488w = 2;
            fVar2.getClass();
            he.l lVar = new he.l(new be.a(3, (ViewGroup) view));
            if (lVar.f6095v.hasNext()) {
                fVar2.f6087w = lVar;
                fVar2.f6085u = 2;
                fVar2.f6088x = this;
                obj2 = aVar;
            } else {
                obj2 = kVar;
            }
            if (obj2 != aVar) {
                obj2 = kVar;
            }
            if (obj2 == aVar) {
                return aVar;
            }
        }
        return kVar;
    }

    @Override // td.a
    public final String toString() {
        if (this.f12487u != null) {
            return super.toString();
        }
        be.o.f2046a.getClass();
        String strA = be.p.a(this);
        be.h.d(strA, "renderLambdaToString(...)");
        return strA;
    }
}
