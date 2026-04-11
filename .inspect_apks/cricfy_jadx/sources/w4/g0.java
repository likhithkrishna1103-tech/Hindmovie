package w4;

import android.database.SQLException;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 extends xd.h implements fe.p {
    public int A;
    public /* synthetic */ Object B;
    public final /* synthetic */ l0 C;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f13942z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g0(l0 l0Var, vd.c cVar, int i) {
        super(2, cVar);
        this.f13942z = i;
        this.C = l0Var;
    }

    @Override // fe.p
    public final Object j(Object obj, Object obj2) {
        switch (this.f13942z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((g0) m((y4.i) obj, (vd.c) obj2)).o(rd.l.f11003a);
            default:
                return ((g0) m((d0) obj, (vd.c) obj2)).o(rd.l.f11003a);
        }
    }

    @Override // xd.a
    public final vd.c m(Object obj, vd.c cVar) {
        switch (this.f13942z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                g0 g0Var = new g0(this.C, cVar, 0);
                g0Var.B = obj;
                return g0Var;
            default:
                g0 g0Var2 = new g0(this.C, cVar, 1);
                g0Var2.B = obj;
                return g0Var2;
        }
    }

    @Override // xd.a
    public final Object o(Object obj) throws Throwable {
        d0 d0Var;
        switch (this.f13942z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i = this.A;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    com.bumptech.glide.c.C(obj);
                    return obj;
                }
                com.bumptech.glide.c.C(obj);
                y4.i iVar = (y4.i) this.B;
                this.A = 1;
                Object objA = l0.a(this.C, iVar, this);
                wd.a aVar = wd.a.f14143v;
                return objA == aVar ? aVar : objA;
            default:
                int i10 = this.A;
                wd.a aVar2 = wd.a.f14143v;
                try {
                    if (i10 == 0) {
                        com.bumptech.glide.c.C(obj);
                        d0Var = (d0) this.B;
                        this.B = d0Var;
                        this.A = 1;
                        obj = d0Var.a(this);
                        if (obj == aVar2) {
                            return aVar2;
                        }
                    } else {
                        if (i10 != 1) {
                            if (i10 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            com.bumptech.glide.c.C(obj);
                            return (Set) obj;
                        }
                        d0Var = (d0) this.B;
                        com.bumptech.glide.c.C(obj);
                    }
                    if (!((Boolean) obj).booleanValue()) {
                        c0 c0Var = c0.f13926w;
                        g0 g0Var = new g0(this.C, null, 0);
                        this.B = null;
                        this.A = 2;
                        obj = d0Var.d(c0Var, g0Var, this);
                        if (obj == aVar2) {
                            return aVar2;
                        }
                        return (Set) obj;
                    }
                } catch (SQLException unused) {
                }
                return sd.r.f11671v;
        }
    }
}
