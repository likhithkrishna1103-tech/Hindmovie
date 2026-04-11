package t0;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p0 extends xd.g implements fe.p, ge.g {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f11786w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f11787x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public /* synthetic */ Object f11788y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ View f11789z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(View view, vd.c cVar) {
        super(cVar);
        this.f11789z = view;
        this.f11786w = 2;
    }

    @Override // ge.g
    public final int e() {
        return this.f11786w;
    }

    @Override // fe.p
    public final Object j(Object obj, Object obj2) {
        return ((p0) m((me.f) obj, (vd.c) obj2)).o(rd.l.f11003a);
    }

    @Override // xd.a
    public final vd.c m(Object obj, vd.c cVar) {
        p0 p0Var = new p0(this.f11789z, cVar);
        p0Var.f11788y = obj;
        return p0Var;
    }

    @Override // xd.a
    public final Object o(Object obj) throws Throwable {
        Object obj2;
        int i = this.f11787x;
        View view = this.f11789z;
        wd.a aVar = wd.a.f14143v;
        if (i == 0) {
            com.bumptech.glide.c.C(obj);
            me.f fVar = (me.f) this.f11788y;
            this.f11788y = fVar;
            this.f11787x = 1;
            fVar.f8463w = view;
            fVar.f8462v = 3;
            fVar.f8465y = this;
            return aVar;
        }
        rd.l lVar = rd.l.f11003a;
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            com.bumptech.glide.c.C(obj);
            return lVar;
        }
        me.f fVar2 = (me.f) this.f11788y;
        com.bumptech.glide.c.C(obj);
        if (view instanceof ViewGroup) {
            this.f11788y = null;
            this.f11787x = 2;
            fVar2.getClass();
            me.j jVar = new me.j(new ge.b(3, (ViewGroup) view));
            if (jVar.f8478w.hasNext()) {
                fVar2.f8464x = jVar;
                fVar2.f8462v = 2;
                fVar2.f8465y = this;
                obj2 = aVar;
            } else {
                obj2 = lVar;
            }
            if (obj2 != aVar) {
                obj2 = lVar;
            }
            if (obj2 == aVar) {
                return aVar;
            }
        }
        return lVar;
    }

    @Override // xd.a
    public final String toString() {
        if (this.f14482v != null) {
            return super.toString();
        }
        ge.q.f5255a.getClass();
        String strA = ge.r.a(this);
        ge.i.d(strA, "renderLambdaToString(...)");
        return strA;
    }
}
