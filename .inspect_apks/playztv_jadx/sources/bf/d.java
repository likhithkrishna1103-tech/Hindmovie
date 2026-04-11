package bf;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.io.EOFException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hf.f f2064a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2066c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2069g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2070h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2065b = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2067d = 4096;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b[] f2068e = new b[8];
    public int f = 7;

    public d(hf.f fVar) {
        this.f2064a = fVar;
    }

    public final void a(int i) {
        int i10;
        if (i > 0) {
            int length = this.f2068e.length - 1;
            int i11 = 0;
            while (true) {
                i10 = this.f;
                if (length < i10 || i <= 0) {
                    break;
                }
                b bVar = this.f2068e[length];
                be.h.b(bVar);
                i -= bVar.f2054c;
                int i12 = this.f2070h;
                b bVar2 = this.f2068e[length];
                be.h.b(bVar2);
                this.f2070h = i12 - bVar2.f2054c;
                this.f2069g--;
                i11++;
                length--;
            }
            b[] bVarArr = this.f2068e;
            int i13 = i10 + 1;
            System.arraycopy(bVarArr, i13, bVarArr, i13 + i11, this.f2069g);
            b[] bVarArr2 = this.f2068e;
            int i14 = this.f + 1;
            Arrays.fill(bVarArr2, i14, i14 + i11, (Object) null);
            this.f += i11;
        }
    }

    public final void b(b bVar) {
        int i = bVar.f2054c;
        int i10 = this.f2067d;
        if (i > i10) {
            b[] bVarArr = this.f2068e;
            od.h.W(bVarArr, 0, bVarArr.length);
            this.f = this.f2068e.length - 1;
            this.f2069g = 0;
            this.f2070h = 0;
            return;
        }
        a((this.f2070h + i) - i10);
        int i11 = this.f2069g + 1;
        b[] bVarArr2 = this.f2068e;
        if (i11 > bVarArr2.length) {
            b[] bVarArr3 = new b[bVarArr2.length * 2];
            System.arraycopy(bVarArr2, 0, bVarArr3, bVarArr2.length, bVarArr2.length);
            this.f = this.f2068e.length - 1;
            this.f2068e = bVarArr3;
        }
        int i12 = this.f;
        this.f = i12 - 1;
        this.f2068e[i12] = bVar;
        this.f2069g++;
        this.f2070h += i;
    }

    public final void c(hf.i iVar) throws EOFException {
        be.h.e(iVar, "data");
        int[] iArr = z.f2145a;
        int iA = iVar.a();
        long j5 = 0;
        long j8 = 0;
        for (int i = 0; i < iA; i++) {
            byte bD = iVar.d(i);
            byte[] bArr = ve.b.f13497a;
            j8 += (long) z.f2146b[bD & 255];
        }
        int i10 = (int) ((j8 + ((long) 7)) >> 3);
        int iA2 = iVar.a();
        hf.f fVar = this.f2064a;
        if (i10 >= iA2) {
            e(iVar.a(), ModuleDescriptor.MODULE_VERSION, 0);
            fVar.h0(iVar);
            return;
        }
        hf.f fVar2 = new hf.f();
        int[] iArr2 = z.f2145a;
        int iA3 = iVar.a();
        int i11 = 0;
        for (int i12 = 0; i12 < iA3; i12++) {
            byte bD2 = iVar.d(i12);
            byte[] bArr2 = ve.b.f13497a;
            int i13 = bD2 & 255;
            int i14 = z.f2145a[i13];
            byte b10 = z.f2146b[i13];
            j5 = (j5 << b10) | ((long) i14);
            i11 += b10;
            while (i11 >= 8) {
                i11 -= 8;
                fVar2.j0((int) (j5 >> i11));
            }
        }
        if (i11 > 0) {
            fVar2.j0((int) ((j5 << (8 - i11)) | (255 >>> i11)));
        }
        hf.i iVarM = fVar2.m(fVar2.f6113v);
        e(iVarM.a(), ModuleDescriptor.MODULE_VERSION, 128);
        fVar.h0(iVarM);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(java.util.ArrayList r14) throws java.io.EOFException {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bf.d.d(java.util.ArrayList):void");
    }

    public final void e(int i, int i10, int i11) {
        hf.f fVar = this.f2064a;
        if (i < i10) {
            fVar.j0(i | i11);
            return;
        }
        fVar.j0(i11 | i10);
        int i12 = i - i10;
        while (i12 >= 128) {
            fVar.j0(128 | (i12 & ModuleDescriptor.MODULE_VERSION));
            i12 >>>= 7;
        }
        fVar.j0(i12);
    }
}
