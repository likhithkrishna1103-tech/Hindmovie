package vc;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v0 extends xd.h implements fe.q {
    public /* synthetic */ se.d A;
    public /* synthetic */ Throwable B;
    public final /* synthetic */ a1 C;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f13703z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0(a1 a1Var, vd.c cVar) {
        super(3, cVar);
        this.C = a1Var;
    }

    @Override // fe.q
    public final Object g(Object obj, Object obj2, Object obj3) {
        v0 v0Var = new v0(this.C, (vd.c) obj3);
        v0Var.A = (se.d) obj;
        v0Var.B = (Throwable) obj2;
        return v0Var.o(rd.l.f11003a);
    }

    @Override // xd.a
    public final Object o(Object obj) throws Throwable {
        int i = this.f13703z;
        if (i == 0) {
            com.bumptech.glide.c.C(obj);
            se.d dVar = this.A;
            Throwable th = this.B;
            k0 k0VarA = this.C.f13568b.a(null);
            g0 g0Var = new g0(k0VarA, null, null);
            Log.d("FirebaseSessions", "Init session datastore failed with exception message: " + th.getMessage() + ". Emit fallback session " + k0VarA.f13656a);
            this.A = null;
            this.f13703z = 1;
            Object objF = dVar.f(g0Var, this);
            wd.a aVar = wd.a.f14143v;
            if (objF == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            com.bumptech.glide.c.C(obj);
        }
        return rd.l.f11003a;
    }
}
