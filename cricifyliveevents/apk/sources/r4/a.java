package r4;

import androidx.media3.decoder.DecoderInputBuffer;
import fe.p;
import pe.n;
import pe.v;
import rd.l;
import s4.d;
import sd.q;
import se.y;
import vd.c;
import w4.g;
import xd.h;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends h implements p {
    public int A;
    public final /* synthetic */ Object B;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f10851z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Object obj, c cVar, int i) {
        super(2, cVar);
        this.f10851z = i;
        this.B = obj;
    }

    @Override // fe.p
    public final Object j(Object obj, Object obj2) {
        v vVar = (v) obj;
        c cVar = (c) obj2;
        switch (this.f10851z) {
        }
        return ((a) m(vVar, cVar)).o(l.f11003a);
    }

    @Override // xd.a
    public final c m(Object obj, c cVar) {
        switch (this.f10851z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new a((b) this.B, cVar, 0);
            case 1:
                return new a((g) this.B, cVar, 1);
            case 2:
                return new a((xb.c) this.B, cVar, 2);
            default:
                return new a((n) this.B, cVar, 3);
        }
    }

    @Override // xd.a
    public final Object o(Object obj) throws Throwable {
        switch (this.f10851z) {
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
                d dVar = ((b) this.B).f10852a;
                this.A = 1;
                Object objC = dVar.c(this);
                wd.a aVar = wd.a.f14143v;
                return objC == aVar ? aVar : objC;
            case 1:
                int i10 = this.A;
                l lVar = l.f11003a;
                if (i10 != 0) {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    com.bumptech.glide.c.C(obj);
                    return lVar;
                }
                com.bumptech.glide.c.C(obj);
                g gVar = (g) this.B;
                this.A = 1;
                Object objF = gVar.f13937b.f(this);
                wd.a aVar2 = wd.a.f14143v;
                if (objF != aVar2) {
                    objF = lVar;
                }
                return objF == aVar2 ? aVar2 : lVar;
            case 2:
                int i11 = this.A;
                if (i11 == 0) {
                    com.bumptech.glide.c.C(obj);
                    se.c cVarB = ((xb.c) this.B).f14478c.f5476a.b();
                    this.A = 1;
                    obj = y.e(cVarB, this);
                    wd.a aVar3 = wd.a.f14143v;
                    if (obj == aVar3) {
                        return aVar3;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    com.bumptech.glide.c.C(obj);
                }
                h1.b bVar = (h1.b) obj;
                return bVar != null ? bVar.a() : q.f11670v;
            default:
                int i12 = this.A;
                if (i12 != 0) {
                    if (i12 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    com.bumptech.glide.c.C(obj);
                    return obj;
                }
                com.bumptech.glide.c.C(obj);
                n nVar = (n) this.B;
                this.A = 1;
                Object objC0 = nVar.c0(this);
                wd.a aVar4 = wd.a.f14143v;
                return objC0 == aVar4 ? aVar4 : objC0;
        }
    }
}
