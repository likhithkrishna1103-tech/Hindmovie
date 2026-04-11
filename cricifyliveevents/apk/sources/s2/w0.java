package s2;

import android.media.MediaCodec;
import android.os.Build;
import androidx.media3.decoder.DecoderInputBuffer;
import f9.a4;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w2.e f11351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y1.t f11353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a4 f11354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a4 f11355e;
    public a4 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f11356g;

    public w0(w2.e eVar) {
        this.f11351a = eVar;
        int i = eVar.f13846b;
        this.f11352b = i;
        this.f11353c = new y1.t(32);
        a4 a4Var = new a4(i, 0L);
        this.f11354d = a4Var;
        this.f11355e = a4Var;
        this.f = a4Var;
    }

    public static a4 d(a4 a4Var, long j4, ByteBuffer byteBuffer, int i) {
        while (j4 >= a4Var.f4009w) {
            a4Var = (a4) a4Var.f4011y;
        }
        while (i > 0) {
            int iMin = Math.min(i, (int) (a4Var.f4009w - j4));
            w2.a aVar = (w2.a) a4Var.f4010x;
            byteBuffer.put(aVar.f13836a, ((int) (j4 - a4Var.f4008v)) + aVar.f13837b, iMin);
            i -= iMin;
            j4 += (long) iMin;
            if (j4 == a4Var.f4009w) {
                a4Var = (a4) a4Var.f4011y;
            }
        }
        return a4Var;
    }

    public static a4 e(a4 a4Var, long j4, byte[] bArr, int i) {
        while (j4 >= a4Var.f4009w) {
            a4Var = (a4) a4Var.f4011y;
        }
        int i10 = i;
        while (i10 > 0) {
            int iMin = Math.min(i10, (int) (a4Var.f4009w - j4));
            w2.a aVar = (w2.a) a4Var.f4010x;
            System.arraycopy(aVar.f13836a, ((int) (j4 - a4Var.f4008v)) + aVar.f13837b, bArr, i - i10, iMin);
            i10 -= iMin;
            j4 += (long) iMin;
            if (j4 == a4Var.f4009w) {
                a4Var = (a4) a4Var.f4011y;
            }
        }
        return a4Var;
    }

    public static a4 f(a4 a4Var, DecoderInputBuffer decoderInputBuffer, o2.f fVar, y1.t tVar) {
        if (decoderInputBuffer.isEncrypted()) {
            long j4 = fVar.f9432b;
            int iD = 1;
            tVar.G(1);
            a4 a4VarE = e(a4Var, j4, tVar.f14609a, 1);
            long j7 = j4 + 1;
            byte b8 = tVar.f14609a[0];
            boolean z10 = (b8 & 128) != 0;
            int i = b8 & 127;
            e2.c cVar = decoderInputBuffer.cryptoInfo;
            byte[] bArr = cVar.f3752a;
            if (bArr == null) {
                cVar.f3752a = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            a4Var = e(a4VarE, j7, cVar.f3752a, i);
            long j10 = j7 + ((long) i);
            if (z10) {
                tVar.G(2);
                a4Var = e(a4Var, j10, tVar.f14609a, 2);
                j10 += 2;
                iD = tVar.D();
            }
            int[] iArr = cVar.f3755d;
            if (iArr == null || iArr.length < iD) {
                iArr = new int[iD];
            }
            int[] iArr2 = cVar.f3756e;
            if (iArr2 == null || iArr2.length < iD) {
                iArr2 = new int[iD];
            }
            if (z10) {
                int i10 = iD * 6;
                tVar.G(i10);
                a4Var = e(a4Var, j10, tVar.f14609a, i10);
                j10 += (long) i10;
                tVar.J(0);
                for (int i11 = 0; i11 < iD; i11++) {
                    iArr[i11] = tVar.D();
                    iArr2[i11] = tVar.B();
                }
            } else {
                iArr[0] = 0;
                iArr2[0] = fVar.f9431a - ((int) (j10 - fVar.f9432b));
            }
            a3.h0 h0Var = (a3.h0) fVar.f9433c;
            int i12 = y1.a0.f14551a;
            byte[] bArr2 = h0Var.f189b;
            byte[] bArr3 = cVar.f3752a;
            int i13 = h0Var.f188a;
            int i14 = h0Var.f190c;
            int i15 = h0Var.f191d;
            cVar.f = iD;
            cVar.f3755d = iArr;
            cVar.f3756e = iArr2;
            cVar.f3753b = bArr2;
            cVar.f3752a = bArr3;
            cVar.f3754c = i13;
            cVar.f3757g = i14;
            cVar.f3758h = i15;
            MediaCodec.CryptoInfo cryptoInfo = cVar.i;
            cryptoInfo.numSubSamples = iD;
            cryptoInfo.numBytesOfClearData = iArr;
            cryptoInfo.numBytesOfEncryptedData = iArr2;
            cryptoInfo.key = bArr2;
            cryptoInfo.iv = bArr3;
            cryptoInfo.mode = i13;
            if (Build.VERSION.SDK_INT >= 24) {
                l4.c0 c0Var = cVar.f3759j;
                c0Var.getClass();
                ((MediaCodec.CryptoInfo.Pattern) c0Var.f7706x).set(i14, i15);
                ((MediaCodec.CryptoInfo) c0Var.f7705w).setPattern((MediaCodec.CryptoInfo.Pattern) c0Var.f7706x);
            }
            long j11 = fVar.f9432b;
            int i16 = (int) (j10 - j11);
            fVar.f9432b = j11 + ((long) i16);
            fVar.f9431a -= i16;
        }
        if (!decoderInputBuffer.hasSupplementalData()) {
            decoderInputBuffer.ensureSpaceForWrite(fVar.f9431a);
            return d(a4Var, fVar.f9432b, decoderInputBuffer.data, fVar.f9431a);
        }
        tVar.G(4);
        a4 a4VarE2 = e(a4Var, fVar.f9432b, tVar.f14609a, 4);
        int iB = tVar.B();
        fVar.f9432b += 4;
        fVar.f9431a -= 4;
        decoderInputBuffer.ensureSpaceForWrite(iB);
        a4 a4VarD = d(a4VarE2, fVar.f9432b, decoderInputBuffer.data, iB);
        fVar.f9432b += (long) iB;
        int i17 = fVar.f9431a - iB;
        fVar.f9431a = i17;
        decoderInputBuffer.resetSupplementalData(i17);
        return d(a4VarD, fVar.f9432b, decoderInputBuffer.supplementalData, fVar.f9431a);
    }

    public final void a(a4 a4Var) {
        if (((w2.a) a4Var.f4010x) == null) {
            return;
        }
        w2.e eVar = this.f11351a;
        synchronized (eVar) {
            a4 a4Var2 = a4Var;
            while (a4Var2 != null) {
                try {
                    w2.a[] aVarArr = eVar.f;
                    int i = eVar.f13849e;
                    eVar.f13849e = i + 1;
                    w2.a aVar = (w2.a) a4Var2.f4010x;
                    aVar.getClass();
                    aVarArr[i] = aVar;
                    eVar.f13848d--;
                    a4Var2 = (a4) a4Var2.f4011y;
                    if (a4Var2 == null || ((w2.a) a4Var2.f4010x) == null) {
                        a4Var2 = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            eVar.notifyAll();
        }
        a4Var.f4010x = null;
        a4Var.f4011y = null;
    }

    public final void b(long j4) {
        a4 a4Var;
        if (j4 == -1) {
            return;
        }
        while (true) {
            a4Var = this.f11354d;
            if (j4 < a4Var.f4009w) {
                break;
            }
            w2.e eVar = this.f11351a;
            w2.a aVar = (w2.a) a4Var.f4010x;
            synchronized (eVar) {
                w2.a[] aVarArr = eVar.f;
                int i = eVar.f13849e;
                eVar.f13849e = i + 1;
                aVarArr[i] = aVar;
                eVar.f13848d--;
                eVar.notifyAll();
            }
            a4 a4Var2 = this.f11354d;
            a4Var2.f4010x = null;
            a4 a4Var3 = (a4) a4Var2.f4011y;
            a4Var2.f4011y = null;
            this.f11354d = a4Var3;
        }
        if (this.f11355e.f4008v < a4Var.f4008v) {
            this.f11355e = a4Var;
        }
    }

    public final int c(int i) {
        w2.a aVar;
        a4 a4Var = this.f;
        if (((w2.a) a4Var.f4010x) == null) {
            w2.e eVar = this.f11351a;
            synchronized (eVar) {
                try {
                    int i10 = eVar.f13848d + 1;
                    eVar.f13848d = i10;
                    int i11 = eVar.f13849e;
                    if (i11 > 0) {
                        w2.a[] aVarArr = eVar.f;
                        int i12 = i11 - 1;
                        eVar.f13849e = i12;
                        aVar = aVarArr[i12];
                        aVar.getClass();
                        eVar.f[eVar.f13849e] = null;
                    } else {
                        w2.a aVar2 = new w2.a(0, new byte[eVar.f13846b]);
                        w2.a[] aVarArr2 = eVar.f;
                        if (i10 > aVarArr2.length) {
                            eVar.f = (w2.a[]) Arrays.copyOf(aVarArr2, aVarArr2.length * 2);
                        }
                        aVar = aVar2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            a4 a4Var2 = new a4(this.f11352b, this.f.f4009w);
            a4Var.f4010x = aVar;
            a4Var.f4011y = a4Var2;
        }
        return Math.min(i, (int) (this.f.f4009w - this.f11356g));
    }
}
