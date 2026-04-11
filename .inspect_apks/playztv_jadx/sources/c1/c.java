package c1;

import ae.p;
import androidx.media3.decoder.DecoderInputBuffer;
import be.h;
import java.util.Collections;
import java.util.Map;
import nd.k;
import od.t;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends td.g implements p {
    public /* synthetic */ Object A;
    public final /* synthetic */ td.g B;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ int f2233y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f2234z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(p pVar, rd.c cVar, int i) {
        super(2, cVar);
        this.f2233y = i;
        switch (i) {
            case 1:
                this.B = (td.g) pVar;
                super(2, cVar);
                break;
            default:
                this.B = (td.g) pVar;
                break;
        }
    }

    @Override // ae.p
    public final Object i(Object obj, Object obj2) {
        b bVar = (b) obj;
        rd.c cVar = (rd.c) obj2;
        switch (this.f2233y) {
        }
        return ((c) m(bVar, cVar)).o(k.f8990a);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [ae.p, td.g] */
    /* JADX WARN: Type inference failed for: r1v1, types: [ae.p, td.g] */
    @Override // td.a
    public final rd.c m(Object obj, rd.c cVar) {
        switch (this.f2233y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                c cVar2 = new c(this.B, cVar, 0);
                cVar2.A = obj;
                return cVar2;
            default:
                c cVar3 = new c(this.B, cVar, 1);
                cVar3.A = obj;
                return cVar3;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [ae.p, td.g] */
    /* JADX WARN: Type inference failed for: r4v12, types: [ae.p, td.g] */
    @Override // td.a
    public final Object o(Object obj) throws Throwable {
        switch (this.f2233y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i = this.f2234z;
                if (i == 0) {
                    i5.a.Q(obj);
                    b bVar = (b) this.A;
                    this.f2234z = 1;
                    obj = this.B.i(bVar, this);
                    sd.a aVar = sd.a.f11942u;
                    if (obj == aVar) {
                        return aVar;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i5.a.Q(obj);
                }
                b bVar2 = (b) obj;
                bVar2.f2232b.set(true);
                return bVar2;
            default:
                int i10 = this.f2234z;
                if (i10 != 0) {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b bVar3 = (b) this.A;
                    i5.a.Q(obj);
                    return bVar3;
                }
                i5.a.Q(obj);
                Map mapUnmodifiableMap = Collections.unmodifiableMap(((b) this.A).f2231a);
                h.d(mapUnmodifiableMap, "unmodifiableMap(preferencesMap)");
                b bVar4 = new b(t.K(mapUnmodifiableMap), false);
                this.A = bVar4;
                this.f2234z = 1;
                Object objI = this.B.i(bVar4, this);
                sd.a aVar2 = sd.a.f11942u;
                return objI == aVar2 ? aVar2 : bVar4;
        }
    }
}
