package o2;

import android.media.MediaCodec;
import android.os.Build;
import androidx.media3.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;
import java.util.Arrays;
import k8.o3;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s2.e f9249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s1.u f9251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public o3 f9252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public o3 f9253e;
    public o3 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f9254g;

    public y0(s2.e eVar) {
        this.f9249a = eVar;
        int i = eVar.f11733b;
        this.f9250b = i;
        this.f9251c = new s1.u(32);
        o3 o3Var = new o3(i, 0L);
        this.f9252d = o3Var;
        this.f9253e = o3Var;
        this.f = o3Var;
    }

    public static o3 d(o3 o3Var, long j5, ByteBuffer byteBuffer, int i) {
        while (j5 >= o3Var.f7357v) {
            o3Var = (o3) o3Var.f7359x;
        }
        while (i > 0) {
            int iMin = Math.min(i, (int) (o3Var.f7357v - j5));
            s2.a aVar = (s2.a) o3Var.f7358w;
            byteBuffer.put(aVar.f11723a, ((int) (j5 - o3Var.f7356u)) + aVar.f11724b, iMin);
            i -= iMin;
            j5 += (long) iMin;
            if (j5 == o3Var.f7357v) {
                o3Var = (o3) o3Var.f7359x;
            }
        }
        return o3Var;
    }

    public static o3 e(o3 o3Var, long j5, byte[] bArr, int i) {
        while (j5 >= o3Var.f7357v) {
            o3Var = (o3) o3Var.f7359x;
        }
        int i10 = i;
        while (i10 > 0) {
            int iMin = Math.min(i10, (int) (o3Var.f7357v - j5));
            s2.a aVar = (s2.a) o3Var.f7358w;
            System.arraycopy(aVar.f11723a, ((int) (j5 - o3Var.f7356u)) + aVar.f11724b, bArr, i - i10, iMin);
            i10 -= iMin;
            j5 += (long) iMin;
            if (j5 == o3Var.f7357v) {
                o3Var = (o3) o3Var.f7359x;
            }
        }
        return o3Var;
    }

    public static o3 f(o3 o3Var, DecoderInputBuffer decoderInputBuffer, a7.c cVar, s1.u uVar) {
        if (decoderInputBuffer.isEncrypted()) {
            long j5 = cVar.f622b;
            int iD = 1;
            uVar.G(1);
            o3 o3VarE = e(o3Var, j5, uVar.f11709a, 1);
            long j8 = j5 + 1;
            byte b10 = uVar.f11709a[0];
            boolean z2 = (b10 & 128) != 0;
            int i = b10 & 127;
            y1.c cVar2 = decoderInputBuffer.cryptoInfo;
            byte[] bArr = cVar2.f14458a;
            if (bArr == null) {
                cVar2.f14458a = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            o3Var = e(o3VarE, j8, cVar2.f14458a, i);
            long j10 = j8 + ((long) i);
            if (z2) {
                uVar.G(2);
                o3Var = e(o3Var, j10, uVar.f11709a, 2);
                j10 += 2;
                iD = uVar.D();
            }
            int[] iArr = cVar2.f14461d;
            if (iArr == null || iArr.length < iD) {
                iArr = new int[iD];
            }
            int[] iArr2 = cVar2.f14462e;
            if (iArr2 == null || iArr2.length < iD) {
                iArr2 = new int[iD];
            }
            if (z2) {
                int i10 = iD * 6;
                uVar.G(i10);
                o3Var = e(o3Var, j10, uVar.f11709a, i10);
                j10 += (long) i10;
                uVar.J(0);
                for (int i11 = 0; i11 < iD; i11++) {
                    iArr[i11] = uVar.D();
                    iArr2[i11] = uVar.B();
                }
            } else {
                iArr[0] = 0;
                iArr2[0] = cVar.f621a - ((int) (j10 - cVar.f622b));
            }
            w2.g0 g0Var = (w2.g0) cVar.f623c;
            int i12 = s1.b0.f11647a;
            byte[] bArr2 = g0Var.f13632b;
            byte[] bArr3 = cVar2.f14458a;
            int i13 = g0Var.f13631a;
            int i14 = g0Var.f13633c;
            int i15 = g0Var.f13634d;
            cVar2.f = iD;
            cVar2.f14461d = iArr;
            cVar2.f14462e = iArr2;
            cVar2.f14459b = bArr2;
            cVar2.f14458a = bArr3;
            cVar2.f14460c = i13;
            cVar2.f14463g = i14;
            cVar2.f14464h = i15;
            MediaCodec.CryptoInfo cryptoInfo = cVar2.i;
            cryptoInfo.numSubSamples = iD;
            cryptoInfo.numBytesOfClearData = iArr;
            cryptoInfo.numBytesOfEncryptedData = iArr2;
            cryptoInfo.key = bArr2;
            cryptoInfo.iv = bArr3;
            cryptoInfo.mode = i13;
            if (Build.VERSION.SDK_INT >= 24) {
                pb.c cVar3 = cVar2.f14465j;
                cVar3.getClass();
                ((MediaCodec.CryptoInfo.Pattern) cVar3.f10311w).set(i14, i15);
                ((MediaCodec.CryptoInfo) cVar3.f10310v).setPattern((MediaCodec.CryptoInfo.Pattern) cVar3.f10311w);
            }
            long j11 = cVar.f622b;
            int i16 = (int) (j10 - j11);
            cVar.f622b = j11 + ((long) i16);
            cVar.f621a -= i16;
        }
        if (!decoderInputBuffer.hasSupplementalData()) {
            decoderInputBuffer.ensureSpaceForWrite(cVar.f621a);
            return d(o3Var, cVar.f622b, decoderInputBuffer.data, cVar.f621a);
        }
        uVar.G(4);
        o3 o3VarE2 = e(o3Var, cVar.f622b, uVar.f11709a, 4);
        int iB = uVar.B();
        cVar.f622b += 4;
        cVar.f621a -= 4;
        decoderInputBuffer.ensureSpaceForWrite(iB);
        o3 o3VarD = d(o3VarE2, cVar.f622b, decoderInputBuffer.data, iB);
        cVar.f622b += (long) iB;
        int i17 = cVar.f621a - iB;
        cVar.f621a = i17;
        decoderInputBuffer.resetSupplementalData(i17);
        return d(o3VarD, cVar.f622b, decoderInputBuffer.supplementalData, cVar.f621a);
    }

    public final void a(o3 o3Var) {
        if (((s2.a) o3Var.f7358w) == null) {
            return;
        }
        s2.e eVar = this.f9249a;
        synchronized (eVar) {
            o3 o3Var2 = o3Var;
            while (o3Var2 != null) {
                try {
                    s2.a[] aVarArr = eVar.f;
                    int i = eVar.f11736e;
                    eVar.f11736e = i + 1;
                    s2.a aVar = (s2.a) o3Var2.f7358w;
                    aVar.getClass();
                    aVarArr[i] = aVar;
                    eVar.f11735d--;
                    o3Var2 = (o3) o3Var2.f7359x;
                    if (o3Var2 == null || ((s2.a) o3Var2.f7358w) == null) {
                        o3Var2 = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            eVar.notifyAll();
        }
        o3Var.f7358w = null;
        o3Var.f7359x = null;
    }

    public final void b(long j5) {
        o3 o3Var;
        if (j5 == -1) {
            return;
        }
        while (true) {
            o3Var = this.f9252d;
            if (j5 < o3Var.f7357v) {
                break;
            }
            s2.e eVar = this.f9249a;
            s2.a aVar = (s2.a) o3Var.f7358w;
            synchronized (eVar) {
                s2.a[] aVarArr = eVar.f;
                int i = eVar.f11736e;
                eVar.f11736e = i + 1;
                aVarArr[i] = aVar;
                eVar.f11735d--;
                eVar.notifyAll();
            }
            o3 o3Var2 = this.f9252d;
            o3Var2.f7358w = null;
            o3 o3Var3 = (o3) o3Var2.f7359x;
            o3Var2.f7359x = null;
            this.f9252d = o3Var3;
        }
        if (this.f9253e.f7356u < o3Var.f7356u) {
            this.f9253e = o3Var;
        }
    }

    public final int c(int i) {
        s2.a aVar;
        o3 o3Var = this.f;
        if (((s2.a) o3Var.f7358w) == null) {
            s2.e eVar = this.f9249a;
            synchronized (eVar) {
                try {
                    int i10 = eVar.f11735d + 1;
                    eVar.f11735d = i10;
                    int i11 = eVar.f11736e;
                    if (i11 > 0) {
                        s2.a[] aVarArr = eVar.f;
                        int i12 = i11 - 1;
                        eVar.f11736e = i12;
                        aVar = aVarArr[i12];
                        aVar.getClass();
                        eVar.f[eVar.f11736e] = null;
                    } else {
                        s2.a aVar2 = new s2.a(0, new byte[eVar.f11733b]);
                        s2.a[] aVarArr2 = eVar.f;
                        if (i10 > aVarArr2.length) {
                            eVar.f = (s2.a[]) Arrays.copyOf(aVarArr2, aVarArr2.length * 2);
                        }
                        aVar = aVar2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            o3 o3Var2 = new o3(this.f9250b, this.f.f7357v);
            o3Var.f7358w = aVar;
            o3Var.f7359x = o3Var2;
        }
        return Math.min(i, (int) (this.f.f7357v - this.f9254g));
    }
}
