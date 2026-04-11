package h1;

import androidx.media3.decoder.DecoderInputBuffer;
import fe.p;
import ge.i;
import java.util.concurrent.atomic.AtomicBoolean;
import rd.l;
import sd.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends xd.h implements p {
    public int A;
    public /* synthetic */ Object B;
    public final /* synthetic */ xd.h C;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f5475z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(p pVar, vd.c cVar, int i) {
        super(2, cVar);
        this.f5475z = i;
        switch (i) {
            case 1:
                this.C = (xd.h) pVar;
                super(2, cVar);
                break;
            default:
                this.C = (xd.h) pVar;
                break;
        }
    }

    @Override // fe.p
    public final Object j(Object obj, Object obj2) {
        b bVar = (b) obj;
        vd.c cVar = (vd.c) obj2;
        switch (this.f5475z) {
        }
        return ((c) m(bVar, cVar)).o(l.f11003a);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [fe.p, xd.h] */
    /* JADX WARN: Type inference failed for: r1v1, types: [fe.p, xd.h] */
    @Override // xd.a
    public final vd.c m(Object obj, vd.c cVar) {
        switch (this.f5475z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                c cVar2 = new c(this.C, cVar, 0);
                cVar2.B = obj;
                return cVar2;
            default:
                c cVar3 = new c(this.C, cVar, 1);
                cVar3.B = obj;
                return cVar3;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [fe.p, xd.h] */
    /* JADX WARN: Type inference failed for: r4v14, types: [fe.p, xd.h] */
    @Override // xd.a
    public final Object o(Object obj) throws Throwable {
        switch (this.f5475z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i = this.A;
                if (i == 0) {
                    com.bumptech.glide.c.C(obj);
                    b bVar = (b) this.B;
                    this.A = 1;
                    obj = this.C.j(bVar, this);
                    wd.a aVar = wd.a.f14143v;
                    if (obj == aVar) {
                        return aVar;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    com.bumptech.glide.c.C(obj);
                }
                b bVar2 = (b) obj;
                i.c(bVar2, "null cannot be cast to non-null type androidx.datastore.preferences.core.MutablePreferences");
                ((AtomicBoolean) bVar2.f5474b.f10037w).set(true);
                return bVar2;
            default:
                int i10 = this.A;
                if (i10 != 0) {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b bVar3 = (b) this.B;
                    com.bumptech.glide.c.C(obj);
                    return bVar3;
                }
                com.bumptech.glide.c.C(obj);
                b bVar4 = new b(s.D(((b) this.B).a()), false);
                this.B = bVar4;
                this.A = 1;
                Object objJ = this.C.j(bVar4, this);
                wd.a aVar2 = wd.a.f14143v;
                return objJ == aVar2 ? aVar2 : bVar4;
        }
    }
}
