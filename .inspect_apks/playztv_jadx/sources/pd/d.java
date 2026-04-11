package pd;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends f1.c implements Iterator, ce.a {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ int f10350y;

    public d(f fVar, int i) {
        this.f10350y = i;
        be.h.e(fVar, "map");
        this.f4694x = fVar;
        this.f4692v = -1;
        this.f4693w = fVar.B;
        e();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f10350y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                b();
                int i = this.f4691u;
                f fVar = (f) this.f4694x;
                if (i >= fVar.f10359z) {
                    throw new NoSuchElementException();
                }
                this.f4691u = i + 1;
                this.f4692v = i;
                e eVar = new e(fVar, i);
                e();
                return eVar;
            case 1:
                b();
                int i10 = this.f4691u;
                f fVar2 = (f) this.f4694x;
                if (i10 >= fVar2.f10359z) {
                    throw new NoSuchElementException();
                }
                this.f4691u = i10 + 1;
                this.f4692v = i10;
                Object obj = fVar2.f10354u[i10];
                e();
                return obj;
            default:
                b();
                int i11 = this.f4691u;
                f fVar3 = (f) this.f4694x;
                if (i11 >= fVar3.f10359z) {
                    throw new NoSuchElementException();
                }
                this.f4691u = i11 + 1;
                this.f4692v = i11;
                Object[] objArr = fVar3.f10355v;
                be.h.b(objArr);
                Object obj2 = objArr[this.f4692v];
                e();
                return obj2;
        }
    }
}
