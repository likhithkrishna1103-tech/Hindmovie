package yc;

import androidx.media3.decoder.DecoderInputBuffer;
import fe.p;
import java.util.concurrent.atomic.AtomicReference;
import pe.v;
import se.y;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends xd.h implements p {
    public int A;
    public final /* synthetic */ n B;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f15046z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(n nVar, vd.c cVar, int i) {
        super(2, cVar);
        this.f15046z = i;
        this.B = nVar;
    }

    @Override // fe.p
    public final Object j(Object obj, Object obj2) {
        v vVar = (v) obj;
        vd.c cVar = (vd.c) obj2;
        switch (this.f15046z) {
        }
        return ((l) m(vVar, cVar)).o(rd.l.f11003a);
    }

    @Override // xd.a
    public final vd.c m(Object obj, vd.c cVar) {
        switch (this.f15046z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new l(this.B, cVar, 0);
            default:
                return new l(this.B, cVar, 1);
        }
    }

    @Override // xd.a
    public final Object o(Object obj) throws Throwable {
        switch (this.f15046z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i = this.A;
                if (i == 0) {
                    com.bumptech.glide.c.C(obj);
                    n nVar = this.B;
                    se.c cVarB = nVar.f15050b.b();
                    final AtomicReference atomicReference = nVar.f15051c;
                    se.d dVar = new se.d() { // from class: yc.k
                        public final boolean equals(Object obj2) {
                            if ((obj2 instanceof se.d) && (obj2 instanceof k)) {
                                return new ge.a(atomicReference).equals(new ge.a(atomicReference));
                            }
                            return false;
                        }

                        @Override // se.d
                        public final Object f(Object obj2, vd.c cVar) {
                            atomicReference.set((g) obj2);
                            return rd.l.f11003a;
                        }

                        public final int hashCode() {
                            return ((((((((((AtomicReference.class.hashCode() + ((atomicReference != null ? r0.hashCode() : 0) * 31)) * 31) + 113762) * 31) - 869290769) * 31) + 1237) * 31) + 2) * 31) + 2;
                        }
                    };
                    this.A = 1;
                    Object objZ = cVarB.z(dVar, this);
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
                if (i10 != 0) {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    com.bumptech.glide.c.C(obj);
                    return obj;
                }
                com.bumptech.glide.c.C(obj);
                se.c cVarB2 = this.B.f15050b.b();
                this.A = 1;
                Object objD = y.d(cVarB2, this);
                wd.a aVar2 = wd.a.f14143v;
                return objD == aVar2 ? aVar2 : objD;
        }
    }
}
