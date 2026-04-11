package vc;

import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w0 extends xd.h implements fe.p {
    public int A;
    public final /* synthetic */ a1 B;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f13707z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w0(a1 a1Var, vd.c cVar, int i) {
        super(2, cVar);
        this.f13707z = i;
        this.B = a1Var;
    }

    @Override // fe.p
    public final Object j(Object obj, Object obj2) {
        pe.v vVar = (pe.v) obj;
        vd.c cVar = (vd.c) obj2;
        switch (this.f13707z) {
        }
        return ((w0) m(vVar, cVar)).o(rd.l.f11003a);
    }

    @Override // xd.a
    public final vd.c m(Object obj, vd.c cVar) {
        switch (this.f13707z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new w0(this.B, cVar, 0);
            default:
                return new w0(this.B, cVar, 1);
        }
    }

    @Override // xd.a
    public final Object o(Object obj) throws Throwable {
        switch (this.f13707z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i = this.A;
                if (i == 0) {
                    com.bumptech.glide.c.C(obj);
                    a1 a1Var = this.B;
                    nb.w wVar = new nb.w(16, a1Var.f13571e.b(), new v0(a1Var, null));
                    d1.t tVar = new d1.t(2, a1Var);
                    this.A = 1;
                    Object objZ = wVar.z(tVar, this);
                    wd.a aVar = wd.a.f14143v;
                    if (objZ == aVar) {
                        return aVar;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    com.bumptech.glide.c.C(obj);
                }
                return rd.l.f11003a;
            default:
                int i10 = this.A;
                vd.c cVar = null;
                a1 a1Var2 = this.B;
                try {
                    if (i10 == 0) {
                        com.bumptech.glide.c.C(obj);
                        d1.i iVar = a1Var2.f13571e;
                        y0 y0Var = new y0(a1Var2, cVar, 0);
                        this.A = 1;
                        Object objA = iVar.a(y0Var, this);
                        wd.a aVar2 = wd.a.f14143v;
                        if (objA == aVar2) {
                            return aVar2;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        com.bumptech.glide.c.C(obj);
                    }
                    break;
                } catch (Exception e9) {
                    Log.d("FirebaseSessions", "App backgrounded, failed to update data. Message: " + e9.getMessage());
                    g0 g0Var = a1Var2.f13573h;
                    if (g0Var == null) {
                        ge.i.i("localSessionData");
                        throw null;
                    }
                    a1Var2.f13573h = g0.a(g0Var, null, a1Var2.f13570d.a(), null, 5);
                }
                return rd.l.f11003a;
        }
    }
}
