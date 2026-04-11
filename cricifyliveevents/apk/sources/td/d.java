package td;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends l1.c implements Iterator, he.a {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f12002z;

    public d(f fVar, int i) {
        this.f12002z = i;
        ge.i.e(fVar, "map");
        this.f7627y = fVar;
        this.f7625w = -1;
        this.f7626x = fVar.C;
        e();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f12002z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                b();
                int i = this.f7624v;
                f fVar = (f) this.f7627y;
                if (i >= fVar.A) {
                    throw new NoSuchElementException();
                }
                this.f7624v = i + 1;
                this.f7625w = i;
                e eVar = new e(fVar, i);
                e();
                return eVar;
            case 1:
                b();
                int i10 = this.f7624v;
                f fVar2 = (f) this.f7627y;
                if (i10 >= fVar2.A) {
                    throw new NoSuchElementException();
                }
                this.f7624v = i10 + 1;
                this.f7625w = i10;
                Object obj = fVar2.f12006v[i10];
                e();
                return obj;
            default:
                b();
                int i11 = this.f7624v;
                f fVar3 = (f) this.f7627y;
                if (i11 >= fVar3.A) {
                    throw new NoSuchElementException();
                }
                this.f7624v = i11 + 1;
                this.f7625w = i11;
                Object[] objArr = fVar3.f12007w;
                ge.i.b(objArr);
                Object obj2 = objArr[this.f7625w];
                e();
                return obj2;
        }
    }
}
