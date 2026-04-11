package bf;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final hf.q f2059c;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2062g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2057a = 4096;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f2058b = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b[] f2060d = new b[8];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2061e = 7;

    public c(s sVar) {
        this.f2059c = new hf.q(sVar);
    }

    public final int a(int i) {
        int i10;
        int i11 = 0;
        if (i > 0) {
            int length = this.f2060d.length;
            while (true) {
                length--;
                i10 = this.f2061e;
                if (length < i10 || i <= 0) {
                    break;
                }
                b bVar = this.f2060d[length];
                be.h.b(bVar);
                int i12 = bVar.f2054c;
                i -= i12;
                this.f2062g -= i12;
                this.f--;
                i11++;
            }
            b[] bVarArr = this.f2060d;
            System.arraycopy(bVarArr, i10 + 1, bVarArr, i10 + 1 + i11, this.f);
            this.f2061e += i11;
        }
        return i11;
    }

    public final hf.i b(int i) throws IOException {
        if (i >= 0) {
            b[] bVarArr = e.f2071a;
            if (i <= bVarArr.length - 1) {
                return bVarArr[i].f2052a;
            }
        }
        int length = this.f2061e + 1 + (i - e.f2071a.length);
        if (length >= 0) {
            b[] bVarArr2 = this.f2060d;
            if (length < bVarArr2.length) {
                b bVar = bVarArr2[length];
                be.h.b(bVar);
                return bVar.f2052a;
            }
        }
        throw new IOException("Header index too large " + (i + 1));
    }

    public final void c(b bVar) {
        this.f2058b.add(bVar);
        int i = bVar.f2054c;
        int i10 = this.f2057a;
        if (i > i10) {
            b[] bVarArr = this.f2060d;
            od.h.W(bVarArr, 0, bVarArr.length);
            this.f2061e = this.f2060d.length - 1;
            this.f = 0;
            this.f2062g = 0;
            return;
        }
        a((this.f2062g + i) - i10);
        int i11 = this.f + 1;
        b[] bVarArr2 = this.f2060d;
        if (i11 > bVarArr2.length) {
            b[] bVarArr3 = new b[bVarArr2.length * 2];
            System.arraycopy(bVarArr2, 0, bVarArr3, bVarArr2.length, bVarArr2.length);
            this.f2061e = this.f2060d.length - 1;
            this.f2060d = bVarArr3;
        }
        int i12 = this.f2061e;
        this.f2061e = i12 - 1;
        this.f2060d[i12] = bVar;
        this.f++;
        this.f2062g += i;
    }

    public final hf.i d() {
        hf.q qVar = this.f2059c;
        byte b10 = qVar.readByte();
        byte[] bArr = ve.b.f13497a;
        int i = b10 & 255;
        int i10 = 0;
        boolean z2 = (b10 & 128) == 128;
        long jE = e(i, ModuleDescriptor.MODULE_VERSION);
        if (!z2) {
            return qVar.m(jE);
        }
        hf.f fVar = new hf.f();
        int[] iArr = z.f2145a;
        be.h.e(qVar, "source");
        a0.g gVar = z.f2147c;
        a0.g gVar2 = gVar;
        int i11 = 0;
        for (long j5 = 0; j5 < jE; j5++) {
            byte b11 = qVar.readByte();
            byte[] bArr2 = ve.b.f13497a;
            i10 = (i10 << 8) | (b11 & 255);
            i11 += 8;
            while (i11 >= 8) {
                a0.g[] gVarArr = (a0.g[]) gVar2.f61w;
                be.h.b(gVarArr);
                gVar2 = gVarArr[(i10 >>> (i11 - 8)) & 255];
                be.h.b(gVar2);
                if (((a0.g[]) gVar2.f61w) == null) {
                    fVar.j0(gVar2.f59u);
                    i11 -= gVar2.f60v;
                    gVar2 = gVar;
                } else {
                    i11 -= 8;
                }
            }
        }
        while (i11 > 0) {
            a0.g[] gVarArr2 = (a0.g[]) gVar2.f61w;
            be.h.b(gVarArr2);
            a0.g gVar3 = gVarArr2[(i10 << (8 - i11)) & 255];
            be.h.b(gVar3);
            int i12 = gVar3.f60v;
            if (((a0.g[]) gVar3.f61w) != null || i12 > i11) {
                break;
            }
            fVar.j0(gVar3.f59u);
            i11 -= i12;
            gVar2 = gVar;
        }
        return fVar.m(fVar.f6113v);
    }

    public final int e(int i, int i10) {
        int i11 = i & i10;
        if (i11 < i10) {
            return i11;
        }
        int i12 = 0;
        while (true) {
            byte b10 = this.f2059c.readByte();
            byte[] bArr = ve.b.f13497a;
            int i13 = b10 & 255;
            if ((b10 & 128) == 0) {
                return i10 + (i13 << i12);
            }
            i10 += (b10 & 127) << i12;
            i12 += 7;
        }
    }
}
